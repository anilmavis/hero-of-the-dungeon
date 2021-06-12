package org.company.items.clothing;

public class ClothingInstance {
    public static Clothing[] all() {
        return new Clothing[] {
                shabbyJerkin(), simpleRobe(), silkenVest(),
                strappedLeather(), buckskinTunic(), wildLeather(),
                plateVest(), chestPlate(), copperPlate(),
        };
    }

    public static LightClothing shabbyJerkin() {
        return new LightClothing("shabby jerkin", 100, 0);
    }

    public static LightClothing simpleRobe() {
        return new LightClothing("simple robe", 200, 0);
    }

    public static LightClothing silkenVest() {
        return new LightClothing("silken vest", 300, 0);
    }

    public static LeatherArmour strappedLeather() {
        return new LeatherArmour("strapped leather", 100, 0);
    }

    public static LeatherArmour buckskinTunic() {
        return new LeatherArmour("buckskin tunic", 200, 0);
    }

    public static LeatherArmour wildLeather() {
        return new LeatherArmour("wild leather", 300, 0);
    }

    public static ChainMailArmour plateVest() {
        return new ChainMailArmour("plate vest", 100, 0);
    }

    public static ChainMailArmour chestPlate() {
        return new ChainMailArmour("chest plate", 200, 0);
    }

    public static ChainMailArmour copperPlate() {
        return new ChainMailArmour("copper plate", 300, 0);
    }
}
