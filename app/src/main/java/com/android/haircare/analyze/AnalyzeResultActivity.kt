package com.android.haircare.analyze

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.android.haircare.R
import com.bumptech.glide.Glide


class AnalyzeResultActivity : AppCompatActivity() {

    private lateinit var button_analyze_50 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analyzeresult)

        button_analyze_50 = findViewById(R.id.button_analyze_50)

        button_analyze_50.setOnClickListener {
            finish()
        }

    }



    override fun onPause() {
        super.onPause()
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

}