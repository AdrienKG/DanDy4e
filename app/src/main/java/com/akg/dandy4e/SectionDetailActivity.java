package com.akg.dandy4e;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;

/**
 * An activity representing a single Detail detail screen. This
 * activity is only used on handset devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link SectionListActivity}.
 * <p/>
 * This activity is mostly just a 'shell' activity containing nothing
 * more than a {@link SectionDetailFragment}.
 */
public class SectionDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.dd_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup vg = (RelativeLayout) findViewById(R.id.fdet_rl);
                FloatingActionButton fab = (FloatingActionButton) view;
                if (fab.getDrawable().getConstantState().equals(getResources().getDrawable(R
                        .drawable.ic_mode_edit, view.getContext().getTheme()).getConstantState())) {
                    fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_clear, view.getContext().getTheme()));
                    for (int i = 0; i < vg.getChildCount(); i++) {
                        View child = vg.getChildAt(i);
                        if (child instanceof EditText) {
                            ((EditText) child).setFocusableInTouchMode(true);
                            ((EditText) child).setFocusable(true);
                        }
                    }
                } else {
                    fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_mode_edit, view.getContext().getTheme()));
                    for (int i = 0; i < vg.getChildCount(); i++) {
                        View child = vg.getChildAt(i);
                        if (child instanceof EditText) {
                            ((EditText) child).setFocusable(false);
                        }
                    }
                }
            }
        });

        // Show the Up button in the action bar.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(SectionDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(SectionDetailFragment.ARG_ITEM_ID));
            SectionDetailFragment fragment = new SectionDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.section_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, SectionListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
