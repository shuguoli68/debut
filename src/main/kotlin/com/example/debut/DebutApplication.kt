package com.example.debut

import com.example.debut.util.updown.FileStorageProperties
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import springfox.documentation.swagger2.annotations.EnableSwagger2

@MapperScan("com.example.debut.mapper")
@SpringBootApplication
@EnableSwagger2
@EnableConfigurationProperties(FileStorageProperties::class)
class DebutApplication : SpringBootServletInitializer()

fun main(args: Array<String>) {
    runApplication<DebutApplication>(*args)
}

@Override
fun configure(builder:SpringApplicationBuilder) : SpringApplicationBuilder {
    return builder.sources(DebutApplication::class.java)
}