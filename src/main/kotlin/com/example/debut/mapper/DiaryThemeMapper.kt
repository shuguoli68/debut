package com.example.debut.mapper

import com.example.debut.entity.Diary
import com.example.debut.entity.DiaryTheme
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface DiaryThemeMapper {
    @Insert("INSERT INTO `diary_theme` VALUES(#{id},#{themeId},#{themeName})")
    fun addDiaryTheme(diary_theme: DiaryTheme):Int

    @Delete("DELETE FROM `diary_theme` WHERE theme_id = #{themeId}")
    fun delDiaryTheme(themeId: Int):Int

    @Update("UPDATE `diary_theme`\n" +
            "        SET theme_name = #{themeName}\n" +
            "        WHERE theme_id = #{themeId}")
    fun upDiaryTheme(diary_theme: DiaryTheme):Int

    @Select("SELECT * FROM `diary_theme` WHERE theme_id = #{themeId}")
    @Results(
            Result(property = "themeId", column = "theme_id"),
            Result(property = "subThemes", column = "theme_id", many = Many(select = "com.example.debut.mapper.DiarySubThemeMapper.queryByThemeId"))
    )
    fun queryById(themeId:Int):List<DiaryTheme>

    @Select("SELECT r.* FROM center_diary_theme h,diary_theme r where h.theme_id=r.theme_id AND h.diary_id=#{diaryId}")
    @Results(//TODO 语句有问题，得到的diary_theme表结果，该表中没有diary_id字段
            Result(property = "diaryId", column = "diary_id"),
            Result(property = "subThemes", column = "diary_id", many = Many(select = "com.example.debut.mapper.CenterDiaryThemeMapper.queryByDiaryId"))
    )
    fun queryByDiaryId(diaryId:String):List<DiaryTheme>


    @Select("select * from `diary_theme`")
    @Results(
            Result(property = "themeId", column = "theme_id"),
            Result(property = "subThemes", column = "theme_id", many = Many(select = "com.example.debut.mapper.DiarySubThemeMapper.queryByThemeId"))
    )
    fun listDiaryTheme():List<DiaryTheme>
}