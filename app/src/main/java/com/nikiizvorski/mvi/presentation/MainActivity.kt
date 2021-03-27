package com.nikiizvorski.mvi.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nikiizvorski.mvi.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}