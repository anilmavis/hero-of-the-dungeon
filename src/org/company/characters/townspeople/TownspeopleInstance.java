package org.company.characters.townspeople;

import org.company.Inventory;
import org.company.Utility;
import org.company.items.clothing.ClothingInstance;
import org.company.items.weapons.WeaponInstance;

public class TownspeopleInstance {
    public static Townspeople[] all() {
        return new Townspeople[] {townspeople(), healer(),};
    }

    public static Townspeople random() {
        Townspeople[] townspeople = all();
        return townspeople[Utility.SECURE_RANDOM.nextInt(townspeople.length)];
    }

    public static Townspeople townspeople() {
        return new Townspeople("townspeople", 1, WeaponInstance.glassShank(), ClothingInstance.shabbyJerkin(), new Inventory(), 2);
    }

    public static Healer healer() {
        return new Healer("healer", 1, null, null, new Inventory(), 1, 1);
    }
}
