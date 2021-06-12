package org.company;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

public class RandomText {
    public ArrayList<String> texts;

    public RandomText() {
        texts = new ArrayList<>();
        String[] colours = {"red", "green", "blue", "white", "gray", "black", "brown", "purple"};
        String[] adjectives = {"old", "broken", "small", "big"};
        String[] objects = {"mirror", "painting", "chair", "table"};
        String[] animals = {"hedgehog", "rat", "bat", "snake"};

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        texts.add((i % 2 == 0 ? "This room is filled with " : "You see ") + colours[j] + " " + adjectives[k] + " " + objects[l] + ".");
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

        texts.add("There is a foul smell here, but it is too dark to see the source.");
        texts.add("There is a bright light in this horrifying room.");
        texts.add("This room is very dark and you feel that someone is watching you.");
        texts.add("This room is very big. You hear some voices behind you.");
        texts.add("There is nothing in this room.");
        System.out.println(texts);
    }

    public String next(boolean isFirstRoom) {
        if (isFirstRoom) {
            return "This room receives beams of sunlight from the stairs that connect the dungeons to the town.\nactions:\nhelp\nattack <monster number>\nmove <door number>\n.";
        }
        return texts.get(new SecureRandom().nextInt(texts.size()));
    }
    public String next() {
        return next(false);
    }
}
