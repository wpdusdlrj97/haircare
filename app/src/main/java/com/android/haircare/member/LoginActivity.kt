package com.android.haircare.member

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.haircare.R
import org.json.JSONArray
import org.json.JSONObject


class LoginActivity : AppCompatActivity() {

    lateinit var loginscreen_login_button: Button
    lateinit var loginscreen_signup_button: TextView

    lateinit var loginscreen_id_edittext: EditText
    lateinit var loginscreen_pw_edittext: EditText



    lateinit var jsonData: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginscreen_login_button = findViewById(R.id.loginscreen_login_button)
        loginscreen_signup_button = findViewById(R.id.loginscreen_signup_button)
        loginscreen_id_edittext = findViewById(R.id.loginscreen_id_edittext)
        loginscreen_pw_edittext = findViewById(R.id.loginscreen_pw_edittext)


        val test_sharedPreference = getSharedPreferences("test", 0)
        val editor = test_sharedPreference.edit()
        editor.putString("id", "test")
        editor.putString("pw", "test")
        editor.putString("nickname", "테스터")
        editor.apply()




        loginscreen_login_button.setOnClickListener {


//            val jsonObject = JSONObject()
//            jsonObject.put("id", "wpdusdlrj97")
//            jsonObject.put("pw", "qqw3262402")
//            jsonObject.put("nickname", "조자이너")
//
//            jsonData = jsonObject.toString() //데이터 파싱 위해서 변수에 담습니다



            //EditText로부터 값 받기
            val id = loginscreen_id_edittext.text.toString()
            val pw = loginscreen_pw_edittext.text.toString()


            if(id == "" || pw == ""){
                Toast.makeText(this, "아이디와 비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            else{
                //Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

                // 쉐어드로부터 저장된 id, pw 가져오기
                val member_sharedPreference = getSharedPreferences(id, Context.MODE_PRIVATE)
                val savedid = member_sharedPreference.getString("id", "")
                val savedpw = member_sharedPreference.getString("pw", "")
                val savednickname = member_sharedPreference.getString("nickname", "")

                if(id==savedid && pw==savedpw){

                    //로그인 성공 시 -> 로그인 정보 저장
                    val login_sharedPreference = getSharedPreferences("login", 0)
                    val login_editor = login_sharedPreference.edit()
                    login_editor.putString("login_id", savedid)
                    login_editor.putString("login_pw", savedpw)
                    login_editor.putString("login_nickname", savednickname)
                    login_editor.apply()


                    Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                    finish()

                }else{
                    Toast.makeText(this, "아이디 혹은 비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
                }


                // 로그인 실패 다이얼로그 보여주기
                //Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
                //Toast.makeText(this, savedid+"/"+savedpw, Toast.LENGTH_SHORT).show()
            }




        }

        loginscreen_signup_button.setOnClickListener {
            Toast.makeText(this, "회원가입 화면으로 이동", Toast.LENGTH_SHORT).show()
            var intent = Intent(this, SignUpActivity::class.java)
            //intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent)
        }

    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

}