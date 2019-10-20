package com.example.debut.mapper

import com.example.debut.entity.DiaryTag
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface DiaryTagMapper {
    @Insert("INSERT INTO `diary_tag` VALUES(#{tagId,jdbcType=VARCHAR},#{tagStr,jdbcType=VARCHAR})")
    fun addDiaryTag(diary_tag: DiaryTag):Int

    @Delete("DELETE FROM `diary_tag` WHERE tag_id = #{tagId,jdbcType=VARCHAR}")
    fun delDiaryTag(tagId: String):Int

    @Update("UPDATE `diary_tag`\n" +
            "        SET tag_str = #{tagStr,jdbcType=VARCHAR}\n" +
            "        WHERE tag_id = #{tagId,jdbcType=VARCHAR}")
    fun upDiaryTag(diary_tag: DiaryTag):Int

    @Select("SELECT * FROM `diary_tag` WHERE tag_id = #{tagId,jdbcType=VARCHAR}")
    fun queryById(tagId:String):List<DiaryTag>

    @Select("SELECT * FROM `diary_tag` WHERE tag_id = #{tagId,jdbcType=VARCHAR}")
    @Results(
            Result(property = "tagId", column = "tag_id"),
            Result(property = "diaries", column = "tag_id", many = Many(select = "com.example.debut.mapper.DiaryMapper.queryByUserId")))
    fun userDiarys(userId:String):DiaryTag

    @Select("select * from `diary_tag`")
    fun listDiaryTag():Page<DiaryTag>
}