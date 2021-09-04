package com.company;

public class Die {

    private final int sides;
    private int value;

    public Die (int sides, int value){
        this.sides = sides;
        this.value = 0;
    }

    public void rollDie() {
        value = (int) (Math.random() * sides + 1);
        //System.out.println("And your number is " + val);
    }

    public int getValue() {
        return value;
    }

}
