package com.example.debut.controller

import com.example.debut.base.MyResponse
import com.example.debut.entity.News
import com.example.debut.entity.Split
import com.example.debut.mapper.NewsMapper
import com.github.pagehelper.PageHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class NewsController {

    @Autowired
    lateinit var newsMapper: NewsMapper

    @RequestMapping(value = ["/news/add"], method = [RequestMethod.POST])
    fun addNews(@RequestBody news: News) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题或内容为空", false)
        if (news.title.isNullOrBlank() || news.content.isNullOrBlank()){
            return response
        }
        val list = newsMapper.queryById(news.newsId)
        if (list.isNotEmpty()){
            response.msg = "添加失败，该News已存在"
            return response
        }
        val value = newsMapper.addNews(news)
        if (value>0){
            response.msg = "添加成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "添加失败，存入数据库失败"
        return response
    }

    @RequestMapping(value = ["/news/del"], method = [RequestMethod.POST])
    fun delNews(@RequestBody news: News) : MyResponse<Boolean> {
        var response = MyResponse(201, "NewsId为空", false)
        if (news.newsId.isNullOrBlank()){
            return response
        }
        val value = newsMapper.delNews(news.newsId)
        if (value>0){
            response.msg = "删除成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "删除失败，从数据库删除失败"
        return response
    }

    @RequestMapping(value = ["/news/update"], method = [RequestMethod.POST])
    fun upNews(@RequestBody news: News) : MyResponse<Boolean> {
        var response = MyResponse(201, "标题或内容为空", false)
        if (news.title.isNullOrBlank() || news.content.isNullOrBlank()){
            return response
        }
        val value = newsMapper.upNews(news)
        if (value>0){
            response.msg = "修改成功"
            response.code = 200
            response.data = true
            return response
        }
        response.msg = "修改失败，存入数据库失败"
        return response
    }

    @RequestMapping(value = ["/news/list"], method = [RequestMethod.POST])
    fun listNews(@RequestBody split: Split) : MyResponse<List<News>> {
        PageHelper.startPage<News>(split.pageNum?:1, split.pageSize?:20)
        val list = newsMapper.listNews()
        return MyResponse(200, "查询成功", list)
    }
}
