package com.example.chatapp

import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.airbnb.lottie.RenderMode

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val container = FrameLayout(this)
        container.setBackgroundColor(0xFFFFFFFF.toInt())

        val animationView = LottieAnimationView(this).apply {
            setAnimation("splash.json")
            setRenderMode(RenderMode.HARDWARE)
            enableMergePathsForKitKatAndAbove(true)
            repeatCount = LottieDrawable.INFINITE
            speed = 1.5f

            setFailureListener {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }

            playAnimation()
        }

        val layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )
        animationView.layoutParams = layoutParams

        container.addView(animationView)
        setContentView(container)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }, 3000)
    }
}