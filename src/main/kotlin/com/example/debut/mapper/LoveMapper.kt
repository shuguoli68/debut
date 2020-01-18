package com.example.debut.mapper

import com.example.debut.entity.Love
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.*
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
    @Results(
            Result(property = "toUserId", column = "to_user_id"),
            Result(property = "user", column = "to_user_id", many = Many(select = "com.example.debut.mapper.UserMapper.queryById"))
    )
    fun queryLove(userId:String):List<Love>

    @Select("SELECT * FROM `love` WHERE to_user_id = #{toUserId} AND love = 1")
    @Results(
            Result(property = "userId", column = "user_id"),
            Result(property = "user", column = "user_id", many = Many(select = "com.example.debut.mapper.UserMapper.queryById"))
    )
    fun queryFan(toUserId:String):List<Love>

    @Select("select * from `love`")
    fun listLove():Page<Love>
}