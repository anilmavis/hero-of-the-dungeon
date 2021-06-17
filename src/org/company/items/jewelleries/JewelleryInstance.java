package org.company.items.jewelleries;

import org.company.Utility;

public class JewelleryInstance {
    public static Jewellery[] all() {
        return new Jewellery[] {
                ruby(), emerald(), silver(),
        };
    }

    public static Jewellery random() {
        return all()[Utility.SECURE_RANDOM.nextInt(all().length)];
    }

    public static Jewellery ruby() {
        return new Jewellery("ruby", 10, 10);
    }

    public static Jewellery emerald() {
        return new Jewellery("emerald", 20, 20);
    }

    public static Jewellery silver() {
        return new Jewellery("silver", 30, 30);
    }
}
