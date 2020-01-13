package com.example.debut.controller

import com.example.debut.base.MyResponse
import com.example.debut.entity.Sign
import com.example.debut.entity.Split
import com.example.debut.mapper.SignMapper
import com.example.debut.util.CommonUtil
import com.github.pagehelper.PageHelper
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@Api(value = "/Sign", tags = arrayOf("操作Sign"))
@RestController
class SignController {

    @Autowired
    lateinit var signMapper: SignMapper

    @ApiOperation(value = "增加sign")
    @RequestMapping(value = ["/sign/add"], method = [RequestMethod.POST])
    fun addSign(@RequestBody sign: Sign) : MyResponse<Boolean> {
        var response = MyResponse(201, "userId为空", false)
        if (sign.userId.isNullOrBlank()){
            return response
        }
        sign.ctTime = CommonUtil.getToday()
        val list = signMapper.queryById(sign.userId, sign.ctTime)
        if (list.isNotEmpty()){
            response.code = 203
            response.msg = "今日已签到，请不要重复签到！"
            return response
        }
        val value = signMapper.addSign(sign)
        if (value>0){
            response.msg = "添加成功"
            response.code = 200
            response.data = true
            return response
        }
        response.code = 202
        response.msg = "添加失败，存入数据库失败"
        return response
    }

    @ApiOperation(value = "根据userId、ctTime查询sign")
    @RequestMapping(value = ["/sign/queryById"], method = [RequestMethod.POST])
    fun queryById(@RequestBody  sign: Sign) : MyResponse<List<Sign>> {
        var response = MyResponse(201, "userId为空", listOf<Sign>())
        if (sign.userId.isNullOrBlank()){
            return response
        }
        sign.ctTime = CommonUtil.getToday()
        val list = signMapper.queryById(sign.userId, sign.ctTime)
        return MyResponse(200, "查询成功", list)
    }

    @ApiOperation(value = "sign列表")
    @RequestMapping(value = ["/sign/list"], method = [RequestMethod.POST])
    fun listSign(@RequestBody split: Split) : MyResponse<List<Sign>> {
        PageHelper.startPage<Sign>(split.pageNum?:1, split.pageSize?:20)
        val list = signMapper.listSign()
        return MyResponse(200, "查询成功", list)
    }

    @ApiOperation(value = "根据userId得到sign列表")
    @RequestMapping(value = ["/sign/listById"], method = [RequestMethod.POST])
    fun listById(@RequestBody  sign: Sign) : MyResponse<List<Sign>> {
        val list = signMapper.listById(sign.userId)
        return MyResponse(200, "查询成功", list)
    }
}