package com.tamayan.videoverificationapp.api

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import com.tamayan.videoverificationapp.BuildConfig
import com.tamayan.videoverificationapp.VideoInfo
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiManager {

    fun execute(): Single<VideoInfo> {
        return buildRetrofit()
                .create(YoutubeApi::class.java)
                .getVideoDetail(BuildConfig.VIDEO_ID, BuildConfig.API_KEY)
                .map {
                    VideoInfo(it.item[0].id, it.item[0].contentDetail.duration)
                }
    }

    private fun buildRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient.Builder().build()

        val moshi = Moshi
                .Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

        return Retrofit
                .Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .build()
    }
}