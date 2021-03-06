package com.example.debut.mapper

import com.example.debut.entity.Diary
import com.example.debut.entity.User
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface UserMapper {

    @Insert("INSERT INTO `user` VALUES(#{id},#{userId},#{passWord},#{name},#{phone},#{sex},#{age},#{ctTime},#{utTime})")
    fun register(user: User):Int

    @Delete("DELETE FROM `user` WHERE user_id = #{userId}")
    fun delUser(userId: String):Int

    @Update("UPDATE `user` SET\n" +
            "            phone = #{phone},\n" +
            "            pass_word = #{passWord},\n" +
            "            name = #{name},\n" +
            "            sex = #{sex},\n" +
            "            age = #{age},\n" +
            "            update_time = #{utTime}\n" +
            "        WHERE user_id = #{userId}")
    fun upUser(user: User):Int

    @Select("SELECT * FROM `user` WHERE user_id = #{userId}")
    fun queryById(userId:String):List<User>

    @Select("SELECT * FROM `user` WHERE user_id = #{userId}")
    @Results(
            Result(property = "userId", column = "user_id"),
            Result(property = "diarys", column = "user_id", many = Many(select = "com.example.debut.mapper.DiaryMapper.queryByUserId"))
    )
    fun userDiarys(userId:String):User

    @Select("select * from `user`")
    fun listUser(): Page<User>

    /**
     * 删除用户时，删除用户对文章的点赞、踩、收藏表中数据
     */
    @Delete("DELETE FROM `diary_like` WHERE user_id = #{userId}")
    fun delLikeByUserId(userId: String):Int
}