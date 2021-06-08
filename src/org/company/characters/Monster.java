package com.company.characters;

import com.company.Door;
import com.company.items.clothing.Clothing;
import com.company.items.weapons.Weapon;

public class Monster extends Character {

    public Monster(String name, Weapon weapon, Clothing clothing, int hitPoints) {
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
