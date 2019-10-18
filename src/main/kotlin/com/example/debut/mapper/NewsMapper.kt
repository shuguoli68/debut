package com.example.debut.mapper

import com.example.debut.entity.News
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface NewsMapper {
    @Insert("INSERT INTO `news` VALUES(#{newsId,jdbcType=VARCHAR},#{title,jdbcType=VARCHAR})")
    fun addNews(news: News):Int

    @Delete("DELETE FROM `news` WHERE news_id = #{newsId,jdbcType=VARCHAR}")
    fun delNews(newsId: String):Int

    @Update("UPDATE `news`\n" +
            "        SET title = #{title,jdbcType=VARCHAR}, content = #{content,jdbcType=VARCHAR}\n" +
            "        WHERE news_id = #{newsId,jdbcType=VARCHAR}")
    fun upNews(news: News):Int

    @Select("SELECT * FROM `news` WHERE news_id = #{newsId,jdbcType=VARCHAR}")
    fun queryById(newsId:String):List<News>

    @Select("select * from `news`")
    fun listNews():Page<News>
}