package com.image.present

import com.image.bean.JokeBean

interface MainPresent{
    // 请求数据。用于同Model交互
    fun presentGetData( pageNo: String, pageSize: String, timeStr: String)
    // 成功后的操作
    interface NetListener{
        fun onSuccess(result: JokeBean)
    }
}