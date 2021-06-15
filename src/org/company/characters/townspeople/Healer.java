package org.company.characters.townspeople;

import org.company.Inventory;
import org.company.items.clothing.Clothing;
import org.company.items.weapons.Weapon;

public class Healer extends Townspeople {
    private final int healAmount;

    public Healer(String name, int hitPoints, Weapon weapon, Clothing clothing, Inventory inventory, int score, int healAmount) {
        super(name, hitPoints, weapon, clothing, inventory, score);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }
}
