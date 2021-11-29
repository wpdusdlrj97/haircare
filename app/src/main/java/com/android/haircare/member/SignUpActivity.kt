package com.android.haircare.member

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.haircare.R
import com.bumptech.glide.Glide


class SignUpActivity : AppCompatActivity() {

    lateinit var suscreen_back_button: ImageView

    lateinit var suscreen_id_edittext: EditText
    lateinit var suscreen_pw_edittext: EditText
    lateinit var suscreen_pwcheck_edittext: EditText
    lateinit var suscreen_nickname_edittext: EditText

    lateinit var suscreen_checkbox1: ImageView
    lateinit var suscreen_checkbox2: ImageView
    lateinit var suscreen_checkbox3: ImageView

    var suscreen_checkbox1_status: Boolean = true
    var suscreen_checkbox2_status: Boolean = true
    var suscreen_checkbox3_status: Boolean = false

    lateinit var suscreen_signup_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        suscreen_back_button = findViewById(R.id.suscreen_back_button)
        suscreen_id_edittext = findViewById(R.id.suscreen_id_edittext)
        suscreen_pw_edittext = findViewById(R.id.suscreen_pw_edittext)
        suscreen_pwcheck_edittext = findViewById(R.id.suscreen_pwcheck_edittext)
        suscreen_nickname_edittext = findViewById(R.id.suscreen_nickname_edittext)
        suscreen_checkbox1 = findViewById(R.id.suscreen_checkbox1)
        suscreen_checkbox2 = findViewById(R.id.suscreen_checkbox2)
        suscreen_checkbox3 = findViewById(R.id.suscreen_checkbox3)

        suscreen_signup_button = findViewById(R.id.suscreen_signup_button)




        //가입하기 버튼 클릭 시
        suscreen_signup_button.setOnClickListener {


            //EditText에 입력한 값
            val id = suscreen_id_edittext.text.toString()
            val pw = suscreen_pw_edittext.text.toString()
            val pwcheck = suscreen_pwcheck_edittext.text.toString()
            val nickname = suscreen_nickname_edittext.text.toString()

            if(id == ""){
                Toast.makeText(this, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show()
            }else if(pw==""){
                Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
            }else if(pwcheck==""){
                Toast.makeText(this, "비밀번호 확인을 입력해주세요", Toast.LENGTH_SHORT).show()
            }else if(nickname==""){
                Toast.makeText(this, "닉네임을 입력해주세요", Toast.LENGTH_SHORT).show()
            }else if(pw!=pwcheck){
                Toast.makeText(this, "비밀번호가 일치하지 하지 않습니다", Toast.LENGTH_SHORT).show()
            }else if(nickname.length>6){
                Toast.makeText(this, "닉네임을 6자리 이하로 입력해주세요", Toast.LENGTH_SHORT).show()
            }else if(suscreen_checkbox1_status==false){
                Toast.makeText(this, "서비스 이용약관에 동의해주세요", Toast.LENGTH_SHORT).show()
            }else if(suscreen_checkbox2_status==false){
                Toast.makeText(this, "개인정보 처리방침에 동의해주세요", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "회원가입 완료", Toast.LENGTH_SHORT).show()

                val member_sharedPreference = getSharedPreferences(id, 0)
                val editor = member_sharedPreference.edit()
                editor.putString("id", id)
                editor.putString("pw", pw)
                editor.putString("nickname",nickname)
                editor.apply()

                var intent = Intent(this, SignUpFinishActivity::class.java)
                startActivity(intent)
                finish()
            }
        }


        suscreen_checkbox1.setOnClickListener {

            if(suscreen_checkbox1_status==false){
                Glide.with(this)
                    .load(R.drawable.check_box_on)
                    .centerCrop()
                    .into(suscreen_checkbox1)
                suscreen_checkbox1_status=true;
            }else{
                Glide.with(this)
                    .load(R.drawable.check_box_off)
                    .centerCrop()
                    .into(suscreen_checkbox1)
                suscreen_checkbox1_status=false;
            }
        }

        suscreen_checkbox2.setOnClickListener {

            if(suscreen_checkbox2_status==false){
                Glide.with(this)
                    .load(R.drawable.check_box_on)
                    .centerCrop()
                    .into(suscreen_checkbox2)
                suscreen_checkbox2_status=true;
            }else{
                Glide.with(this)
                    .load(R.drawable.check_box_off)
                    .centerCrop()
                    .into(suscreen_checkbox2)
                suscreen_checkbox2_status=false;
            }
        }

        suscreen_checkbox3.setOnClickListener {

            if(suscreen_checkbox3_status==false){
                Glide.with(this)
                    .load(R.drawable.check_box_on)
                    .centerCrop()
                    .into(suscreen_checkbox3)
                suscreen_checkbox3_status=true;
            }else{
                Glide.with(this)
                    .load(R.drawable.check_box_off)
                    .centerCrop()
                    .into(suscreen_checkbox3)
                suscreen_checkbox3_status=false;
            }
        }





        //뒤로가기 버튼 클릭 시
        suscreen_back_button.setOnClickListener {
            finish()
        }


    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

}