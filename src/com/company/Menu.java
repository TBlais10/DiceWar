package com.company;

import java.util.ArrayList;
import java.util.Locale;

public class Menu {

    private static ArrayList<String> diceQuotes = new ArrayList<>();
    private static ArrayList<Player> scoreboard = new ArrayList<>();

    public static void start() {
        System.out.println("Welcome to Dice Wars!");
        System.out.println(". . . . . .");
        getDiceQuote();
        System.out.print(". . . . . .");

    }

    public static void mainMenu() {
        scoreboard();
        System.out.println("Would you like to start a new Dice War?!!! Y/N?");
        String input = CLI.getString(1,3);
        if (input.substring(0, 1).toUpperCase().equals("Y")){
            flavorText("Great! How many players will there be? Min of 2 players");
            int players = CLI.getInt(2,10);
            System.out.println();
            flavorText("Ok! How many rounds do you want to play? Min of 1 round, max of 10.");
            int rounds = CLI.getInt(1,10);
            System.out.println();
            flavorText("Awesome! What type of dice do you want to use? Enter a number representing how many sides the dice has. Min of 2, max of 20");
            int typeOfDice = CLI.getInt(2, 20);
            System.out.println();
            flavorText("Almost done! How many dice will each player roll per round? Min of 1, max of 10");
            int diceAmmount = CLI.getInt(1,10);
            System.out.println();
            //add a print line that repeats the information given from the user and asks them to confirm it.
            flavorText("Excellent! Lets get rolling!!!");
        }

    }

    public static void getDiceQuote() {
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

        int randomQuote = (int) (Math.random() * diceQuotes.size());
        System.out.println((diceQuotes.get(randomQuote)));
    }

    public static void subMenu() {

    }

    public static void scoreboard() {
        if (scoreboard.size() != 0) {
            System.out.println("Here is the scoreboard from our previous game!");
            for (int i = 0; i < scoreboard.size(); i++) {
                System.out.println(i + 1 + ") " + scoreboard.get(i).getName() + "....." + scoreboard.get(i).getScore() + " Points");
            }
        }
    }

    public static void flavorText(String statement){
        System.out.println(". . . . . .");
        System.out.println(statement);
        System.out.print(". . . . . .");
    }

}
