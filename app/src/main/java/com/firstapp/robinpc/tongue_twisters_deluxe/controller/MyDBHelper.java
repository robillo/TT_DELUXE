package com.firstapp.robinpc.tongue_twisters_deluxe.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.firstapp.robinpc.tongue_twisters_deluxe.model.Data;

import java.util.ArrayList;
import java.util.List;

public class MyDBHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "AddTwisters.db";
    private static final String TABLE_NAME = "AddTwisters";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_NAME = "NAME";
    private static final String COLUMN_DESCRIPTION = "DESCRIPTION";

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_NAME + " TEXT, " + COLUMN_DESCRIPTION + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    //CRUD OPERATIONS
    //CREATE
    public Boolean insertTwister(String NAME, String DESCRIPTION){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME + " ", NAME);
        contentValues.put(COLUMN_DESCRIPTION + " ", DESCRIPTION);
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        return true;
    }
    //READ
    public Cursor getTwister(int ID){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME +
                " WHERE " + COLUMN_ID + "=" + ID + " ", null);
    }
    //UPDATE
    public boolean updateTwister(Integer ID, String NAME, String DESCRIPTION) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, NAME);
        contentValues.put(COLUMN_DESCRIPTION, DESCRIPTION);
        sqLiteDatabase.update(TABLE_NAME, contentValues, COLUMN_ID + " = ? ", new String[] { Integer.toString(ID) } );
        return true;
    }
    //DELETE
    public Integer deleteTwister(Integer ID) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,
                COLUMN_ID + "= ? ",
                new String[] { Integer.toString(ID) });
    }

    public List<Data> getAllTwisters() {
        List<Data> data = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor res =  sqLiteDatabase.rawQuery( "SELECT * FROM " + TABLE_NAME + " ", null );
        res.moveToFirst();

        while(!res.isAfterLast()){
            data.add(new Data(res.getString(res.getColumnIndex(COLUMN_ID)),res.getString(res.getColumnIndex(COLUMN_NAME)),res.getString(res.getColumnIndex(COLUMN_DESCRIPTION))));
            res.moveToNext();
        }

        return data;
    }

    public int numberOfRows(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return (int) DatabaseUtils.queryNumEntries(sqLiteDatabase, TABLE_NAME);
    };
}
