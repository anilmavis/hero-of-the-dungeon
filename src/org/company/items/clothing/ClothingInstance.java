package com.company.items.clothing;

public class ClothingInstance {
    public static Clothing[] all() {
        return new Clothing[] {
                shabbyJerkin(), simpleRobe(), silkenVest(),
                strappedLeather(), buckskinTunic(), wildLeather(),
                plateVest(), chestPlate(), copperPlate(),
        };
    }

    public static LightClothing shabbyJerkin() {
        return new LightClothing("shabby jerkin", 0, 0);
    }

    public static LightClothing simpleRobe() {
        return new LightClothing("simple robe", 1, 0);
    }

    public static LightClothing silkenVest() {
        return new LightClothing("silken vest", 1, 0);
    }

    public static LeatherArmour strappedLeather() {
        return new LeatherArmour("strapped leather", 1, 0);
    }

    public static LeatherArmour buckskinTunic() {
        return new LeatherArmour("buckskin tunic", 1, 0);
    }

    public static LeatherArmour wildLeather() {
        return new LeatherArmour("wild leather", 1, 0);
    }

    public static ChainMailArmour plateVest() {
        return new ChainMailArmour("plate vest", 1, 0);
    }

    public static ChainMailArmour chestPlate() {
        return new ChainMailArmour("chest plate", 1, 0);
    }

    public static ChainMailArmour copperPlate() {
        return new ChainMailArmour("copper plate", 1, 0);
    }
}
