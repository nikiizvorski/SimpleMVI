package com.nikiizvorski.mvi.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SimpleMVI : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}