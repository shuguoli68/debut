package com.example.debut.controller

import com.example.debut.base.MyResponse
import com.example.debut.entity.DiarySubTheme
import com.example.debut.entity.Split
import com.example.debut.mapper.DiarySubThemeMapper
import com.github.pagehelper.PageHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class DiarySubThemeController {

    @Autowired
    lateinit var diarySubThemeMapper: DiarySubThemeMapper

    @RequestMapping(value = ["/diarySubTheme/add"], method = [RequestMethod.POST])
    fun addDiarySubTheme(@RequestBody diarySubTheme: DiarySubTheme) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题或主分类为空", false)
        if (diarySubTheme.subThemeName.isNullOrBlank() || diarySubTheme.themeId==null){
            return response
        }
        val list = diarySubThemeMapper.queryById(diarySubTheme.subThemeId)
        if (list.isNotEmpty()){
            val value = diarySubThemeMapper.upDiarySubTheme(diarySubTheme)
            if (value>0){
                response.msg = "该DiarySubTheme已存在,更新成功"
                response.code = 200
                response.data = true
                return response
            }
            response.msg = "该DiarySubTheme已存在,更新失败，存入数据库失败"
            return response
        }
        val value = diarySubThemeMapper.addDiarySubTheme(diarySubTheme)
        if (value>0){
            response.msg = "添加成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "添加失败，存入数据库失败"
        return response
    }

    @RequestMapping(value = ["/diarySubTheme/del"], method = [RequestMethod.POST])
    fun delDiarySubTheme(@RequestBody diarySubTheme: DiarySubTheme) : MyResponse<Boolean> {
        var response = MyResponse(201, "DiarySubThemeId为空", false)
        if (diarySubTheme.subThemeId==null){
            return response
        }
        val value = diarySubThemeMapper.delDiarySubTheme(diarySubTheme.subThemeId)
        if (value>0){
            response.msg = "删除成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "删除失败，从数据库删除失败"
        return response
    }

    @RequestMapping(value = ["/diarySubTheme/listById"], method = [RequestMethod.POST])
    fun listDiarySubThemeById(@RequestBody  diarySubTheme: DiarySubTheme) : MyResponse<List<DiarySubTheme>> {
        val list = diarySubThemeMapper.queryById(diarySubTheme.subThemeId)
        return MyResponse(200, "查询成功", list)
    }
    @RequestMapping(value = ["/diarySubTheme/list"], method = [RequestMethod.POST])
    fun listDiarySubTheme(@RequestBody split: Split) : MyResponse<List<DiarySubTheme>> {
        PageHelper.startPage<DiarySubTheme>(split.pageNum?:1, split.pageSize?:20)
        val list = diarySubThemeMapper.listDiarySubTheme()
        return MyResponse(200, "查询成功", list)
    }
}