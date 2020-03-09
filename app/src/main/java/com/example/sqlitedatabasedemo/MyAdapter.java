package com.example.sqlitedatabasedemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    ArrayList<String> name,roll;
    ArrayList<String> id;

    DataBaseHelper dataBaseHelper;

    AlertDialog.Builder builder;

    public MyAdapter(Context context, ArrayList<String> name, ArrayList<String> roll,ArrayList<String> id) {
        this.context = context;
        this.name = name;
        this.roll = roll;
        this.id = id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.sample_layout,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.NameTextView.setText(name.get(position));
        holder.rollTextView.setText(roll.get(position));
        holder.idTextView.setText(id.get(position));


        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,UpdateActivity.class);
                intent.putExtra("id",id.get(position));
                intent.putExtra("oldName",name.get(position));
                intent.putExtra("oldRoll",roll.get(position));

                context.startActivity(intent);

            }
        });
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBaseHelper=new DataBaseHelper(context);
                dataBaseHelper.getWritableDatabase();

                int status = dataBaseHelper.deleteData(id.get(position));
                Toast.makeText(context, "Item Clicked"+id.get(position), Toast.LENGTH_SHORT).show();
            }
        });




    }

    @Override
    public int getItemCount() {

        return name.size();
    }
}
