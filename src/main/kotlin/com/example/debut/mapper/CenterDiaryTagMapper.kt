package com.example.debut.mapper

import com.example.debut.entity.CenterDiaryTag
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface CenterDiaryTagMapper {
    @Insert("INSERT INTO `center_diary_tag` VALUES(#{diary_id,jdbcType=VARCHAR},#{tag_id,jdbcType=VARCHAR}pe=BIGINT})")
    fun addCenterDiaryTag(center_diary_tag: CenterDiaryTag):Int

    @Delete("DELETE FROM `center_diary_tag` WHERE diary_id = #{center_diary_tagId,jdbcType=VARCHAR}")
    fun delCenterDiaryTag(center_diary_tagId: String):Int

    @Update("UPDATE `center_diary_tag`\n" +
            "        SET title = #{title,jdbcType=VARCHAR}, content = #{content,jdbcType=VARCHAR}\n" +
            "        WHERE center_diary_tag_id = #{center_diary_tagId,jdbcType=VARCHAR}")
    fun upCenterDiaryTag(center_diary_tag: CenterDiaryTag):Int

    @Select("SELECT * FROM `center_diary_tag` WHERE tag_id = #{center_diary_tagId,jdbcType=VARCHAR}")
    fun queryByTagId(center_diary_tagId:String):List<CenterDiaryTag>

    @Select("SELECT * FROM `center_diary_tag` WHERE diary_id = #{center_diary_tagId,jdbcType=VARCHAR}")
    fun queryByDiaryId(center_diary_tagId:String):List<CenterDiaryTag>

    @Select("select * from `center_diary_tag`")
    fun listCenterDiaryTag():Page<CenterDiaryTag>
}