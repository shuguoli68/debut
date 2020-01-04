package com.example.debut.mapper

import com.example.debut.entity.CenterDiaryTheme
import com.example.debut.entity.DiarySubTheme
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface CenterDiaryThemeMapper {
    @Insert("INSERT INTO `center_diary_theme` VALUES(#{id},#{diaryId},#{themeId},#{subThemeId})")
    fun addCenterDiaryTheme(center_diary_theme: CenterDiaryTheme):Int

    @Delete("DELETE FROM `center_diary_theme` WHERE diary_id = #{diaryId}")
    fun delCenterDiaryTheme(diaryId:String):Int

    @Select("SELECT r.* FROM center_diary_theme h,diary_sub_theme r where h.sub_theme_id=r.sub_theme_id AND h.diary_id=#{diaryId}")
    fun queryByDiaryId(diary_id:String):List<DiarySubTheme>
//    @Update("UPDATE `center_diary_theme`\n" +
//            "        SET title = #{title}, content = #{content}\n" +
//            "        WHERE center_diary_theme_id = #{center_diary_themeId}")
//    fun upCenterDiaryTheme(center_diary_theme: CenterDiaryTheme):Int

//    @Select("SELECT * FROM `center_diary_theme` WHERE theme_id = #{themeId}")
//    fun queryById(themeId:String):List<CenterDiaryTheme>
//
//    @Select("select * from `center_diary_theme`")
//    fun listCenterDiaryTheme():Page<CenterDiaryTheme>
}