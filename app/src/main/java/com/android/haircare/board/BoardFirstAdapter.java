package com.android.haircare.board;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.android.haircare.member.LoginActivity;
import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class BoardFirstAdapter extends RecyclerView.Adapter<BoardFirstAdapter.ViewHolder>{

    List<BoardFirstData> boardfirst_itemList;
    private Context context;

    public BoardFirstAdapter(List<BoardFirstData> boardfirst_itemList, Context context) {
        this.boardfirst_itemList=boardfirst_itemList;
        this.context=context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView doctor_img_item;
        TextView doctor_name_item;
        TextView boardfirst_type_item;
        TextView boardfirst_title_item;
        TextView boardfirst_tag_item;
        TextView boardfirst_date_item;
        LinearLayout boardfirst_linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            boardfirst_linearLayout=itemView.findViewById(R.id.boardfirst_layout);
            doctor_img_item=itemView.findViewById(R.id.doctor_img);
            doctor_name_item=itemView.findViewById(R.id.doctor_name);
            boardfirst_type_item=itemView.findViewById(R.id.boardfirst_type);
            boardfirst_title_item=itemView.findViewById(R.id.boardfirst_title);
            boardfirst_tag_item=itemView.findViewById(R.id.boardfirst_tag);
            boardfirst_date_item=itemView.findViewById(R.id.boardfirst_date);

        }
    }

    @NonNull
    @Override
    public BoardFirstAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.boardfirstitem,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BoardFirstAdapter.ViewHolder holder, final int position) {

        //holder.doctor_img_item.setImageResource(boardfirst_itemList.get(position).getDoctor_img());
        Glide.with(context)
                .load(boardfirst_itemList.get(position).getDoctor_img())
                .thumbnail(0.3f)
                .centerCrop()
                .into(holder.doctor_img_item);

        //imageview round
        holder.doctor_img_item.setClipToOutline(true);
        holder.doctor_name_item.setText(boardfirst_itemList.get(position).getDoctor_name());
        holder.boardfirst_type_item.setText(boardfirst_itemList.get(position).getBoardfirst_type());
        holder.boardfirst_title_item.setText(boardfirst_itemList.get(position).getBoardfirst_title());
        holder.boardfirst_tag_item.setText(boardfirst_itemList.get(position).getBoardfirst_tag());
        holder.boardfirst_date_item.setText(boardfirst_itemList.get(position).getBoardfirst_date());

        //onclicklistener -> 해당 레이아웃을 클릭했을 시
        holder.boardfirst_linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),"테스트 "+boardfirst_itemList.get(position).getDoctor_name(),Toast.LENGTH_SHORT).show();

                //인텐트 발동
                Intent intent = new Intent(view.getContext(), BoardDetailActivity.class);

                //의사 프로필 이미지
                Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), boardfirst_itemList.get(position).getDoctor_img());
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("doctor_img", byteArray);

                //의사 이름, 타입, 제목, 태그, 날짜
                intent.putExtra("doctor_name", boardfirst_itemList.get(position).getDoctor_name());
                intent.putExtra("boardfirst_type", boardfirst_itemList.get(position).getBoardfirst_type());
                intent.putExtra("boardfirst_title", boardfirst_itemList.get(position).getBoardfirst_title());
                intent.putExtra("boardfirst_tag", boardfirst_itemList.get(position).getBoardfirst_tag());
                intent.putExtra("boardfirst_date", boardfirst_itemList.get(position).getBoardfirst_date());

                view.getContext().startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return boardfirst_itemList.size();
    }


}