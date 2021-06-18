package org.company.highScores;

import org.company.characters.Hero;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class HighScore {
    private static File file = new File("high-scores.txt");
    private static final ArrayList<Entry> entries = new ArrayList<>();

    public static void write(Hero hero) {
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file.getName(), true);
            fileWriter.write(String.format("%s%n", new Entry(hero.getName(), hero.getScore())));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read() {
        try {
            FileReader fileReader = new FileReader(file.getName());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            for (int i = 0; i < Files.lines(Paths.get(file.getName())).count(); i++) {
                String[] strings = bufferedReader.readLine().split(", ");
                entries.add(new Entry(strings[0], Integer.parseInt(strings[1])));
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        entries.sort(new EntryComparator());
        System.out.println("high scores:");

        for (int i = 0; i < 5; i++) {
            System.out.println(entries.get(i));
        }
    }
}
