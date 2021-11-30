package com.android.haircare.board

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.haircare.R
import com.android.haircare.analyze.MicroscopeActivity

class BoardSecondFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var BoardSecond_itemList: List<BoardSecondData>

    lateinit var write_button: ImageView
    lateinit var board_second_progressbar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_boardsecond, container, false)
        board_second_progressbar = root!!.findViewById(R.id.board_second_progressbar)


        board_second_progressbar.incrementProgressBy(5)

        recyclerView = root!!.findViewById(R.id.boardsecond_recycler)
        recyclerView.setHasFixedSize(true)
        //recyclerView.setLayoutManager(LinearLayoutManager(context))
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.isNestedScrollingEnabled = false;

        write_button = root!!.findViewById(R.id.write_button)



        val rv_sharedPreference = context?.getSharedPreferences("rv_db", 0)
        val rv_editor = rv_sharedPreference?.edit()
        rv_editor?.putInt("rv_status", 0)
        rv_editor?.apply()

        write_button.setOnClickListener {
            //Toast.makeText(context,"글쓰기 버튼",Toast.LENGTH_SHORT).show();

            //로그인 정보 조회
            val profile_sharedPreference = context?.getSharedPreferences("login", Context.MODE_PRIVATE)
            val profile_id = profile_sharedPreference?.getString("login_id", "")

            if(profile_id==""){
                Toast.makeText(context,"로그인 후 이용 가능합니다",Toast.LENGTH_SHORT).show();
            }else{
                var intent = Intent(context, BoardSecondWriteActivity::class.java)
                startActivity(intent)
            }
        }


        return root
    }


    override fun onResume() {
        super.onResume()

        val rv_sharedPreference = context?.getSharedPreferences("rv_db", 0)
        val rv_status =rv_sharedPreference?.getInt("rv_status", 0);


        if(rv_status==1){ //리사이클러뷰 스크롤 그대로
            val rv_editor = rv_sharedPreference?.edit()
            rv_editor?.putInt("rv_status", 0)
            rv_editor?.apply()
        }else{
            //리사이클러뷰 아이템 재정렬
            val board_sharedPreference = context?.getSharedPreferences("board_db", 0)
            val board_count =board_sharedPreference?.getInt("board_count", 0);

            Log.d("보드 카운트",board_count.toString())


            //initData();
            BoardSecond_itemList = ArrayList()


            if (board_count != null) {

                for(i in board_count downTo 1) { //역으로 삽입

                    val board_nickname = board_sharedPreference?.getString("board_nickname$i", "");
                    val board_date = board_sharedPreference?.getString("board_date$i", "");
                    val board_content = board_sharedPreference?.getString("board_content$i", "");
                    val board_status = board_sharedPreference?.getString("board_status$i", "");
                    val board_first_image = board_sharedPreference?.getString("board_first_image_$i", "");
                    val board_second_image = board_sharedPreference?.getString("board_second_image_$i", "");
                    val board_third_image = board_sharedPreference?.getString("board_third_image_$i", "");

                    //데이터 삽입
                    (BoardSecond_itemList as ArrayList<BoardSecondData>).add(
                        BoardSecondData(
                            i,
                            R.drawable.profile,
                            board_nickname,
                            board_date,
                            board_content,
                            board_status,
                            board_first_image,
                            board_second_image,
                            board_third_image,
                        )
                    )
                }
            }

            (BoardSecond_itemList as ArrayList<BoardSecondData>).add(
                BoardSecondData(1002,
                    R.drawable.board_profile2,
                    "힙몬스터",
                    "2021-09-09",
                    "30대 중반이고 치료를 받고싶은데..\n" +
                            "임신준비중이어서 어떻게해야할지 모르겠네요\n" +
                            "임신중에도 탈모치료가 가능한지 궁금합니다\n" +
                            "\n" +
                            "임신하고 머리가 너무 많이빠졌어요\n" +
                            "출산하고나면 돌아온다고는 하는데 아무래도 걱정이많이되네요\n" +
                            "\n" +
                            "출산하고 탈모치료를 병행하면 더 빨리 자라날까요?\n" +
                            "탈모치료는 어떻게 진행되는지 알고싶습니다...\n" +
                            "\n" +
                            "탈모약 핀페시아(finasteride 1mg) 8년 째 먹고 있었습니다.\n" +
                            "임신할 때 안좋은 영향이 있나요?\n" +
                            "있다면 바로 끊어야 할까요?",
                    "답변 완료",
                    "",
                    "",
                    "",
                )
            )
            (BoardSecond_itemList as ArrayList<BoardSecondData>).add(
                BoardSecondData(1001,
                    R.drawable.board_profile1,
                    "탈모짱짱",
                    "2021-04-28",
                    "탈모에 대해 질문드립니다.\n" +
                            "\n" +
                            "현재 나이는 25살이며 23살에 두피클리닉 센터에서 무료검진을 받았습니다. 결과는 매우 충격적으로 탈모 중기에\n" +
                            "해당된다는 결과를 받았으며, 이대로 지속된다면 앞으로 50%의 머리카락은 빠진다고 하셨는데요. 저도 매우 민감한 부분이라\n" +
                            "치료를 받고 싶었지만 한달에 80만원이라는 관리비를 부담하기에는 학생 신분으로서 너무나도 부담스러워서 어찌 할 방법이 없어서 지금은 잠자기전 머리감는것과 탈모에는 전혀도움안되지만 그래도 민감성 탈모샴푸를 쓰고있습니다.\n" +
                            "탈모는 치료를 받아도 많이 호전은되지만 완전히 치료는 보기 힘든것 같더군요 그리고 두피에 여드름도 나고 붉은색을 띄는데 이것도 따로 진료를 받아야하나요?",
                    "답변 완료",
                    "",
                    "",
                    "",
                )
            )


            //리사이클러뷰에 적용시키기
            recyclerView?.setAdapter(BoardSecondAdapter(BoardSecond_itemList, context))
            board_second_progressbar.visibility = View.INVISIBLE

            //어댑터 설정
            val bs_adatper = BoardSecondAdapter(BoardSecond_itemList, context)
            bs_adatper.setHasStableIds(true)
            bs_adatper.notifyDataSetChanged() //깜빡임
        }
    }

}