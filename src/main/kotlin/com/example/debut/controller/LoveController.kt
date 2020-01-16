package com.example.debut.controller

import com.example.debut.base.MyResponse
import com.example.debut.entity.Love
import com.example.debut.entity.Split
import com.example.debut.mapper.LoveMapper
import com.example.debut.util.CommonUtil
import com.github.pagehelper.PageHelper
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@Api(value = "Love", tags = arrayOf("（取消）关注他人"))
@RestController
class LoveController {

    @Autowired
    lateinit var loveMapper: LoveMapper

    @ApiOperation(value = "关注他人")
    @RequestMapping(value = ["/love/add"], method = [RequestMethod.POST])
    fun addLove(@RequestBody love: Love) : MyResponse<Boolean> {
        var response = MyResponse(201, "userId或toUserId为空", false)
        if (love.userId.isNullOrBlank() || love.toUserId.isNullOrBlank()){
            return response
        }
        val list = loveMapper.queryById(love)
        if (list.isNotEmpty()){
            love.utTime = CommonUtil.getNowDate()
            val value = loveMapper.upLove(love)
            if (value>0){
                response.msg = "该Love已存在,更新成功"
                response.code = 200
                response.data = true
                return response
            }
            response.code = 202
            response.msg = "该Love已存在,更新失败，存入数据库失败"
            return response
        }
        love.ctTime = CommonUtil.getNowDate()
        val value = loveMapper.addLove(love)
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

    @ApiOperation(value = "删除love")
    @RequestMapping(value = ["/love/del"], method = [RequestMethod.POST])
    fun delLove(@RequestBody love: Love) : MyResponse<Boolean> {
        var response = MyResponse(201, "userId或toUserId为空", false)
        if (love.userId.isNullOrBlank() || love.toUserId.isNullOrBlank()){
            return response
        }
        val value = loveMapper.delLove(love)
        if (value>0){
            response.msg = "删除成功"
            response.code = 200
            response.data = true
            return response
        }
        response.code = 202
        response.msg = "删除失败，从数据库删除失败"
        return response
    }

    @ApiOperation(value = "根据ID查询love")
    @RequestMapping(value = ["/love/listById"], method = [RequestMethod.POST])
    fun listLoveById(@RequestBody  love: Love) : MyResponse<List<Love>> {
        var response = MyResponse(201, "userId或toUserId为空", listOf<Love>())
        if (love.userId.isNullOrBlank() || love.toUserId.isNullOrBlank()){
            return response
        }
        val list = loveMapper.queryById(love)
        return MyResponse(200, "查询成功", list)
    }

    @ApiOperation(value = "我关注的用户列表")
    @RequestMapping(value = ["/love/queryLove"], method = [RequestMethod.POST])
    fun queryLove(@RequestBody  love: Love) : MyResponse<List<Love>> {
        var response = MyResponse(201, "userId为空", listOf<Love>())
        if (love.userId.isNullOrBlank()){
            return response
        }
        val list = loveMapper.queryLove(love.userId)
        return MyResponse(200, "查询成功", list)
    }

    @ApiOperation(value = "粉丝列表，即关注我的用户列表")
    @RequestMapping(value = ["/love/queryFan"], method = [RequestMethod.POST])
    fun queryFan(@RequestBody  love: Love) : MyResponse<List<Love>> {
        var response = MyResponse(201, "userId为空", listOf<Love>())
        if (love.userId.isNullOrBlank()){
            return response
        }
        val list = loveMapper.queryFan(love.userId)
        return MyResponse(200, "查询成功", list)
    }

    @ApiOperation(value = "love列表")
    @RequestMapping(value = ["/love/list"], method = [RequestMethod.POST])
    fun listLove(@RequestBody split: Split) : MyResponse<List<Love>> {
        PageHelper.startPage<Love>(split.pageNum?:1, split.pageSize?:20)
        val list = loveMapper.listLove()
        return MyResponse(200, "查询成功", list)
    }
}