package com.example.debut.mapper

import com.example.debut.entity.CenterDiaryTag
import com.example.debut.entity.DiaryTag
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface CenterDiaryTagMapper {
    @Insert("INSERT INTO `center_diary_tag` VALUES(#{id,jdbcType=INTEGER},#{diaryId,jdbcType=VARCHAR},#{tagId,jdbcType=VARCHAR})")
    fun addCenterDiaryTag(center_diary_tag: CenterDiaryTag):Int

    @Delete("DELETE FROM `center_diary_tag` WHERE diary_id = #{diaryId,jdbcType=VARCHAR}")
    fun delCenterDiaryTag(center_diary_tagId: String):Int


    @Select("SELECT * FROM `center_diary_tag` WHERE tag_id = #{tagId,jdbcType=VARCHAR}")
    fun queryByTagId(tag_id:String):List<CenterDiaryTag>

    @Select("SELECT r.* FROM center_diary_tag h,diary_tag r where h.tag_id=r.tag_id AND h.diary_id=#{diaryId,jdbcType=VARCHAR}")
    fun queryByDiaryId(diary_id:String):List<DiaryTag>

    @Select("select * from `center_diary_tag`")
    fun listCenterDiaryTag():Page<CenterDiaryTag>
}