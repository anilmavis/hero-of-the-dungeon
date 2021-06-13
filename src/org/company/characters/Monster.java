package org.company.characters;

import org.company.Door;
import org.company.Level;
import org.company.Room;
import org.company.items.Item;
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
    public void die() {
        super.die();
        room.removeMonster(this);
        room.addItem(getClothing());
        setClothing(null);
        room.addItem(getWeapon());
        setWeapon(null);

        for (final Item item :
                getInventory().getItems()) {
            getInventory().dropItem(item, room);
        }
    }

    @Override
    public void move(Door door) {
    }

    @Override
    public boolean attack(Character character) {
        return true;
    }

    @Override
    public void block() {
    }
}
