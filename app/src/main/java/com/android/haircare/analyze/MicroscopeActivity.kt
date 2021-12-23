package com.android.haircare.analyze

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.haircare.R
import com.bumptech.glide.Glide


class MicroscopeActivity : AppCompatActivity() {


    private lateinit var gif_imageView: ImageView
    private lateinit var ms_textview: TextView
    private lateinit var ms_capture_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_microscope)

        gif_imageView = findViewById(R.id.gif_imageView)
        ms_textview = findViewById(R.id.ms_textview)
        ms_capture_button = findViewById(R.id.ms_capture_button)

        //Glide.with(this).load(R.drawable.cute).centerCrop().into(gif_imageView)
        //Glide.with(this).load(R.drawable.micro_double).centerCrop().into(imageView)



        //인텐트로 값 받기 (50배율 or 400배율)
        var intent = getIntent()
        var magnification = intent.getStringExtra("magnification").toString()


        if(magnification=="50"){
            Glide.with(this).load(R.drawable.micro_double).centerCrop().into(gif_imageView)
            ms_textview.text = "50배율 현미경 영상 송출 중..."

            ms_capture_button.setOnClickListener {
                //Toast.makeText(this, "결과화면으로 이동", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, AnalyzeResultActivity::class.java)
                //intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent)
                finish()
            }


        }else{
            Glide.with(this).load(R.drawable.hair400).centerCrop().into(gif_imageView)
            ms_textview.text = "400배율 현미경 영상 송출 중..."

            ms_capture_button.setOnClickListener {
                //Toast.makeText(this, "모발 손상도 결과화면으로 이동", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, AnalyzeResult400Activity::class.java)
                //intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent)
                finish()
            }
        }






    }


    override fun onPause() {
        super.onPause()
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

}