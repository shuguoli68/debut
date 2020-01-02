package com.example.debut

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import springfox.documentation.swagger2.annotations.EnableSwagger2

@MapperScan("com.example.debut.mapper")
@SpringBootApplication
@EnableSwagger2
class DebutApplication : SpringBootServletInitializer()

fun main(args: Array<String>) {
    runApplication<DebutApplication>(*args)
}
