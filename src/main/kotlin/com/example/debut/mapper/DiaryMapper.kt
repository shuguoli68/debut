package com.example.debut.mapper

import com.example.debut.entity.CenterDiaryTag
import com.example.debut.entity.CenterDiaryTheme
import com.example.debut.entity.Diary
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface DiaryMapper {
    @Insert("INSERT INTO `diary` VALUES(#{diaryId},#{title},#{content},#{theme},#{subTheme},#{ctTime},#{utTime},#{userId})")
    fun addDiary(diary: Diary):Int

    @Delete("DELETE FROM `diary` WHERE diary_id = #{diaryId}")
    fun delDiary(diaryId: String):Int

    @Update("UPDATE `diary`\n" +
            "        SET title = #{title}, content = #{content}, theme = #{theme}, sub_theme = #{subTheme}, update_time = #{utTime}\n" +
            "        WHERE diary_id = #{diaryId}")
    fun upDiary(diary: Diary):Int

    @Select("SELECT * FROM `diary` WHERE diary_id = #{diaryId}")
    @Results(
            Result(property = "diaryId", column = "diary_id"),
            Result(property = "diaryTags", column = "diary_id", many = Many(select = "com.example.debut.mapper.CenterDiaryTagMapper.queryByDiaryId"))
    )
    fun queryById(diaryId:String):List<Diary>

    @Select("SELECT * FROM `diary` WHERE user_id = #{userId}")
    @Results(
            Result(property = "diaryId", column = "diary_id"),
            Result(property = "diaryTags", column = "diary_id", many = Many(select = "com.example.debut.mapper.CenterDiaryTagMapper.queryByDiaryId"))
    )
    fun queryByUserId(userId:String):List<Diary>

    @Select("select * from `diary`")
    @Results(
            Result(property = "diaryId", column = "diary_id"),
            Result(property = "diaryTags", column = "diary_id", many = Many(select = "com.example.debut.mapper.CenterDiaryTagMapper.queryByDiaryId")),
            Result(property = "diaryId", column = "diary_id"),
            Result(property = "diaryThemes", column = "diary_id", many = Many(select = "com.example.debut.mapper.DiaryThemeMapper.queryByDiaryId"))
    )
    fun listDiary():Page<Diary>

    /**
     * 标签中间表
     */
    @Insert("INSERT INTO `center_diary_tag` VALUES(#{id,jdbcType=INTEGER},#{diaryId},#{tagId})")
    fun addCenterDiaryTag(center_diary_tag: CenterDiaryTag):Int

    @Delete("DELETE FROM `center_diary_tag` WHERE diary_id = #{tagId}")
    fun delCenterDiaryTag(center_diary_tagId: String):Int

    /**
     * 分类中间表
     */
    @Insert("INSERT INTO `center_diary_theme` VALUES(#{id},#{diaryId},#{themeId},#{subThemeId})")
    fun addCenterDiaryTheme(center_diary_theme: CenterDiaryTheme):Int

    @Delete("DELETE FROM `center_diary_theme` WHERE diary_id = #{diaryId}")
    fun delCenterDiaryTheme(diaryId:String):Int

    /**
     * 赞、踩、收藏表
     */
    @Delete("DELETE FROM `diary_like` WHERE diary_id = #{diaryId}")
    fun delLikeByDiaryId(diaryId: String):Int
}