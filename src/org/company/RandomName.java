package org.company;

import java.security.SecureRandom;

public class RandomName {
    private String[] names;

    public RandomName() {
        names = new String[] {
                "anıl", "hümay", "özge",
                "melike", "yankı", "dilvin",
                "kaan", "cansu", "haktan",
                "berra", "rüştü", "serhat",
        };
    }

    public String next() {
        return names[new SecureRandom().nextInt(names.length)];
    }
}
