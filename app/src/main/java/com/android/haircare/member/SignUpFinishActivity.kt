package com.android.haircare.member

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.haircare.R
import com.android.haircare.analyze.MicroscopeActivity
import com.bumptech.glide.Glide


class SignUpFinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signupfinish)

        val signupresultscreen_confirm_button: Button = findViewById(R.id.signupresultscreen_confirm_button)
        val signupresultscreen_survey_button: Button = findViewById(R.id.signupresultscreen_survey_button)



        signupresultscreen_confirm_button.setOnClickListener {
            //Toast.makeText(this, "로그인 완료화면으로 이동", Toast.LENGTH_SHORT).show()
            finish()
        }

        signupresultscreen_survey_button.setOnClickListener {
            var intent = Intent(this, SurveyActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

}