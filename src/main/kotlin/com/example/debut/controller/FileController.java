package com.example.debut.controller;

import com.example.debut.base.MyResponse;
import com.example.debut.entity.Split;
import com.example.debut.mapper.FileMapper;
import com.example.debut.util.updown.FileStorageService;
import com.example.debut.entity.UploadFileResponse;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "/FileUpDown", tags = "文件的上传下载")
@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private FileMapper fileMapper;

    @ApiOperation(value = "上传单个文件")
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        UploadFileResponse uploadFileResponse = new UploadFileResponse(0,fileName, fileDownloadUri, file.getContentType(), file.getSize());
        fileMapper.addFile(uploadFileResponse);
        return uploadFileResponse;
    }

    @ApiOperation(value = "上传多个文件")
    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "下载文件")
    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }


    @ApiOperation(value = "删除File")
    @RequestMapping(value = "/file/del", method = RequestMethod.POST)
    MyResponse<Boolean> delFile(@RequestBody UploadFileResponse banner) {
        MyResponse response = new MyResponse(201, "Path为空", false);
        if (banner.getFilePath().isEmpty()){
            return response;
        }
        int value = fileMapper.delFile(banner.getFilePath());
        if (value>0){
            response.setMsg("删除成功");
            response.setCode(200);
            response.setData(true);
            return response;
        }
        response.setCode(202);
        response.setMsg("删除失败，从数据库删除失败");
        return response;
    }

    @ApiOperation(value = "File列表")
    @RequestMapping(value = "/file/list", method = RequestMethod.POST)
    List<UploadFileResponse> listFile(@RequestBody Split split) {
        PageHelper.startPage(split.getPageNum(), split.getPageSize());
        List<UploadFileResponse> list = fileMapper.listFile();
        return list;
    }
}
