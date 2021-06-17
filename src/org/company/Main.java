package org.company;

import org.company.characters.Hero;
import org.company.highScores.Entry;
import org.company.highScores.EntryComparator;
import org.company.items.clothing.Clothing;
import org.company.items.clothing.ClothingInstance;
import org.company.items.weapons.Weapon;
import org.company.items.weapons.WeaponInstance;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(final String[] args) {
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
        System.out.println("class:\n1. rogue: glass shank and strapped leather\n2. warrior: rusted hatchet and plate vest\n3. archer: crude bow, shabby jerkin");
        Weapon weapon = WeaponInstance.glassShank();
        Clothing clothing = ClothingInstance.strappedLeather();

        switch (Utility.SCANNER.nextInt()) {
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

        try {
            File file = new File("high-scores.txt");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file.getName(), true);
            fileWriter.write(String.format("%s%n", new Entry(hero.getName(), hero.getScore())));
            fileWriter.close();
            FileReader fileReader = new FileReader(file.getName());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<Entry> entries = new ArrayList<>();

            for (int i = 0; i < Files.lines(Paths.get(file.getName())).count(); i++) {
                String[] strings = bufferedReader.readLine().split(", ");
                entries.add(new Entry(strings[0], Integer.parseInt(strings[1])));
            }
            bufferedReader.close();
            entries.sort(new EntryComparator());

            System.out.println("high scores:");
            for (Entry entry : entries) {
                System.out.println(entry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
