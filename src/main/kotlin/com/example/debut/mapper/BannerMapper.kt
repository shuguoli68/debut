package com.example.debut.mapper

import com.example.debut.entity.Banner
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface BannerMapper {
    @Insert("INSERT INTO `banner` VALUES(#{id},#{imgPath},#{urlPath},#{title},#{des},#{mstr})")
    fun addBanner(banner: Banner):Int

    @Delete("DELETE FROM `banner` WHERE id = #{id}")
    fun delBanner(id: Int):Int

    @Update("UPDATE `banner`\n" +
            "        SET url_path = #{urlPath}, title = #{title}, des = #{des}, mstr = #{mstr}\n" +
            "        WHERE img_path = #{imgPath}")
    fun upBanner(banner: Banner):Int

    @Select("SELECT * FROM `banner` WHERE img_path = #{imgPath}")
    fun queryByImgPath(imgPath:String):List<Banner>

    @Select("select * from `banner`")
    fun listBanner():Page<Banner>
}