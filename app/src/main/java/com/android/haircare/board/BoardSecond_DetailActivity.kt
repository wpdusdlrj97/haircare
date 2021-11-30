package com.android.haircare.board

import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.util.Base64
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.android.haircare.R
import com.bumptech.glide.Glide


class BoardSecond_DetailActivity : AppCompatActivity() {

    private lateinit var boardsecond_detail_profile: ImageView
    private lateinit var boardsecond_detail_nickname: TextView
    private lateinit var boardsecond_detail_date: TextView
    private lateinit var boardsecond_detail_content: TextView
    private lateinit var boardsecond_detail_status: TextView

    private lateinit var boardsecond_detail_first_image: ImageView
    private lateinit var boardsecond_detail_second_image: ImageView
    private lateinit var boardsecond_detail_third_image: ImageView

    private lateinit var doctor_answer_layout : LinearLayout
    private lateinit var doctor_noanswer_layout : LinearLayout

    private lateinit var boardseconddetail_doctor_img : ImageView
    private lateinit var boardseconddetail_doctor_name : TextView
    private lateinit var boardseconddetail_doctor_title : TextView
    private lateinit var boardseconddetail_doctor_content : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_second_detail)

        boardsecond_detail_profile = findViewById(R.id.boardsecond_detail_profile)
        boardsecond_detail_nickname = findViewById(R.id.boardsecond_detail_nickname)
        boardsecond_detail_date = findViewById(R.id.boardsecond_detail_date)
        boardsecond_detail_content = findViewById(R.id.boardsecond_detail_content)
        boardsecond_detail_status = findViewById(R.id.boardsecond_detail_status)

        boardsecond_detail_first_image = findViewById(R.id.boardsecond_detail_first_image)
        boardsecond_detail_second_image = findViewById(R.id.boardsecond_detail_second_image)
        boardsecond_detail_third_image = findViewById(R.id.boardsecond_detail_third_image)

        doctor_answer_layout = findViewById(R.id.doctor_answer_layout)
        doctor_noanswer_layout = findViewById(R.id.doctor_noanswer_layout)

        boardseconddetail_doctor_img = findViewById(R.id.boardseconddetail_doctor_img)
        boardseconddetail_doctor_name = findViewById(R.id.boardseconddetail_doctor_name)
        boardseconddetail_doctor_title = findViewById(R.id.boardseconddetail_doctor_title)
        boardseconddetail_doctor_content = findViewById(R.id.boardseconddetail_doctor_content)


        //접근 시 recyclerview 스크롤 유지
        val rv_sharedPreference = getSharedPreferences("rv_db", 0)
        val rv_editor = rv_sharedPreference?.edit()
        rv_editor?.putInt("rv_status", 1)
        rv_editor?.apply()


        //인텐트로 값 받기 (프로필 이미지, 이름, 타입, 제목, 해시태그, 날짜)
        var intent = getIntent()
        var board_no = intent.getStringExtra("board_no").toString()

        if(board_no=="1001"){
            Glide.with(this)
                .load(R.drawable.board_profile1)
                .thumbnail(0.3f)
                .centerCrop()
                .into(boardsecond_detail_profile)
            boardsecond_detail_nickname.text="탈모짱짱"
            boardsecond_detail_date.text="2021-04-28"
            boardsecond_detail_content.text="탈모에 대해 질문드립니다.\n" +
                    "\n" +
                    "현재 나이는 25살이며 23살에 두피클리닉 센터에서 무료검진을 받았습니다. 결과는 매우 충격적으로 탈모 중기에\n" +
                    "해당된다는 결과를 받았으며, 이대로 지속된다면 앞으로 50%의 머리카락은 빠진다고 하셨는데요. 저도 매우 민감한 부분이라\n" +
                    "치료를 받고 싶었지만 한달에 80만원이라는 관리비를 부담하기에는 학생 신분으로서 너무나도 부담스러워서 어찌 할 방법이 없어서 지금은 잠자기전 머리감는것과 탈모에는 전혀도움안되지만 그래도 민감성 탈모샴푸를 쓰고있습니다.\n" +
                    "탈모는 치료를 받아도 많이 호전은되지만 완전히 치료는 보기 힘든것 같더군요 그리고 두피에 여드름도 나고 붉은색을 띄는데 이것도 따로 진료를 받아야하나요?"

            boardsecond_detail_status.text="답변 완료"

            Glide.with(this)
                .load(R.drawable.board_content1_1)
                .thumbnail(0.3f)
                .centerCrop()
                .into(boardsecond_detail_first_image)
            Glide.with(this)
                .load(R.drawable.board_content1_2)
                .thumbnail(0.3f)
                .centerCrop()
                .into(boardsecond_detail_second_image)
            Glide.with(this)
                .load(R.drawable.board_content1_3)
                .thumbnail(0.3f)
                .centerCrop()
                .into(boardsecond_detail_third_image)





            doctor_answer_layout.visibility= View.VISIBLE
            doctor_noanswer_layout.visibility = View.GONE

            Glide.with(this)
                .load(R.drawable.doctor1)
                .thumbnail(0.3f)
                .centerCrop()
                .into(boardseconddetail_doctor_img)

            boardseconddetail_doctor_title.text = "남자 20대 초반의 탈모 예방법 및 올바른 샴푸 사용법 안내"
            boardseconddetail_doctor_name.text = "박태준 전문의"
            boardseconddetail_doctor_content.text = "안녕하세요, 하이닥 외과 상담의 박태준 입니다.\n" +
                    "\n" +
                    "두피클리닉센터라면 병원이 아닙니다. 탈모는 정확한 진단하에 적절한 치료를 받아야 합니다.\n" +
                    "\n" +
                    "관리만으로 탈모의 진행을 막을수도 치료가 되는것도 아닙니다. 샴푸 역시 탈모를 치료할 수는 없습니다. 되도록 가까운 피부과나 탈모진료 병원을 방문하셔서 정확한 진단을 받으시고 치료도 받으시길 권유드립니다.\n" +
                    "\n" +
                    "남자의 경우 대부분 남성형 탈모이며 남성형 탈모는 진행이 많이 되어 사라지지 않았다면 더이상 진행을 막고 호전될수 있습니다. 또한 탈모의 병리기전이 모낭의 미세염증으로 인한 모근의 축소화로 모발이 가늘어지는 현상이므로 동반증상으로 두피가 붉거나 트러블이 생기는 경우가 많습니다."

            boardseconddetail_doctor_img.clipToOutline = true

        }else if(board_no=="1002"){

            Glide.with(this)
                .load(R.drawable.board_profile2)
                .thumbnail(0.3f)
                .centerCrop()
                .into(boardsecond_detail_profile)
            boardsecond_detail_nickname.text="힙몬스터"
            boardsecond_detail_date.text="2021-09-09"
            boardsecond_detail_content.text="30대 중반이고 치료를 받고싶은데..\n" +
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
                    "있다면 바로 끊어야 할까요?"
            boardsecond_detail_status.text="답변 완료"

            Glide.with(this)
                .load(R.drawable.board_content2_1)
                .thumbnail(0.3f)
                .centerCrop()
                .into(boardsecond_detail_first_image)
            Glide.with(this)
                .load(R.drawable.board_content2_2)
                .thumbnail(0.3f)
                .centerCrop()
                .into(boardsecond_detail_second_image)

            boardsecond_detail_third_image.visibility = View.GONE
            doctor_answer_layout.visibility= View.VISIBLE
            doctor_noanswer_layout.visibility = View.GONE

            Glide.with(this)
                .load(R.drawable.doctor3)
                .thumbnail(0.3f)
                .centerCrop()
                .into(boardseconddetail_doctor_img)

            boardseconddetail_doctor_title.text = "30대 중반의 임산부 탈모 예방법 및 올바른 치료법 안내"
            boardseconddetail_doctor_name.text = "김효진 원장"
            boardseconddetail_doctor_content.text = "반갑습니다, 힙몬스터님^^\n" +
                    "\n" +
                    "진심으로 치료하는 진한의원 대표원장 김효진입니다.\n" +
                    "\n" +
                    "우선 바쁘신 가운데 저희 진한의원의 문을 두드려주셔서 진심으로 감사드립니다.\n" +
                    "\n" +
                    "모발 때문에 고민이 많으시지요. 임신 준비는 또 하셔야 하는데 치료와 병행해도 되는지 궁금한 부분이 많으리라 생각됩니다. ^^\n" +
                    "\n" +
                    "탈모는 모발이 빠지는 증상과 함께 모발 가늘어짐, 두피 가려움이나 열감,\n" +
                    "과다한 기름짐, 비듬과 같은 노폐물 증가가 함께 나타나는 경우가 많습니다.\n" +
                    "\n" +
                    "탈모라고 하는 질환은 증상은 같지만 그 원인은 사람마다 다릅니다.\n" +
                    "정확한 한의학적 진단 과정을 통해 원인을 잘 파악하고 치료에 들어가는 것이\n" +
                    "무엇보다 중요합니다.\n" +
                    "\n" +
                    "진한의원에서는 적외선 체열검사, 두피현미경 검사, 자율신경계 검사와 문진을 통해\n" +
                    "탈모의 원인을 밝히고 증상과 원인을 함께 치료합니다.\n" +
                    "\n" +
                    "탈모의 경우 증상과 원인에 따라 치료 내용이 달라질 수 있어\n" +
                    "검사와 상담이 병행되어야 합니다.\n" +
                    "\n" +
                    "한의학에서는 탈모를 혈(血)의 개념으로 설명하는데\n" +
                    "신체의 상부로 향하는 열이 너무 많아 인체의 항상성에 불균형이 초래되거나\n" +
                    "혈의 순환에 장애가 되는 요인들이 발생할 경우\n" +
                    "머리카락이 가늘어지고 머리가 갑자기 많이 빠질 수 있습니다."

            boardseconddetail_doctor_img.clipToOutline = true

        }else{

            val i = board_no

            val board_sharedPreference = getSharedPreferences("board_db", 0)
            val board_nickname = board_sharedPreference?.getString("board_nickname$i", "");
            val board_date = board_sharedPreference?.getString("board_date$i", "");
            val board_content = board_sharedPreference?.getString("board_content$i", "");
            val board_status = board_sharedPreference?.getString("board_status$i", "");
            val board_first_image = board_sharedPreference?.getString("board_first_image_$i", "");
            val board_second_image = board_sharedPreference?.getString("board_second_image_$i", "");
            val board_third_image = board_sharedPreference?.getString("board_third_image_$i", "");

            boardsecond_detail_nickname.text=board_nickname
            boardsecond_detail_date.text=board_date
            boardsecond_detail_content.text=board_content
            boardsecond_detail_status.text=board_status
            boardsecond_detail_status.setTextColor(Color.parseColor("#A3A6AA"))

            if(board_first_image==""){
                boardsecond_detail_first_image.visibility = View.GONE
            }else{
                val encodeByte: ByteArray = Base64.decode(board_first_image, Base64.DEFAULT) // String 화 된 이미지를  base64방식으로 인코딩하여 byte배열을 만듬
                val board_first_image_bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size) //byte배열을 bitmapfactory 메소드를 이용하여 비트맵으로 바꿔준다.
                Glide.with(this)
                    .asBitmap()
                    .load(board_first_image_bitmap)
                    .thumbnail(0.3f)
                    .centerCrop()
                    .into(boardsecond_detail_first_image)
            }

            if(board_second_image==""){
                boardsecond_detail_second_image.visibility = View.GONE
            }else{
                val encodeByte: ByteArray = Base64.decode(board_second_image, Base64.DEFAULT) // String 화 된 이미지를  base64방식으로 인코딩하여 byte배열을 만듬
                val board_second_image_bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size) //byte배열을 bitmapfactory 메소드를 이용하여 비트맵으로 바꿔준다.
                Glide.with(this)
                    .asBitmap()
                    .load(board_second_image_bitmap)
                    .thumbnail(0.3f)
                    .centerCrop()
                    .into(boardsecond_detail_second_image)
            }

            if(board_third_image==""){
                boardsecond_detail_third_image.visibility = View.GONE
            }else{
                val encodeByte: ByteArray = Base64.decode(board_third_image, Base64.DEFAULT) // String 화 된 이미지를  base64방식으로 인코딩하여 byte배열을 만듬
                val board_third_image_bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size) //byte배열을 bitmapfactory 메소드를 이용하여 비트맵으로 바꿔준다.
                Glide.with(this)
                    .asBitmap()
                    .load(board_third_image_bitmap)
                    .thumbnail(0.3f)
                    .centerCrop()
                    .into(boardsecond_detail_third_image)
            }


            doctor_noanswer_layout.visibility = View.VISIBLE
            doctor_answer_layout.visibility= View.GONE

        }


    }


    override fun onPause() {
        super.onPause()
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

    }
}