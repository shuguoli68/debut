package com.example.debut.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UploadFileResponse", description = "文件的上传回复")
public class UploadFileResponse {
    @ApiModelProperty(value = "file表的id,自增")
    private int id =0 ;
    @ApiModelProperty(value = "file表的fileName,文件名称，带后缀")
    private String fileName;
    @ApiModelProperty(value = "file表的fileDownloadUri,文件完整路径")
    private String fileDownloadUri;
    @ApiModelProperty(value = "file表的fileDownloadUri,文件类型")
    private String fileType;
    @ApiModelProperty(value = "file表的size,文件大小，单位kb")
    private long size;

    public UploadFileResponse() {
    }

    public UploadFileResponse(int id, String fileName, String fileDownloadUri, String fileType, long size) {
        this.id = id;
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
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
                ", fileDownloadUri='" + fileDownloadUri + '\'' +
                ", fileType='" + fileType + '\'' +
                ", size=" + size +
                '}';
    }
}
