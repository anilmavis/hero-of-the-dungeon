package org.company.characters;

import org.company.Inventory;
import org.company.Level;
import org.company.Room;
import org.company.items.Item;
import org.company.items.clothing.Clothing;
import org.company.items.weapons.Weapon;

public abstract class Character {
    private Level level;
    private Room room;
    private int hitPoints;
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

    public boolean takeDamage(int damage) {
        if (hitPoints < 1) {
            return false;
        } else {
            hitPoints -= damage;
            return true;
        }
    }

    public abstract boolean attack(Character character);

    @Override
    public String toString() {
        return String.format("%s, %d hit points, %s, %s", getName(), getHitPoints(), getWeapon().getName(), getClothing().getName());
    }
}
