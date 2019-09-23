package com.example.debut.base

data class MyResponse<T> (
        var code:Int,
        var msg:String,
        var data:T
)