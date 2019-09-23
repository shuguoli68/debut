package com.example.debut.service

import com.example.debut.entity.Diary
import com.github.pagehelper.Page

interface DiaryService {
    fun addDiary(diary: Diary):Int
    fun delDiary(diaryId: String):Int
    fun upDiary(diary: Diary):Int
    fun queryById(diaryId:String):List<Diary>
    fun listDiary():Page<Diary>
    fun queryByUserId(userId:String):List<Diary>
}