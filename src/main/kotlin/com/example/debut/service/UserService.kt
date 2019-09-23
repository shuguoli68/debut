package com.example.debut.service

import com.example.debut.entity.Diary
import com.example.debut.entity.User

interface UserService {
    fun register(user: User):Int
    fun delUser(userId: String):Int
    fun upUser(user: User):Int
    fun queryById(userId:String):List<User>
    fun listDiary(userId:String):List<Diary>
    fun userDiarys(userId:String):User
}