package com.image.present

import com.image.bean.JokeBean

interface MainPresent{
    fun presentGetData( pageNo: String, pageSize: String, timeStr: String)
    interface NetListener{
        fun onSuccess(result: JokeBean)
    }
}