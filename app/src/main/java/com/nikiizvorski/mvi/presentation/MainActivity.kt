package com.nikiizvorski.mvi.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nikiizvorski.mvi.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}