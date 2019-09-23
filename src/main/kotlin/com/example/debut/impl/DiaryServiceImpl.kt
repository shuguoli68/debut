package com.example.debut.impl

import com.example.debut.entity.Diary
import com.example.debut.entity.Split
import com.example.debut.mapper.DiaryMapper
import com.example.debut.service.DiaryService
import com.github.pagehelper.Page
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DiaryServiceImpl : DiaryService{


    @Autowired
    lateinit var diaryMapper: DiaryMapper

    override fun addDiary(diary: Diary): Int {
        return diaryMapper.addDiary(diary = diary)
    }

    override fun delDiary(diaryId: String): Int {
        return diaryMapper.delDiary(diaryId)
    }

    override fun upDiary(diary: Diary): Int {
        return diaryMapper.upDiary(diary)
    }

    override fun queryById(diaryId: String): List<Diary> {
        return diaryMapper.queryById(diaryId)
    }

    override fun queryByUserId(userId: String): List<Diary> {
        return diaryMapper.queryByUserId(userId)
    }

    override fun listDiary(): Page<Diary> {
        return diaryMapper.listDiary()
    }
}