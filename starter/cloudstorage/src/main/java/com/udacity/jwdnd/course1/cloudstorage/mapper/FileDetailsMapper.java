package com.udacity.jwdnd.course1.cloudstorage.mapper;


import com.udacity.jwdnd.course1.cloudstorage.model.FileDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileDetailsMapper {

    @Insert("INSERT INTO FILES (filename,contenttype,filesize,filedata,userid) VALUES(#{fileName},#{contentType},#{fileSize},#{fileData},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int addFile(FileDetail fileDetail);

    @Select("SELECT * FROM FILES WHERE userid = #{userId}")
    List<FileDetail> getAllFiles(Integer userId);

    @Select("SELECT * FROM FILES WHERE filename = #{fileName}")
    FileDetail getFileByName(String fileName);

    @Select("SELECT * FROM FILES WHERE fileId = #{fileId}")
    FileDetail getFile(Integer fileId);

    @Delete("DELETE FROM FILES WHERE fileId=#{fileId}")
    void deleteFile(Integer fileId);

}

