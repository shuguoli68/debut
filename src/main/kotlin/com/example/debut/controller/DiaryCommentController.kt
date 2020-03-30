package com.example.debut.controller

import com.example.debut.base.MyResponse
import com.example.debut.entity.DiaryComment
import com.example.debut.entity.Split
import com.example.debut.mapper.DiaryCommentMapper
import com.github.pagehelper.PageHelper
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@Api(value = "DiaryComment", tags = arrayOf("操作DiaryComment"))
@RestController
class DiaryCommentController {

    @Autowired
    lateinit var diaryCommentMapper: DiaryCommentMapper

    @ApiOperation(value = "增加diaryComment")
    @RequestMapping(value = ["/diaryComment/add"], method = [RequestMethod.POST])
    fun addDiaryComment(@RequestBody diaryComment: DiaryComment) : MyResponse<Boolean> {
        var response = MyResponse(201, "内容为空", false)
        if (diaryComment.diaryId.isNullOrBlank() ){
            return response
        }
        val value = diaryCommentMapper.addDiaryComment(diaryComment)
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

    /*@ApiOperation(value = "删除diaryComment")
    @RequestMapping(value = ["/diaryComment/del"], method = [RequestMethod.POST])
    fun delDiaryComment(@RequestBody diaryComment: DiaryComment) : MyResponse<Boolean> {
        var response = MyResponse(201, "DiaryCommentId为空", false)
        if (diaryComment.diaryCommentId.isNullOrBlank()){
            return response
        }
        val value = diaryCommentMapper.delDiaryComment(diaryComment.diaryCommentId)
        if (value>0){
            response.msg = "删除成功"
            response.code = 200
            response.data = true
            return response
        }
        response.code = 202
        response.msg = "删除失败，从数据库删除失败"
        return response
    }*/

    @ApiOperation(value = "根据ID查询diaryComment")
    @RequestMapping(value = ["/diaryComment/listById"], method = [RequestMethod.POST])
    fun listDiaryCommentById(@RequestBody  diaryComment: DiaryComment) : MyResponse<List<DiaryComment>> {
        var response = MyResponse(201, "DiaryCommentId为空", listOf<DiaryComment>())
        if (diaryComment.diaryId.isNullOrBlank()){
           return response
        }
        val list = diaryCommentMapper.queryById(diaryComment)
        return MyResponse(200, "查询成功", list)
    }

    @ApiOperation(value = "diaryComment列表")
    @RequestMapping(value = ["/diaryComment/list"], method = [RequestMethod.POST])
    fun listDiaryComment(@RequestBody split: Split) : MyResponse<List<DiaryComment>> {
        PageHelper.startPage<DiaryComment>(split.pageNum?:1, split.pageSize?:20)
        val list = diaryCommentMapper.listDiaryComment()
        return MyResponse(200, "查询成功", list)
    }
}