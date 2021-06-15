package org.company.characters.townspeople;

import org.company.Inventory;
import org.company.characters.Character;
import org.company.items.clothing.Clothing;
import org.company.items.weapons.Weapon;

public class Townspeople extends Character {
    public Townspeople(String name, int hitPoints, Weapon weapon, Clothing clothing, Inventory inventory) {
        super(name, hitPoints, weapon, clothing, inventory);
    }

    @Override
    public boolean attack(Character character) {
        return true;
    }
}
