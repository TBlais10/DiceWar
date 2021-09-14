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
    } //Starts the program from main w/ a dice quote.

    public static void mainMenu() {
        scoreboard();
        System.out.println("Would you like to start a new Dice War?!!! Y/N?");
        String input = CLI.getString(1, 4);
        if (input.substring(0, 1).equalsIgnoreCase("Y")) {
            CLI.flavorText(". ", "Ok! Which dice war would you like to play?\n1) Standard Dice War\n2) Dungeons and Dragons Dice War");
            int answer = CLI.getInt(1,2);
            if (answer == 1){ //Starts the process for the Standard Dice War.
            CLI.flavorText(". ", "Great the Standard Dice War! How many players will there be? Min of 2 players.");
            int players = CLI.getInt(2, 10);

            CLI.newTerminalScreen();
            CLI.flavorText(". ","Ok! How many rounds do you want to play? Min of 1 round, max of 10.");
            int rounds = CLI.getInt(1, 10);

            CLI.newTerminalScreen();
            CLI.flavorText(". ","Awesome! What type of dice do you want to use? Enter a number representing how many sides the dice has. Min of 2, max of 20.");
            int typeOfDice = CLI.getInt(2, 20);

            CLI.newTerminalScreen();
            CLI.flavorText(". ","Almost done! How many dice will each player roll per round? Min of 1, max of 10.");
            int diceAmount = CLI.getInt(1, 10);

            newDiceWarConfirmation(players, rounds, typeOfDice, diceAmount);
            }

            else if (answer == 2){
                CLI.flavorText(". ", "Ah yes! The Dungeons and Dragons Dice War. How many will be joining us at the table? Minimum of 2, max of 10");
                int players = CLI.getInt(2, 10);
                CLI.flavorText(". ", "Very well. Roll for initiative!");
                new Game(players, 3, 0, 0, 2);
            } //Starts the dnd dice game.
        }
        else if (input.substring(0, 1).equalsIgnoreCase("N")) {
            CLI.exit("Dice Wars"); //Exits the program.
        } else if (input.equalsIgnoreCase("test")) {
            new Game(2, 3, 6, 4, 1); //Quickly creates a game to test the program.
        }

    } //The Main menu of the program.

    private static void newDiceWarConfirmation(int players, int rounds, int typeOfDice, int diceAmount) {
        CLI.newTerminalScreen();

        System.out.println("Ok, lets review!\nNumber of players: " + players + "\nNumber of Rounds: " + rounds + "\nType of dice your rolling: D" + typeOfDice + "\nThe amount of D" + typeOfDice + ": " + diceAmount);
        System.out.println("Is this all correct?\n Y to start the game or N to return to restart the form.");
        CLI.scanner.nextLine();
        String answer = CLI.getString(1, 3);
        if (answer.substring(0, 1).equalsIgnoreCase("Y")) {
            CLI.flavorText(". ", "Excellent! Lets get rolling!!!");
            scoreboard.clear();
            new Game(players, rounds, typeOfDice, diceAmount, 1);
        } else if (answer.substring(0, 1).equalsIgnoreCase("N")) {
            CLI.flavorText(". ", "Ok! Restarting the form...");
        }
    } //This code takes the inputs from the Menu for Standard Dice War and asks the user to confirm their choices or start the forum again.

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
    } //An array of Dice Quotes that will fire randomly at the start of the program.

    public static void scoreboard() {
        if (scoreboard.size() != 0) {
            System.out.println("Here is the scoreboard from our previous game!");
            Collections.sort(scoreboard);
            Collections.reverse(scoreboard);
            for (int i = 0; i < scoreboard.size(); i++) {
                System.out.println((i + 1) + ") " + scoreboard.get(i).getName() + "....." + scoreboard.get(i).getScore() + " Points");
            }
        }
        CLI.flavorText(". ", "MAIN MENU");
    } //Takes the Arraylist full of the player scores from last game and shows.

    public static List<Player> getScoreboard() {
        return scoreboard;
    }
}
