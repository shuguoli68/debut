package com.example.debut.util

import java.text.SimpleDateFormat
import java.util.*
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm


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

    fun getToken(userID:String, password:String): String {
        val currentTime = System.currentTimeMillis()
        val start = Date(currentTime)
        val end = Date(currentTime + 60 * 60 * 1000) //一小时有效时间
        val token = JWT.create().withAudience(userID).withIssuedAt(start).withExpiresAt(end).sign(Algorithm.HMAC256(password))
        return token
    }
}