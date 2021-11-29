package com.android.haircare.analyze

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.haircare.R
import com.bumptech.glide.Glide


class MicroscopeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_microscope)

        val imageView: ImageView = findViewById(R.id.gif_imageView)

        Glide.with(this).load(R.drawable.cute).centerCrop().into(imageView)
        //Glide.with(this).load(R.drawable.micro_double).centerCrop().into(imageView)

        //overridePendingTransition(R.anim.fadein, R.anim.fadeout);


        val ms_capture_button: Button = findViewById(R.id.ms_capture_button)


        ms_capture_button.setOnClickListener {
            Toast.makeText(this, "결과화면으로 이동", Toast.LENGTH_SHORT).show()
            var intent = Intent(this, AnalyzeResultActivity::class.java)
            //intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent)
            finish()
        }
    }


    override fun onPause() {
        super.onPause()
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

}