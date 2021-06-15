package org.company;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Level {
    private static int lastId = 0;
    private final int id;
    private final int m;
    private final int n;
    private final ArrayList<Room> rooms;

    public Level(int m, int n) {
        this.id = lastId++;
        this.m = m;
        this.n = n;
        this.rooms = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public static ArrayList<Level> generate() {
        final SecureRandom secureRandom = new SecureRandom();
        ArrayList<Level> levels = new ArrayList<>();

        for (int levelId = 0; levelId < 17; levelId++) {
            final int m = secureRandom.nextInt(4) + 1;
            final int n = secureRandom.nextInt(4) + 1;
            final Level level = new Level(m, n);
            for (final Room room :
                    Room.generate(level, m, n)) {
                level.getRooms().add(room);
            }
            levels.add(level);
        }
        for (int i = 0; i < levels.size(); i++) {
            if (i != levels.size() - 1) {
                final int m1 = levels.get(i).getM();
                final int i1 = secureRandom.nextInt(m1);
                final int n1 = levels.get(i).getN();
                final int j1 = secureRandom.nextInt(n1);
                final int m2 = levels.get(i + 1).getM();
                final int i2 = secureRandom.nextInt(m2);
                final int n2 = levels.get(i + 1).getN();
                final int j2 = secureRandom.nextInt(n2);
                final Level level1 = levels.get(i);
                final Level level2 = levels.get(i + 1);
                final Room room1 = level1.getRooms().get(i1 * n1 + j1);
                final Room room2 = level2.getRooms().get(i2 * n2 + j2);
                room1.addDoor(new Door(room2, level2));
                room2.addDoor(new Door(room1, level1));
            }
        }
        // print(levels);
        return levels;
    }

    public static void print(ArrayList<Level> levels) {
        for (Level level : levels) {
            System.out.println("level " + (level.getId() + 1) + " (" + level.getM() + ", " + level.getN() + ")");

            for (Room room : level.getRooms()) {
                System.out.println("    room " + (room.getId() + 1));
                ArrayList<Door> doors = room.getDoors();

                for (int i = 0; i < doors.size(); i++) {
                    if (!doors.get(i).isStair()) {
                        System.out.printf("        door (d%d), room %d%n", i + 1, doors.get(i).getRoom().getId() + 1);
                    }
                }

                for (int i = 0; i < doors.size(); i++) {
                    if (doors.get(i).isStair()) {
                        System.out.printf("        stair (s%d), level %d%n", i + 1, doors.get(i).getLevel().getId() + 1);
                    }
                }
            }
        }
    }
}
