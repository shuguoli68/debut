package com.example.debut.mapper

import com.example.debut.entity.Diary
import com.example.debut.entity.DiaryLike
import com.example.debut.entity.DiaryLikeCount
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Repository

@Repository
interface DiaryLikeMapper {
    @Insert("INSERT INTO `diary_like` VALUES(#{id},#{userId},#{diaryId},#{love},#{collect})")
    fun addDiaryLike(diary_like: DiaryLike):Int

    @Delete("DELETE FROM `diary_like` WHERE user_id = #{userId}")
    fun delByUserId(userId: String):Int

    @Delete("DELETE FROM `diary_like` WHERE diary_id = #{diaryId}")
    fun delByDiaryId(diaryId: String):Int

    @Update("UPDATE `diary_like`\n" +
            "        SET love = #{love}, collect = #{collect}\n" +
            "        WHERE user_id = #{userId} AND diary_id = #{diaryId}")
    fun upDiaryLike(diary_like: DiaryLike):Int

    @Select("SELECT * FROM `diary_like` WHERE user_id = #{userId} AND diary_id = #{diaryId} AND love = #{love}")
    fun queryLike(diary_like: DiaryLike):List<DiaryLike>

    @Select("SELECT * FROM `diary_like` WHERE user_id = #{userId} AND diary_id = #{diaryId} AND collect = #{collect}")
    fun queryCollect(diary_like: DiaryLike):List<DiaryLike>

    @Select("SELECT * FROM `diary_like` WHERE user_id = #{userId} AND diary_id = #{diaryId}")
    fun queryByUserDiaryId(diary_like: DiaryLike):List<DiaryLike>

    @Select("select * from `diary_like`")
    fun listDiaryLike():Page<DiaryLike>

    /**
     * 操作数量表
     */
    @Insert("INSERT INTO `diary_like_count` VALUES(#{id},#{diaryId},#{love},#{unlove},#{collect})")
    fun addLikeCount(likeCount: DiaryLikeCount):Int

    @Select("SELECT * FROM `diary_like_count` WHERE diary_id = #{diaryId}")
    fun queryLikeCount(diaryId: String):List<DiaryLikeCount>

    @Update("UPDATE `diary_like_count`\n" +
            "        SET love = #{love}, unlove = #{unlove},collect = #{collect}\n" +
            "        WHERE diary_id = #{diaryId}")
    fun upLikeCount(likeCount: DiaryLikeCount):Int

    @Select("select * from `diary_like_count` order by love desc")
    fun loveRank():Page<DiaryLikeCount>

    @Select("select * from `diary_like_count` order by unlove desc")
    fun unloveRank():Page<DiaryLikeCount>

    @Select("select * from `diary_like_count` order by collect desc")
    fun collectRank():Page<DiaryLikeCount>
}