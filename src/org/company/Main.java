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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Level> levels = Level.generate();
        System.out.println("name:");
        String name = scanner.nextLine();
        System.out.println("gender: (type 'male' or 'female')");
        String gender = scanner.nextLine();
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
        Hero hero = new Hero(name, gender, age, weapon, clothing, 20, levels.get(0).getRooms().get(0), levels.get(0));

        while (true) {
            hero.display();
            Room room = levels.get(hero.getLevel().getId()).getRooms().get(hero.getRoom().getId());
            room.display();

            action:
            while (true) {
                System.out.println("action:");
                String[] actionArgs = scanner.nextLine().split(" ");
                String action = actionArgs[0];
                System.arraycopy(actionArgs, 1, actionArgs, 0, actionArgs.length - 1);

                switch (action) {
                    case "help":
                        System.out.printf("actions:%nhelp%nattack <monster number>%nmove <door number>%n");
                    case "move":
                        if (actionArgs[0].charAt(0) == 'd') {
                            hero.move(room.getDoors().get(Integer.parseInt(actionArgs[0].substring(1)) - 1));
                        }
                        break action;
                    case "attack":
                        if (actionArgs[0].charAt(0) == 'm') {
                            Monster monster = room.getMonsters().get(Integer.parseInt(actionArgs[0].substring(1)) - 1);
                            hero.attack(monster);

                            if (monster.isDead()) {
                                monster.getRoom().getItems().add(monster.getWeapon());
                                monster.setWeapon(null);
                                monster.getRoom().getItems().add(monster.getClothing());
                                monster.setClothing(null);

                                for (Item item :
                                        monster.getInventory().getItems()) {
                                    monster.getInventory().dropItem(item, room);
                                }
                                break action;
                            }
                        }
                        break;
                    case "take":
                        if (actionArgs[0].charAt(0) == 'i') {
                            hero.getInventory().addItem(hero.getRoom().getItems().get(Integer.parseInt(actionArgs[0].substring(1)) - 1));
                            hero.getRoom().getItems().remove(Integer.parseInt(actionArgs[0].substring(1)) - 1);
                        }
                        break action;
                    case "inventory":
                        if (actionArgs[0].equals("display")) {
                            hero.getInventory().display();
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
