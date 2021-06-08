package org.company;

import org.company.characters.Monster;
import org.company.characters.Townspeople;
import org.company.items.Item;

import java.util.ArrayList;

public class Room {
    private final int id;
    private final int corridor;
    private final String text;
    private final ArrayList<Door> doors;
    private final ArrayList<Monster> monsters;
    private final ArrayList<Townspeople> townspeople;
    private final ArrayList<Item> items;

    public Room(int id, int corridor, String text, ArrayList<Door> doors, ArrayList<Monster> monsters, ArrayList<Townspeople> townspeople) {
        this.id = id;
        this.corridor = corridor;
        this.text = text;
        this.doors = doors;
        this.monsters = monsters;
        this.townspeople = townspeople;
        this.items = new ArrayList<>();
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
        System.out.println(text + "\nthe hero sees the following");

        for (int i = 0; i < doors.size(); i++) {
            System.out.println(doors.get(i).isStair() ? "stair (" + doors.get(i).getWay() : "door (" + (i + 1) + ")");
        }

        for (int i = 0; i < monsters.size(); i++) {
            if (!monsters.get(i).isDead()) {
                System.out.println("monster (m" + (i + 1) + ")");
            }
        }

        for (int i = 1; i <= townspeople.size(); i++) {
            System.out.println(i + " townspeople (t" + i + ")");
        }
    }
}
