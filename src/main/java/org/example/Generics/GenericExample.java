package org.example.Generics;

import java.util.ArrayList;

class JacobGen<T> {
    T jacob;

    JacobGen (T jacob) {
        this.jacob = jacob;
    }

    T getJacob() {
        return jacob;
    }
}

class SuspiciousCreature {
    private boolean hasLongFace;

    private boolean hasLongLegs;
    private int numberOfLegs;

    public SuspiciousCreature(boolean hasLongFace, boolean hasLongLegs, int numberOfLegs) {
        this.hasLongFace = hasLongFace;
        this.hasLongLegs = hasLongLegs;
        this.numberOfLegs = numberOfLegs;
    }

    public boolean isAHorse() {
        return hasLongFace && numberOfLegs == 4 && !hasLongLegs;
    }
}


class JacobGenUsage {
    public static void main(String[] args) {
        JacobGen<String> strJacob = new JacobGen<String> ("My name is Jacob");
        System.out.println(strJacob); // reference type
        System.out.println(strJacob.getJacob()); // "My name is jacob"

        SuspiciousCreature maybeHorse = new SuspiciousCreature(true, false, 4);
        SuspiciousCreature maybeMonster = new SuspiciousCreature(true, true, 9);

        JacobGen<SuspiciousCreature> horseGen = new JacobGen<>(maybeHorse);
        JacobGen<SuspiciousCreature> monsterGen = new JacobGen<>(maybeMonster);

        ArrayList<JacobGen<SuspiciousCreature>> jacobGenList = new ArrayList<JacobGen<SuspiciousCreature>>();
        jacobGenList.add(horseGen);
        jacobGenList.add(monsterGen);

        for (JacobGen<SuspiciousCreature> creature: jacobGenList
             ) {
            System.out.println("The verdict on whether the gen you've got there is a horse: " +
                    creature.getJacob().isAHorse());
        }
    }
}