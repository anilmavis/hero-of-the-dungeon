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
    private final ArrayList<Door> doors;
    private final ArrayList<Monster> monsters;
    private final ArrayList<Townspeople> townspeople;
    private final ArrayList<Item> items;

    public Room(String text) {
        this.id = lastId++;
        this.text = text;
        this.doors = new ArrayList<>();
        this.monsters = new ArrayList<>();
        this.townspeople = new ArrayList<>();
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

    public ArrayList<Townspeople> getTownspeople() {
        return townspeople;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s%nThe hero sees the following.%n", text));

        for (int i = 0; i < doors.size(); i++) {
            stringBuilder.append(String.format((doors.get(i).isStair() ? "stair" : "door") + " (d%d)%n", i + 1));
        }

        for (int i = 0; i < monsters.size(); i++) {
            stringBuilder.append(String.format("%s (m%d)%n", monsters.get(i).getName(), i + 1));
        }

        for (int i = 0; i < townspeople.size(); i++) {
            stringBuilder.append(String.format("%s (t%d)%n", townspeople.get(i).getName(), i + 1));
        }

        for (int i = 0; i < items.size(); i++) {
            stringBuilder.append(String.format("%s (i%d)%n", items.get(i).getName(), i + 1));
        }
        return stringBuilder.toString();
    }

    public static ArrayList<Room> generate(Level level, int m, int n) {
        final SecureRandom secureRandom = new SecureRandom();
        final RandomText randomText = new RandomText();
        final RandomName randomName = new RandomName();
        final ArrayList<Room> rooms = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                final Room room = new Room(randomText.next());
                final int x = secureRandom.nextInt(9) + 1;

                for (int k = 0; k < x; k++) {
                    final Monster monster = MonsterInstance.ape();
                    monster.setLevel(level);
                    monster.setRoom(room);
                    room.getMonsters().add(monster);
                }

                for (int k = 0; k < x / 3; k++) {
                    if (secureRandom.nextInt() < 0.5) {
                        room.getTownspeople().add(new Townspeople(randomName.next(), 22, WeaponInstance.glassShank(), ClothingInstance.shabbyJerkin(), new Inventory(), 2));
                    } else {
                        room.getTownspeople().add(new Townspeople(randomName.next(), 22, WeaponInstance.glassShank(), ClothingInstance.shabbyJerkin(), new Inventory(), 1));
                    }
                }
                rooms.add(room);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                final Room room = rooms.get(i * n + j);

                if (j != n - 1) {
                    room.addDoor(new Door(rooms.get(room.getId() + 1)));
                }

                if (j != 0) {
                    room.addDoor(new Door(rooms.get(room.getId() - 1)));
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (i != m - 1) {
                final int ni1 = secureRandom.nextInt(n);
                final int ni2 = secureRandom.nextInt(n);
                Room room1 = rooms.get(i * n + ni1);
                Room room2 = rooms.get((i + 1) * n + ni2);
                room1.addDoor(new Door(room2));
                room2.addDoor(new Door(room1));
            }
        }
        lastId = 0;
        return rooms;
    }
}
