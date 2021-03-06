package com.akg.dandy4e.activity.adapters;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.akg.dandy4e.BR;
import com.akg.dandy4e.R;
import com.akg.dandy4e.SectionListActivity;
import com.akg.dandy4e.database.CharacterReaderContract;
import com.akg.dandy4e.database.object.Character;
import com.akg.dandy4e.databinding.ActivityCharacterSelectionListViewRowBinding;

import java.util.List;

public class CharacterSelectionRecyclerAdapter extends RecyclerView.Adapter<CharacterSelectionRecyclerAdapter.CharacterSelectionRecyclerViewHolder> {
    private List<Character> modelItems;
    private int itemLayout;

    public CharacterSelectionRecyclerAdapter(List<Character> resource, int itemLayout) {
        this.modelItems = resource;
        this.itemLayout = itemLayout;
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
    public Long getDBID(int position) {
        Character item = modelItems.get(position);
        if (item != null) {
            return item.getDBID();
        }
        return Long.valueOf(-1);
    }

    @Override
    public CharacterSelectionRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
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

    public static class CharacterSelectionRecyclerViewHolder extends RecyclerView.ViewHolder
            implements AdapterView.OnItemClickListener {
        private ActivityCharacterSelectionListViewRowBinding binding;

        public CharacterSelectionRecyclerViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public ActivityCharacterSelectionListViewRowBinding getBinding() {
            return binding;
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(view.getContext(), SectionListActivity.class);
            intent.putExtra(CharacterReaderContract.CharacterEntry.COLUMN_NAME_ENTRY_ID,
                    position);
            view.getContext().startActivity(intent);
        }
    }
}
