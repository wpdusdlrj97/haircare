package com.android.haircare.board

import android.Manifest
import android.Manifest.permission.CAMERA
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.*
import androidx.annotation.NonNull
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import com.android.haircare.R
import java.io.ByteArrayOutputStream
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class BoardSecondWriteActivity : AppCompatActivity() {

    lateinit var bscw_edittext: EditText
    lateinit var test_imageview1: ImageView
    lateinit var test_imageview2: ImageView
    lateinit var test_imageview3: ImageView
    lateinit var bswc_write_button: Button

    lateinit var bswc_progressbar: ProgressBar

    var ImageData1: Uri? = null;
    var ImageData2: Uri? = null;
    var ImageData3: Uri? = null;




    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_second_write)

        bscw_edittext = findViewById(R.id.bscw_edittext)
        test_imageview1 = findViewById(R.id.test_imageview1)
        test_imageview2 = findViewById(R.id.test_imageview2)
        test_imageview3 = findViewById(R.id.test_imageview3)
        bswc_write_button = findViewById(R.id.bswc_write_button)

        bswc_progressbar = findViewById(R.id.bswc_progressbar)


        test_imageview1.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, 1)
        }

        test_imageview2.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, 2)
        }

        test_imageview3.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, 3)
        }

        bswc_progressbar.visibility = View.INVISIBLE

        //접근 시 recyclerview 스크롤 유지
        val rv_sharedPreference = getSharedPreferences("rv_db", 0)
        val rv_editor = rv_sharedPreference?.edit()
        rv_editor?.putInt("rv_status", 1)
        rv_editor?.apply()

        bswc_write_button.setOnClickListener {



            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ISO_DATE
            val formatted = current.format(formatter)
            Log.d("현재 날짜", formatted)


            //로그인 정보 꺼내오기
            val profile_sharedPreference = getSharedPreferences("login", Context.MODE_PRIVATE)
            val profile_nickname = profile_sharedPreference?.getString("login_nickname", "")

            //게시판 총 글 수 꺼내오기
            val board_sharedPreference = getSharedPreferences("board_db", 0)
            var board_count = board_sharedPreference?.getInt("board_count", 0)
            val bs_content = bscw_edittext.text.toString()

            var bitmap_string_1 = ""
            var bitmap_string_2 = ""
            var bitmap_string_3 = ""

            if(bs_content==""){
                Toast.makeText(this, "질문할 내용을 입력해주세요", Toast.LENGTH_SHORT).show();
            }else{

                bswc_progressbar.visibility = View.VISIBLE
                bswc_progressbar.incrementProgressBy(5)

                if(ImageData1!=null){
                    //비트맵 to 스트링
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImageData1)
                    val stream = ByteArrayOutputStream()
                    bitmap.compress(Bitmap.CompressFormat.PNG, 20, stream)
                    val bytes = stream.toByteArray()
                    bitmap_string_1= Base64.getEncoder().encodeToString(bytes)
                }

                if(ImageData2!=null){
                    //비트맵 to 스트링
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImageData2)
                    val stream = ByteArrayOutputStream()
                    bitmap.compress(Bitmap.CompressFormat.PNG, 20, stream)
                    val bytes = stream.toByteArray()
                    bitmap_string_2= Base64.getEncoder().encodeToString(bytes)
                }

                if(ImageData3!=null){
                    //비트맵 to 스트링
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImageData3)
                    val stream = ByteArrayOutputStream()
                    bitmap.compress(Bitmap.CompressFormat.PNG, 20, stream)
                    val bytes = stream.toByteArray()
                    bitmap_string_3= Base64.getEncoder().encodeToString(bytes)
                }


                if (board_count != null) {
                    val board_count_plus = board_count + 1
                    val board_editor = board_sharedPreference?.edit()
                    //게시판 총 글 수 증가
                    board_editor?.putInt("board_count", board_count_plus)
                    Log.d("총 글 수", board_count_plus.toString())
                    //게시판 글 내용 추가
                    board_editor?.putString("board_nickname$board_count_plus", profile_nickname)
                    board_editor?.putString("board_content$board_count_plus", bs_content)
                    board_editor?.putString("board_date$board_count_plus", formatted)
                    board_editor?.putString("board_status$board_count_plus", "미답변")
                    board_editor?.putString("board_first_image_$board_count_plus", bitmap_string_1)
                    board_editor?.putString("board_second_image_$board_count_plus", bitmap_string_2)
                    board_editor?.putString("board_third_image_$board_count_plus", bitmap_string_3)
                    board_editor?.apply()
                    Log.d("글 내용", bs_content)
                    //Log.d("bitmap스트링", bitmap_string_1)
                };


                Toast.makeText(this, "질문 작성을 완료했습니다", Toast.LENGTH_SHORT).show();

                //접근 시 recyclerview 스크롤 유지
                val rv_sharedPreference = getSharedPreferences("rv_db", 0)
                val rv_editor = rv_sharedPreference?.edit()
                rv_editor?.putInt("rv_status", 0)
                rv_editor?.apply()

                finish()
            }



        }
    }



    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 1) {
                ImageData1 = data?.data!!
                //Toast.makeText(this, ImageData1.toString(), Toast.LENGTH_SHORT).show()

                 try {
                     //URI에 관한 영구권한 부여
                      val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImageData1)
                      test_imageview1.setImageBitmap(bitmap)

                 } catch (e: Exception) {
                    e.printStackTrace()
                }
            }else if(requestCode == 2){
                ImageData2 = data?.data!!
                //Toast.makeText(this, ImageData2.toString(), Toast.LENGTH_SHORT).show()

                try {
                    //URI에 관한 영구권한 부여
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImageData2)
                    test_imageview2.setImageBitmap(bitmap)

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }else if(requestCode == 3){
                ImageData3 = data?.data!!
                //Toast.makeText(this, ImageData3.toString(), Toast.LENGTH_SHORT).show()

                try {
                    //URI에 관한 영구권한 부여
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImageData3)
                    test_imageview3.setImageBitmap(bitmap)

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }



        }
    }


//    // 카메라 권한 요청
//    private fun requestPermission() {
//        ActivityCompat.requestPermissions(this, arrayOf(READ_EXTERNAL_STORAGE, CAMERA), 1)
//    }
//
//    // 카메라 권한 체크
//    private fun checkPersmission(): Boolean {
//        return (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) ==
//                PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,
//            android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
//    }
//
//    // 권한요청 결과
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            Log.d("TAG", "Permission: " + permissions[0] + "was " + grantResults[0] + "카메라 허가 받음 예이^^")
//        }else{
//            Log.d("TAG","카메라 허가 못받음 ㅠ 젠장!!")
//        }
//    }


    override fun onPause() {
        super.onPause()
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }


}