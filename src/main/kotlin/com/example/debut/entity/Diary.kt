package com.example.debut.entity

data class Diary(
    var diaryId: String,
    var title: String?,
    var content: String?,
    var theme: Int?,
    var subTheme: Int?,
    var ctTime: Long?,
    var utTime: Long?,
    var userId: String?
)