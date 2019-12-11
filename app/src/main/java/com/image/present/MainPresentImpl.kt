package com.image.present

import com.image.MainActivity
import com.image.bean.JokeBean
import com.image.model.MainModel
import com.image.model.MainModelImpl

class MainPresentImpl(val mainView:MainActivity): MainPresent, MainPresent.NetListener {

    var mainModle : MainModel ?= null
    init {
        mainModle = MainModelImpl()
    }
    override fun presentGetData(pageNo: String, pageSize: String, timeStr: String) {
        mainModle?.getData(this,pageNo,pageSize,timeStr)
    }
    override fun onSuccess(result: JokeBean) {
        mainView.setAdapter(result)
    }
}