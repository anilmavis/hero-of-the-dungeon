package org.company;

import org.company.characters.Monster;
import org.company.characters.MonsterInstance;
import org.company.characters.townspeople.Townspeople;
import org.company.items.Item;
import org.company.items.clothing.ClothingInstance;
import org.company.items.weapons.WeaponInstance;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Room {
    private static int lastId = 0;
    private final int id;
    private final String text;
    private final ArrayList<Monster> monsters;
    private final ArrayList<Townspeople> townspeople;
    private final ArrayList<Door> doors;
    private final ArrayList<Item> items;

    public Room(String text, ArrayList<Monster> monsters, ArrayList<Townspeople> townspeople) {
        this.id = lastId++;
        this.text = text;
        this.monsters = monsters;
        this.townspeople = townspeople;
        this.doors = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public int getId() {
        return id;
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

    public void removeMonster(Monster monster) {
        monsters.remove(monster);
    }

    public ArrayList<Townspeople> getTownspeople() {
        return townspeople;
    }

    public void removeTownspeople(Townspeople townspeople) {
        this.townspeople.remove(townspeople);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void display() {
        System.out.printf("%s%nThe hero sees the following.%n", text);

        for (int i = 0; i < doors.size(); i++) {
            System.out.printf((doors.get(i).isStair() ? "stair" : "door") + " (d%d)%n", i + 1);
        }

        for (int i = 0; i < monsters.size(); i++) {
            System.out.printf("%s (m%d)%n", monsters.get(i).getName(), i + 1);
        }

        for (int i = 0; i < townspeople.size(); i++) {
            System.out.printf("%s (t%d)%n", townspeople.get(i).getName(), i + 1);
        }

        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%s (i%d)%n", items.get(i).getName(), i + 1);
        }
    }

    public static ArrayList<Room> generate(SecureRandom secureRandom, int m, int n) {
        final ArrayList<Room> rooms = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                final ArrayList<Monster> monsters = new ArrayList<>();
                final int x = secureRandom.nextInt(9) + 1;

                for (int k = 0; k < x; k++) {
                    monsters.add(MonsterInstance.ape());
                }
                final ArrayList<Townspeople> townspeople = new ArrayList<>();

                for (int k = 0; k < x / 3; k++) {
                    townspeople.add(new Townspeople("townspeople", WeaponInstance.glassShank(), ClothingInstance.shabbyJerkin(), 10, 100));
                }
                final Room room = new Room(new RandomText().next(), monsters, townspeople);
                rooms.add(room);

                for (final Monster monster :
                        room.getMonsters()) {
                    monster.setRoom(room);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                final Room room = rooms.get(i * n + j);
                if (j != 0) {
                    room.addDoor(new Door(rooms.get(room.getId() - 1)));
                }

                if (j != n - 1) {
                    room.addDoor(new Door(rooms.get(room.getId() + 1)));
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (i != m - 1) {
                final int ni1 = secureRandom.nextInt(n);
                final int ni2 = secureRandom.nextInt(n);
                System.out.printf("%d, %d%n", ni1, ni2);
                rooms.get(i * n + ni1).addDoor(new Door(rooms.get((i + 1) * n + ni2)));
                rooms.get((i + 1) * n + ni2).addDoor(new Door(rooms.get(i * n + ni1)));
            }
        }
        lastId = 0;
        return rooms;
    }
}
