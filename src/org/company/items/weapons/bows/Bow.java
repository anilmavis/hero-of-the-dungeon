package com.company.items.weapons.bows;

import com.company.items.weapons.Weapon;

public abstract class Bow extends Weapon {
    public Bow(String name, int weight, int value, int damage, int range) {
        super(name, weight, value, damage, range);
    }
}
