package org.company.characters;

import org.company.Door;
import org.company.items.clothing.Clothing;
import org.company.items.weapons.Weapon;

public class Townspeople extends Character {
    public Townspeople(String name, Weapon weapon, Clothing clothing, int hitPoints) {
        super(name, weapon, clothing, hitPoints);
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
