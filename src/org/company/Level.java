package org.company;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Level {
    private static int lastId = 0;
    private final int id;
    private final int m;
    private final int n;
    private final ArrayList<Room> rooms;

    public Level(int m, int n, ArrayList<Room> rooms) {
        this.id = lastId++;
        this.m = m;
        this.n = n;
        this.rooms = rooms;
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

    public static ArrayList<Level> generate(SecureRandom secureRandom) {
        ArrayList<Level> levels = new ArrayList<>();

        for (int i = 0; i < 17; i++) {
            int m = secureRandom.nextInt(4) + 1;
            int n = secureRandom.nextInt(4) + 1;
            levels.add(new Level(m, n, Room.generate(secureRandom, m, n)));
        }
        for (int i = 0; i < levels.size(); i++) {
            if (i != levels.size() - 1) {
                int m1 = levels.get(i).getM();
                int i1 = secureRandom.nextInt(m1);
                int n1 = levels.get(i).getN();
                int j1 = secureRandom.nextInt(n1);
                int m2 = levels.get(i + 1).getM();
                int i2 = secureRandom.nextInt(m2);
                int n2 = levels.get(i + 1).getN();
                int j2 = secureRandom.nextInt(n2);
                levels.get(i).getRooms().get(i1 * n1 + j1).addDoor(new Door(levels.get(i + 1).getRooms().get(i2 * n2 + j2), levels.get(i + 1)));
                levels.get(i + 1).getRooms().get(i2 * n2 + j2).addDoor(new Door(levels.get(i).getRooms().get(i1 * n1 + j1), levels.get(i)));
            }
        }
        print(levels);
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
