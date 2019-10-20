package com.example.debut.controller

import com.example.debut.base.MyResponse
import com.example.debut.entity.CenterDiaryTag
import com.example.debut.entity.Split
import com.example.debut.mapper.CenterDiaryTagMapper
import com.github.pagehelper.PageHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class CenterDiaryTagController {

    @Autowired
    lateinit var centerDiaryTagService: CenterDiaryTagMapper

//    @RequestMapping(value = ["/centerDiaryTag/add"], method = [RequestMethod.POST])
//    fun addCenterDiaryTag(@RequestBody centerDiaryTag: CenterDiaryTag) : MyResponse<Boolean> {
//        var response = MyResponse(201, "标题或内容为空", false)
//        if (centerDiaryTag.diaryId.isNullOrBlank() || centerDiaryTag.tagId.isNullOrBlank()){
//            return response
//        }
//        val list = centerDiaryTagService.queryById(centerDiaryTag.centerDiaryTagId)
//        if (list.isNotEmpty()){
//            response.msg = "添加失败，该CenterDiaryTag已存在"
//            return response
//        }
//        val value = centerDiaryTagService.addCenterDiaryTag(centerDiaryTag)
//        if (value>0){
//            response.msg = "添加成功"
//            response.code = 200
//            response.data = true
//            return response
//        }
//        response.msg = "添加失败，存入数据库失败"
//        return response
//    }

//    @RequestMapping(value = ["/centerDiaryTag/del"], method = [RequestMethod.POST])
//    fun delCenterDiaryTag(@RequestBody centerDiaryTag: CenterDiaryTag) : MyResponse<Boolean> {
//        var response = MyResponse(201, "CenterDiaryTagId为空", false)
//        if (centerDiaryTag.centerDiaryTagId.isNullOrBlank()){
//            return response
//        }
//        val value = centerDiaryTagService.delCenterDiaryTag(centerDiaryTag.centerDiaryTagId)
//        if (value>0){
//            response.msg = "删除成功"
//            response.code = 200
//            response.data = true
//            return response
//        }
//        response.msg = "删除失败，从数据库删除失败"
//        return response
//    }

    @RequestMapping(value = ["/centerDiaryTag/findByTagId"], method = [RequestMethod.POST])
    fun findByTagId(@RequestBody centerDiaryTag: CenterDiaryTag) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题或内容为空", false)
        if (centerDiaryTag.tagId.isNullOrBlank() ){
            return response
        }
        val list = centerDiaryTagService.queryByTagId(centerDiaryTag.tagId)
        if (list.isNotEmpty()){
            response.msg = "查询成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "查询失败"
        return response
    }

    @RequestMapping(value = ["/centerDiaryTag/findByDiaryId"], method = [RequestMethod.POST])
    fun findByDiaryId(@RequestBody centerDiaryTag: CenterDiaryTag) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题或内容为空", false)
        if (centerDiaryTag.diaryId.isNullOrBlank()){
            return response
        }
        val list = centerDiaryTagService.queryByDiaryId(centerDiaryTag.diaryId)
        if (list.isNotEmpty()){
            response.msg = "查询成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "查询失败"
        return response
    }

    @RequestMapping(value = ["/centerDiaryTag/list"], method = [RequestMethod.POST])
    fun listCenterDiaryTag(@RequestBody split: Split) : MyResponse<List<CenterDiaryTag>> {
        PageHelper.startPage<CenterDiaryTag>(split.pageNum?:1, split.pageSize?:20)
        val list = centerDiaryTagService.listCenterDiaryTag()
        return MyResponse(200, "查询成功", list)
    }
}