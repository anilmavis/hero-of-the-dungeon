package org.company.characters;

import org.company.Door;
import org.company.Level;
import org.company.Room;
import org.company.items.clothing.Clothing;
import org.company.items.weapons.Weapon;

public class Monster extends Character {
    private Room room;
    private Level level;

    public Monster(String name, Weapon weapon, Clothing clothing, int hitPoints) {
        super(name, weapon, clothing, hitPoints);
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public void move(Door door) {
    }

    @Override
    public void attack(Character character) {
    }

    @Override
    public void block() {
    }
}
