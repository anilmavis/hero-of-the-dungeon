package org.company.characters;

import org.company.Inventory;
import org.company.interfaces.Fightable;
import org.company.items.clothing.Clothing;
import org.company.items.weapons.Weapon;

public class Monster extends Character implements Fightable {
    public Monster(String name, int hitPoints, Weapon weapon, Clothing clothing, Inventory inventory) {
        super(name, hitPoints, weapon, clothing, inventory);
    }

    @Override
    public void attack(Character character) {
    }

    @Override
    public boolean block() {
        return false;
    }
}
