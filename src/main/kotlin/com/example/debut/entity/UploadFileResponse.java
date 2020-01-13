package com.example.debut.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UploadFileResponse", description = "文件的上传回复")
public class UploadFileResponse {
    @ApiModelProperty(value = "file表的id,自增")
    private int id =0 ;
    @ApiModelProperty(value = "file表的fileName,文件名称，带后缀")
    private String fileName="";
    @ApiModelProperty(value = "file表的filePath,文件完整路径")
    private String filePath ="";
    @ApiModelProperty(value = "file表的fileType,文件类型")
    private String fileType="";
    @ApiModelProperty(value = "file表的size,文件大小，单位kb")
    private long size=0L;

    public UploadFileResponse() {
    }

    public UploadFileResponse(int id, String fileName, String filePath, String fileType, long size) {
        this.id = id;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "UploadFileResponse{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", fileDownloadUri='" + filePath + '\'' +
                ", fileType='" + fileType + '\'' +
                ", size=" + size +
                '}';
    }
}
