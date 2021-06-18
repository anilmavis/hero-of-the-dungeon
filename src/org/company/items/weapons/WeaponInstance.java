package org.company.items.weapons;

import org.company.items.weapons.axes.BroadAxe;
import org.company.items.weapons.axes.MediumAxe;
import org.company.items.weapons.axes.SmallAxe;
import org.company.items.weapons.bows.CompositeBow;
import org.company.items.weapons.bows.LongBow;
import org.company.items.weapons.bows.ShortBow;
import org.company.items.weapons.swords.Dagger;
import org.company.items.weapons.swords.LongSword;
import org.company.items.weapons.swords.ShortSword;

public class WeaponInstance {
    public static Weapon[] all() {
        return new Weapon[] {
                glassShank(), skinningKnife(), stiletto(),
                rustedSword(), copperSword(), sabre(),
                broadSword(), warSword(), ancientSword(),

                rustedHatchet(), jadeHatchet(), boardingAxe(),
                stoneAxe(), jadeChopper(), woodSplitter(),
                poleAxe(), doubleAxe(), gildedAxe(),

                crudeBow(), recurveBow(), boneBow(),
                royalBow(), deathBow(), groveBow(),
                reflexBow(), compoundBow(), sniperBow(),
        };
    }

    public static Dagger glassShank() {
        return new Dagger("glass shank", 100, 1, 1);
    }

    public static Dagger skinningKnife() {
        return new Dagger("skinning knife", 200, 2, 2);
    }

    public static Dagger stiletto() {
        return new Dagger("stiletto", 300, 3, 4);
    }

    public static ShortSword rustedSword() {
        return new ShortSword("rusted sword", 100, 1, 1);
    }

    public static ShortSword copperSword() {
        return new ShortSword("copper sword", 200, 2, 2);
    }

    public static ShortSword sabre() {
        return new ShortSword("sabre", 300, 3, 4);
    }

    public static LongSword broadSword() {
        return new LongSword("broad sword", 100, 1, 1);
    }

    public static LongSword warSword() {
        return new LongSword("war sword", 200, 2, 2);
    }

    public static LongSword ancientSword() {
        return new LongSword("ancient sword", 300, 3, 4);
    }

    public static SmallAxe rustedHatchet() {
        return new SmallAxe("rusted hatchet", 100, 1, 1);
    }

    public static SmallAxe jadeHatchet() {
        return new SmallAxe("jade hatchet", 200, 2, 2);
    }

    public static SmallAxe boardingAxe() {
        return new SmallAxe("boarding axe", 300, 3, 4);
    }

    public static MediumAxe stoneAxe() {
        return new MediumAxe("stone axe", 100, 1, 1);
    }

    public static MediumAxe jadeChopper() {
        return new MediumAxe("jade chopper", 200, 2, 2);
    }

    public static MediumAxe woodSplitter() {
        return new MediumAxe("wood splitter", 300, 3, 4);
    }

    public static BroadAxe poleAxe() {
        return new BroadAxe("pole axe", 100, 1, 1);
    }

    public static BroadAxe doubleAxe() {
        return new BroadAxe("double axe", 200, 2, 2);
    }

    public static BroadAxe gildedAxe() {
        return new BroadAxe("gilded axe", 300, 3, 4);
    }

    public static ShortBow crudeBow() {
        return new ShortBow("crude bow", 100, 1, 1);
    }

    public static ShortBow recurveBow() {
        return new ShortBow("recurve bow", 200, 2, 2);
    }

    public static ShortBow boneBow() {
        return new ShortBow("bone bow", 300, 3, 4);
    }

    public static LongBow royalBow() {
        return new LongBow("royal bow", 100, 1, 1);
    }

    public static LongBow deathBow() {
        return new LongBow("death bow", 200, 2, 2);
    }

    public static LongBow groveBow() {
        return new LongBow("grove bow", 300, 3, 4);
    }

    public static CompositeBow reflexBow() {
        return new CompositeBow("reflex bow", 100, 1, 1);
    }

    public static CompositeBow compoundBow() {
        return new CompositeBow("compound bow", 200, 2, 2);
    }

    public static CompositeBow sniperBow() {
        return new CompositeBow("sniper bow", 300, 3, 4);
    }
}
