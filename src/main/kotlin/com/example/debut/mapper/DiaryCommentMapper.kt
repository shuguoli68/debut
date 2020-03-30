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
    @Insert("INSERT INTO `diary_comment` VALUES(#{id},#{userId},#{name},#{diaryId},#{beUserId},#{beName},#{beId},#{ctTime})")
    fun addDiaryComment(diary_comment: DiaryComment):Int

    //只查询回复作者的
    @Select("SELECT * FROM `diary_comment` WHERE diary_id = #{diaryId} AND be_id = 0")
    fun queryById(diaryComment: DiaryComment):List<DiaryComment>

    @Select("select * from `diary_comment`")
    fun listDiaryComment():Page<DiaryComment>
}