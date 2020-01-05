package com.example.debut.controller

import com.example.debut.base.MyResponse
import com.example.debut.entity.DiaryLike
import com.example.debut.entity.Split
import com.example.debut.mapper.DiaryLikeMapper
import com.github.pagehelper.PageHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class DiaryLikeController {

    @Autowired
    lateinit var diaryLikeMapper: DiaryLikeMapper

    @RequestMapping(value = ["/diaryLike/add"], method = [RequestMethod.POST])
    fun addDiaryLike(@RequestBody diaryLike: DiaryLike) : MyResponse<Boolean> {
        var response = MyResponse(201, "用户或日记不存在", false)
        if (diaryLike.userId.isNullOrBlank() || diaryLike.diaryId.isNullOrBlank()){
            return response
        }
        val list = diaryLikeMapper.queryByUserDiaryId(diaryLike.userId, diaryLike.diaryId)
        if (list.isNotEmpty()){
            val value = diaryLikeMapper.upDiaryLike(diaryLike)
            if (value>0){
                response.msg = "该DiaryLike已存在,更新成功"
                response.code = 200
                response.data = true
                return response
            }
            response.code = 202
            response.msg = "该DiaryLike已存在,更新失败，存入数据库失败"
            return response
        }
        val value = diaryLikeMapper.addDiaryLike(diaryLike)
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

    @RequestMapping(value = ["/diaryLike/del"], method = [RequestMethod.POST])
    fun delDiaryLike(@RequestBody diaryLike: DiaryLike) : MyResponse<Boolean> {
        var response = MyResponse(201, "失败，id为空", false)
        if (diaryLike.userId.isNullOrBlank() && diaryLike.diaryId.isNullOrBlank()){
            return response
        }
        val value = diaryLikeMapper.delByUserId(diaryLike.userId)
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

    @RequestMapping(value = ["/diaryLike/listLike"], method = [RequestMethod.POST])
    fun listLike(@RequestBody  diaryLike: DiaryLike) : MyResponse<List<DiaryLike>> {
        var response = MyResponse(201, "用户或日记不存在", listOf<DiaryLike>())
        if (diaryLike.userId.isNullOrBlank() || diaryLike.diaryId.isNullOrBlank()){
            return response
        }
        val list = diaryLikeMapper.queryLike(diaryLike)
        return MyResponse(200, "查询成功", list)
    }

    @RequestMapping(value = ["/diaryLike/listCollect"], method = [RequestMethod.POST])
    fun listCollect(@RequestBody  diaryLike: DiaryLike) : MyResponse<List<DiaryLike>> {
        var response = MyResponse(201, "用户或日记不存在", listOf<DiaryLike>())
        if (diaryLike.userId.isNullOrBlank() || diaryLike.diaryId.isNullOrBlank()){
            return response
        }
        val list = diaryLikeMapper.queryCollect(diaryLike)
        return MyResponse(200, "查询成功", list)
    }

    @RequestMapping(value = ["/diaryLike/list"], method = [RequestMethod.POST])
    fun listDiaryLike(@RequestBody split: Split) : MyResponse<List<DiaryLike>> {
        PageHelper.startPage<DiaryLike>(split.pageNum?:1, split.pageSize?:20)
        val list = diaryLikeMapper.listDiaryLike()
        return MyResponse(200, "查询成功", list)
    }
}