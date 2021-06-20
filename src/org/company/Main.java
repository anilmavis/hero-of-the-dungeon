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
        System.out.println("Welcome to the game!\nname:");
        final String name = Utility.SCANNER.nextLine();
        System.out.println("gender: (male, female, etc.)");
        final String gender = Utility.SCANNER.nextLine();
        System.out.println("age:");
        int age;

        // We did not catch the exceptions as we could avoid from them easily, thanks to the hasNextInt method. The exception handling exists in the Action class.
        while (true) {
            if (Utility.SCANNER.hasNextInt()) {
                age = Utility.SCANNER.nextInt();

                if (age < 0) {
                    System.out.println("age must be equal to or greater than 0");
                    Utility.SCANNER.nextLine();
                } else {
                    Utility.SCANNER.nextLine();
                    break;
                }
            } else {
                System.out.println("age must be integer");
                Utility.SCANNER.nextLine();
            }
        }
        System.out.println("class:\n1. rogue: glass shank and shabby jerkin\n2. warrior: rusted hatchet and shabby jerkin\n3. archer: crude bow and shabby jerkin");
        Weapon weapon = WeaponInstance.glassShank();
        Clothing clothing = ClothingInstance.shabbyJerkin();

        while (true) {
            if (Utility.SCANNER.hasNextInt()) {
                switch (Utility.SCANNER.nextInt()) {
                    case 2:
                        weapon = WeaponInstance.rustedHatchet();
                        clothing = ClothingInstance.shabbyJerkin();
                        System.out.printf("%s is warrior%n", name);
                        break;
                    case 3:
                        weapon = WeaponInstance.recurveBow();
                        clothing = ClothingInstance.shabbyJerkin();
                        System.out.printf("%s is archer%n", name);
                        break;
                    default:
                        System.out.println("the class is set to rogue as the hero did not write a valid number");
                        System.out.printf("%s is rogue%n", name);
                        break;
                }
                Utility.SCANNER.nextLine();
                break;
            } else {
                System.out.println("class number must be integer");
                Utility.SCANNER.nextLine();
            }
        }
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
