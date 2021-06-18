package org.company.doors;

import org.company.Level;
import org.company.Room;

public class Stair extends Door {
    private final Level level;

    public Stair(Room room, Level level) {
        super(room);
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return String.format("%s (level %s)", getClass().getSimpleName(), level.getId() + 1);
    }
}
