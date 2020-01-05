package com.example.debut.mapper

import com.example.debut.entity.Diary
import com.example.debut.entity.DiaryLike
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface DiaryLikeMapper {
    @Insert("INSERT INTO `diary_like` VALUES(#{id},#{userId},#{diaryId},#{like},#{collect})")
    fun addDiaryLike(diary_like: DiaryLike):Int

    @Delete("DELETE FROM `diary_like` WHERE user_id = #{userId}")
    fun delByUserId(userId: String):Int

    @Delete("DELETE FROM `diary_like` WHERE diary_id = #{diaryId}")
    fun delByDiaryId(diaryId: String):Int

    @Update("UPDATE `diary_like`\n" +
            "        SET like = #{like}, collect = #{collect}\n" +
            "        WHERE user_id = #{userId} AND diary_id = #{diaryId}")
    fun upDiaryLike(diary_like: DiaryLike):Int

    @Select("SELECT * FROM `diary_like` WHERE user_id = #{userId} AND diary_id = #{diaryId} AND like = #{like}")
    fun queryLike(diary_like: DiaryLike):List<DiaryLike>

    @Select("SELECT * FROM `diary_like` WHERE user_id = #{userId} AND diary_id = #{diaryId} AND collect = #{collect}")
    fun queryCollect(diary_like: DiaryLike):List<DiaryLike>

    @Delete("DELETE FROM `diary_like` WHERE user_id = #{userId} AND diary_id = #{diaryId}")
    fun queryByUserDiaryId(userId: String, diaryId: String):List<DiaryLike>

    @Select("select * from `diary_like`")
    fun listDiaryLike():Page<DiaryLike>
}