package org.company.characters;

import org.company.Inventory;
import org.company.Utility;
import org.company.interfaces.Fightable;
import org.company.items.clothing.ChainMailArmour;
import org.company.items.clothing.Clothing;
import org.company.items.weapons.Weapon;

public class Monster extends Character implements Fightable {
    public Monster(String name, int hitPoints, Weapon weapon, Clothing clothing, Inventory inventory) {
        super(name, hitPoints, weapon, clothing, inventory);
    }

    @Override
    public void attack(Character character) {
        int damage = Utility.SECURE_RANDOM.nextInt(getWeapon().getDamage() * 2 + getWeapon().getRange());
        final int protection = character.getClothing().getProtection();

        if (damage <= protection) {
            damage = 1;
        } else {
            damage -= protection;
        }
        System.out.printf("%s fights back and does %d damage%n", getName(), damage);
        character.setHitPoints(character.getHitPoints() - damage);
    }

    @Override
    public boolean block() {
        int blockChance = 16;

        if (getClothing() instanceof ChainMailArmour) {
            blockChance /= 2;
        }
        return Utility.SECURE_RANDOM.nextInt(blockChance) < 1;
    }
}
