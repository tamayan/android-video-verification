package com.tamayan.videoverificationapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubeThumbnailLoader
import com.google.android.youtube.player.YouTubeThumbnailView
import com.tamayan.videoverificationapp.BuildConfig
import com.tamayan.videoverificationapp.R.layout
import com.tamayan.videoverificationapp.api.ApiManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : YouTubeBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        showThumbnail()
        showVideo()
        getDuration()
    }

    @SuppressLint("ShowToast")
    private fun getDuration() {
        ApiManager
                .execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = {
                            durationTextView.text = "動画時間：${it.duration}"
                        },
                        onError = {
                            Toast.makeText(this, it.message, Toast.LENGTH_LONG)
                        }
                )
    }

    private fun showVideo() {
        youTubePlayerView
                .initialize(
                        BuildConfig.API_KEY,
                        object : YouTubePlayer.OnInitializedListener {

                            override fun onInitializationSuccess(provider: YouTubePlayer.Provider, player: YouTubePlayer, wasRestored: Boolean) {
                                // 動画を読み込む(再生はしない)
                                player.cueVideo(BuildConfig.VIDEO_ID)
                            }

                            override fun onInitializationFailure(provider: YouTubePlayer.Provider, youTubeInitializationResult: YouTubeInitializationResult) {
                            }
                        })
    }

    private fun showThumbnail() {
        thumbnailView
                .initialize(
                        BuildConfig.API_KEY,
                        object : YouTubeThumbnailView.OnInitializedListener {
                            override fun onInitializationSuccess(thumbnailView: YouTubeThumbnailView?, loader: YouTubeThumbnailLoader?) {
                                loader?.setVideo(BuildConfig.VIDEO_ID)
                            }

                            override fun onInitializationFailure(p0: YouTubeThumbnailView?, p1: YouTubeInitializationResult?) {
                            }
                        })
    }
}
