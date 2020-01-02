package com.example.debut.util

import java.text.SimpleDateFormat
import java.util.*

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
}