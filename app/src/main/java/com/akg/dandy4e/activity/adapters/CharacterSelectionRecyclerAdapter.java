package com.akg.dandy4e.activity.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akg.dandy4e.BR;
import com.akg.dandy4e.R;
import com.akg.dandy4e.database.object.Character;
import com.akg.dandy4e.databinding.ActivityCharacterSelectionListViewRowBinding;

import java.util.List;

public class CharacterSelectionRecyclerAdapter extends RecyclerView.Adapter<CharacterSelectionRecyclerAdapter.CharacterSelectionRecyclerViewHolder> {
    List<Character> modelItems = null;

    public CharacterSelectionRecyclerAdapter(List<Character> resource) {
        this.modelItems = resource;
    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        final LayoutInflater inflater = ((Activity) context).getLayoutInflater();
//        ActivityCharacterSelectionListViewRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.activity_character_selection_list_view_row, parent, false);
//        binding.setCharacter(modelItems.get(position));
////        final TextView tvName = (TextView) convertView.findViewById(R.id.cslvr_name);
////        final TextView tvRace = (TextView) convertView.findViewById(R.id.cslvr_race);
////        final TextView tvClass = (TextView) convertView.findViewById(R.id.cslvr_class);
////        final TextView tvLevel = (TextView) convertView.findViewById(R.id.cslvr_level);
////
////        final Character item = modelItems.get(position);
////
////        tvName.setText(item.getCharacterName());
////        tvRace.setText("Race: " + item.getCharacterRace());
////        tvClass.setText("Class: " + item.getCharacterClass());
////        tvLevel.setText("Level: " + item.getCharacterLevel().toString());
//        return binding.getRoot();
//    }
//
//    public Long getDBID(int position) {
//        Character item = modelItems.get(position);
//        if (item != null) {
//            return item.getDBID();
//        }
//        return Long.valueOf(-1);
//    }

    @Override
    public CharacterSelectionRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_character_selection_list_view_row, parent, false);
        CharacterSelectionRecyclerViewHolder holder = new CharacterSelectionRecyclerViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(CharacterSelectionRecyclerViewHolder holder, int position) {
        final Character character = modelItems.get(position);
        holder.getBinding().setVariable(BR.character, character);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return modelItems.size();
    }

    public static class CharacterSelectionRecyclerViewHolder extends RecyclerView.ViewHolder {
        private ActivityCharacterSelectionListViewRowBinding binding;

        public CharacterSelectionRecyclerViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public ActivityCharacterSelectionListViewRowBinding getBinding() {
            return binding;
        }
    }
}
