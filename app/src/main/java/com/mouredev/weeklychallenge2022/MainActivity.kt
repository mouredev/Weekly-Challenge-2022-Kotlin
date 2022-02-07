package com.mouredev.weeklychallenge2022

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge5)

        val urlString =
            "https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png"
        Challenge5().calculateAspectRatio(urlString)
    }
}