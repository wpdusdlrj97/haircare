package com.android.haircare.board

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.haircare.R
import com.bumptech.glide.Glide


class BoardDetailActivity : AppCompatActivity() {

    private lateinit var bd1_back: ImageView

    private lateinit var boardfirstdetail_doctor_img: ImageView
    private lateinit var  boardfirstdetail_doctor_name: TextView
    private lateinit var  boardfirstdetail_type: TextView
    private lateinit var  boardfirstdetail_title: TextView
    private lateinit var  boardfirstdetail_tag: TextView
    private lateinit var  boardfirstdetail_date: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_detail)


        bd1_back = findViewById(R.id.bd1_back)
        boardfirstdetail_doctor_img = findViewById(R.id.boardfirstdetail_doctor_img)
        boardfirstdetail_doctor_name = findViewById(R.id.boardfirstdetail_doctor_name)
        boardfirstdetail_type = findViewById(R.id.boardfirstdetail_type)
        boardfirstdetail_title = findViewById(R.id.boardfirstdetail_title)
        boardfirstdetail_tag = findViewById(R.id.boardfirstdetail_tag)
        boardfirstdetail_date = findViewById(R.id.boardfirstdetail_date)



        //인텐트로 값 받기 (프로필 이미지, 이름, 타입, 제목, 해시태그, 날짜)
        var intent = getIntent()
        val byteArray = getIntent().getByteArrayExtra("doctor_img")
        val doctor_img = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)
        var doctor_name = intent.getStringExtra("doctor_name").toString()
        var boardfirst_type = intent.getStringExtra("boardfirst_type").toString()
        var boardfirst_title = intent.getStringExtra("boardfirst_title").toString()
        var boardfirst_tag = intent.getStringExtra("boardfirst_tag").toString()
        var boardfirst_date = intent.getStringExtra("boardfirst_date").toString()


        Glide.with(this)
            .load(doctor_img)
            .centerCrop()
            .thumbnail(0.5f)
            .into(boardfirstdetail_doctor_img)
        boardfirstdetail_doctor_img.clipToOutline = true
        boardfirstdetail_doctor_name.text=doctor_name
        boardfirstdetail_type.text=boardfirst_type
        boardfirstdetail_title.text=boardfirst_title
        boardfirstdetail_tag.text=boardfirst_tag
        boardfirstdetail_date.text=boardfirst_date

        bd1_back.setOnClickListener {
            finish()
        }
    }



    override fun onPause() {
        super.onPause()
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);



    }
}