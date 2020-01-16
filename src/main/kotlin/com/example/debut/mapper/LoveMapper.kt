package com.example.debut.mapper

import com.example.debut.entity.Love
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface LoveMapper {
    @Insert("INSERT INTO `love` VALUES(#{id},#{userId},#{toUserId},#{love},#{ctTime},#{utTime})")
    fun addLove(love: Love):Int

    @Delete("DELETE FROM `love` WHERE user_id = #{userId} AND to_user_id = #{toUserId}")
    fun delLove(love: Love):Int

    @Update("UPDATE `love`\n" +
            "        SET love = #{love}, utTime = #{utTime}\n" +
            "        WHERE user_id = #{userId} AND to_user_id = #{toUserId}")
    fun upLove(love: Love):Int

    @Select("SELECT * FROM `love` WHERE user_id = #{userId} AND to_user_id = #{toUserId}")
    fun queryById(love: Love):List<Love>

    @Select("SELECT * FROM `love` WHERE user_id = #{userId} AND love = 1")
    fun queryLove(userId:String):List<Love>

    @Select("SELECT * FROM `love` WHERE to_user_id = #{userId} AND love = 1")
    fun queryFan(userId:String):List<Love>

    @Select("select * from `love`")
    fun listLove():Page<Love>
}