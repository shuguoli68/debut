package com.example.debut.mapper

import com.example.debut.entity.Diary
import com.example.debut.entity.DiarySubTheme
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface DiarySubThemeMapper {
    @Insert("INSERT INTO `diary_sub_theme` VALUES(#{id},#{subThemeId},#{subThemeName},#{themeId})")
    fun addDiarySubTheme(diary_sub_theme: DiarySubTheme):Int

    @Delete("DELETE FROM `diary_sub_theme` WHERE sub_theme_id = #{subThemeId}")
    fun delDiarySubTheme(diary_sub_themeId: Int):Int

    @Update("UPDATE `diary_sub_theme`\n" +
            "        SET sub_theme_name = #{subThemeName}\n" +
            "        WHERE sub_theme_id = #{subThemeId}")
    fun upDiarySubTheme(diary_sub_theme: DiarySubTheme):Int

    @Select("SELECT * FROM `diary_sub_theme` WHERE sub_theme_id = #{subThemeId}")
    fun queryById(diary_sub_themeId:Int):List<DiarySubTheme>

    @Select("SELECT * FROM `diary_sub_theme` WHERE theme_id = #{themeId}")
    fun queryByThemeId(themeId:Int):List<DiarySubTheme>

    @Select("select * from `diary_sub_theme`")
    fun listDiarySubTheme():Page<DiarySubTheme>
}