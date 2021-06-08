package org.company;

public class Door {
    private final int reference;
    private final String way;
    private final boolean isStair;

    public Door(int reference, String way) {
        this.reference = reference;
        this.way = way;
        this.isStair = !way.isEmpty();
    }

    public Door(int reference) {
        this(reference, "");
    }

    public int getReference() {
        return reference;
    }

    public boolean isStair() {
        return isStair;
    }

    public String getWay() {
        return way;
    }
}
