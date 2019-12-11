package com.image.model

import com.image.present.MainPresent

// 只有一个获取数据的方法
interface MainModel{
    fun getData( listener:MainPresent.NetListener,pageNo:String, pageSize:String,timeStr : String)
}