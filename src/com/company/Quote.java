package com.company;

import java.util.ArrayList;

public class Quote {

    private static ArrayList<String> diceQuotes = new ArrayList<>();

    public static ArrayList<String> getDiceQuotes() {
        return diceQuotes;
    }

    public static void generateDiceQuote() {
        diceQuotes.add("The dice of God are always loaded.\n" +
                "- Ralph Waldo Emerson");
        diceQuotes.add("Who then may trust the dice, at Fortune's throw?\n" +
                "- Geoffrey Chaucer");
        diceQuotes.add("You can blow on the dice all you want, but whether they come up seven is still a function of random luck.\n" +
                "- Barry Ritholtz");
        diceQuotes.add("Fortune confounds the wise,\n" +
                "And when they least expect it turns the dice.\n" +
                "-John Dryden");
        diceQuotes.add("I shall never believe that God plays dice with the world.\n" +
                "-Albert Einstein");

    } //An array of Dice Quotes that will fire randomly at the start of the program.

}
