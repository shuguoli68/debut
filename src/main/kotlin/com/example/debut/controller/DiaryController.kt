package com.example.debut.controller

import com.example.debut.base.MyResponse
import com.example.debut.entity.CenterDiaryTag
import com.example.debut.entity.CenterDiaryTheme
import com.example.debut.entity.Diary
import com.example.debut.entity.Split
import com.example.debut.mapper.CenterDiaryTagMapper
import com.example.debut.mapper.DiaryMapper
import com.example.debut.util.CommonUtil
import com.github.pagehelper.PageHelper
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@Api(value = "/diary", tags = arrayOf("diary的增删改查"))
class DiaryController {

    @Autowired
    lateinit var diaryService: DiaryMapper


    @ApiOperation(value = "增加diary")
    @RequestMapping(value = ["/diary/add"], method = [RequestMethod.POST])
    fun addDiary(@RequestBody diary: Diary) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题或内容为空", false)
        if (diary.title.isNullOrBlank() || diary.content.isNullOrBlank()){
            return response
        }
        diary.diaryId = diary.userId+System.currentTimeMillis()
        val list = diaryService.queryById(diary.diaryId)
        if (list.isNotEmpty()){
            response.msg = "发布失败，该Diary已存在"
            return response
        }
        diary.ctTime = CommonUtil.getNowDate()
        diary.utTime = CommonUtil.getNowDate()
        val value = diaryService.addDiary(diary)
        if (value>0){
            saveTag(diary.tagId, diary.diaryId)
            saveTheme(diary.diaryId, diary.theme, diary.subTheme)
            response.msg = "发布成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "发布失败，存入数据库失败"
        return response
    }

    @ApiOperation(value = "删除diary")
    @RequestMapping(value = ["/diary/del"], method = [RequestMethod.POST])
    fun delDiary(@RequestBody diary: Diary) : MyResponse<Boolean> {
        var response = MyResponse(201, "DiaryId为空", false)
        if (diary.diaryId.isNullOrBlank()){
            return response
        }
        val value = diaryService.delDiary(diary.diaryId)
        if (value > 0){
            delTag(diaryId = diary.diaryId)
            delTheme(diaryId = diary.diaryId)
            response.msg = "删除成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "删除失败，从数据库删除失败"
        return response
    }

    @ApiOperation(value = "编辑更新diary")
    @RequestMapping(value = ["/diary/update"], method = [RequestMethod.POST])
    fun upDiary(@RequestBody diary: Diary) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题或内容为空", false)
        if (diary.title.isNullOrBlank() || diary.content.isNullOrBlank()){
            return response
        }
        diary.ctTime = CommonUtil.getNowDate()
        val value = diaryService.upDiary(diary)
        if (value>0){
            saveTag(diary.tagId, diary.diaryId)
            saveTheme(diary.diaryId, diary.theme, diary.subTheme)
            response.msg = "修改成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "修改失败，存入数据库失败"
        return response
    }

    @ApiOperation(value = "根据diaryId查询")
    @RequestMapping(value = ["/diary/query"], method = [RequestMethod.POST])
    fun queryDiary(@RequestBody diary: Diary) : MyResponse<Diary> {
        var response = MyResponse(201, "DiaryId为空", Diary())
        if (diary.diaryId.isNullOrBlank()){
            return response
        }
        val value = diaryService.queryById(diary.diaryId)
        response.data = if (value.isNotEmpty()) value[0] else Diary()
        response.code = 200
        response.msg = "查询成功"
        return response
    }

    @ApiOperation(value = "获取diary列表")
    @RequestMapping(value = ["/diary/list"], method = [RequestMethod.POST])
    fun listDiary(@RequestBody split: Split) : MyResponse<List<Diary>> {
        PageHelper.startPage<Diary>(split.pageNum?:1, split.pageSize?:20)
        val list = diaryService.listDiary()
        return MyResponse(200, "查询成功", list)
    }

    /**
     * 增加中间表标签
     */
    private fun saveTag(tagId:String, diaryId:String){
        if (tagId.isNullOrBlank())
            return
        diaryService.delCenterDiaryTag(diaryId)//删除文章原来的标签
        val tags = tagId.split("|")
        for (id in tags){
            if (!id.isNullOrBlank())//添加文章新的标签
                diaryService.addCenterDiaryTag(CenterDiaryTag(0, diaryId, id))
        }
    }

    /**
     * 删除中间表 标签
     */
    private fun delTag(diaryId:String){
        diaryService.delCenterDiaryTag(diaryId)
    }

    /**
     * 增加中间表分类
     */
    private fun saveTheme(diaryId:String, themeId:Int, subThemeId:Int){
        diaryService.delCenterDiaryTheme(diaryId)//删除文章原来的分类
        diaryService.addCenterDiaryTheme(CenterDiaryTheme(0, diaryId, themeId, subThemeId))
    }

    /**
     * 删除中间表分类
     */
    private fun delTheme(diaryId:String){
        diaryService.delCenterDiaryTheme(diaryId)
    }
}