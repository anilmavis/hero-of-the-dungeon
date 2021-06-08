package org.company;

import org.company.items.Item;

import java.util.ArrayList;

public class Inventory {
    private final int size;
    private final ArrayList<Item> items;

    public Inventory(int size) {
        this.size = size;
        items = new ArrayList<>();
    }

    public int getSize() {
        return size;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void dropItem(Item item, Room room) {
        room.getItems().add(item);
    }
}
