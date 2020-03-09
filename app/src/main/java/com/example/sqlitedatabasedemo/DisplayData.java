package com.example.sqlitedatabasedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayData extends AppCompatActivity {
    DataBaseHelper dataBaseHelper;
    ArrayList<String> name_arraylist,roll_arrayList;
    ArrayList<String>id_arraylist;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);


        dataBaseHelper=new DataBaseHelper(DisplayData.this);

        Cursor cursor = dataBaseHelper.getAllData();
        if (cursor.getCount() == 0) {

        }

        name_arraylist = new ArrayList<>();
        roll_arrayList = new ArrayList<>();
        id_arraylist = new ArrayList<>();


        while (cursor.moveToNext()) {

            name_arraylist.add(cursor.getString(cursor.getColumnIndex(Query.STUDENT_NAME)));
            roll_arrayList.add(cursor.getString(cursor.getColumnIndex(Query.STUDENT_ROLL)));
            id_arraylist.add(cursor.getString(cursor.getColumnIndex(Query.ID)));


        }



        recyclerView=findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter=new MyAdapter(DisplayData.this,name_arraylist,roll_arrayList,id_arraylist);


        recyclerView.setAdapter(adapter);






    }
}
