package org.company.characters;

import org.company.Inventory;
import org.company.Utility;
import org.company.items.clothing.ClothingInstance;
import org.company.items.weapons.WeaponInstance;

public class MonsterInstance {
    public static Monster[] all() {
        return new Monster[] {
                ape(), bandit(), beast(),
                birdPerson(), blackGuard(), hannibal(),
        };
    }

    public static Monster random(int levelId) {
        Monster[] possibleMonsters;
        if (levelId < 4) {
            possibleMonsters = new Monster[] {ape(), bandit(), beast()};
        } else if (levelId < 8) {
            possibleMonsters = new Monster[] {bandit(), beast(), birdPerson()};
        } else if (levelId < 12) {
            possibleMonsters = new Monster[] {beast(), birdPerson(), blackGuard()};
        } else if (levelId < 16) {
            possibleMonsters = new Monster[] {birdPerson(), blackGuard(), hannibal()};
        } else {
            possibleMonsters = all();
        }
        return possibleMonsters[Utility.SECURE_RANDOM.nextInt(possibleMonsters.length)];
    }

    public static Monster ape() {
        return new Monster("ape", 1, WeaponInstance.glassShank(), ClothingInstance.shabbyJerkin(), new Inventory());
    }

    public static Monster bandit() {
        return new Monster("bandit", 2, WeaponInstance.skinningKnife(), ClothingInstance.simpleRobe(), new Inventory());
    }

    public static Monster beast() {
        return new Monster("beast", 3, WeaponInstance.stiletto(), ClothingInstance.silkenVest(), new Inventory());
    }

    public static Monster birdPerson() {
        return new Monster("bird person", 8, WeaponInstance.rustedSword(), ClothingInstance.strappedLeather(), new Inventory());
    }

    public static Monster blackGuard() {
        return new Monster("black guard", 16, WeaponInstance.copperSword(), ClothingInstance.buckskinTunic(), new Inventory());
    }

    public static Monster hannibal() {
        return new Monster("hannibal", 32, WeaponInstance.sabre(), ClothingInstance.wildLeather(), new Inventory());
    }
}
