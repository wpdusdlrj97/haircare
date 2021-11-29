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
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.haircare.R
import com.android.haircare.analyze.MicroscopeActivity

class BoardSecondFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var BoardSecond_itemList: List<BoardSecondData>

    lateinit var write_button: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_boardsecond, container, false)

        recyclerView = root!!.findViewById(R.id.boardsecond_recycler)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.setLayoutManager(LinearLayoutManager(context))

        write_button = root!!.findViewById(R.id.write_button)




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



        val board_sharedPreference = context?.getSharedPreferences("board_db", 0)
        val board_count =board_sharedPreference?.getInt("board_count", 0);


//        //게시판 글 작성 시
//        val board_sharedPreference = context?.getSharedPreferences("board_second", 0)
//        val board_editor = board_sharedPreference?.edit()
//        board_editor?.putString("board_content"+board_count, "건강한 모발을 위한 두피 관리법"+board_count)


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

                //데이터 삽입
                (BoardSecond_itemList as ArrayList<BoardSecondData>).add(
                    BoardSecondData(
                        R.drawable.profile,
                        board_nickname,
                        board_date,
                        board_content,
                        board_status,
                        board_first_image,
                    )
                )
            }
        }

        (BoardSecond_itemList as ArrayList<BoardSecondData>).add(
            BoardSecondData(
                R.drawable.board_profile1,
                "BTS 진",
                "2021-09-09",
                "원래 관심 부담스러워하는 편이라 잘 안나서는 타입인디ㅠ\n" +
                        "일부러 수술 직후에 가면 다들관심 보일까봐\n" +
                        "수술도 주말끼고 연차도 3 정도 내서 회복하고 나갔는데…\n" +
                        "다들 뭔가 달라진 것 같다고 유심히 보셔서 모발이식 고백했슴다ㅎ\n" +
                        "과장님 부장님의 관심이 너무 뜨겁네요..ㅎ..\n" +
                        "헤어라인 한건데 한번만 보여달라고 하셔서 보여드렸더니\n" +
                        "생각보다 제 이마가 이렇게 넓었던 건지는 몰랐다고 숱이 없다고만 생각 했었는데\n" +
                        "이식모들이 심어진 것 보고는 라인 괜찮은 것 같다며 병원 소개 해달라고 하셔서\n" +
                        "갑자기 병원 직원 빙의ㅋㅋㅋㅋ\n" +
                        "아직 초반이라 암흑기가 안와서 저도 집에서 보면서 뿌듯해하고 있긴했는데\n" +
                        "회사에서 이런 뜨거운 반응 부담스러우면서도 좋기도 하네요ㅋㅋㅋ\n" +
                        "관리를 더 열심히 해봐야 겠습니다 오늘도 연차내서 금토일 쉬는건 안비밀ㅋㅋ",
                "답변 완료",
                "",
            )
        )
        (BoardSecond_itemList as ArrayList<BoardSecondData>).add(
            BoardSecondData(
                R.drawable.board_profile2,
                "블랙핑크 로제",
                "2021-07-12",
                "해외 가발 영상을 보면, 레이스가발 매듭부분을 탈색해서 더 자연스럽게 쓰더라구요.\n" +
                        "\n" +
                        "혹시 해보신 분 있을까요?. 도전해볼까하는데,, 엄두가 안납니다 ㅠㅠ..\n" +
                        "아니면 업체 통해서 해보신 분이라도 ㅎㅎ..\n" +
                        "\n" +
                        "가발업체에 직접적으로 문의를 드려본 적은 없으나, 하x모에서 RC모?라고 있는 것 말고는 정보가 없네요. ㅠㅠ",
                "미답변",
                "",
            )
        )
        (BoardSecond_itemList as ArrayList<BoardSecondData>).add(
            BoardSecondData(
                R.drawable.board_profile3,
                "유느님",
                "2021-05-21",
                "프로페시아랑 아보다트 둘다 드셔본분 중에서\n" +
                        "차이점은 효과가 크게 변함이없겠죠?ㅠㅠ\n" +
                        "\n" +
                        "프로페시아가 가격이아무래도 부담이되어서\n" +
                        "아보다트로 1년넘게먹는중이긴한데 더 자라나는건진 모르겠고..방지만되는거겠죠?ㅠ",
                "답변 완료",
                "",
            )
        )
        (BoardSecond_itemList as ArrayList<BoardSecondData>).add(
            BoardSecondData(
                R.drawable.board_profile4,
                "보검보검",
                "2021-04-28",
                "안녕하세요 오랜 회원님의 티않나고 자연스러운 헤어 요청으로\n" +
                        "가르마펌, 애쉬브라운컬러로 진행을 해드렸답니다.\n" +
                        "우선 맞춤가발로 스킨의 자연스러운 헤어라인과 기법으로 티나지 않게 만들었고\n" +
                        "애쉬브라운컬로 진행했습니다.\n" +
                        "고정식으로 했으며 모류 방향 가르마위치까지 완벽하게 진행했습니다.\n" +
                        "거기서 저희만의 오랜 노하우가 집약된 커트 기술과 펌 기술로 티나지 않게 만들어 드렸답니다.\n" +
                        "대만족하셨답니다.",
                "답변 완료",
                "",
            )
        )


        //리사이클러뷰에 적용시키기
        recyclerView?.setAdapter(BoardSecondAdapter(BoardSecond_itemList, context))
    }

}