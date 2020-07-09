//Adapter for loading List of Estate
package com.example.realestate;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {
    String titleStr[], descriptionStr[];
    int images[];
    Context mContext;
    public ListAdapter(Context cot, String s1[], String s2[], int img[]){
        mContext=cot;
        titleStr= s1;
        descriptionStr= s2;
        images =img;

    }
    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.row_list_layout,parent,false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder holder, final int position) {
       holder.titleText.setText(titleStr[position]);
       holder.descriptionText.setText(descriptionStr[position]);
       holder.thumbnailImageView.setImageResource(images[position]);
       holder.mConstraintLayout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(mContext,Details.class);
               intent.putExtra("titleTxt",titleStr[position]);
               intent.putExtra("descriptionTxt",descriptionStr[position]);
               intent.putExtra("imageView",images[position]);
               mContext.startActivity(intent);

           }
       });
    }

    @Override
    public int getItemCount() {
        return titleStr.length;
    }

    public class ListHolder extends RecyclerView.ViewHolder{

        TextView titleText,descriptionText;
        ImageView thumbnailImageView;
        ConstraintLayout mConstraintLayout;
        public ListHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.myText1);
            descriptionText =itemView.findViewById(R.id.myText2);
            thumbnailImageView = itemView.findViewById(R.id.thumbnailImage);
            mConstraintLayout = itemView.findViewById(R.id.list_row);
        }
    }
}
