package com.example.debut.mapper

import com.example.debut.entity.DiaryTag
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface DiaryTagMapper {
    @Insert("INSERT INTO `diary_tag` VALUES(#{tagId,jdbcType=VARCHAR},#{tagStr,jdbcType=VARCHAR})")
    fun addDiaryTag(diary_tag: DiaryTag):Int

    @Delete("DELETE FROM `diary_tag` WHERE tag_id = #{tagId,jdbcType=VARCHAR}")
    fun delDiaryTag(tagId: Int):Int

    @Update("UPDATE `diary_tag`\n" +
            "        SET tag_str = #{tagStr,jdbcType=VARCHAR}\n" +
            "        WHERE tag_id = #{tagId,jdbcType=VARCHAR}")
    fun upDiaryTag(diary_tag: DiaryTag):Int

    @Select("SELECT * FROM `diary_tag` WHERE tag_id = #{tagId,jdbcType=VARCHAR}")
    fun queryById(tagId:Int):List<DiaryTag>

    @Select("select * from `diary_tag`")
    fun listDiaryTag():Page<DiaryTag>
}