package com.example.debut.controller

import com.example.debut.base.MyResponse
import com.example.debut.entity.DiaryTag
import com.example.debut.entity.Split
import com.example.debut.mapper.DiaryTagMapper
import com.github.pagehelper.PageHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class DiaryTagController {

    @Autowired
    lateinit var diaryTagService: DiaryTagMapper

    @RequestMapping(value = ["/diaryTag/add"], method = [RequestMethod.POST])
    fun addDiaryTag(@RequestBody diaryTag: DiaryTag) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题或内容为空", false)
        if (diaryTag.tagStr.isNullOrBlank()){
            return response
        }
        val list = diaryTagService.queryById(diaryTag.tagId)
        if (list.isNotEmpty()){
            response.msg = "添加失败，该DiaryTag已存在"
            return response
        }
        val value = diaryTagService.addDiaryTag(diaryTag)
        if (value>0){
            response.msg = "添加成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "添加失败，存入数据库失败"
        return response
    }

    @RequestMapping(value = ["/diaryTag/del"], method = [RequestMethod.POST])
    fun delDiaryTag(@RequestBody diaryTag: DiaryTag) : MyResponse<Boolean> {
        var response = MyResponse(201, "DiaryTagId为空", false)
        if (diaryTag.tagId==null){
            return response
        }
        val value = diaryTagService.delDiaryTag(diaryTag.tagId)
        if (value>0){
            response.msg = "删除成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "删除失败，从数据库删除失败"
        return response
    }

    @RequestMapping(value = ["/diaryTag/update"], method = [RequestMethod.POST])
    fun upDiaryTag(@RequestBody diaryTag: DiaryTag) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题或内容为空", false)
        if (diaryTag.tagStr.isNullOrBlank()){
            return response
        }
        val value = diaryTagService.upDiaryTag(diaryTag)
        if (value>0){
            response.msg = "修改成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "修改失败，存入数据库失败"
        return response
    }

    @RequestMapping(value = ["/diaryTag/list"], method = [RequestMethod.POST])
    fun listDiaryTag(@RequestBody split: Split) : MyResponse<List<DiaryTag>> {
        PageHelper.startPage<DiaryTag>(split.pageNum?:1, split.pageSize?:20)
        val list = diaryTagService.listDiaryTag()
        return MyResponse(200, "查询成功", list)
    }
}