package org.company;

import org.company.characters.Hero;
import org.company.characters.Monster;
import org.company.items.clothing.Clothing;
import org.company.items.clothing.ClothingInstance;
import org.company.items.weapons.Weapon;
import org.company.items.weapons.WeaponInstance;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final SecureRandom secureRandom = new SecureRandom();
        final ArrayList<Level> levels = Level.generate(secureRandom);
        System.out.println("name:");
        final String name = scanner.nextLine();
        System.out.println("gender: (type 'male' or 'female')");
        final String gender = scanner.nextLine();
        System.out.println("age:");
        int age = scanner.nextInt();

        while (age < 0) {
            age = scanner.nextInt();
        }
        System.out.println("class:\n1. rogue: glass shank and strapped leather\n2. warrior: rusted hatchet and plate vest\n3. archer: crude bow, shabby jerkin");
        Weapon weapon;
        Clothing clothing;

        switch (scanner.nextInt()) {
            case 1:
                weapon = WeaponInstance.glassShank();
                clothing = ClothingInstance.strappedLeather();
                break;
            case 2:
                weapon = WeaponInstance.rustedHatchet();
                clothing = ClothingInstance.plateVest();
                break;
            case 3:
                weapon = WeaponInstance.crudeBow();
                clothing = ClothingInstance.shabbyJerkin();
                break;
            default:
                weapon = null;
                clothing = null;
                break;
        }
        scanner.nextLine();
        final Level level1 = levels.get(0);
        final Hero hero = new Hero(name, gender, age, weapon, clothing, 20, level1.getRooms().get(0), level1);
        boolean mainLoopShouldClose = false;
        boolean innerLoopShouldClose;

        while (!mainLoopShouldClose) {
            hero.display();
            final Room room = levels.get(hero.getLevel().getId()).getRooms().get(hero.getRoom().getId());
            room.display();
            innerLoopShouldClose = false;

            while (!innerLoopShouldClose) {
                System.out.println("action:");
                final String[] actionArgs = scanner.nextLine().split(" ");
                final String action = actionArgs[0];
                System.arraycopy(actionArgs, 1, actionArgs, 0, actionArgs.length - 1);

                switch (action) {
                    case "help":
                        System.out.printf("actions:%nhelp%nattack <monster number>%nmove <door number>%n");
                    case "move":
                        if (actionArgs[0].charAt(0) == 'd') {
                            hero.move(room.getDoors().get(Integer.parseInt(actionArgs[0].substring(1)) - 1));
                        } else {
                            System.out.println("invalid arguments");
                        }
                        innerLoopShouldClose = true;
                    case "attack":
                        if (actionArgs[0].charAt(0) == 'm') {
                            final Monster monster = room.getMonsters().get(Integer.parseInt(actionArgs[0].substring(1)) - 1);
                            if (!hero.attack(monster)) {
                                innerLoopShouldClose = true;
                            }
                        } else {
                            System.out.println("invalid arguments");
                        }
                        break;
                    case "inventory":
                        System.out.println(hero.getInventory());
                        break;
                    case "view":
                        switch (actionArgs[0].charAt(0)) {
                            case 'd':
                                System.out.println("doors cannot be viewed");
                                break;
                            case 'm':
                                System.out.println(hero.getRoom().getMonsters().get(Integer.parseInt(actionArgs[0].substring(1)) - 1));
                                break;
                            case 't':
                                System.out.println(hero.getRoom().getTownspeople().get(Integer.parseInt(actionArgs[0].substring(1)) - 1));
                                break;
                            case 'i':
                                System.out.println(hero.getRoom().getItems().get(Integer.parseInt(actionArgs[0].substring(1)) - 1));
                                break;
                        }
                        break;
                    case "take":
                        if (actionArgs[0].charAt(0) == 'i') {
                            hero.getInventory().addItem(hero.getRoom().getItems().get(Integer.parseInt(actionArgs[0].substring(1)) - 1));
                            hero.getRoom().getItems().remove(Integer.parseInt(actionArgs[0].substring(1)) - 1);
                        }
                        innerLoopShouldClose = true;
                        break;
                    case "equip":
                        if (actionArgs[0].charAt(0) == 'i') {
                            hero.equip(hero.getInventory().getItems().get(Integer.parseInt(actionArgs[0].substring(1)) - 1));
                        } else {
                            System.out.println("invalid arguments");
                        }
                        break;
                    case "drop":
                        if (actionArgs[0].charAt(0) == 'i') {
                            hero.getInventory().dropItem(hero.getInventory().getItems().get(Integer.parseInt(actionArgs[0].substring(1)) - 1), hero.getRoom());
                        } else {
                            System.out.println("invalid arguments");
                        }
                        break;
                    case "close":
                        innerLoopShouldClose = true;
                        mainLoopShouldClose = true;
                        break;
                    default:
                        System.out.println("invalid action");
                        break;
                }
            }
        }
    }
}
