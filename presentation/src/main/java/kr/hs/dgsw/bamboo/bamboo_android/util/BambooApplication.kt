package kr.hs.dgsw.bamboo.bamboo_android.util

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BambooApplication : Application() {
    companion object {
        lateinit var prefs: PreferenceManager
    }

    override fun onCreate() {
        super.onCreate()
        prefs = PreferenceManager(applicationContext)
    }
}
