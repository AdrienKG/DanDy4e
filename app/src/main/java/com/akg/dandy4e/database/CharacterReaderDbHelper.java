package com.akg.dandy4e.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.akg.dandy4e.database.CharacterReaderContract.CharacterEntry;

public class CharacterReaderDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "CharacterReader.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
        "CREATE TABLE " + CharacterEntry.TABLE_NAME + " (" +
        CharacterEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
        CharacterEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
        CharacterEntry.COLUMN_NAME_RACE + TEXT_TYPE + COMMA_SEP +
        CharacterEntry.COLUMN_NAME_CLASS + TEXT_TYPE + COMMA_SEP +
        CharacterEntry.COLUMN_NAME_LEVEL + INTEGER_TYPE + " )";

    private static final String SQL_DELETE_ENTRIES =
        "DROP TABLE IF EXISTS " + CharacterEntry.TABLE_NAME;
    
    public CharacterReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}