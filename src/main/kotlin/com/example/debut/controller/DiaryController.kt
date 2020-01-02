package com.example.debut.controller

import com.example.debut.base.MyResponse
import com.example.debut.entity.Diary
import com.example.debut.entity.Split
import com.example.debut.mapper.DiaryMapper
import com.example.debut.util.CommonUtil
import com.github.pagehelper.PageHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class DiaryController {

    @Autowired
    lateinit var diaryService: DiaryMapper

    @RequestMapping(value = ["/diary/add"], method = [RequestMethod.POST])
    fun addDiary(@RequestBody diary: Diary) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题或内容为空", false)
        if (diary.title.isNullOrBlank() || diary.content.isNullOrBlank()){
            return response
        }
        val list = diaryService.queryById(diary.diaryId)
        if (list.isNotEmpty()){
            response.msg = "发布失败，该Diary已存在"
            return response
        }
        diary.ctTime = CommonUtil.getNowDate()
        diary.utTime = CommonUtil.getNowDate()
        val value = diaryService.addDiary(diary)
        if (value>0){
            response.msg = "发布成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "发布失败，存入数据库失败"
        return response
    }

    @RequestMapping(value = ["/diary/del"], method = [RequestMethod.POST])
    fun delDiary(@RequestBody diary: Diary) : MyResponse<Boolean> {
        var response = MyResponse(201, "DiaryId为空", false)
        if (diary.diaryId.isNullOrBlank()){
            return response
        }
        val value = diaryService.delDiary(diary.diaryId)
        if (value>0){
            response.msg = "删除成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "删除失败，从数据库删除失败"
        return response
    }

    @RequestMapping(value = ["/diary/update"], method = [RequestMethod.POST])
    fun upDiary(@RequestBody diary: Diary) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题或内容为空", false)
        if (diary.title.isNullOrBlank() || diary.content.isNullOrBlank()){
            return response
        }
        diary.ctTime = CommonUtil.getNowDate()
        val value = diaryService.upDiary(diary)
        if (value>0){
            response.msg = "修改成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "修改失败，存入数据库失败"
        return response
    }

    @RequestMapping(value = ["/diary/list"], method = [RequestMethod.POST])
    fun listDiary(@RequestBody split: Split) : MyResponse<List<Diary>> {
        PageHelper.startPage<Diary>(split.pageNum?:1, split.pageSize?:20)
        val list = diaryService.listDiary()
        return MyResponse(200, "查询成功", list)
    }
}