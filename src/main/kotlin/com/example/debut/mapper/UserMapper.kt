package com.example.debut.mapper

import com.example.debut.entity.Diary
import com.example.debut.entity.User
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface UserMapper {

    @Insert("INSERT INTO `user` VALUES(#{userId,jdbcType=VARCHAR},#{passWord,jdbcType=VARCHAR},#{phone,jdbcType=VARCHAR},#{sex,jdbcType=INTEGER},#{age,jdbcType=INTEGER},#{ctTime,jdbcType=TIMESTAMP},#{utTime,jdbcType=TIMESTAMP})")
    fun register(user: User):Int

    @Delete("DELETE FROM `user` WHERE user_id = #{userId,jdbcType=VARCHAR}")
    fun delUser(userId: String):Int

    @Update("UPDATE `user` SET\n" +
            "            phone = #{phone,jdbcType=VARCHAR},\n" +
            "            pass_word = #{passWord,jdbcType=VARCHAR},\n" +
            "            sex = #{sex,jdbcType=INTEGER},\n" +
            "            age = #{age,jdbcType=INTEGER},\n" +
            "            update_time = #{utTime,jdbcType=TIMESTAMP}\n" +
            "        WHERE user_id = #{userId,jdbcType=VARCHAR}")
    fun upUser(user: User):Int

    @Select("SELECT * FROM `user` WHERE user_id = #{userId,jdbcType=VARCHAR}")
    fun queryById(userId:String):List<User>

    @Select("SELECT * FROM `user` WHERE user_id = #{userId,jdbcType=VARCHAR}")
    @Results(
            Result(property = "userId", column = "user_id"),
            Result(property = "diarys", column = "user_id", many = Many(select = "com.example.debut.mapper.DiaryMapper.queryByUserId")),
            Result(property = "tagId", column = "tag_id"),
            Result(property = "diaryTags", column = "tag_id", many = Many(select = "com.example.debut.mapper.DiaryTagMapper.queryById"))
    )
    fun userDiarys(userId:String):User

    @Select("SELECT * FROM `diary` WHERE user_id = #{userId,jdbcType=VARCHAR}")
    fun listDiary(userId:String):List<Diary>
}