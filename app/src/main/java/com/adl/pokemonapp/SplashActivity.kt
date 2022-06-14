package com.adl.pokemonapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.adl.pokemonapp.ui.pokelist.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        delayAndGoToMain()
    }

    private fun delayAndGoToMain() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent : Intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }, 1200)

    }

}