package com.example.debut.mapper

import com.example.debut.entity.Token
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface TokenMapper {
    @Insert("INSERT INTO `token` VALUES(#{id,jdbcType=INTEGER},#{userId,jdbcType=VARCHAR},#{userToken,jdbcType=VARCHAR})")
    fun addToken(token: Token):Int

    @Delete("DELETE FROM `token` WHERE user_id = #{userId,jdbcType=VARCHAR}")
    fun delToken(userId: String):Int

    @Update("UPDATE `token`\n" +
            "        SET user_token = #{userToken,jdbcType=VARCHAR}\n" +
            "        WHERE user_id = #{userId,jdbcType=VARCHAR}")
    fun upToken(token: Token):Int

    @Select("SELECT * FROM `token` WHERE user_id = #{userId,jdbcType=VARCHAR}")
    fun queryById(userId:String):List<Token>

    @Select("select * from `token`")
    fun listToken():Page<Token>
}
