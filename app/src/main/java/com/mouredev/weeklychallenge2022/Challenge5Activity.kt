package com.mouredev.weeklychallenge2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// Activity necesaria para resolver el Challenge 5
class Challenge5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge5)

        Challenge5().aspectRatio("https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png")
    }
}