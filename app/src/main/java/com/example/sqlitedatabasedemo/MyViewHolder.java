package com.example.sqlitedatabasedemo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView countryNameTextView,countryDescTextView;
      ImageView imageView;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        countryNameTextView=itemView.findViewById(R.id.countryNameTextViewId);
        countryDescTextView=itemView.findViewById(R.id.decsTextViewId);
        imageView=itemView.findViewById(R.id.imageViewid);
    }
}
