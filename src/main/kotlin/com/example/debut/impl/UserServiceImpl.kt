package com.example.debut.impl

import com.example.debut.entity.Diary
import com.example.debut.entity.User
import com.example.debut.mapper.UserMapper
import com.example.debut.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    lateinit var userMapper:UserMapper

    override fun register(user: User):Int {
        return userMapper.register(user = user)
    }

    override fun delUser(userId: String):Int {
        return userMapper.delUser(userId = userId)
    }

    override fun upUser(user: User):Int {
        return userMapper.upUser(user = user)
    }

    override fun queryById(userId: String): List<User> {
        return userMapper.queryById(userId = userId)
    }

    override fun userDiarys(userId: String): User {
        return userMapper.userDiarys(userId = userId)
    }

    override fun listDiary(userId: String): List<Diary> {
        return userMapper.listDiary(userId = userId)
    }
}