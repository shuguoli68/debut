package com.example.debut.mapper

import com.example.debut.entity.Diary
import com.example.debut.entity.Split
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface DiaryMapper {
    @Insert("INSERT INTO `diary` VALUES(#{diaryId,jdbcType=VARCHAR},#{title,jdbcType=VARCHAR},#{content,jdbcType=VARCHAR},#{theme,jdbcType=INTEGER},#{subTheme,jdbcType=INTEGER},#{ctTime,jdbcType=BIGINT},#{utTime,jdbcType=BIGINT})")
    fun addDiary(diary: Diary):Int

    @Delete("DELETE FROM `diary` WHERE diary_id = #{diaryId,jdbcType=VARCHAR}")
    fun delDiary(diaryId: String):Int

    @Update("UPDATE `diary`\n" +
            "        SET title = #{title,jdbcType=VARCHAR}, content = #{content,jdbcType=VARCHAR}, theme = #{theme,jdbcType=INTEGER}, sub_theme = #{subTheme,jdbcType=INTEGER}, update_time = #{utTime,jdbcType=BIGINT}\n" +
            "        WHERE diary_id = #{diaryId,jdbcType=VARCHAR}")
    fun upDiary(diary: Diary):Int

    @Select("SELECT * FROM `diary` WHERE diary_id = #{diaryId,jdbcType=VARCHAR}")
    fun queryById(diaryId:String):List<Diary>

    @Select("SELECT * FROM `diary` WHERE user_id = #{userId,jdbcType=VARCHAR}")
    fun queryByUserId(userId:String):List<Diary>

    @Select("select * from `diary`")
    fun listDiary():Page<Diary>
}