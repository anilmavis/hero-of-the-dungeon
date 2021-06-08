package org.company;

import java.security.SecureRandom;
import java.util.ArrayList;

public class RandomText {
    public ArrayList<String> texts;

    public RandomText() {
        texts = new ArrayList<>();
        ArrayList<String> objects = new ArrayList<>();
        objects.add("spike");
        objects.add("spider web");
        objects.add("rat");
        objects.add("rock");
        objects.add("corpse");

        for (int i = 0; i < 5; i++) {
            texts.add("This room is filled with " + (i % 2 == 0 ? "big " : "small ") + objects.get(i) + "s.");
        }

        for (int i = 0; i < 5; i++) {
            texts.add("you see a " + (i % 2 == 0 ? "large " : "tiny ") + objects.get(i) + ".");
        }

        for (int i = 0; i < 5; i++) {
            texts.add("be careful about " + objects.get(i) + "s.");
        }

        for (int i = 0; i < 5; i++) {
            texts.add("there are lots of " + objects.get(i) + "s.");
        }

        for (int i = 0; i < 5; i++) {
            texts.add("you see a " + (i % 2 == 0 ? "horrifying " : "terrible ") + objects.get(i) + ".");
        }

        texts.add("there is a foul smell here, but it is too dark to see the source.");
        texts.add("there is a bright light in this horrifying room.");
        texts.add("this room is very dark and you feel that someone is watching you.");
        texts.add("this room is very big. You hear some voices behind you.");
        texts.add("there is nothing in this room.");
    }

    public String get(boolean isFirstRoom) {
        SecureRandom secureRandom = new SecureRandom();
        if (isFirstRoom) {
            return "This room receives beams of sunlight from the stairs that connect the dungeons to the town.";
        }
        return texts.get(secureRandom.nextInt(texts.size()));
    }
    public String get() {
        return get(false);
    }
}
