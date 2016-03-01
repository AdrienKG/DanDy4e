package com.akg.dandy4e.activity.adapters;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.tool.DataBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.akg.dandy4e.R;
import com.akg.dandy4e.activity.CharacterSelection;
import com.akg.dandy4e.database.object.Character;
import com.akg.dandy4e.databinding.ActivityCharacterSelectionListViewRowBinding;

import java.util.List;

public class CharacterSelectionListViewAdapter extends ArrayAdapter<Character> {
    List<Character> modelItems = null;
    Context context;
    public CharacterSelectionListViewAdapter(Context context, List<Character> resource) {
    super(context, android.R.layout.simple_list_item_multiple_choice, resource);
        this.context = context;
        this.modelItems = resource;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.activity_character_selection_list_view_row, parent, false);
        ActivityCharacterSelectionListViewRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.activity_character_selection_list_view_row, parent, false);
        binding.setCharacter(modelItems.get(position));
//        final TextView tvName = (TextView) convertView.findViewById(R.id.cslvr_name);
//        final TextView tvRace = (TextView) convertView.findViewById(R.id.cslvr_race);
//        final TextView tvClass = (TextView) convertView.findViewById(R.id.cslvr_class);
//        final TextView tvLevel = (TextView) convertView.findViewById(R.id.cslvr_level);
//
//        final Character item = modelItems.get(position);
//
//        tvName.setText(item.getCharacterName());
//        tvRace.setText("Race: " + item.getCharacterRace());
//        tvClass.setText("Class: " + item.getCharacterClass());
//        tvLevel.setText("Level: " + item.getCharacterLevel().toString());
        return convertView;
    }

    public Long getDBID(int position) {
        Character item = modelItems.get(position);
        if (item != null) {
            return item.getDBID();
        }
        return Long.valueOf(-1);
    }
}
