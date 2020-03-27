package com.example.debut.controller

import com.example.debut.base.MyResponse
import com.example.debut.entity.Phone
import com.example.debut.entity.Split
import com.example.debut.mapper.PhoneMapper
import com.github.pagehelper.PageHelper
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@Api(value = "Phone", tags = arrayOf("操作Phone，设备信息"))
@RestController
class PhoneController {

    @Autowired
    lateinit var phoneMapper: PhoneMapper

    @ApiOperation(value = "增加phone")
    @RequestMapping(value = ["/phone/add"], method = [RequestMethod.POST])
    fun addPhone(@RequestBody phone: Phone) : MyResponse<Boolean> {
        var response = MyResponse(201, "userIds为空", false)
        if (phone.userIds.isNullOrBlank()){
            return response
        }
        val list = phoneMapper.queryBy(phone)
        if (list.isNotEmpty()){
            response.msg = "该Phone已存在"
            response.code = 200
            response.data = true
            return response
        }
        val value = phoneMapper.addPhone(phone)
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

    @ApiOperation(value = "根据ID查询phone")
    @RequestMapping(value = ["/phone/listById"], method = [RequestMethod.POST])
    fun listPhoneById(@RequestBody  phone: Phone) : MyResponse<List<Phone>> {
        var response = MyResponse(201, "PhoneId为空", listOf<Phone>())
        if (phone.userIds.isNullOrBlank()){
           return response
        }
        val list = phoneMapper.queryById(phone.userIds)
        return MyResponse(200, "查询成功", list)
    }

    @ApiOperation(value = "根据imei查询phone")
    @RequestMapping(value = ["/phone/listByImei"], method = [RequestMethod.POST])
    fun listPhoneByImei(@RequestBody  phone: Phone) : MyResponse<List<Phone>> {
        var response = MyResponse(201, "imei为空", listOf<Phone>())
        if (phone.imei.isNullOrBlank()){
            return response
        }
        val list = phoneMapper.queryByImei(phone.imei)
        return MyResponse(200, "查询成功", list)
    }

    @ApiOperation(value = "phone列表")
    @RequestMapping(value = ["/phone/list"], method = [RequestMethod.POST])
    fun listPhone(@RequestBody split: Split) : MyResponse<List<Phone>> {
        PageHelper.startPage<Phone>(split.pageNum?:1, split.pageSize?:20)
        val list = phoneMapper.listPhone()
        return MyResponse(200, "查询成功", list)
    }
}