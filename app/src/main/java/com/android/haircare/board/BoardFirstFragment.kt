package com.android.haircare.board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.haircare.R


class BoardFirstFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit  var BoardFirst_itemList: List<BoardFirstData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_boardfirst, container, false)

        recyclerView = root!!.findViewById(R.id.boardfirst_recycler)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.setLayoutManager(LinearLayoutManager(context))

        //initData();
        BoardFirst_itemList = ArrayList()
        (BoardFirst_itemList as ArrayList<BoardFirstData>).add(BoardFirstData(R.drawable.doctor1, "김철수 전문의", "두피", "빗질과 두피 마사지로 하는 모발 관리법에는 어떤 것이 있을까요?", "#두피 #마사지 #전문의", "2021.11.07"))
        (BoardFirst_itemList as ArrayList<BoardFirstData>).add(BoardFirstData(R.drawable.doctor2, "고철현 전문의", "모발", "건강한 모발을 위한 두피 관리법 & 샴푸 선택법을 공유합니다", "#건강 #샴푸 #두피관리 #모발", "2021.09.17"))
        (BoardFirst_itemList as ArrayList<BoardFirstData>).add(BoardFirstData(R.drawable.doctor3, "손지수 전문의", "두피", "두피 타입에 따른 두피관리법! 탈모 예방하기 위한 5가지 수칙", "#탈모예방 #두피관리법 #타입", "2021.08.05"))
        (BoardFirst_itemList as ArrayList<BoardFirstData>).add(BoardFirstData(R.drawable.doctor4, "이민우 전문의", "모발", "겨울철 두피 건강주의보! 셀프 두피 관리법을 공개합니다", "#겨울철 두피 #셀프 #전문", "2021.07.01"))
        (BoardFirst_itemList as ArrayList<BoardFirstData>).add(BoardFirstData(R.drawable.doctor5, "김지민 전문의", "두피", "탈모의 계절은 사실 여름? 가을 탈모 막는 여름철 두피 관리법", "#두피 #탈모 #여름철", "2020.10.19"))
        (BoardFirst_itemList as ArrayList<BoardFirstData>).add(BoardFirstData(R.drawable.doctor6, "오태식 전문의", "모발", "지성 vs 건성...  가을철 민감해진 두피 타입 진단받기", "#지성 #건성 #민감 두피", "2020.09.09"))
        (BoardFirst_itemList as ArrayList<BoardFirstData>).add(BoardFirstData(R.drawable.doctor7, "유채영 전문의", "두피", "대학생들의 두피,모발관리 인식과 탈모자각증상에 따른 상관관계", "#대학생 #모발관리 #탈모자각", "2020.05.06"))
//        (BoardFirst_itemList as ArrayList<BoardFirstData>).add(BoardFirstData(R.drawable.doctor8, "박태영 전문의", "모발", "한국인의 두피모발 특성과 남성형탈모증에 대해 알려드릴게요", "#한국 #남성탈모 #모발특성", "2020.03.19"))

        //리사이클러뷰에 적용시키기
        recyclerView?.setAdapter(BoardFirstAdapter(BoardFirst_itemList, context))

        return root

    }

    

}