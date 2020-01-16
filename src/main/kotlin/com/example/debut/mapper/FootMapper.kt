package com.example.debut.mapper

import com.example.debut.entity.Foot
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface FootMapper {
    @Insert("INSERT INTO `foot` VALUES(#{id},#{userId},#{toUserId},#{foot},#{ctTime},#{strTime})")
    fun addFoot(foot: Foot):Int

//    @Delete("DELETE FROM `foot` WHERE foot_id = #{footId}")
//    fun delFoot(footId: String):Int
//
//    @Update("UPDATE `foot`\n" +
//            "        SET title = #{title}, content = #{content}\n" +
//            "        WHERE foot_id = #{footId}")
//    fun upFoot(foot: Foot):Int

    @Select("SELECT * FROM `foot` WHERE user_id = #{userId} AND to_user_id = #{toUserId} AND ct_time = #{ctTime}")
    fun queryById(foot: Foot):List<Foot>

    @Select("SELECT * FROM `foot` WHERE user_id = #{userId} AND foot = 1")
    fun queryBrowse(userId:String):List<Foot>

    @Select("SELECT * FROM `foot` WHERE to_user_id = #{userId} AND foot = 1")
    fun queryFoot(userId:String):List<Foot>

    @Select("select * from `foot`")
    fun listFoot():Page<Foot>
}