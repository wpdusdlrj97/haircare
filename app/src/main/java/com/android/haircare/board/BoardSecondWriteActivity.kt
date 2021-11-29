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
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
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
    lateinit var bswc_write_button: Button

    var ImageData: Uri? = null;




    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_second_write)

        bscw_edittext = findViewById(R.id.bscw_edittext)
        test_imageview1 = findViewById(R.id.test_imageview1)
        test_imageview2 = findViewById(R.id.test_imageview2)
        bswc_write_button = findViewById(R.id.bswc_write_button)


        test_imageview1.setOnClickListener {

//            if(checkPersmission()){
//                val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
//                intent.setType("image/*")
//                startActivityForResult(intent, 9)
//            }else{
//                requestPermission()
//            }

            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, 1)


        }

//        test_imageview2.setOnClickListener {
//            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
//            intent.setType("image/*")
//            startActivityForResult(intent, 2)
//        }


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

            var bitmap_string = ""

            if(ImageData!=null){
                //비트맵 to 스트링
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImageData)
                val stream = ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
                val bytes = stream.toByteArray()
                bitmap_string= Base64.getEncoder().encodeToString(bytes)
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
                board_editor?.putString("board_first_image_$board_count_plus", bitmap_string)
                board_editor?.apply()
                Log.d("글 내용", bs_content)
                Log.d("bitmap스트링", bitmap_string)
            };


            Toast.makeText(this, "질문 작성을 완료했습니다", Toast.LENGTH_SHORT).show();
            finish()

        }
    }

    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 1) {
                ImageData = data?.data!!
                Toast.makeText(this, ImageData.toString(), Toast.LENGTH_SHORT).show()

                 try {
                     //URI에 관한 영구권한 부여
                      val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImageData)
                      test_imageview1.setImageBitmap(bitmap)

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