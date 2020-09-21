package com.shahriar.zenxoidtodo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_Name = "todo.db";
    public static final String tablename = "todolist";
    public static final String COL1 = "id";
    public static final String COL2 = "title";
    public static final String COL3 = "description";
    public static final String COL4 = "checked";


    public DatabaseHelper(@Nullable Context context) {
        super(context, tablename, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + tablename + "(ID integer primary key autoincrement,title text,description text,checked text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tablename);
        onCreate(db);
    }

    public boolean insert_all(String title, String description, String checked){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues ContentValues = new ContentValues();
        ContentValues.put(COL2, title);
        ContentValues.put(COL3, description);
        ContentValues.put(COL4, checked);
        long result = db.insert(tablename,null,ContentValues);
        if (result == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean insert_title(String title){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues ContentValues = new ContentValues();
        ContentValues.put(COL2, title);
            long result = db.insert(tablename,null,ContentValues);
            if (result == -1){
                return false;
            }
            else{
            return true;
        }
    }

    public Cursor get_all_item(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + tablename, null);
    }

}
