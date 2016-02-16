package com.akg.dandy4e;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Adrien on 2016-02-12.
 */
public class SectionContent {
    /**
     * An array of sample (dummy) items.
     */
    public static List<SectionItem> ITEMS = new ArrayList<SectionItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, SectionItem> ITEM_MAP = new HashMap<String, SectionItem>();

    static {
        addItem(createSectionItem("Details", null, R.layout.fragment_details));
        addItem(createSectionItem("Abilities", null, 0));
        addItem(createSectionItem("Attack", null, 0));
        addItem(createSectionItem("Health", null, 0));
        addItem(createSectionItem("Powers", null, 0));
        addItem(createSectionItem("Skills", null, 0));
        addItem(createSectionItem("Feats", null, 0));
        addItem(createSectionItem("Equipment", null, 0));
        addItem(createSectionItem("Rituals", null, 0));
        addItem(createSectionItem("Notes", null, 0));
    }

    private static void addItem(SectionItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static SectionItem createSectionItem(String section, Map details, int fragment) {
        return new SectionItem(section, details, fragment);
    }

    public static class SectionItem {
        public String id;
        public Map details;
		public int fragment;

        public SectionItem(String id, Map details, int fragment) {
            this.id = id;
            this.details = details;
			this.fragment = fragment;
        }
        
        @Override
        public String toString() {
            return id;
        }
    }
}
