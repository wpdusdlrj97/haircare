package com.android.haircare.board;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.haircare.R;
import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

public class BoardSecondAdapter extends RecyclerView.Adapter<BoardSecondAdapter.ViewHolder>{

    List<BoardSecondData> boardsecond_itemList;
    private Context context;

    public BoardSecondAdapter(List<BoardSecondData> boardsecond_itemList, Context context) {
        this.boardsecond_itemList=boardsecond_itemList;
        this.context=context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout boardsecond_linearLayout;
        
        ImageView boardsecond_profile;
        TextView boardsecond_nickname;
        TextView boardsecond_date;
        TextView boardsecond_content;
        TextView boardsecond_status;

        ImageView boardsecond_first_image;
        ImageView boardsecond_second_image;
        ImageView boardsecond_third_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            boardsecond_linearLayout=itemView.findViewById(R.id.boardsecond_layout);
            boardsecond_profile=itemView.findViewById(R.id.boardsecond_profile);
            boardsecond_nickname=itemView.findViewById(R.id.boardsecond_nickname);
            boardsecond_date=itemView.findViewById(R.id.boardsecond_date);
            boardsecond_content=itemView.findViewById(R.id.boardsecond_content);
            boardsecond_status=itemView.findViewById(R.id.boardsecond_status);

            boardsecond_first_image=itemView.findViewById(R.id.boardsecond_first_image);
            boardsecond_second_image=itemView.findViewById(R.id.boardsecond_second_image);
            boardsecond_third_image=itemView.findViewById(R.id.boardsecond_third_image);

        }
    }

    @NonNull
    @Override
    public BoardSecondAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.boardseconditem,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BoardSecondAdapter.ViewHolder holder, final int position) {

        //holder.doctor_img_item.setImageResource(boardfirst_itemList.get(position).getDoctor_img());
        Glide.with(context)
                .load(boardsecond_itemList.get(position).getBoardsecond_profile())
                .thumbnail(0.3f)
                .centerCrop()
                .into(holder.boardsecond_profile);
        //imageview round
        holder.boardsecond_profile.setClipToOutline(true);

        holder.boardsecond_nickname.setText(boardsecond_itemList.get(position).getBoardsecond_nickname());
        holder.boardsecond_date.setText(boardsecond_itemList.get(position).getBoardsecond_date());
        holder.boardsecond_content.setText(boardsecond_itemList.get(position).getBoardsecond_content());
        holder.boardsecond_status.setText(boardsecond_itemList.get(position).getBoardsecond_status());

        if(boardsecond_itemList.get(position).getBoardsecond_status().equals("?????????")){
            holder.boardsecond_status.setTextColor(Color.parseColor("#A3A6AA"));
        }else{
            holder.boardsecond_status.setTextColor(Color.parseColor("#6893E6"));
        }




        String board_first_image_string = boardsecond_itemList.get(position).getBoardsecond_first_image();
        String board_second_image_string = boardsecond_itemList.get(position).getBoardsecond_second_image();
        String board_third_image_string = boardsecond_itemList.get(position).getBoardsecond_third_image();


        if(board_first_image_string.equals("")){

            if(boardsecond_itemList.get(position).getBoardsecond_no()==1001){
                Glide.with(context)
                        .load(R.drawable.board_content1_1)
                        .thumbnail(0.3f)
                        .centerCrop()
                        .into(holder.boardsecond_first_image);
            }else if(boardsecond_itemList.get(position).getBoardsecond_no()==1002){
                Glide.with(context)
                        .load(R.drawable.board_content2_1)
                        .thumbnail(0.3f)
                        .centerCrop()
                        .into(holder.boardsecond_first_image);
            }else{
                holder.boardsecond_first_image.setVisibility(View.GONE);
            }

        }else{
            byte[] encodeByte = Base64.decode(board_first_image_string, Base64.DEFAULT);// String ??? ??? ????????????  base64???????????? ??????????????? byte????????? ??????
            Bitmap board_first_image_bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);//byte????????? bitmapfactory ???????????? ???????????? ??????????????? ????????????.
            //holder.boardsecond_first_image.setImageBitmap(board_first_image_bitmap);
            Glide.with(context)
                    .asBitmap()
                    .load(board_first_image_bitmap)
                    .thumbnail(0.3f)
                    .centerCrop()
                    .into(holder.boardsecond_first_image);
        }

        if(board_second_image_string.equals("")){

            if(boardsecond_itemList.get(position).getBoardsecond_no()==1001){
                Glide.with(context)
                        .load(R.drawable.board_content1_2)
                        .thumbnail(0.3f)
                        .centerCrop()
                        .into(holder.boardsecond_second_image);
            }else if(boardsecond_itemList.get(position).getBoardsecond_no()==1002){
                Glide.with(context)
                        .load(R.drawable.board_content2_2)
                        .thumbnail(0.3f)
                        .centerCrop()
                        .into(holder.boardsecond_second_image);
            }else{
                holder.boardsecond_second_image.setVisibility(View.GONE);
            }

        }else{
            byte[] encodeByte = Base64.decode(board_second_image_string, Base64.DEFAULT);// String ??? ??? ????????????  base64???????????? ??????????????? byte????????? ??????
            Bitmap board_second_image_bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);//byte????????? bitmapfactory ???????????? ???????????? ??????????????? ????????????.
            //holder.boardsecond_second_image.setImageBitmap(board_second_image_bitmap);
            Glide.with(context)
                    .asBitmap()
                    .load(board_second_image_bitmap)
                    .thumbnail(0.3f)
                    .centerCrop()
                    .into(holder.boardsecond_second_image);
        }

        if(board_third_image_string.equals("")){

            if(boardsecond_itemList.get(position).getBoardsecond_no()==1001){
                Glide.with(context)
                        .load(R.drawable.board_content1_3)
                        .thumbnail(0.3f)
                        .centerCrop()
                        .into(holder.boardsecond_third_image);
            }else{
                holder.boardsecond_third_image.setVisibility(View.GONE);
            }
        }else{
            byte[] encodeByte = Base64.decode(board_third_image_string, Base64.DEFAULT);// String ??? ??? ????????????  base64???????????? ??????????????? byte????????? ??????
            Bitmap board_third_image_bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);//byte????????? bitmapfactory ???????????? ???????????? ??????????????? ????????????.
            //holder.boardsecond_third_image.setImageBitmap(board_third_image_bitmap);
            Glide.with(context)
                    .asBitmap()
                    .load(board_third_image_bitmap)
                    .thumbnail(0.3f)
                    .centerCrop()
                    .into(holder.boardsecond_third_image);
        }



        //onclicklistener -> ?????? ??????????????? ???????????? ???
        holder.boardsecond_linearLayout.setOnClickListener(new View.OnClickListener() {

            String board_no = String.valueOf(boardsecond_itemList.get(position).getBoardsecond_no());

            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), board_no,Toast.LENGTH_SHORT).show();
                //????????? ??????
                Intent intent = new Intent(view.getContext(), BoardSecond_DetailActivity.class);
                //????????? ??????
                intent.putExtra("board_no", board_no);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return boardsecond_itemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position){
        return position;
    }





}