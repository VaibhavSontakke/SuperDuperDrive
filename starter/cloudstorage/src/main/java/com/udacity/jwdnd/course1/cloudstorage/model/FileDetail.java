package com.udacity.jwdnd.course1.cloudstorage.model;

import java.util.Arrays;

public class FileDetail {
    private Integer Id;
    private String name;
    private String contentType;
    private Long size;
    private Integer userId;
    private byte[] data;

    public FileDetail(Integer Id, String name, String contentType, Long size, Integer userId, byte[] data) {
        this.Id = Id;
        this.name = name;
        this.contentType = contentType;
        this.size = size;
        this.userId = userId;
        this.data = data;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileId=" + Id +
                ", fileName='" + name + '\'' +
                ", contentType='" + contentType + '\'' +
                ", fileSize='" + size + '\'' +
                ", userId=" + userId +
                ", fileData=" + Arrays.toString(data) +
                '}';
    }
}


