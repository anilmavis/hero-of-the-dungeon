package org.company.characters.townspeople;

import org.company.Door;
import org.company.characters.Character;
import org.company.items.clothing.Clothing;
import org.company.items.weapons.Weapon;

public class Townspeople extends Character {
    public Townspeople(String name, Weapon weapon, Clothing clothing, int hitPoints, int inventorySize) {
        super(name, weapon, clothing, hitPoints, inventorySize);
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
