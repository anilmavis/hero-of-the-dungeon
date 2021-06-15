package org.company;

import org.company.characters.Hero;
import org.company.characters.Monster;
import org.company.items.Item;

import java.util.Scanner;

public class Action {
    public static boolean handle(Hero hero) {
        final Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("action:");
            final String[] action = scanner.nextLine().split(" ");
            final Room room = hero.getRoom();

            switch (action[0]) {
                case "help":
                    System.out.println("help");
                    break;
                case "move":
                    switch (action[1].charAt(0)) {
                        case 'd':
                            hero.move(room.getDoors().get(Integer.parseInt(action[1].substring(1)) - 1));
                            flag = false;
                            break;
                        default:
                            break;
                    }
                    break;
                case "attack":
                    switch (action[1].charAt(0)) {
                        case 'm':
                            final Monster monster = room.getMonsters().get(Integer.parseInt(action[1].substring(1)) - 1);
                            hero.attack(monster);

                            if (monster.isDead()) {
                                flag = false;
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
                            flag = false;
                            break;
                        default:
                            break;
                    }
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
                            flag = false;
                            break;
                        default:
                            break;
                    }
                    break;
                case "rescue":
                    switch (action[1].charAt(0)) {
                        case 't':
                            if (room.getMonsters().size() < 1) {
                                hero.rescue(room.getTownspeople().get(Integer.parseInt(action[1].substring(1)) - 1));
                                flag = false;
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case "exit":
                    return false;
                default:
                    break;
            }
        }
        return true;
    }
}
