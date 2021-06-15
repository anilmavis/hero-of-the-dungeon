package org.company.characters;

import org.company.Door;
import org.company.Inventory;
import org.company.interfaces.Movable;
import org.company.items.clothing.Clothing;
import org.company.items.weapons.Weapon;

import java.security.SecureRandom;

public class Hero extends Character implements Movable {
    private final String gender;
    private final int age;
    private int score;

    public Hero(String name, int hitPoints, String gender, int age, Weapon weapon, Clothing clothing, Inventory inventory) {
        super(name, hitPoints, weapon, clothing, inventory);
        this.gender = gender;
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void move(Door door) {
        if (door.isStair()) {
            setLevel(door.getLevel());
        }
        setRoom(door.getRoom());
    }

    @Override
    public boolean attack(Character character) {
        final SecureRandom secureRandom = new SecureRandom();
        final int damage = secureRandom.nextInt(getWeapon().getDamage() + 1) * getWeapon().getRange();
        final int characterDamage = secureRandom.nextInt(character.getWeapon().getDamage() + 1) * character.getWeapon().getRange();

        if (character.takeDamage(damage)) {
            takeDamage(characterDamage);
            System.out.printf("%s causes %d damage to %s, it fights back and does %d damage%n", getName(), damage, character.getName(), characterDamage);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Level %d, Room %d%n%s", getLevel().getId() + 1, getRoom().getId() + 1, super.toString());
    }
}
