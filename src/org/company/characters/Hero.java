package org.company.characters;

import org.company.Door;
import org.company.Level;
import org.company.Room;
import org.company.items.clothing.Clothing;
import org.company.items.weapons.Weapon;

import java.security.SecureRandom;

public class Hero extends Character {
    private String gender;
    private int age;
    private Room room;
    private Level level;
    private int score;

    public Hero(String name, String gender, int age, Weapon weapon, Clothing clothing, int hitPoints, int inventorySize, Room room, Level level, int score) {
        super(name, weapon, clothing, hitPoints, inventorySize);
        this.gender = gender;
        setAge(age);
        this.room = room;
        this.level = level;
        this.score = score;
    }

    public Hero(String name, String gender, int age, Weapon weapon, Clothing clothing, int hitPoints, Room room, Level level) {
        super(name, weapon, clothing, hitPoints);
        this.gender = gender;
        setAge(age);
        this.room = room;
        this.level = level;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
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
            level = door.getLevel();
        }
        room = door.getRoom();
    }

    @Override
    public void attack(Character character) {
        final SecureRandom secureRandom = new SecureRandom();
        final int damage = secureRandom.nextInt(getWeapon().getDamage() + 1) * getWeapon().getRange();
        final int characterDamage = secureRandom.nextInt(character.getWeapon().getDamage() + 1) * character.getWeapon().getRange();

        if (character.takeDamage(damage)) {
            takeDamage(characterDamage);
        }
        System.out.printf("%s causes %d damage to %s, it fights back and does %d damage%n", getName(), damage, character.getName(), characterDamage);
    }

    @Override
    public void block() {
        System.out.printf("%s blocks%n", getName());
    }

    @Override
    public void display() {
        System.out.printf("level %d, room %d%n", level.getId() + 1, room.getId() + 1);
        super.display();
    }
}
