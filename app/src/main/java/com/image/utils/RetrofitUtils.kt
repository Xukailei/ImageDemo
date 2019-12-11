package com.image.utils

import com.image.api.RetrofitService
import com.image.constant.Constant
import com.image.loge
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.Time
import java.util.concurrent.TimeUnit
/**
 * 创建Retrofit
 */
class RetrofitUtils {
    companion object {
        fun creat(url: String): Retrofit {
            val level: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BODY
            //新建log拦截器
            val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
                loge("RetrofitUtils", "OkHttp: " + message)
            })
            loggingInterceptor.level = level

            var httpBuild = OkHttpClient().newBuilder()
            httpBuild.connectTimeout(60, TimeUnit.SECONDS)
            httpBuild.readTimeout(10, TimeUnit.SECONDS)
            // 添加拦截器
            httpBuild.addInterceptor(loggingInterceptor)
            return Retrofit.Builder()
                    .baseUrl(url)
                    .client(httpBuild.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }

        //获取ServiceApi
        fun <T> getService(url: String, service: Class<T>): T {
            return RetrofitUtils.creat(url).create(service)
        }

        var retrofitService: RetrofitService = RetrofitUtils.getService(Constant.BASEURL, RetrofitService::class.java)
    }
}