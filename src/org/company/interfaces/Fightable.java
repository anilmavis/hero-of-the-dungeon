package org.company.interfaces;

import org.company.characters.Character;

public interface Fightable {
    void attack(Character character);
    boolean block();
}
