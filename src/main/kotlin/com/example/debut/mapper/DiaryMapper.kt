package com.example.debut.mapper

import com.example.debut.entity.CenterDiaryTag
import com.example.debut.entity.Diary
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface DiaryMapper {
    @Insert("INSERT INTO `diary` VALUES(#{diaryId,jdbcType=VARCHAR},#{title,jdbcType=VARCHAR},#{content,jdbcType=VARCHAR},#{theme,jdbcType=INTEGER},#{subTheme,jdbcType=INTEGER},#{ctTime,jdbcType=TIMESTAMP},#{utTime,jdbcType=TIMESTAMP},#{userId,jdbcType=VARCHAR})")
    fun addDiary(diary: Diary):Int

    @Delete("DELETE FROM `diary` WHERE diary_id = #{diaryId,jdbcType=VARCHAR}")
    fun delDiary(diaryId: String):Int

    @Update("UPDATE `diary`\n" +
            "        SET title = #{title,jdbcType=VARCHAR}, content = #{content,jdbcType=VARCHAR}, theme = #{theme,jdbcType=INTEGER}, sub_theme = #{subTheme,jdbcType=INTEGER}, update_time = #{utTime,jdbcType=TIMESTAMP}\n" +
            "        WHERE diary_id = #{diaryId,jdbcType=VARCHAR}")
    fun upDiary(diary: Diary):Int

    @Select("SELECT * FROM `diary` WHERE diary_id = #{diaryId,jdbcType=VARCHAR}")
    @Results(
            Result(property = "diaryId", column = "diary_id"),
            Result(property = "diaryTags", column = "diary_id", many = Many(select = "com.example.debut.mapper.CenterDiaryTagMapper.queryByDiaryId"))
    )
    fun queryById(diaryId:String):List<Diary>

    @Select("SELECT * FROM `diary` WHERE user_id = #{userId,jdbcType=VARCHAR}")
    @Results(
            Result(property = "diaryId", column = "diary_id"),
            Result(property = "diaryTags", column = "diary_id", many = Many(select = "com.example.debut.mapper.CenterDiaryTagMapper.queryByDiaryId"))
    )
    fun queryByUserId(userId:String):List<Diary>

    @Select("select * from `diary`")
    @Results(
            Result(property = "diaryId", column = "diary_id"),
            Result(property = "diaryTags", column = "diary_id", many = Many(select = "com.example.debut.mapper.CenterDiaryTagMapper.queryByDiaryId"))
    )
    fun listDiary():Page<Diary>

    @Insert("INSERT INTO `center_diary_tag` VALUES(#{id,jdbcType=INTEGER},#{diaryId,jdbcType=VARCHAR},#{tagId,jdbcType=VARCHAR})")
    fun addCenterDiaryTag(center_diary_tag: CenterDiaryTag):Int

    @Delete("DELETE FROM `center_diary_tag` WHERE diary_id = #{tagId,jdbcType=VARCHAR}")
    fun delCenterDiaryTag(center_diary_tagId: String):Int
}