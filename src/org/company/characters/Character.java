package org.company.characters;

import org.company.Inventory;
import org.company.Level;
import org.company.Room;
import org.company.characters.townspeople.Townspeople;
import org.company.items.Item;
import org.company.items.clothing.Clothing;
import org.company.items.weapons.Weapon;

import java.util.ArrayList;

public abstract class Character {
    private Level level;
    private Room room;
    private int hitPoints;
    private boolean isDead;
    private final String name;
    private Weapon weapon;
    private Clothing clothing;
    private final Inventory inventory;

    public Character(String name, int hitPoints, Weapon weapon, Clothing clothing, Inventory inventory) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.weapon = weapon;
        this.clothing = clothing;
        this.inventory = inventory;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Clothing getClothing() {
        return clothing;
    }

    public void setClothing(Clothing clothing) {
        this.clothing = clothing;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void equip(Item item) {
        inventory.remove(item);
        inventory.setWeight(inventory.getWeight() - item.getWeight());

        if (item instanceof Weapon) {
            inventory.add(weapon);
            inventory.setWeight(inventory.getWeight() + weapon.getWeight());
            weapon = (Weapon) item;
        } else if (item instanceof Clothing) {
            inventory.add(clothing);
            inventory.setWeight(inventory.getWeight() + clothing.getWeight());
            clothing = (Clothing) item;
        }
    }

    public void die() {
        System.out.printf("%s dies%n", name);;
        isDead = true;
        if (this instanceof Monster) {
            room.getMonsters().remove(this);
        } else if (this instanceof Townspeople) {
            room.getTownspeople().remove(this);
        }
        room.getItems().add(clothing);
        clothing = null;
        room.getItems().add(weapon);
        weapon = null;

        for (final Item item :
                inventory.getItems()) {
            inventory.drop(item, room);
        }
    }

    @Override
    public String toString() {
        return String.format("%s, %d hit points, %s, %s", getName(), getHitPoints(), getWeapon().getName(), getClothing().getName());
    }
}
