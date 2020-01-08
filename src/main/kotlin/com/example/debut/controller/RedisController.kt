package com.example.debut.controller

import com.example.debut.base.MyResponse
import com.example.debut.config.RedisUtils
import com.example.debut.entity.KeyValue
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@Api(value = "/Redis", tags = arrayOf("操作Redis"))
@RestController
class RedisController {

    @Resource
    lateinit var redisUtils: RedisUtils

    @ApiOperation(value = "增加redis")
    @RequestMapping(value = ["/redis/add"], method = [RequestMethod.POST])
    fun addRedis(@RequestBody bean: KeyValue) : MyResponse<Boolean> {
        var response = MyResponse(201, "key或value为空", false)
        if (bean.key.isNullOrBlank() || bean.value.isNullOrBlank()){
            return response
        }
        val value = redisUtils.set(bean.key, bean.value)
        if (value){
            response.msg = "添加成功"
            response.code = 200
            response.data = true
            return response
        }
        response.code = 202
        response.msg = "添加失败，存入数据库失败"
        return response
    }

    @ApiOperation(value = "根据key查询value")
    @RequestMapping(value = ["/redis/get"], method = [RequestMethod.POST])
    fun getRedis(@RequestBody bean: KeyValue) : MyResponse<String> {
        var response = MyResponse(201, "key为空", "")
        if (bean.key.isNullOrBlank()){
            return response
        }
        val value = redisUtils.get(bean.key)
        if (!value.isNullOrBlank()){
            response.msg = "查询成功"
            response.code = 200
            response.data = value
            return response
        }
        response.code = 202
        response.msg = "查询失败，key-value不存在"
        return response
    }

    @ApiOperation(value = "根据key删除value")
    @RequestMapping(value = ["/redis/del"], method = [RequestMethod.POST])
    fun delRedis(@RequestBody bean: KeyValue) : MyResponse<Boolean> {
        var response = MyResponse(201, "key为空", false)
        if (bean.key.isNullOrBlank()){
            return response
        }
        val value = redisUtils.get(bean.key)
        if (!value.isNullOrBlank()){
            if (redisUtils.delete(bean.key)){
                response.msg = "删除成功"
                response.code = 200
                response.data = true
                return response
            }
            response.msg = "删除失败"
            response.code = 203
            response.data = false
            return response
        }
        response.code = 202
        response.msg = "删除失败，key-value不存在"
        return response
    }
}