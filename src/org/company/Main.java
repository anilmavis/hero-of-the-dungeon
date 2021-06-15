package org.company;

import org.company.characters.Hero;
import org.company.items.clothing.Clothing;
import org.company.items.clothing.ClothingInstance;
import org.company.items.weapons.Weapon;
import org.company.items.weapons.WeaponInstance;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("name:");
        final String name = scanner.nextLine();
        System.out.println("gender:");
        final String gender = scanner.nextLine();
        System.out.println("age:");
        int age = scanner.nextInt();

        while (age < 0) {
            age = scanner.nextInt();
        }
        System.out.println("class:\n1. rogue: glass shank and strapped leather\n2. warrior: rusted hatchet and plate vest\n3. archer: crude bow, shabby jerkin");
        Weapon weapon = WeaponInstance.glassShank();
        Clothing clothing = ClothingInstance.strappedLeather();

        switch (scanner.nextInt()) {
            case 2:
                weapon = WeaponInstance.rustedHatchet();
                clothing = ClothingInstance.plateVest();
                break;
            case 3:
                weapon = WeaponInstance.crudeBow();
                clothing = ClothingInstance.shabbyJerkin();
                break;
            default:
                break;
        }
        scanner.nextLine();
        final ArrayList<Level> levels = Level.generate();
        final Level level1 = levels.get(0);
        final Hero hero = new Hero(name, 22, gender, age, weapon, clothing, new Inventory());
        hero.setLevel(level1);
        hero.setRoom(level1.getRooms().get(0));

        do {
            System.out.println(hero);
            System.out.print(hero.getRoom());
        } while (Action.handle(hero) && !hero.isDead());
        // save the score of the hero to a file after dying or typing exit
    }
}
