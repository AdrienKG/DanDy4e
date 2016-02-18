package com.akg.dandy4e.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.akg.dandy4e.database.CharacterReaderContract.CharacterEntry;
import android.database.*;

public class CharacterReaderDbHelper extends SQLiteOpenHelper {
	private static CharacterReaderDbHelper singleton = null;
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
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
		CharacterEntry.COLUMN_NAME_LEVEL + INTEGER_TYPE  + COMMA_SEP + 
		CharacterEntry.COLUMN_NAME_XP + INTEGER_TYPE  + COMMA_SEP + 
		CharacterEntry.COLUMN_NAME_EPIC + TEXT_TYPE  + COMMA_SEP + 
		CharacterEntry.COLUMN_NAME_PARAGON + TEXT_TYPE  + COMMA_SEP + 
		CharacterEntry.COLUMN_NAME_MISC + TEXT_TYPE  + " )";

    private static final String SQL_DELETE_ENTRIES =
        "DROP TABLE IF EXISTS " + CharacterEntry.TABLE_NAME;
    
    private CharacterReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
	
	public static CharacterReaderDbHelper getSingleton(Context context) {
		if (singleton == null) {
			singleton = new CharacterReaderDbHelper(context);
		}
		return singleton;
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
	
	public Cursor getCharacters(SQLiteDatabase db) {
		String[] projection = {CharacterEntry._ID,
			CharacterEntry.COLUMN_NAME_NAME,
			CharacterEntry.COLUMN_NAME_RACE,
			CharacterEntry.COLUMN_NAME_CLASS,
			CharacterEntry.COLUMN_NAME_LEVEL};

        return db.query(
			CharacterEntry.TABLE_NAME,  // The table to query
			projection,                               // The columns to return
			null,                                // The columns for the WHERE clause
			null,                            // The values for the WHERE clause
			null,                                     // don't group the rows
			null,                                     // don't filter by row groups
			null                                 // The sort order
        );
	}

    public Cursor getCharacterDetails(SQLiteDatabase db, String id) {
        String[] projection = {CharacterEntry._ID,
                CharacterEntry.COLUMN_NAME_NAME,
                CharacterEntry.COLUMN_NAME_RACE,
                CharacterEntry.COLUMN_NAME_CLASS,
                CharacterEntry.COLUMN_NAME_LEVEL,
                CharacterEntry.COLUMN_NAME_XP,
                CharacterEntry.COLUMN_NAME_EPIC,
                CharacterEntry.COLUMN_NAME_PARAGON,
                CharacterEntry.COLUMN_NAME_MISC};

        return db.query(
                CharacterEntry.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                CharacterEntry.COLUMN_NAME_NAME + " = ?",                                // The
                // columns for the
                // WHERE clause
                new String[]{id},                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
    }
}
