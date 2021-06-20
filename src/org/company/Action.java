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
                    System.out.println("actions:\nhelp\nmove <door>\nattack <character>\ninventory\nview <any>\ntake <item>\ndrop <item>\nequip <item>\nrescue <townspeople>\nexit");
                    break;
                case "move":
                    try {
                        switch (action[1].charAt(0)) {
                            case 'd':
                                hero.move(room.getDoors().get(Integer.parseInt(action[1].substring(1)) - 1));
                                flag = false;
                                break;
                            default:
                                System.out.println("invalid argument");
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("no argument");
                        flag = true;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("invalid door number");
                        flag = true;
                    } catch (NumberFormatException e) {
                        System.out.println("not a number");
                        flag = true;
                    } catch (Exception e) {
                        System.out.println("unknown exception");
                        flag = true;
                    }
                    break;
                case "attack":
                    try {
                        switch (action[1].charAt(0)) {
                            case 'm':
                                final Monster monster = room.getMonsters().get(Integer.parseInt(action[1].substring(1)) - 1);
                                hero.attack(monster);

                                if (monster.isDead()) {
                                    flag = false;
                                }

                                if (hero.isDead()) {
                                    flag = false;
                                }
                                break;
                            default:
                                System.out.println("invalid argument");
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("no argument");
                        flag = true;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("invalid monster number");
                        flag = true;
                    } catch (NumberFormatException e) {
                        System.out.println("not a number");
                        flag = true;
                    } catch (Exception e) {
                        System.out.println("unknown exception");
                        flag = true;
                    }
                    break;
                case "inventory":
                    System.out.println(hero.getInventory());
                    break;
                case "view":
                    try {
                        switch (action[1].charAt(0)) {
                            case 'd':
                                System.out.println(room.getDoors().get(Integer.parseInt(action[1].substring(1)) - 1));
                                hero.setRescueScore(hero.getRescueScore() - 1);
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
                                System.out.println("invalid argument");
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("no argument");
                        flag = true;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("invalid object number");
                        flag = true;
                    } catch (NumberFormatException e) {
                        System.out.println("not a number");
                        flag = true;
                    } catch (Exception e) {
                        System.out.println("unknown exception");
                        flag = true;
                    }
                    break;
                case "take":
                    try {
                        switch (action[1].charAt(0)) {
                            case 'i':
                                final Item item = room.getItems().get(Integer.parseInt(action[1].substring(1)) - 1);

                                if (hero.getInventory().add(item)) {
                                    room.getItems().remove(item);
                                    flag = false;
                                }
                                break;
                            default:
                                System.out.println("invalid argument");
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("no argument");
                        flag = true;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("invalid item number");
                        flag = true;
                    } catch (NumberFormatException e) {
                        System.out.println("not a number");
                        flag = true;
                    } catch (Exception e) {
                        System.out.println("unknown exception");
                        flag = true;
                    }
                    break;
                case "drop":
                    try {
                        switch (action[1].charAt(0)) {
                            case 'i':
                                hero.getInventory().drop(hero.getInventory().getItems().get(Integer.parseInt(action[1].substring(1)) - 1), hero.getRoom());
                                flag = false;
                                break;
                            default:
                                System.out.println("invalid argument");
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("no argument");
                        flag = true;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("invalid item number");
                        flag = true;
                    } catch (NumberFormatException e) {
                        System.out.println("not a number");
                        flag = true;
                    } catch (Exception e) {
                        System.out.println("unknown exception");
                        flag = true;
                    }
                    break;
                case "equip":
                    try {
                        switch (action[1].charAt(0)) {
                            case 'i':
                                hero.equip(hero.getInventory().getItems().get(Integer.parseInt(action[1].substring(1)) - 1));
                                flag = false;
                                break;
                            default:
                                System.out.println("invalid argument");
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("no argument");
                        flag = true;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("invalid item number");
                        flag = true;
                    } catch (NumberFormatException e) {
                        System.out.println("not a number");
                        flag = true;
                    } catch (Exception e) {
                        System.out.println("unknown exception");
                        flag = true;
                    }
                    break;
                case "rescue":
                    try {
                        switch (action[1].charAt(0)) {
                            case 't':
                                if (room.getMonsters().size() < 1) {
                                    hero.rescue(room.getTownspeople().get(Integer.parseInt(action[1].substring(1)) - 1));
                                    flag = false;
                                } else {
                                    System.out.println("there are monsters in the room");
                                    flag = true;
                                }
                                break;
                            default:
                                System.out.println("invalid argument");
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("no argument");
                        flag = true;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("invalid townspeople number");
                        flag = true;
                    } catch (NumberFormatException e) {
                        System.out.println("not a number");
                        flag = true;
                    } catch (Exception e) {
                        System.out.println("unknown exception");
                        flag = true;
                    }
                    break;
                case "exit":
                    return false;
                default:
                    System.out.println("invalid action");
                    break;
            }
        }
        return true;
    }
}
