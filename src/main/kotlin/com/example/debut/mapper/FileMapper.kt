package com.example.debut.mapper

import com.example.debut.entity.UploadFileResponse
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

@Repository
interface FileMapper {
    @Insert("INSERT INTO `up_file` VALUES(#{id},#{fileName},#{filePath},#{fileType},#{size})")
    fun addFile(up_file: UploadFileResponse):Int

    @Delete("DELETE FROM `up_file` WHERE file_path = #{filePath}")
    fun delFile(filePath: String):Int

    @Select("select * from `up_file`")
    fun listFile():Page<UploadFileResponse>
}