package com.akg.dandy4e.database;

import android.provider.BaseColumns;

public final class CharacterReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public CharacterReaderContract() {}

    /* Inner class that defines the table contents */
    public static abstract class CharacterEntry implements BaseColumns {
        public static final String TABLE_NAME = "characterinfo";
        public static final String COLUMN_NAME_ENTRY_ID = "characterid";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_RACE = "race";
        public static final String COLUMN_NAME_CLASS = "class";
        public static final String COLUMN_NAME_LEVEL = "level";
    }
}