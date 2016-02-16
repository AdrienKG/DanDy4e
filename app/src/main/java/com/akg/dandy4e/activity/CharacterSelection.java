package com.akg.dandy4e.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.akg.dandy4e.SectionListActivity;
import com.akg.dandy4e.R;
import com.akg.dandy4e.activity.adapters.CharacterSelectionListViewAdapter;
import com.akg.dandy4e.database.CharacterReaderContract.CharacterEntry;
import com.akg.dandy4e.database.CharacterReaderDbHelper;
import com.akg.dandy4e.database.object.Character;

import java.util.ArrayList;
import java.util.List;

public class CharacterSelection extends ActionBarActivity {

	private CharacterReaderDbHelper helper = null;
    private SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_selection);

		helper = new CharacterReaderDbHelper(this);
        db = helper.getWritableDatabase();

        final ListView characterList = (ListView) findViewById(R.id.cs_characterList);
        registerForContextMenu(characterList);
        characterList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        characterList.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // TODO Auto-generated method stub

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
//                getMenuInflater().inflate(R.menu.menu_character_selction, menu);
//                findViewById(R.id.listViewCheckBox);
                return true;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
//                    case R.id.action_discard:
//                        SparseBooleanArray checked = characterList.getCheckedItemPositions();
//                        for (int i = 0; i < characterList.getCount(); i++) {
//                            if (checked.get(i)) {
//                                db.delete(CharacterEntry.TABLE_NAME,
//                                        CharacterEntry._ID + " = " + ((Character) characterList.getItemAtPosition(i)).getDBID().toString(),
//                                        null);
//                            }
//                        }
//                        refreshCharacterList();
//                        mode.finish();
//                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                // TODO Auto-generated method stub

            }
        });

        characterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Intent intent = new Intent(arg1.getContext(), SectionListActivity.class);
                startActivityForResult(intent, 1);
            }


        });
        refreshCharacterList();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.cs_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CharacterCreation.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
//            case R.id.action_settings:
//                return true;
            case R.id.action_new:
                Intent intent = new Intent(this, CharacterCreation.class);
                startActivityForResult(intent, 1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        refreshCharacterList();
    }

    private void refreshCharacterList() {
        final ListView characterList = (ListView) findViewById(R.id.cs_characterList);
        final List<Character> listOfNames = new ArrayList<Character>();
        
        Cursor c = helper.getCharacters(db);

        c.moveToFirst();
        for (int i = 0; i < c.getCount(); i++) {
            listOfNames.add(new Character(
                    c.getLong(c.getColumnIndex(CharacterEntry._ID)),
                    c.getString(c.getColumnIndex(CharacterEntry.COLUMN_NAME_NAME)),
                    c.getString(c.getColumnIndex(CharacterEntry.COLUMN_NAME_RACE)),
                    c.getString(c.getColumnIndex(CharacterEntry.COLUMN_NAME_CLASS)),
                    c.getInt(c.getColumnIndex(CharacterEntry.COLUMN_NAME_LEVEL))));
            c.moveToNext();
        }

//        final MainListViewAdapter arrayAdapter = new MainListViewAdapter(this, listOfNames);
        final CharacterSelectionListViewAdapter arrayAdapter = new
                CharacterSelectionListViewAdapter(this,
                listOfNames);
        characterList.setAdapter(arrayAdapter);
    }
}
