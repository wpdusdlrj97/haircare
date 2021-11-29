package com.android.haircare

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
import androidx.navigation.Navigation
import com.android.haircare.R
import com.android.haircare.analyze.MicroscopeActivity


class AnalyzeFragment : Fragment() {

    //private lateinit var analyzeViewModel: AnalyzeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        //analyzeViewModel = ViewModelProvider(this).get(AnalyzeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_analyze, container, false)
        val textView: TextView = root.findViewById(R.id.text_analyze)
        val button_analyze: Button = root.findViewById(R.id.button_analyze)

        textView.text = "인공지능 분석"
//        analyzeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        button_analyze.setOnClickListener {
            Toast.makeText(context, "분석화면으로 이동", Toast.LENGTH_SHORT).show()
            var intent = Intent(context, MicroscopeActivity::class.java)
            startActivity(intent)

        }

        return root


    }


}