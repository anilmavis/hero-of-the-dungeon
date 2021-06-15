package org.company.characters;

import org.company.Door;
import org.company.Inventory;
import org.company.characters.townspeople.Healer;
import org.company.characters.townspeople.Townspeople;
import org.company.interfaces.Fightable;
import org.company.interfaces.Movable;
import org.company.items.clothing.Clothing;
import org.company.items.weapons.Weapon;

import java.security.SecureRandom;

public class Hero extends Character implements Movable, Fightable {
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
    public void attack(Character character) {
        final SecureRandom secureRandom = new SecureRandom();
        final int heroDamage = secureRandom.nextInt(getWeapon().getDamage() + 1) * getWeapon().getRange();
        final int characterDamage = secureRandom.nextInt(character.getWeapon().getDamage() + 1) * character.getWeapon().getRange();
        System.out.printf("%s causes %d damage to %s%n", getName(), heroDamage, character.getName());
        character.setHitPoints(character.getHitPoints() - heroDamage);

        if (character.getHitPoints() < 1) {
            character.die();
        } else {
            System.out.printf("it fights back and does %d damage%n", characterDamage);
            setHitPoints(getHitPoints() - characterDamage);

            if (getHitPoints() < 1) {
                die();
            }
        }
    }

    @Override
    public void block() {}

    public void rescue(Character character) {
        if (character instanceof Townspeople) {
            score += ((Townspeople) character).getScore();
        }
        if (character instanceof Healer) {
            setHitPoints(getHitPoints() + ((Healer) character).getHealAmount());
        }
    }

    @Override
    public String toString() {
        return String.format("level %d, room %d%n%s", getLevel().getId() + 1, getRoom().getId() + 1, super.toString());
    }
}
