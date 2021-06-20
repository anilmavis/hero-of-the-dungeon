package org.company;

import org.company.characters.Monster;
import org.company.characters.MonsterInstance;
import org.company.characters.townspeople.Townspeople;
import org.company.characters.townspeople.TownspeopleInstance;
import org.company.doors.Door;
import org.company.items.Item;
import org.company.items.jewelleries.JewelleryInstance;

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

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public ArrayList<Townspeople> getTownspeople() {
        return townspeople;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public static ArrayList<Room> generate(Level level, int m, int n) {
        final ArrayList<Room> rooms = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                final Room room = new Room(Utility.TEXT.random());
                final int x = Utility.SECURE_RANDOM.nextInt(level.getId() + 4) + 1;

                for (int k = 0; k < x; k++) {
                    Monster monster = MonsterInstance.random(level.getId());
                    monster.setLevel(level);
                    monster.setRoom(room);

                    if (Utility.SECURE_RANDOM.nextInt(5) < 1) {
                        monster.getInventory().add(JewelleryInstance.random());
                    }
                    room.getMonsters().add(monster);
                }

                for (int k = 0; k < x / 3; k++) {
                    room.getTownspeople().add(TownspeopleInstance.random());
                }

                if (Utility.SECURE_RANDOM.nextInt(5) < 1) {
                    room.getItems().add(JewelleryInstance.random());
                }
                rooms.add(room);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                final Room room = rooms.get(i * n + j);

                if (j != n - 1) {
                    room.getDoors().add(new Door(rooms.get(room.getId() + 1)));
                }

                if (j != 0) {
                    room.getDoors().add(new Door(rooms.get(room.getId() - 1)));
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (i != m - 1) {
                final int ni1 = Utility.SECURE_RANDOM.nextInt(n);
                final int ni2 = Utility.SECURE_RANDOM.nextInt(n);
                Room room1 = rooms.get(i * n + ni1);
                Room room2 = rooms.get((i + 1) * n + ni2);
                room1.getDoors().add(new Door(room2));
                room2.getDoors().add(new Door(room1));
            }
        }
        lastId = 0;
        return rooms;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s%nThe hero sees the following.%n", text));

        for (int i = 0; i < doors.size(); i++) {
            stringBuilder.append(String.format(doors.get(i).getClass().getSimpleName() + " (d%d)%n", i + 1));
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
}
