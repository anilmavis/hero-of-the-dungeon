package org.company.characters;

import org.company.items.clothing.ClothingInstance;
import org.company.items.weapons.WeaponInstance;

public class MonsterInstance {
    public static Monster[] all() {
        return new Monster[] {
                ape(), bandit(), beast(),
                birdPerson(), blackGuard(), hannibal(),
        };
    }

    public static Monster ape() {
        return new Monster("ape", WeaponInstance.glassShank(), ClothingInstance.shabbyJerkin(), 1);
    }

    public static Monster bandit() {
        return new Monster("bandit", WeaponInstance.skinningKnife(), ClothingInstance.simpleRobe(), 2);
    }

    public static Monster beast() {
        return new Monster("beast", WeaponInstance.stiletto(), ClothingInstance.silkenVest(), 3);
    }

    public static Monster birdPerson() {
        return new Monster("bird person", WeaponInstance.rustedSword(), ClothingInstance.strappedLeather(), 4);
    }

    public static Monster blackGuard() {
        return new Monster("black guard", WeaponInstance.copperSword(), ClothingInstance.buckskinTunic(), 5);
    }

    public static Monster hannibal() {
        return new Monster("hannibal", WeaponInstance.sabre(), ClothingInstance.wildLeather(), 6);
    }
}
