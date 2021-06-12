package org.company.characters.townspeople;

import org.company.items.clothing.Clothing;
import org.company.items.weapons.Weapon;

public class Healer extends Townspeople {
    private final int healAmount;

    public Healer(String name, Weapon weapon, Clothing clothing, int hitPoints, int inventorySize, int healAmount) {
        super(name, weapon, clothing, hitPoints, inventorySize);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }
}
