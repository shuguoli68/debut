package com.example.debut.controller

import com.example.debut.base.MyResponse
import com.example.debut.entity.DiaryLike
import com.example.debut.entity.Split
import com.example.debut.mapper.DiaryLikeMapper
import com.github.pagehelper.PageHelper
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@Api(value = "/diaryLike", tags = arrayOf("diaryLike的增删改查"))
@RestController
class DiaryLikeController {

    @Autowired
    lateinit var diaryLikeMapper: DiaryLikeMapper

    @ApiOperation(value = "增加diary")
    @RequestMapping(value = ["/diaryLike/add"], method = [RequestMethod.POST])
    fun addDiaryLike(@RequestBody diaryLike: DiaryLike) : MyResponse<Boolean> {
        var response = MyResponse(201, "用户或日记不存在", false)
        if (diaryLike.userId.isNullOrBlank() || diaryLike.diaryId.isNullOrBlank()){
            return response
        }
        val list = diaryLikeMapper.queryByUserDiaryId(diaryLike)
        if (list != null && list.isNotEmpty()){
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

    @ApiOperation(value = "删除用户时，删除diaryLike")
    @RequestMapping(value = ["/diaryLike/delUser"], method = [RequestMethod.POST])
    fun delUserLike(@RequestBody diaryLike: DiaryLike) : MyResponse<Boolean> {
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

    @ApiOperation(value = "删除日记时，删除diaryLike")
    @RequestMapping(value = ["/diaryLike/delDiary"], method = [RequestMethod.POST])
    fun delDiaryLike(@RequestBody diaryLike: DiaryLike) : MyResponse<Boolean> {
        var response = MyResponse(201, "失败，id为空", false)
        if (diaryLike.userId.isNullOrBlank() && diaryLike.diaryId.isNullOrBlank()){
            return response
        }
        val value = diaryLikeMapper.delByDiaryId(diaryLike.diaryId)
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

    @ApiOperation(value = "diary点赞列表")
    @RequestMapping(value = ["/diaryLike/listLike"], method = [RequestMethod.POST])
    fun listLike(@RequestBody  diaryLike: DiaryLike) : MyResponse<List<DiaryLike>> {
        var response = MyResponse(201, "用户或日记不存在", listOf<DiaryLike>())
        if (diaryLike.userId.isNullOrBlank() || diaryLike.diaryId.isNullOrBlank()){
            return response
        }
        val list = diaryLikeMapper.queryLike(diaryLike)
        return MyResponse(200, "查询成功", list)
    }

    @ApiOperation(value = "diary的收藏列表")
    @RequestMapping(value = ["/diaryLike/listCollect"], method = [RequestMethod.POST])
    fun listCollect(@RequestBody  diaryLike: DiaryLike) : MyResponse<List<DiaryLike>> {
        var response = MyResponse(201, "用户或日记不存在", listOf<DiaryLike>())
        if (diaryLike.userId.isNullOrBlank() || diaryLike.diaryId.isNullOrBlank()){
            return response
        }
        val list = diaryLikeMapper.queryCollect(diaryLike)
        return MyResponse(200, "查询成功", list)
    }

    @ApiOperation(value = "diaryLike列表")
    @RequestMapping(value = ["/diaryLike/list"], method = [RequestMethod.POST])
    fun listDiaryLike(@RequestBody split: Split) : MyResponse<List<DiaryLike>> {
        PageHelper.startPage<DiaryLike>(split.pageNum?:1, split.pageSize?:20)
        val list = diaryLikeMapper.listDiaryLike()
        return MyResponse(200, "查询成功", list)
    }
}