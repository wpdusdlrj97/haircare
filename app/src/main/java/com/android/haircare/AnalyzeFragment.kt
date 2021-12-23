package com.android.haircare

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.haircare.analyze.AnalyzeDetailActivity
import com.android.haircare.analyze.MicroscopeActivity


class AnalyzeFragment : Fragment() {

    private lateinit var analyze_1_layout: LinearLayout
    private lateinit var analyze_2_layout: LinearLayout
    private lateinit var analyze_3_layout: LinearLayout
    private lateinit var analyze_4_layout: LinearLayout
    private lateinit var analyze_5_layout: LinearLayout
    private lateinit var analyze_6_layout: LinearLayout
    private lateinit var analyze_7_layout: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        //analyzeViewModel = ViewModelProvider(this).get(AnalyzeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_analyze, container, false)
        val button_analyze: Button = root.findViewById(R.id.button_analyze)
        val button_analyze400: Button = root.findViewById(R.id.button_analyze400)

        analyze_1_layout = root.findViewById(R.id.analyze_1_layout)
        analyze_2_layout = root.findViewById(R.id.analyze_2_layout)
        analyze_3_layout = root.findViewById(R.id.analyze_3_layout)
        analyze_4_layout = root.findViewById(R.id.analyze_4_layout)
        analyze_5_layout = root.findViewById(R.id.analyze_5_layout)
        analyze_6_layout = root.findViewById(R.id.analyze_6_layout)
        analyze_7_layout = root.findViewById(R.id.analyze_7_layout)


        analyze_1_layout.setOnClickListener{
            var intent = Intent(context, AnalyzeDetailActivity::class.java)
            intent.putExtra("type", "1");
            startActivity(intent)
        }
        analyze_2_layout.setOnClickListener{
            var intent = Intent(context, AnalyzeDetailActivity::class.java)
            intent.putExtra("type", "2");
            startActivity(intent)
        }
        analyze_3_layout.setOnClickListener{
            var intent = Intent(context, AnalyzeDetailActivity::class.java)
            intent.putExtra("type", "3");
            startActivity(intent)
        }
        analyze_4_layout.setOnClickListener{
            var intent = Intent(context, AnalyzeDetailActivity::class.java)
            intent.putExtra("type", "4");
            startActivity(intent)
        }
        analyze_5_layout.setOnClickListener{
            var intent = Intent(context, AnalyzeDetailActivity::class.java)
            intent.putExtra("type", "5");
            startActivity(intent)
        }
        analyze_6_layout.setOnClickListener{
            var intent = Intent(context, AnalyzeDetailActivity::class.java)
            intent.putExtra("type", "6");
            startActivity(intent)
        }
        analyze_7_layout.setOnClickListener{
            var intent = Intent(context, AnalyzeDetailActivity::class.java)
            intent.putExtra("type", "7");
            startActivity(intent)
        }



        button_analyze.setOnClickListener {
            Toast.makeText(context, "분석화면으로 이동", Toast.LENGTH_SHORT).show()
            var intent = Intent(context, MicroscopeActivity::class.java)
            intent.putExtra("magnification", "50");
            startActivity(intent)
        }

        button_analyze400.setOnClickListener {
            Toast.makeText(context, "400배 분석화면으로 이동", Toast.LENGTH_SHORT).show()
            var intent = Intent(context, MicroscopeActivity::class.java)
            intent.putExtra("magnification", "400");
            startActivity(intent)
        }

        return root


    }


}