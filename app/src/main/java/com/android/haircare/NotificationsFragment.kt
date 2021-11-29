package com.android.haircare

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.haircare.R
import com.android.haircare.analyze.AnalyzeResultActivity
import com.android.haircare.analyze.MicroscopeActivity
import com.android.haircare.member.LoginActivity

class NotificationsFragment : Fragment() {

    lateinit var mp_login_button: TextView
    lateinit var mp_nickname_textview: TextView


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_notifications, container, false)

        mp_login_button = root.findViewById(R.id.mp_login_button)
        mp_nickname_textview = root.findViewById(R.id.mp_nickname_textview)

        //로그인 정보가 있을 경우
        val profile_sharedPreference = context?.getSharedPreferences("login", Context.MODE_PRIVATE)
        val profile_id = profile_sharedPreference?.getString("login_id", "")
        val profile_nickname = profile_sharedPreference?.getString("login_nickname", "")

        if(profile_id==""){
            mp_login_button.text = "로그인"
            mp_nickname_textview.text = "AI 두피·모발 분석 서비스"
        }else{
            mp_login_button.text = "로그아웃"
            mp_nickname_textview.text = profile_nickname+"님"
        }

        return root


    }

    override fun onResume() {
        super.onResume()


        //로그인 정보가 있을 경우
        val profile_sharedPreference = context?.getSharedPreferences("login", Context.MODE_PRIVATE)
        val profile_id = profile_sharedPreference?.getString("login_id", "")
        val profile_nickname = profile_sharedPreference?.getString("login_nickname", "")

        if(profile_id==""){
            mp_login_button.text = "로그인"
            mp_nickname_textview.text = "AI 두피·모발 분석 서비스"
        }else{
            mp_login_button.text = "로그아웃"
            mp_nickname_textview.text = profile_nickname+"님"
        }


        mp_login_button.setOnClickListener {

            //로그인 정보가 있을 경우
            val login_sharedPreference = context?.getSharedPreferences("login", Context.MODE_PRIVATE)
            val login_id = login_sharedPreference?.getString("login_id", "")

            if(login_id==""){
                //mp_login_button.text = "로그인"
                //Toast.makeText(context, "로그인 페이지으로 이동", Toast.LENGTH_SHORT).show()
                var intent = Intent(context, LoginActivity::class.java)
                startActivity(intent)
            }else{
                //mp_login_button.text = "로그아웃"
                //로그아웃 시 -> sharedprefrence 초기화
                val login_editor = login_sharedPreference?.edit()
                login_editor?.putString("login_id", "")
                login_editor?.apply()

                Toast.makeText(context, "로그아웃 되었습니다", Toast.LENGTH_SHORT).show()
                mp_login_button.text = "로그인"
                mp_nickname_textview.text = "AI 두피·모발 분석 서비스"
            }


        }


//        if (login_id=="") {
//            mp_login_button.text = "로그인"
//            mp_login_button.setOnClickListener {
//                //Toast.makeText(context, "로그인 페이지으로 이동", Toast.LENGTH_SHORT).show()
//                var intent = Intent(context, LoginActivity::class.java)
//                startActivity(intent)
//            }
//
//        } else {
//            mp_login_button.text = "로그아웃"
//            mp_login_button.setOnClickListener {
//
//                //로그아웃 시 -> sharedprefrence 초기화
//                val login_sharedPreference = context?.getSharedPreferences("login", 0)
//                val login_editor = login_sharedPreference?.edit()
//                login_editor?.putString("login_id", "")
//                login_editor?.apply()
//
//
//                Toast.makeText(context, "로그아웃 되었습니다", Toast.LENGTH_SHORT).show()
//                mp_login_button.text = "로그인"
//            }
//        }
    }

}