package com.example.fullscreensplashscreen

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.WindowManager
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen


class SplashScreen: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            installSplashScreen()
            startActivity(Intent(this@SplashScreen, MainActivity::class.java))
            finish()
        } else {
            // revert to old theme
            setTheme(R.style.Theme_FullScreenSplashScreen)
            // start a handler to navigate after 0.5 seconds (better than no splashScreen I recon)
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                startActivity(Intent(this@SplashScreen, MainActivity::class.java))
                finish()
            }, 500)
        }
    }
}