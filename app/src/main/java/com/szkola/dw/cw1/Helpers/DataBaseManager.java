package com.szkola.dw.cw1.Helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseManager extends SQLiteOpenHelper {
    public DataBaseManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE tabela1 (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 'title' TEXT, 'context' TEXT, 'color' INT, 'path' TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE if EXISTS tabela1");
        onCreate(sqLiteDatabase);
    }

    public boolean insert(String title, String context, int color, String path){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("context", context);
        contentValues.put("color", color);
        contentValues.put("path", path);

        db.insertOrThrow("tabela1", null, contentValues);
        db.close();
        return true;

    }

    public ArrayList<Note> getAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Note> notes = new ArrayList<>();
        Cursor result = db.rawQuery("SELECT * FROM tabela1", null);
        while (result.moveToNext()){
            notes.add(new Note(
                    result.getString(result.getColumnIndex("title")),
                    result.getString(result.getColumnIndex("context")),
                    result.getInt(result.getColumnIndex("color")),
                    result.getString(result.getColumnIndex("path"))
            ));
        }
        return notes;
    }
}
