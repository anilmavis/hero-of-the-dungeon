package org.company.items.weapons.swords;

import org.company.items.weapons.Weapon;

public abstract class Sword extends Weapon {
    public Sword(String name, int weight, int value, int damage, int range) {
        super(name, weight, value, damage, range);
    }
}
