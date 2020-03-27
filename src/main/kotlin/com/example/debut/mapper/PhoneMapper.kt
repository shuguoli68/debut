package com.example.debut.mapper

import com.example.debut.entity.Phone
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface PhoneMapper {
    @Insert("INSERT INTO `phone` VALUES(#{id},#{os},#{version},#{brand},#{model},#{imei},#{userIds})")
    fun addPhone(phone: Phone):Int

    @Delete("DELETE FROM `phone` WHERE id = #{id}")
    fun delPhone(id: String):Int

    @Select("SELECT * FROM `phone` WHERE user_ids = #{userIds}")
    fun queryById(userIds:String):List<Phone>

    @Select("SELECT * FROM `phone` WHERE imei = #{imei}")
    fun queryByImei(imei:String):List<Phone>

    @Select("SELECT * FROM `phone` WHERE imei = #{imei} AND user_ids = #{userIds}")
    fun queryBy(phone: Phone):List<Phone>

    @Select("select * from `phone`")
    fun listPhone():Page<Phone>
}