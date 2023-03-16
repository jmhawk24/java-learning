package org.example.datastructures.lists.linkedlists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Trolley {
    private int numPassengers;
    private int speed;

    public Trolley() {
        this.numPassengers = 0;
        this.speed = 0;
    }

    public void pickup() {
        System.out.println("picking up");
        this.numPassengers++;
    }

    public void dropoff() {
        System.out.println("dropping off");
        this.numPassengers--;
    }

    public void hostageSituation() {
        this.speed = 40;
        System.out.println("Don't go below 35");
    }

    public void go() {
        this.speed = 20;
        System.out.println("Moving");
    }

    public void stop() {
        this.speed = 0;
        System.out.println("Stopping");
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public int getSpeed() {
        return speed;
    }
}

public class LinkedListApplication {
    public static void main(String[] args) {
        List<Trolley> tArray = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Trolley t = new Trolley();
            t.pickup();
            t.pickup();
            t.go();
            System.out.println("this many passengers: " + t.getNumPassengers() + " and this speed: " + t.getSpeed());
            tArray.add(t);
        }
        LinkedList<Trolley> myLinkedList = new LinkedList<Trolley>();
        myLinkedList.addAll(tArray);


        while (myLinkedList.peek() != null) {
            Trolley nextTrolley = myLinkedList.poll(); // this automatically empties the linked list
            nextTrolley.stop();
            nextTrolley.dropoff();
        }
    }
}
