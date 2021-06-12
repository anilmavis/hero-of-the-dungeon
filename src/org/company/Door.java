package org.company;

public class Door {
    private final Room room;
    private final Level level;
    private final boolean isStair;

    public Door(Room room, Level level) {
        this.room = room;
        this.level = level;
        isStair = level != null;
    }

    public Door(Room room) {
        this(room, null);
    }

    public Room getRoom() {
        return room;
    }

    public Level getLevel() {
        return level;
    }

    public boolean isStair() {
        return isStair;
    }
}
