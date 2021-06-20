package org.company;

import java.util.ArrayList;

public class Text {
    private final ArrayList<String> texts;

    public Text() {
        texts = new ArrayList<>();
        String[] colours = {"red", "green", "blue", "white", "gray", "black", "brown", "purple"};
        String[] adjectives = {"old", "broken", "small", "big"};
        String[] objects = {"mirror", "painting", "chair", "table"};
        String[] animals = {"hedgehog", "rat", "bat", "snake"};

        for (int i = 0; i < colours.length; i++) {
            for (int j = 0; j < adjectives.length; j++) {
                for (int k = 0; k < objects.length; k++) {
                    texts.add((Utility.SECURE_RANDOM.nextInt(2) < 1 ? "This room is filled with " : "You see ") + colours[i] + " " + adjectives[j] + " " + objects[k] + "s.");
                }
            }
        }

        for (int i = 0; i < colours.length; i++) {
            for (int j = 0; j < animals.length; j++) {
                texts.add("Be careful about " + colours[i] + " " + animals[j] + "s.");
            }
        }
        // System.out.println(texts.size() + "\n" + texts);
    }

    public String random() {
        return texts.get(Utility.SECURE_RANDOM.nextInt(texts.size()));
    }
}
