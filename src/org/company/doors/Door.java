package org.company.doors;

import org.company.Room;

public class Door {
    private final Room room;

    public Door(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }
}
