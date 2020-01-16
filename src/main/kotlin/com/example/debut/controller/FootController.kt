package com.example.debut.controller

import com.example.debut.base.MyResponse
import com.example.debut.entity.Foot
import com.example.debut.entity.Split
import com.example.debut.mapper.FootMapper
import com.example.debut.util.CommonUtil
import com.github.pagehelper.PageHelper
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@Api(value = "Foot", tags = arrayOf("浏览足迹"))
@RestController
class FootController {

    @Autowired
    lateinit var footMapper: FootMapper

    @ApiOperation(value = "浏览，增加foot")
    @RequestMapping(value = ["/foot/add"], method = [RequestMethod.POST])
    fun addFoot(@RequestBody foot: Foot) : MyResponse<Boolean> {
        var response = MyResponse(201, "userId或toUserId为空", false)
        if (foot.userId.isNullOrBlank() || foot.toUserId.isNullOrBlank()){
            return response
        }
        foot.ctTime = CommonUtil.getToday()
        foot.strTime = CommonUtil.getNowDate()
        val list = footMapper.queryById(foot)
        if (list.isNotEmpty()){
            response.code = 203
            response.msg = "今日已浏览，请不要重复请求！"
            return response
        }
        val value = footMapper.addFoot(foot)
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

    @ApiOperation(value = "根据ID查询foot")
    @RequestMapping(value = ["/foot/listById"], method = [RequestMethod.POST])
    fun listFootById(@RequestBody  foot: Foot) : MyResponse<List<Foot>> {
        var response = MyResponse(201, "userId或toUserId为空", listOf<Foot>())
        if (foot.userId.isNullOrBlank() || foot.toUserId.isNullOrBlank()){
            return response
        }
        val list = footMapper.queryById(foot)
        return MyResponse(200, "查询成功", list)
    }

    @ApiOperation(value = "浏览，我浏览过的用户列表")
    @RequestMapping(value = ["/foot/queryBrowse"], method = [RequestMethod.POST])
    fun queryBrowse(@RequestBody  foot: Foot) : MyResponse<List<Foot>> {
        var response = MyResponse(201, "userId为空", listOf<Foot>())
        if (foot.userId.isNullOrBlank()){
            return response
        }
        val list = footMapper.queryBrowse(foot.userId)
        return MyResponse(200, "查询成功", list)
    }

    @ApiOperation(value = "足迹，看过我的用户列表")
    @RequestMapping(value = ["/foot/queryFoot"], method = [RequestMethod.POST])
    fun queryFoot(@RequestBody  foot: Foot) : MyResponse<List<Foot>> {
        var response = MyResponse(201, "userId为空", listOf<Foot>())
        if (foot.userId.isNullOrBlank()){
            return response
        }
        val list = footMapper.queryFoot(foot.userId)
        return MyResponse(200, "查询成功", list)
    }

    @ApiOperation(value = "foot列表")
    @RequestMapping(value = ["/foot/list"], method = [RequestMethod.POST])
    fun listFoot(@RequestBody split: Split) : MyResponse<List<Foot>> {
        PageHelper.startPage<Foot>(split.pageNum?:1, split.pageSize?:20)
        val list = footMapper.listFoot()
        return MyResponse(200, "查询成功", list)
    }
}