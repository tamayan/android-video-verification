package com.tamayan.videoverificationapp

import android.os.Bundle
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubeThumbnailLoader
import com.google.android.youtube.player.YouTubeThumbnailView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : YouTubeBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        youTubePlayerView
                .initialize(BuildConfig.API_KEY, object : YouTubePlayer.OnInitializedListener {
                    override fun onInitializationSuccess(provider: YouTubePlayer.Provider, player: YouTubePlayer, wasRestored: Boolean) {
                        player.loadVideo(BuildConfig.VIDEO_ID)
                    }

                    override fun onInitializationFailure(provider: YouTubePlayer.Provider, youTubeInitializationResult: YouTubeInitializationResult) {
                    }
                })

        thumbnailView
                .initialize(BuildConfig.API_KEY, object : YouTubeThumbnailView.OnInitializedListener {
                    override fun onInitializationSuccess(thumbnailView: YouTubeThumbnailView?, loader: YouTubeThumbnailLoader?) {
                        loader?.setVideo(BuildConfig.VIDEO_ID)
                    }

                    override fun onInitializationFailure(p0: YouTubeThumbnailView?, p1: YouTubeInitializationResult?) {
                    }
                })
    }
}
