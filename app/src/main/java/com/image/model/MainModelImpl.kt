package com.image.model

import com.image.loge
import com.image.present.MainPresent
import com.image.present.MainPresentImpl
import com.image.utils.RetrofitUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainModelImpl:MainModel {
    var netlistener:MainPresent.NetListener ?= null
    override fun getData(listener: MainPresent.NetListener, pageNo: String, pageSize: String, timeStr: String) {
        if(netlistener == null){
            netlistener = listener
        }
        RetrofitUtils.retrofitService.getJoin(pageNo,pageSize ,timeStr)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    result ->
                    when(result.reason){
                        "Success" -> netlistener!!.onSuccess(result)
                    }
                }
    }
}