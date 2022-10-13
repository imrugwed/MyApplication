package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DBNAME="usersbd";

    public DBHandler(Context context) {
        super(context, "usersbd", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("CREATE TABLE  users (name TEXT primary key,day TEXT,month TEXT,year TEXT,email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("DROP TABLE IF EXISTS " + "users");
    }

    public Boolean insertData(String name,String day,String month,String year,String email){
        SQLiteDatabase MyBD=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("day",day);
        contentValues.put("month",month);
        contentValues.put("year",year);
        contentValues.put("email",email);
        long result =MyBD.insert("users",null,contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }
}
