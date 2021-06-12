package org.company;

import org.company.characters.Monster;
import org.company.characters.townspeople.Townspeople;
import org.company.items.Item;

import java.util.ArrayList;

public class Room {
    private final int id;
    private final int corridor;
    private final String text;
    private ArrayList<Door> doors;
    private final ArrayList<Monster> monsters;
    private final ArrayList<Townspeople> townspeople;
    private final ArrayList<Item> items;

    public Room(int id, int corridor, String text, ArrayList<Monster> monsters, ArrayList<Townspeople> townspeople) {
        this.id = id;
        this.corridor = corridor;
        this.text = text;
        this.items = new ArrayList<>();
        this.monsters = monsters;
        this.townspeople = townspeople;
    }

    public int getId() {
        return id;
    }

    public int getCorridor() {
        return corridor;
    }

    public String getText() {
        return text;
    }

    public ArrayList<Door> getDoors() {
        return doors;
    }

    public void setDoors(ArrayList<Door> doors) {
        this.doors = doors;
    }

    public void addDoor(Door door) {
        doors.add(door);
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public ArrayList<Townspeople> getTownspeople() {
        return townspeople;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void display() {
        System.out.printf("%s%nThe hero sees the following.%n", text);

        for (int i = 0; i < doors.size(); i++) {
            System.out.printf((doors.get(i).isStair() ? "stair" : "door") + " (d%d)%n", i + 1);
        }

        for (int i = 0; i < monsters.size(); i++) {
            if (!monsters.get(i).isDead()) {
                System.out.printf("monster (m%d)%n", i + 1);
            }
        }

        for (int i = 0; i < townspeople.size(); i++) {
            System.out.printf("townspeople (t%d)%n", i + 1);
        }

        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%s (i%d)%n", items.get(i).getName(), i + 1);
        }
    }
}
