package com.company.characters;

import com.company.Door;
import com.company.items.clothing.Clothing;
import com.company.items.weapons.Weapon;

public class Hero extends Character {
    private int levelId;
    private int roomId;

    public Hero(String name, Weapon weapon, Clothing clothing, int hitPoints) {
        super(name, weapon, clothing, hitPoints);
    }

    public int getLevelId() {
        return levelId;
    }

    public int getRoomId() {
        return roomId;
    }

    @Override
    public void move(Door door) {
        switch (door.getWay()) {
            case "down":
                levelId = levelId - 1;
                break;
            case "up":
                levelId = levelId + 1;
                break;
            default:
                break;
        }
        roomId = door.getReference();
    }

    @Override
    public void attack(Character character) {
        character.setHitPoints(character.getHitPoints() - getWeapon().getDamage());
        character.attack(this);
        System.out.println("the hero causes " + getWeapon().getDamage() + " hit points damage to m1, the monster fights back and does " + character.getWeapon().getDamage() + " hit points damage");
    }

    @Override
    public void block() {
    }

    @Override
    public void display() {
        System.out.println("level " + (levelId + 1) + ", room " + (roomId + 1));
        super.display();
    }
}
