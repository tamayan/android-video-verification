package com.tamayan.videoverificationapp.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {

    @GET("videos?part=contentDetails")
    fun getVideoDetail(@Query("id") id: String, @Query("key") key: String): Single<ResponseJson>
}