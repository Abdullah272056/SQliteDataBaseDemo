package com.example.sqlitedatabasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText,rollEditText;
    Button insertButton,displayButton;

    String name,roll;

    DataBaseHelper dataBaseHelper;

    List<String> name_arraylist,roll_arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBaseHelper = new DataBaseHelper(MainActivity.this);


        nameEditText=findViewById(R.id.nameEditTextId);
        rollEditText=findViewById(R.id.rollEditTextId);
        insertButton=findViewById(R.id.insertButtonId);
        displayButton=findViewById(R.id.DisplayButtonId);


        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nameEditText.length()<=0||nameEditText==null){
                    nameEditText.setError("Enter Your Name");

                }
                else if (rollEditText.length()<=0||rollEditText==null){
                    rollEditText.setError("Enter Your Roll");
                }
                else {
                    name=nameEditText.getText().toString();
                    roll=rollEditText.getText().toString();
                    dataBaseHelper.getWritableDatabase();
                   long id= dataBaseHelper.insertData(new Student(name,roll));
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();



                }
            }

        });


        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DisplayData.class);

                startActivity(intent);



            }

        });




    }
}
