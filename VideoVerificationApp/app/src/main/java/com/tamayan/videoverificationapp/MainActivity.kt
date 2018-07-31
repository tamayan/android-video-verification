package com.tamayan.videoverificationapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeStandalonePlayer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = YouTubeStandalonePlayer.createVideoIntent(this, BuildConfig.API_KEY, BuildConfig.VIDEO_ID)
        startActivity(intent)
    }
}
