package org.company.characters;

import org.company.Door;
import org.company.items.clothing.Clothing;
import org.company.items.weapons.Weapon;

public class Monster extends Character {

    public Monster(String name, Weapon weapon, Clothing clothing, int hitPoints, int inventorySize) {
        super(name, weapon, clothing, hitPoints, inventorySize);
    }

    @Override
    public void move(Door door) {
    }

    @Override
    public void attack(Character character) {
        if (getHitPoints() < 1) {
            setDead(true);
        }
        character.setHitPoints(character.getHitPoints() - getWeapon().getDamage());
        System.out.println("the monster fights back and does " + character.getWeapon().getDamage() + " hit points damage");
    }

    @Override
    public void block() {
    }
}
