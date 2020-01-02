package com.example.debut.controller

import com.example.debut.base.MyResponse
import com.example.debut.config.MyHttpSessionListener
import com.example.debut.entity.Diary
import com.example.debut.entity.User
import com.example.debut.mapper.UserMapper
import com.example.debut.util.CommonUtil
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

@RestController
@Api(value = "/user", tags = arrayOf("用户的注册登录删除"))
class UserController {

    @Autowired
    lateinit var userService: UserMapper

    @ApiOperation(value = "测试接口")
    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun test():String{
        return "test"
    }

    @ApiOperation(value = "查看在线人数")
    @RequestMapping(value = ["/online"], method = [RequestMethod.GET])
    fun online():String{
        return "当前在线人数：" + MyHttpSessionListener.online
    }

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = ["/register"], method = [RequestMethod.POST])
    fun register(@RequestBody user: User) :MyResponse<Boolean> {
        var response = MyResponse(201, "用户名或密码为空", false)
        if (user.userId.isNullOrBlank() || user.passWord.isNullOrBlank()){
            return response
        }
        val list = userService.queryById(userId = user.userId)
        if (list.isNotEmpty()){
            response.msg = "注册失败，用户名已存在"+",list0="+list[0].toString()
            return response
        }
        user.ctTime = CommonUtil.getNowDate()
        user.utTime = CommonUtil.getNowDate()
        val value = userService.register(user = user)
        if (value>0){
            response.msg = "注册成功"
            response.code = 200
            return response
        }
        response.msg = "注册失败，存入数据库失败"
        return response
    }

    @ApiOperation(value = "用户登录")
    @RequestMapping(value = ["/login"], method = [RequestMethod.POST])
    fun login(@RequestBody user: User, res: HttpServletResponse) : MyResponse<User> {
        val userId = user.userId
        val passWord = user.passWord?:""
        var response = MyResponse(201, "用户名或密码为空", User())
        if (userId.isNullOrBlank() || passWord.isNullOrBlank()){
            return response
        }
        val list = userService.queryById(userId = userId)
        if (list.isEmpty()){
            response.msg = "登录失败，用户不存在"
            return response
        }
        print("pwd="+passWord+",0 pwd="+list[0].passWord)
        if (passWord != list[0].passWord){
            response.msg = "登录失败，密码错误"+",userID="+userId+",pwd="+passWord+",size="+list.size+",list0="+list[0].toString()
            return response
        }
        val token = CommonUtil.getToken(userId, passWord)

        val cookie = Cookie("token", token)
        cookie.path = "/"
        res.addCookie(cookie)
        return MyResponse(200, "登录成功",list[0])
    }

    @ApiOperation(value = "用户更新资料")
    @RequestMapping(value = ["/user/update"], method = [RequestMethod.POST])
    fun updateUser(@RequestBody user: User) :MyResponse<Boolean> {
        var response = MyResponse(201, "用户ID为空", false)
        if (user.userId.isNullOrBlank()){
            return response
        }
        val list = userService.queryById(userId = user.userId)
        if (list.isEmpty()){
            response.msg = "修改失败，用户不存在"
            return response
        }
        user.utTime = CommonUtil.getNowDate()
        val value = userService.upUser(user = user)
        if (value>0){
            response.msg = "修改成功"+",user="+user.toString()+",size="+list.size+",list0="+list[0].toString()
            response.code = 200
            return response
        }
        response.msg = "修改失败，存入数据库失败"
        return response
    }

    @ApiOperation(value = "删除用户")
    @RequestMapping(value = ["/user/del"], method = [RequestMethod.POST])
    fun delUser(@RequestBody map:Map<String, String>) :MyResponse<User> {
        val userId = map.get("userId")?:""
        var response = MyResponse(201, "用户ID为空", User(/*userId,"","",0,0,0L,0L, arrayListOf()*/))
        if (userId.isNullOrBlank()){
            return response
        }
        val list = userService.queryById(userId = userId)
        if (list.isEmpty()){
            response.msg = "删除失败，用户不存在"
            return response
        }
        val value = userService.delUser(userId = userId)
        if (value>0){
            response.msg = "删除成功"
            response.code = 200
            return response
        }
        response.msg = "删除失败，从数据库删除失败"
        return response
    }

    @ApiOperation(value = "查询用户详细资料，携带diary")
    @RequestMapping(value = ["/user/diarys"], method = [RequestMethod.POST])
    fun userDiarys(@RequestBody map:Map<String, String>) :MyResponse<User> {
        val userId = map.get("userId")?:""
        var response = MyResponse(201, "用户名为空", User(/*userId,"","",0,0,0L,0L, arrayListOf()*/))
        if (userId.isNullOrBlank()){
            return response
        }
        val user = userService.userDiarys(userId = userId)
        if (user==null){
            response.msg = "查询失败，用户没有发布diary"
            return response
        }
        return MyResponse(200, "查询成功",user)
    }

    @ApiOperation(value = "用户下的所有diary")
    @RequestMapping(value = ["/user/listDiary"], method = [RequestMethod.POST])
    fun listDiary(@RequestBody user: User) :MyResponse<List<Diary>> {
        val userId = user.userId
        var response = MyResponse(201, "用户名为空", listOf<Diary>())
        if (userId.isNullOrBlank()){
            return response
        }
        val diarys = userService.listDiary(userId = userId)
        if (diarys.isEmpty()){
            response.msg = "查询失败，用户没有发布diary"
            return response
        }
        return MyResponse(200, "查询成功",diarys)
    }
}