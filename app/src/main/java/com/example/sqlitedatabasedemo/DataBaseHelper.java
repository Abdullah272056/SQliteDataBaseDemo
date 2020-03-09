package com.example.sqlitedatabasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    Context  context;
    public DataBaseHelper(@Nullable Context context) {
        super(context, Query.DATAbASE_NAME, null, Query.DATAbASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Query.CREATE_TABLE);
        Toast.makeText(context, "db created", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertData(Student student){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Query.STUDENT_NAME,student.getName());
        contentValues.put(Query.STUDENT_ROLL,student.getRoll());

        long id = db.insert(Query.TABLE_NAME,null,contentValues);


        return id;

    }



    public Cursor getAllData(){

       // List<Student> data = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor  = db.rawQuery("SELECT * FROM "+Query.TABLE_NAME,null);

//        if (cursor.moveToFirst()){
//
//            do {
//                Student student = new Student();
//                student.setId(cursor.getInt(cursor.getColumnIndex(Query.ID)));
//                student.setName(cursor.getString(cursor.getColumnIndex(Query.STUDENT_NAME)));
//                student.setRoll(cursor.getString(cursor.getColumnIndex(Query.STUDENT_ROLL)));
//                data.add(student);
//
//
//            }while (cursor.moveToNext());
//        }

        return cursor;
    }

    public int deleteData(String id){
        SQLiteDatabase db = getWritableDatabase();
        int status = db.delete(Query.TABLE_NAME,"id=?",new String[]{String.valueOf(id)});
        return status;
    }




}
