package com.example.debut.mapper

import com.example.debut.entity.Sign
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SignMapper {
    @Insert("INSERT INTO `sign` VALUES(#{id},#{userId},#{ctTime},#{strTime})")
    fun addSign(sign: Sign):Int

    @Select("SELECT * FROM `sign` WHERE user_id = #{userId} AND ct_time = #{ctTime}")
    fun queryById(userId:String,ctTime:Date):List<Sign>

    @Select("select * from `sign`")
    fun listSign():Page<Sign>

    @Select("select * from `sign` WHERE user_id = #{userId}")
    fun listById(userId:String):List<Sign>
}