package com.image.api

import com.image.bean.JokeBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    // 这里是get请求，用的聚合数据的API
    @GET("joke/content/list.php")
    fun getJoin(
            @Query("page") page: String
            , @Query("pagesize") pagesize: String
            , @Query("time") time: String
            , @Query("sort") sort: String = "desc"
            , @Query("key") key: String = "cbf3dd8ea754d9dc764c704945e782cc"): Observable<JokeBean>
}