package com.example.hp.makemylist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.hp.makemylist.Contract.*;

public class DBHelper extends SQLiteOpenHelper {
    public static  final  String DATABASE_NAME= "list.db";
    public static final  int DATABASE_VERSION=1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_LIST_TABLE= "CREATE TABLE " +
                Entry.TABLE_NAME+ " ("+
                Entry._ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                Entry.COLUMN_NAME+" TEXT NOT NULL, "+
                Entry.COLUMN_AMOUNT+" INTEGER NOT NULL, "+
                Entry.COLUMN_TIMESTAMP+" TIMESTAMP DEFAULT CURRENT_TIMESTAMP"+
                ");";
        db.execSQL(SQL_CREATE_LIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Entry.TABLE_NAME);
        onCreate(db);
    }
}
