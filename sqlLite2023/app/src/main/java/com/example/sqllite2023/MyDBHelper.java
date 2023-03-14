package com.example.sqllite2023;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DBName = "mydb.db";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "Sinhvien";
    private static final String ID = "_id";
    private static final String NAME = "name";
    private static final String YEAROB = "yearob";
    private SQLiteDatabase myDB;

    public MyDBHelper(@Nullable Context context) {
        super(context, DBName, null, VERSION);
    }

    public static String getID() {
        return ID;
    }

    public static String getNAME() {
        return NAME;
    }

    public static String getYEAROB() {
        return YEAROB;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryTable = "CREATE TABLE " + TABLE_NAME + " ( " + ID +
                " INTEGER PRIMARY KEY autoincrement," +
                NAME + " TEXT NOT NULL, " + YEAROB + " INTEGER NOT NULL" + ")";
        db.execSQL(queryTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void openDB() {
        myDB = getWritableDatabase();
    }
    public void closeDB() {
        if (myDB != null && myDB.isOpen()) {
            myDB.close();
        }
    }

    public long Insert(String name, int yearob) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(YEAROB, yearob);
        return  db.insert(TABLE_NAME, null, values);
    }

    public long Update(int id, String name, int yearob) {
        ContentValues values = new ContentValues();
        values.put(ID, id);
        values.put(NAME, name);
        values.put(YEAROB, yearob);
        String where = ID + " = " + id;
        return myDB.update(TABLE_NAME, values, where, null);
    }

    public long Delete(int id) {
        String where = ID + " = " + id;
        return myDB.delete(TABLE_NAME, where, null);
    }

    public Cursor Search(String name) {
        String where = NAME + " = '" + name + "'";
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + where;
        return myDB.rawQuery(query, null);
    }
    public Cursor DisplayAll() {
        String query = "SELECT * FROM " + TABLE_NAME;
        return myDB.rawQuery(query, null);
    }
}
