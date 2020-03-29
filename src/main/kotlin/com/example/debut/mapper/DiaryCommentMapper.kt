package com.example.debut.mapper

import com.example.debut.entity.DiaryComment
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface DiaryCommentMapper {
    @Insert("INSERT INTO `diary_comment` VALUES(#{id},#{diary_commentId},#{title})")
    fun addDiaryComment(diary_comment: DiaryComment):Int

    @Select("SELECT * FROM `diary_comment` WHERE diary_comment_id = #{diary_commentId}")
    fun queryById(diary_commentId:String):List<DiaryComment>

    @Select("select * from `diary_comment`")
    fun listDiaryComment():Page<DiaryComment>
}