package com.android.haircare

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.android.haircare.R
import com.android.haircare.analyze.MicroscopeActivity


class HomeFragment : Fragment() {


    private lateinit var main_banner: ImageView
    private lateinit var main_img1: ImageView
    private lateinit var main_img2: ImageView
    private lateinit var main_img3: ImageView
    private lateinit var main_img4: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        main_banner = root.findViewById(R.id.main_banner)
        main_img1 = root.findViewById(R.id.main_img1)
        main_img2 = root.findViewById(R.id.main_img2)
        main_img3 = root.findViewById(R.id.main_img3)
        main_img4 = root.findViewById(R.id.main_img4)




        main_banner.setOnClickListener {
            //Toast.makeText(context, "분석화면으로 이동", Toast.LENGTH_SHORT).show()
            var intent = Intent(context, MicroscopeActivity::class.java)
            intent.putExtra("magnification", "50");
            startActivity(intent)
        }


        main_img1.setOnClickListener {
            Toast.makeText(context, "서비스 준비중입니다", Toast.LENGTH_SHORT).show()
        }

        main_img2.setOnClickListener {
            Toast.makeText(context, "서비스 준비중입니다", Toast.LENGTH_SHORT).show()
        }

        main_img3.setOnClickListener {
            Toast.makeText(context, "서비스 준비중입니다", Toast.LENGTH_SHORT).show()
        }

        main_img4.setOnClickListener {
            Toast.makeText(context, "서비스 준비중입니다", Toast.LENGTH_SHORT).show()
        }



        return root
    }


}