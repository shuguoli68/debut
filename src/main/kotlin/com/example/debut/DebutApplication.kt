package com.example.debut

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@MapperScan("com.example.debut.mapper")
@SpringBootApplication
class DebutApplication : SpringBootServletInitializer()

fun main(args: Array<String>) {
    runApplication<DebutApplication>(*args)
}
