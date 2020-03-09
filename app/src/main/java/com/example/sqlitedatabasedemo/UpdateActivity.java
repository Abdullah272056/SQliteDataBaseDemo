package com.example.sqlitedatabasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText updateNameEditText,updateRollEditText ;
    Button updateButton;
    String updateName,updateRoll;
    String oldName,oldRoll,id;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        dataBaseHelper=new DataBaseHelper(UpdateActivity.this);
        dataBaseHelper.getWritableDatabase();

        updateNameEditText=findViewById(R.id.updateNameEditTextId);
        updateRollEditText=findViewById(R.id.updateRollEditTextId);
        updateButton=findViewById(R.id.updateButtonId);



        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
             oldName = bundle.getString("oldName");
             oldRoll = bundle.getString("oldRoll");
             id=bundle.getString("id");
             updateNameEditText.setText(oldName);
            updateRollEditText.setText(oldRoll);
        }

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateName=updateNameEditText.getText().toString();
                updateRoll=updateRollEditText.getText().toString();
                int intId = Integer.parseInt(id);

                int idt = dataBaseHelper.updateData(new Student(intId,updateName,updateRoll));
                Toast.makeText(UpdateActivity.this, String.valueOf(idt), Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(UpdateActivity.this,DisplayData.class);
                startActivity(intent);


            }
        });





    }
}
