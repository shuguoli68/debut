package com.example.debut.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConf {
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController::class.java))
                .paths(PathSelectors.any())
                .build()//                .enable(false)//线上可以关闭
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("debut后台api接口文档")
                .description("json 风格接口")
                .termsOfServiceUrl("http://127.0.0.1:8085/doc.html")
                .version("1.0")
                .build()
    }
}
