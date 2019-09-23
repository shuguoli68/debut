package com.example.debut

import com.example.debut.controller.DiaryController
import com.example.debut.controller.UserController
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@MapperScan("com.example.debut.mapper")
@SpringBootApplication
class DebutApplication

fun main(args: Array<String>) {
    runApplication<DebutApplication>(*args)
    //开启各个Controller
    UserController()
    DiaryController()
}
