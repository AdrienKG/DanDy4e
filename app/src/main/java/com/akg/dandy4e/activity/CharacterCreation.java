package com.akg.dandy4e.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.akg.dandy4e.R;
import com.akg.dandy4e.database.CharacterReaderContract.CharacterEntry;
import com.akg.dandy4e.database.CharacterReaderDbHelper;

public class CharacterCreation  extends Activity {

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);

        db = new CharacterReaderDbHelper(this).getWritableDatabase();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_character_creation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //if (id == R.id.action_accept) {
       //     ContentValues values = new ContentValues();
         //   values.put(CharacterEntry.COLUMN_NAME_NAME, ((EditText) findViewById(R.id.acc_name_field)).getText().toString());
        //    values.put(CharacterEntry.COLUMN_NAME_RACE, ((EditText) findViewById(R.id.acc_race_field)).getText().toString());
       //     values.put(CharacterEntry.COLUMN_NAME_CLASS, ((EditText) findViewById(R.id.acc_class_field)).getText().toString());
         //   values.put(CharacterEntry.COLUMN_NAME_LEVEL, Integer.valueOf(1));
        //    db.insert(CharacterEntry.TABLE_NAME, null, values);
        //    setResult(RESULT_OK, null);
         //   finish();
         //   return true;
       // }
        setResult(RESULT_CANCELED, null);
        return super.onOptionsItemSelected(item);
    }
}
