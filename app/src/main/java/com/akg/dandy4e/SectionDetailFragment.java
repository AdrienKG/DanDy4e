package com.akg.dandy4e;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.database.sqlite.*;
import com.akg.dandy4e.database.*;
import android.database.*;
import com.akg.dandy4e.database.CharacterReaderContract.CharacterEntry;
import com.akg.dandy4e.database.object.*;
import com.akg.dandy4e.database.object.Character;
import com.akg.dandy4e.databinding.FragmentDetailsBinding;

/**
 * A fragment representing a single Detail detail screen.
 * This fragment is either contained in a {@link SectionListActivity}
 * in two-pane mode (on tablets) or a {@link SectionDetailActivity}
 * on handsets.
 */
public class SectionDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private SectionContent.SectionItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SectionDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = SectionContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.id);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		if (mItem.fragment == R.layout.fragment_details) {
			SQLiteDatabase db = CharacterReaderDbHelper.getSingleton(null).getWritableDatabase();
			Cursor c = CharacterReaderDbHelper.getSingleton(null).getCharacterDetails(db, "Adrien");

            if (c.moveToFirst()) {
                Character character = new Character(c.getLong(c.getColumnIndex(CharacterEntry._ID)),
                        c.getString(c.getColumnIndex(CharacterEntry.COLUMN_NAME_NAME)),
                        c.getString(c.getColumnIndex(CharacterEntry.COLUMN_NAME_RACE)),
                        c.getString(c.getColumnIndex(CharacterEntry.COLUMN_NAME_CLASS)),
                        c.getInt(c.getColumnIndex(CharacterEntry.COLUMN_NAME_LEVEL)));
                FragmentDetailsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false);
                binding.setCharacter(character);
                return binding.getRoot();
            }
		}
        return inflater.inflate(R.layout.fragment_details, container);
    }
}
