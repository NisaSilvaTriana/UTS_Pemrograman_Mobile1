package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    private lateinit var Judul: TextView
    private lateinit var splashlogo: ImageView
    private lateinit var animLogo: Animation
    private lateinit var animText: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        getId()
        settingAnimation()

        // Auto pindah ke LoginActivity setelah 3 detik
        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 3000)
    }

    private fun getId() {
        Judul = findViewById(R.id.Judul)
        splashlogo = findViewById(R.id.splashLogo)
    }

    private fun settingAnimation() {
        animLogo = AnimationUtils.loadAnimation(this, R.anim.anim_logo)
        animText = AnimationUtils.loadAnimation(this, R.anim.anim_text)

        splashlogo.startAnimation(animLogo)
        Judul.startAnimation(animText)
    }
}
