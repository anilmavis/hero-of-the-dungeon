package org.company.characters;

import org.company.Inventory;
import org.company.Level;
import org.company.Room;
import org.company.items.Item;
import org.company.items.clothing.Clothing;
import org.company.items.weapons.Weapon;

public class Monster extends Character {
    public Monster(String name, int hitPoints, Weapon weapon, Clothing clothing, Inventory inventory) {
        super(name, hitPoints, weapon, clothing, inventory);
    }

    public void die() {
        getRoom().getMonsters().remove(this);
        getRoom().getItems().add(getClothing());
        setClothing(null);
        getRoom().getItems().add(getWeapon());
        setWeapon(null);

        for (final Item item :
                getInventory().getItems()) {
            getInventory().drop(item, getRoom());
        }
    }

    @Override
    public boolean attack(Character character) {
        return true;
    }
}
