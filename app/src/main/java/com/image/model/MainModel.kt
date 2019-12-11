package com.image.model

import com.image.present.MainPresent

interface MainModel{
    fun getData( listener:MainPresent.NetListener,pageNo:String, pageSize:String,timeStr : String)
}