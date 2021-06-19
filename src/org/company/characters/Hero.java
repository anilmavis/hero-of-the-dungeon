package org.company.characters;

import org.company.Utility;
import org.company.doors.Door;
import org.company.Inventory;
import org.company.characters.townspeople.Healer;
import org.company.characters.townspeople.Townspeople;
import org.company.doors.Stair;
import org.company.interfaces.Fightable;
import org.company.interfaces.Movable;
import org.company.items.clothing.ChainMailArmour;
import org.company.items.clothing.Clothing;
import org.company.items.weapons.Weapon;

public class Hero extends Character implements Movable, Fightable {
    private final String gender;
    private final int age;
    private int rescueScore;

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

    public int getRescueScore() {
        return rescueScore;
    }

    public void setRescueScore(int rescueScore) {
        this.rescueScore = rescueScore;
    }

    @Override
    public void move(Door door) {
        if (door instanceof Stair) {
            setLevel(((Stair) door).getLevel());
        }
        setRoom(door.getRoom());
    }

    @Override
    public void attack(Character character) {
        int damage = Utility.SECURE_RANDOM.nextInt((getWeapon().getDamage() * 2 + getWeapon().getRange()));
        final int protection = character.getClothing().getProtection();

        if (damage <= protection) {
            damage = 1;
        } else {
            damage -= protection;
        }
        System.out.printf("%s causes %d damage to %s%n", getName(), damage, character.getName());
        character.setHitPoints(character.getHitPoints() - damage);

        if (character.getHitPoints() < 1) {
            character.die();
        } else {
            if (block()) {
                System.out.printf("%s blocked the incoming attack%n", getName());
            } else {
                if (character instanceof Monster) {
                    ((Monster) character).attack(this);

                    if (getHitPoints() < 1) {
                        die();
                    }
                }
            }
        }
    }

    @Override
    public boolean block() {
        int blockChance = 8;

        if (getClothing() instanceof ChainMailArmour) {
            blockChance /= 2;
        }
        return Utility.SECURE_RANDOM.nextInt(blockChance) < 1;
    }

    public void rescue(Character character) {
        if (character instanceof Townspeople) {
            rescueScore += ((Townspeople) character).getScore();

            if (character instanceof Healer) {
                setHitPoints(getHitPoints() + ((Healer) character).getHealAmount());
            }
            getRoom().getTownspeople().remove(character);
        }
    }

    @Override
    public String toString() {
        return String.format("%s, %s score", super.toString(), rescueScore + getInventory().getValue());
    }
}
