package com.tamayan.videoverificationapp.view

import android.app.Application
import com.tamayan.videoverificationapp.BuildConfig
import timber.log.Timber
import timber.log.Timber.DebugTree

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}