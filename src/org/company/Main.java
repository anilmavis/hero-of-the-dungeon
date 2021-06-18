package org.company;

import org.company.characters.Hero;
import org.company.highScores.HighScore;
import org.company.items.clothing.Clothing;
import org.company.items.clothing.ClothingInstance;
import org.company.items.weapons.Weapon;
import org.company.items.weapons.WeaponInstance;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        HighScore.read();
        System.out.println("name:");
        final String name = Utility.SCANNER.nextLine();
        System.out.println("gender:");
        final String gender = Utility.SCANNER.nextLine();
        System.out.println("age:");
        int age = Utility.SCANNER.nextInt();

        while (age < 0) {
            System.out.println("age is lesser than 0");
            age = Utility.SCANNER.nextInt();
        }
        System.out.println("class:\n1. rogue: glass shank and shabby jerkin\n2. warrior: rusted hatchet and shabby jerkin\n3. archer: crude bow and shabby jerkin");
        Weapon weapon = WeaponInstance.glassShank();
        Clothing clothing = ClothingInstance.shabbyJerkin();

        switch (Utility.SCANNER.nextInt()) {
            case 2:
                weapon = WeaponInstance.rustedHatchet();
                clothing = ClothingInstance.shabbyJerkin();
                System.out.printf("%s is a warrior%n", name);
                break;
            case 3:
                weapon = WeaponInstance.recurveBow();
                clothing = ClothingInstance.shabbyJerkin();
                System.out.printf("%s is an archer%n", name);
                break;
            default:
                System.out.printf("%s is a rogue%n", name);
                break;
        }
        Utility.SCANNER.nextLine();
        final ArrayList<Level> levels = Level.generate();
        final Level level1 = levels.get(0);
        final Hero hero = new Hero(name, 22, gender, age, weapon, clothing, new Inventory());
        hero.setLevel(level1);
        hero.setRoom(level1.getRooms().get(0));

        do {
            System.out.printf("level %d, room %d%n", hero.getLevel().getId() + 1, hero.getRoom().getId() + 1);
            System.out.println(hero);
            System.out.print(hero.getRoom());
        } while (Action.handle(hero) && !hero.isDead());
        Utility.SCANNER.close();
        HighScore.write(hero);
        HighScore.read();
    }
}
