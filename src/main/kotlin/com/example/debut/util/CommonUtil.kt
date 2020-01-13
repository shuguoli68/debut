package com.example.debut.util

import java.text.SimpleDateFormat
import java.util.*
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.swagger.annotations.ApiModelProperty
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import javax.servlet.http.HttpServletRequest




object CommonUtil {

    /**
     * 获取当前时间
     */
    fun getNowDate() : Date{
        val date = Date()//获得系统时间.
        val sdf = SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " )
        val time = sdf.parse( sdf.format(date) )
        return time
    }

    /**
     * 获取今天，年月日
     */
    fun getToday() : Date{
        val date = Date()//获得系统时间.
        val sdf = SimpleDateFormat( " yyyy-MM-dd" )
        val time = sdf.parse( sdf.format(date) )
        return time
    }

    /**
     * 获取token
     */
    fun getToken(userID:String, password:String): String {
        val currentTime = System.currentTimeMillis()
        val start = Date(currentTime)
        val end = Date(currentTime + 365 * 24 * 60 * 60 * 1000) //一年有效时间
        val token = JWT.create().withAudience(userID).withIssuedAt(start).withExpiresAt(end).sign(Algorithm.HMAC256(password))
        return token
    }

    /**
     * 获取request
     */
    private fun getRequest(): HttpServletRequest? {
        val requestAttributes = RequestContextHolder
                .getRequestAttributes() as ServletRequestAttributes?
        return requestAttributes?.request
    }

    /**
     * 从token获取userId
     */
    fun getTokenUserId(): String {
        val token = getRequest()?.getHeader("token")// 从 http 请求头中取出 token
        return JWT.decode(token).audience[0]
    }
}