package org.company;

import org.company.items.Item;

import java.util.ArrayList;

public class Inventory {
    private final int maxWeight;
    private int weight;
    private int value;
    private final ArrayList<Item> items;

    public Inventory(int maxWeight) {
        this.maxWeight = maxWeight;
        items = new ArrayList<>();
    }

    public Inventory() {
        this(1000);
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public boolean add(Item item) {
        if (item.getWeight() + weight > maxWeight) {
            System.out.println("inventory is full");
            return false;
        }
        items.add(item);
        weight += item.getWeight();
        value += item.getValue();
        return true;
    }

    public void remove(Item item) {
        items.remove(item);
        weight -= item.getWeight();
        value -= item.getValue();
    }

    public void drop(Item item, Room room) {
        remove(item);
        room.getItems().add(item);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Inventory (%d/%d g)%n", weight, maxWeight));

        for (int i = 0; i < items.size(); i++) {
            stringBuilder.append(String.format("%s (i%d)", items.get(i), i + 1));

            if (i != items.size() - 1) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
