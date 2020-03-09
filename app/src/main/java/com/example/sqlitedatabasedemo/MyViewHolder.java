package com.example.sqlitedatabasedemo;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView NameTextView,rollTextView,idTextView;
    ImageButton editButton,deleteButton;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        NameTextView=itemView.findViewById(R.id.NameTextViewId);
        rollTextView=itemView.findViewById(R.id.rollTextViewId);
        idTextView=itemView.findViewById(R.id.idTextViewId);
        editButton=itemView.findViewById(R.id.editButtonId);
        deleteButton=itemView.findViewById(R.id.deleteButtonId);

    }
}
