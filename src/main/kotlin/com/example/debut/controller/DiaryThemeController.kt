package com.example.debut.controller

import com.example.debut.base.MyResponse
import com.example.debut.entity.DiaryTheme
import com.example.debut.entity.Split
import com.example.debut.mapper.DiaryThemeMapper
import com.github.pagehelper.PageHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class DiaryThemeController {

    @Autowired
    lateinit var diaryThemeMapper: DiaryThemeMapper

    @RequestMapping(value = ["/diaryTheme/add"], method = [RequestMethod.POST])
    fun addDiaryTheme(@RequestBody diaryTheme: DiaryTheme) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题为空", false)
        if (diaryTheme.themeName.isNullOrBlank() || diaryTheme.themeId ==null){
            return response
        }
        val list = diaryThemeMapper.queryById(diaryTheme.themeId)
        if (list.isNotEmpty()){
            val value = diaryThemeMapper.upDiaryTheme(diaryTheme)
            if (value>0){
                response.msg = "该DiaryTheme已存在,更新成功"
                response.code = 200
                response.data = true
                return response
            }
            response.msg = "该DiaryTheme已存在,更新失败，存入数据库失败"
            return response
        }
        val value = diaryThemeMapper.addDiaryTheme(diaryTheme)
        if (value>0){
            response.msg = "添加成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "添加失败，存入数据库失败"
        return response
    }

    @RequestMapping(value = ["/diaryTheme/del"], method = [RequestMethod.POST])
    fun delDiaryTheme(@RequestBody diaryTheme: DiaryTheme) : MyResponse<Boolean> {
        var response = MyResponse(201, "DiaryThemeId为空", false)
        if (diaryTheme.themeId == null){
            return response
        }
        val value = diaryThemeMapper.delDiaryTheme(diaryTheme.themeId)
        if (value>0){
            response.msg = "删除成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "删除失败，从数据库删除失败"
        return response
    }

    @RequestMapping(value = ["/diaryTheme/listById"], method = [RequestMethod.POST])
    fun listDiaryThemeById(@RequestBody  diaryTheme: DiaryTheme) : MyResponse<List<DiaryTheme>> {
        val list = diaryThemeMapper.queryById(diaryTheme.themeId)
        return MyResponse(200, "查询成功", list)
    }

    @RequestMapping(value = ["/diaryTheme/list"], method = [RequestMethod.POST])
    fun listDiaryTheme() : MyResponse<List<DiaryTheme>> {
        val list = diaryThemeMapper.listDiaryTheme()
        return MyResponse(200, "查询成功", list)
    }
}
