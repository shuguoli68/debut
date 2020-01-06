package com.example.debut.controller

import com.example.debut.base.MyResponse
import com.example.debut.entity.DiaryLike
import com.example.debut.entity.DiaryLikeCount
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
            updateCount(list[0], diaryLike)
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
        addCount(diaryLike)
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

    @ApiOperation(value = "点赞排行榜")
    @RequestMapping(value = ["/diaryLike/loveRank"], method = [RequestMethod.POST])
    fun loveRank(@RequestBody split: Split) : MyResponse<List<DiaryLikeCount>> {
        PageHelper.startPage<DiaryLikeCount>(split.pageNum?:1, split.pageSize?:20)
        val list = diaryLikeMapper.loveRank()
        return MyResponse(200, "查询成功", list)
    }

    @ApiOperation(value = "踩排行榜")
    @RequestMapping(value = ["/diaryLike/unloveRank"], method = [RequestMethod.POST])
    fun unloveRank(@RequestBody split: Split) : MyResponse<List<DiaryLikeCount>> {
        PageHelper.startPage<DiaryLikeCount>(split.pageNum?:1, split.pageSize?:20)
        val list = diaryLikeMapper.unloveRank()
        return MyResponse(200, "查询成功", list)
    }

    @ApiOperation(value = "收藏排行榜")
    @RequestMapping(value = ["/diaryLike/collectRank"], method = [RequestMethod.POST])
    fun collectRank(@RequestBody split: Split) : MyResponse<List<DiaryLikeCount>> {
        PageHelper.startPage<DiaryLikeCount>(split.pageNum?:1, split.pageSize?:20)
        val list = diaryLikeMapper.collectRank()
        return MyResponse(200, "查询成功", list)
    }



    /**
     * 操作数量表
     */
    private fun addCount(diaryLike: DiaryLike){
        val list = diaryLikeMapper.queryLikeCount(diaryLike.diaryId)
        if (list.isNotEmpty()){
            val count = list[0]
            if (diaryLike.love == 1)
                ++count.love
            else if (diaryLike.love == 0)
                ++count.unlove

            if (diaryLike.collect == 1)
                ++count.collect
            else if (diaryLike.collect == 0)
                --count.collect
            diaryLikeMapper.upLikeCount(count)
        }else {
            val count = DiaryLikeCount()
            count.diaryId = diaryLike.diaryId
            if (diaryLike.love == 1)
                count.love = 1
            else if (diaryLike.love == 0)
                count.unlove = 1

            if (diaryLike.collect == 1)
                count.collect = 1
            diaryLikeMapper.addLikeCount(count)
        }
    }

    /**
     * 操作数量表
     */
    private fun updateCount(oldM: DiaryLike, newM: DiaryLike){
        val list = diaryLikeMapper.queryLikeCount(newM.diaryId)
        if (list.isNotEmpty()){
            val count = list[0]
            if (oldM.love != newM.love){
                if (newM.love == 1) {
                    ++count.love
                    --count.unlove
                } else if (newM.love == 0) {
                    --count.love
                    ++count.unlove
                }
            }
            if (oldM.collect != newM.collect){
                if (newM.collect == 1) {
                    ++count.collect
                } else if (newM.collect == 0) {
                    --count.collect
                }
            }
            diaryLikeMapper.upLikeCount(count)
        }
    }
}