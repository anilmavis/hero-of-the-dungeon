package org.company;

import java.util.ArrayList;

public class Text {
    public final ArrayList<String> texts;

    public Text() {
        texts = new ArrayList<>();
        String[] colours = {"red", "green", "blue", "white", "gray", "black", "brown", "purple"};
        String[] adjectives = {"old", "broken", "small", "big"};
        String[] objects = {"mirror", "painting", "chair", "table"};
        String[] animals = {"hedgehog", "rat", "bat", "snake"};

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        texts.add((i % 2 == 0 ? "This room is filled with " : "You see ") + colours[j] + " " + adjectives[k] + " " + objects[l] + "s.");
                    }
                }
            }
        }

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    texts.add("Be careful about " + colours[j] + " " + animals[k] + "s.");
                }
            }
        }
    }

    public String random() {
        return texts.get(Utility.SECURE_RANDOM.nextInt(texts.size()));
    }
}
