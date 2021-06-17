package org.company.highScores;

public class Entry {
    private final String name;
    private final int score;

    public Entry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("%s, %d", name, score);
    }
}
