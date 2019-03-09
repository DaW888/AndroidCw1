package com.szkola.dw.cw1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseManager extends SQLiteOpenHelper {
    public DataBaseManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE tabela1 (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 'a' TEXT, 'b' TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE if EXISTS tabela1");
        onCreate(sqLiteDatabase);
    }

    public boolean insert(String a, String b){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("a", a);
        contentValues.put("b", b);

        db.insertOrThrow("tabela1", null, contentValues);
        db.close();
        return true;

    }
}
