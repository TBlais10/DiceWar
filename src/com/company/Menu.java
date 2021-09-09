package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Menu {

    private static ArrayList<String> diceQuotes = new ArrayList<>();
    private static List<Player> scoreboard = new ArrayList<>();

    public static void start() {
        System.out.println("Welcome to Dice Wars!");
        System.out.println(". . . . . .");
        getDiceQuote();
        System.out.print(". . . . . .\n");
        mainMenu();
    }

    public static void mainMenu() {
        scoreboard();
        System.out.println("Would you like to start a new Dice War?!!! Y/N?");
        String input = CLI.getString(1,4);
        if (input.substring(0, 1).equalsIgnoreCase("Y")){
            CLI.flavorText("Great! How many players will there be? Min of 2 players.");
            int players = CLI.getInt(2,10);
            System.out.println();

            CLI.flavorText("Ok! How many rounds do you want to play? Min of 1 round, max of 10.");
            int rounds = CLI.getInt(1,10);
            System.out.println();

            CLI.flavorText("Awesome! What type of dice do you want to use? Enter a number representing how many sides the dice has. Min of 2, max of 20.");
            int typeOfDice = CLI.getInt(2, 20);
            System.out.println();

            CLI.flavorText("Almost done! How many dice will each player roll per round? Min of 1, max of 10.");
            int diceAmount = CLI.getInt(1,10);
            System.out.println();

            System.out.println("Ok, lets review!\nNumber of players: " + players + "\nNumber of Rounds: " + rounds + "\nType of dice your rolling: D" + typeOfDice + "\nThe amount of D" + typeOfDice + " : " + diceAmount); //TODO: Refactor this code into a new method
            System.out.println("Is this all correct?\n Y to start the game or N to return to restart the form.");
            //TODO: Refactor this input code into a new method
            CLI.scanner.nextLine();
            String answer = CLI.getString(1, 3);
            if (answer.substring(0, 1).equalsIgnoreCase("Y")){
                CLI.flavorText("Excellent! Lets get rolling!!!");
                scoreboard.clear();
                new Game(players, rounds, typeOfDice, diceAmount);
            }
            else if (answer.substring(0, 1).equalsIgnoreCase("N")){
                CLI.flavorText("Ok! Restarting the form...");
                //add method once code has been refactored
            }

        }

        else if(input.substring(0,1).equalsIgnoreCase("N")){
            CLI.exit();
        }

        else if (input.equalsIgnoreCase("test")){
            new Game(2,3, 6,4);
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

    public static void scoreboard() {
        if (scoreboard.size() != 0) {
            System.out.println("Here is the scoreboard from our previous game!");
            Collections.sort(scoreboard);
            Collections.reverse(scoreboard);
            for (int i = 0; i < scoreboard.size(); i++) {
                System.out.println((i + 1) + ") " + scoreboard.get(i).getName() + "....." + scoreboard.get(i).getScore() + " Points");
            }
        }
    }

    public static List<Player> getScoreboard() {
        return scoreboard;
    }
}
