package org.company;

import org.company.characters.Hero;
import org.company.characters.Monster;
import org.company.items.clothing.ClothingInstance;
import org.company.items.weapons.WeaponInstance;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Level> levels = Level.generate();
        System.out.println("name:");
        String name = scanner.nextLine();
        System.out.println("class:\n1. rogue: glass shank and strapped leather\n2. warrior: rusted hatchet and plate vest\n3. archer: crude bow, shabby jerkin");
        Hero hero = new Hero(name, null, null, 20, 100);

        switch (scanner.nextInt()) {
            case 1:
                hero = new Hero(name, WeaponInstance.glassShank(), ClothingInstance.strappedLeather(), 20, 100);
                break;
            case 2:
                hero = new Hero(name, WeaponInstance.rustedHatchet(), ClothingInstance.plateVest(), 20, 100);
                break;
            case 3:
                hero = new Hero(name, WeaponInstance.crudeBow(), ClothingInstance.shabbyJerkin(), 20, 100);
                break;
            default:
                break;
        }

        while (true) {
            hero.display();
            Room room = levels.get(hero.getLevelId()).getRooms().get(hero.getRoomId());
            room.display();

            action:
            while (true) {
                System.out.println("action:");
                String[] action = scanner.nextLine().split(" ");

                switch (action[0]) {
                    case "attack":
                        if (action[1].charAt(0) == 'm') {
                            Monster monster = room.getMonsters().get(Integer.parseInt(action[1].substring(1)) - 1);
                            hero.attack(monster);

                            if (monster.isDead()) {
                                break action;
                            }
                        }
                        break;
                    case "move":
                        if (action[1].charAt(0) == 'd' && action[1].charAt(1) != 'o') { // ?
                            hero.move(room.getDoors().get(Integer.parseInt(action[1].substring(1)) - 1));
                        } else if (action[1].equals("up") || action[1].equals("down")) {
                            for (int i = 0; i < room.getDoors().size(); i++) {
                                if (room.getDoors().get(i).isStair()) {
                                    hero.move(room.getDoors().get(i));
                                    break;
                                }
                            }
                        }
                        break action;
                    case "take":
                        if (action[1].charAt(0) == 'i') {
                        }
                        break;
                    case "help":
                        System.out.println("options:\nattack <monster number>\nmove <door number>\nhelp");
                    default:
                        break;
                }
            }
        }
    }
}
