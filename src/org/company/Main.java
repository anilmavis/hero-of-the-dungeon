package org.company;

import org.company.characters.Hero;
import org.company.characters.Monster;
import org.company.items.Item;
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
        boolean mainLoopShouldClose = false;
        boolean innerLoopShouldClose;

        while (!mainLoopShouldClose) {
            System.out.println(hero);
            final Room room = levels.get(hero.getLevel().getId()).getRooms().get(hero.getRoom().getId());
            System.out.print(room);
            innerLoopShouldClose = false;

            while (!innerLoopShouldClose) {
                System.out.println("action:");
                final String[] action = scanner.nextLine().split(" ");

                switch (action[0]) {
                    case "help":
                        System.out.println("help");
                        break;
                    case "move":
                        switch (action[1].charAt(0)) {
                            case 'd':
                                hero.move(room.getDoors().get(Integer.parseInt(action[1].substring(1)) - 1));
                                break;
                            default:
                                break;
                        }
                        innerLoopShouldClose = true;
                        break;
                    case "attack":
                        switch (action[1].charAt(0)) {
                            case 'm':
                                final Monster monster = room.getMonsters().get(Integer.parseInt(action[1].substring(1)) - 1);

                                if (!hero.attack(monster)) {
                                    innerLoopShouldClose = true;
                                }
                                break;
                            default:
                                break;
                        }
                        break;
                    case "inventory":
                        System.out.println(hero.getInventory());
                        break;
                    case "view":
                        switch (action[1].charAt(0)) {
                            case 'd':
                                System.out.println(room.getDoors().get(Integer.parseInt(action[1].substring(1)) - 1));
                                break;
                            case 'm':
                                System.out.println(room.getMonsters().get(Integer.parseInt(action[1].substring(1)) - 1));
                                break;
                            case 't':
                                System.out.println(room.getTownspeople().get(Integer.parseInt(action[1].substring(1)) - 1));
                                break;
                            case 'i':
                                System.out.println(room.getItems().get(Integer.parseInt(action[1].substring(1)) - 1));
                                break;
                            default:
                                break;
                        }
                        break;
                    case "take":
                        switch (action[1].charAt(0)) {
                            case 'i':
                                final Item item = room.getItems().get(Integer.parseInt(action[1].substring(1)) - 1);
                                hero.getInventory().add(item);
                                room.getItems().remove(item);
                                break;
                            default:
                                break;
                        }
                        innerLoopShouldClose = true;
                        break;
                    case "equip":
                        switch (action[1].charAt(0)) {
                            case 'i':
                                hero.equip(hero.getInventory().getItems().get(Integer.parseInt(action[1].substring(1)) - 1));
                                break;
                            default:
                                break;
                        }
                        break;
                    case "drop":
                        switch (action[1].charAt(0)) {
                            case 'i':
                                hero.getInventory().drop(hero.getInventory().getItems().get(Integer.parseInt(action[1].substring(1)) - 1), hero.getRoom());
                                break;
                            default:
                                break;
                        }
                        break;
                    case "close":
                        mainLoopShouldClose = true;
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
