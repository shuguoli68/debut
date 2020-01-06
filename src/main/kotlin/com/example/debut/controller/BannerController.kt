package com.example.debut.controller

import com.example.debut.base.MyResponse
import com.example.debut.entity.Banner
import com.example.debut.entity.Split
import com.example.debut.mapper.BannerMapper
import com.github.pagehelper.PageHelper
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@Api(value = "/Banner", tags = arrayOf("Banner的增删改查"))
@RestController
class BannerController {

    @Autowired
    lateinit var bannerMapper: BannerMapper

    @ApiOperation(value = "增加Banner")
    @RequestMapping(value = ["/banner/add"], method = [RequestMethod.POST])
    fun addBanner(@RequestBody banner: Banner) : MyResponse<Boolean> {
        var response = MyResponse(201, "图片地址为空", false)
        if (banner.imgPath.isNullOrBlank()){
            return response
        }
        val list = bannerMapper.queryByImgPath(banner.imgPath)
        if (list.isNotEmpty()){
            val value = bannerMapper.upBanner(banner)
            if (value>0){
                response.msg = "该Banner已存在,更新成功"
                response.code = 200
                response.data = true
                return response
            }
            response.code = 202
            response.msg = "该Banner已存在,更新失败，存入数据库失败"
            return response
        }
        val value = bannerMapper.addBanner(banner)
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

    @ApiOperation(value = "删除Banner")
    @RequestMapping(value = ["/banner/del"], method = [RequestMethod.POST])
    fun delBanner(@RequestBody banner: Banner) : MyResponse<Boolean> {
        var response = MyResponse(201, "imgPath为空", false)
        if (banner.imgPath.isNullOrBlank()){
            return response
        }
        val value = bannerMapper.delBanner(banner.id)
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

    @ApiOperation(value = "根据ID查询Banner")
    @RequestMapping(value = ["/banner/listById"], method = [RequestMethod.POST])
    fun listBannerById(@RequestBody  banner: Banner) : MyResponse<List<Banner>> {
        var response = MyResponse(201, "imgPath为空", listOf<Banner>())
        if (banner.imgPath.isNullOrBlank()){
            return response
        }
        val list = bannerMapper.queryByImgPath(banner.imgPath)
        return MyResponse(200, "查询成功", list)
    }

    @ApiOperation(value = "Banner列表")
    @RequestMapping(value = ["/banner/list"], method = [RequestMethod.POST])
    fun listBanner(@RequestBody split: Split) : MyResponse<List<Banner>> {
        PageHelper.startPage<Banner>(split.pageNum?:1, split.pageSize?:20)
        val list = bannerMapper.listBanner()
        return MyResponse(200, "查询成功", list)
    }
}