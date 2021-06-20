package org.company.highScores;

import org.company.characters.Hero;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class HighScore {
    private static final File file = new File("high-scores.txt");
    private static final ArrayList<Entry> entries = new ArrayList<>();

    public static void write(Hero hero) {
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file.getName(), true);
            fileWriter.write(String.format("%s%n", new Entry(hero.getName(), hero.getRescueScore() + hero.getInventory().getValue())));
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(file.getName() + " cannot be created or opened");
        } catch (Exception e) {
            System.out.println("unknown exception");
        }
    }

    public static void read() {
        try {
            entries.clear();
            final FileReader fileReader = new FileReader(file.getName());
            final BufferedReader bufferedReader = new BufferedReader(fileReader);

            for (int i = 0; i < Files.lines(Paths.get(file.getName())).count(); i++) {
                final String[] strings = bufferedReader.readLine().split(", ");
                entries.add(new Entry(strings[0], Integer.parseInt(strings[1])));
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(file.getName() + " cannot be opened. It is normal if it is your first gameplay. When you die or type exit, the file will be created.");
        } catch (Exception e) {
            System.out.println("unknown exception");
        }
        entries.sort(new EntryComparator());

        if (entries.size() > 0) {
            System.out.println("high scores:");
        }
        int size = 5;

        if (entries.size() <= 5) {
            size = entries.size();
        }

        for (int i = 0; i < size; i++) {
            System.out.println(entries.get(i));
        }
    }
}
