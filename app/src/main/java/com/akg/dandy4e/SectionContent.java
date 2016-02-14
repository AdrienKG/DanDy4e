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
        addItem(createSectionItem("Details", null));
        addItem(createSectionItem("Abilities", null));
        addItem(createSectionItem("Attack", null));
        addItem(createSectionItem("Health", null));
        addItem(createSectionItem("Powers", null));
        addItem(createSectionItem("Skills", null));
        addItem(createSectionItem("Feats", null));
        addItem(createSectionItem("Equipment", null));
        addItem(createSectionItem("Rituals", null));
        addItem(createSectionItem("Notes", null));
    }

    private static void addItem(SectionItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static SectionItem createSectionItem(String section, Map details) {
        return new SectionItem(section, details);
    }

    public static class SectionItem {
        public String id;
        public Map details;

        public SectionItem(String id, Map details) {
            this.id = id;
            this.details = details;
        }
        
        @Override
        public String toString() {
            return id;
        }
    }
}
