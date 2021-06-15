package org.company.characters.townspeople;

import org.company.Inventory;
import org.company.characters.Character;
import org.company.items.clothing.Clothing;
import org.company.items.weapons.Weapon;

public class Townspeople extends Character {
    private final int score;

    public Townspeople(String name, int hitPoints, Weapon weapon, Clothing clothing, Inventory inventory, int score) {
        super(name, hitPoints, weapon, clothing, inventory);
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
