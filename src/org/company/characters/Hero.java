package org.company.characters;

import org.company.Door;
import org.company.items.clothing.Clothing;
import org.company.items.weapons.Weapon;

public class Hero extends Character {
    private int levelId;
    private int roomId;

    public Hero(String name, Weapon weapon, Clothing clothing, int hitPoints, int inventorySize) {
        super(name, weapon, clothing, hitPoints, inventorySize);
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
        character.takeDamage(getWeapon().getDamage());
        takeDamage(character.getWeapon().getDamage());
        System.out.println("the hero causes " + getWeapon().getDamage() + " hit points damage to " + character.getName());
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
