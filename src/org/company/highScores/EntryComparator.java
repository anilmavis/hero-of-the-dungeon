package org.company.highScores;

import java.util.Comparator;

public class EntryComparator implements Comparator<Entry> {
    @Override
    public int compare(Entry entry1, Entry entry2) {
        return Integer.compare(entry2.getScore(), entry1.getScore());
    }
}
