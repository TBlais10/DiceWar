package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Menu {

    public static void start() {
        System.out.println("Welcome to Dice Wars!");
        Quote.generateDiceQuote();
        CLI.flavorText(". ",6,  Quote.getDiceQuotes());
        mainMenu();
    } //Starts the program from main w/ a die quote.

    public static void mainMenu() {
        Scoreboard.getScoreboard();
        System.out.println("Would you like to start a new Dice War?!!! Y/N?");
        String input = CLI.getString(1, 4);
        if (input.substring(0, 1).equalsIgnoreCase("Y")) {
            CLI.flavorText(". ",6,  "Ok! Which dice war would you like to play?\n1) Standard Dice War\n2) Dungeons and Dragons Dice War");
            int answer = CLI.getInt(1,2);
            if (answer == 1){ //Starts the process for the Standard Dice War.
            CLI.flavorText(". ",6,  "Great the Standard Dice War! How many players will there be? Min of 2 players.");
            int players = CLI.getInt(2, 10);

            CLI.newTerminalScreen();
                CLI.flavorText(". ",6,  "Awesome! Would you like to add extra NPC players? If you don't want to have any additional players, press 0. Otherwise! Enter in a minimum of 1, maximum of 8");
                int npcPlayers = CLI.getInt(0, 8);

            CLI.newTerminalScreen();
            CLI.flavorText(". ",6, "Ok! How many rounds do you want to play? Min of 1 round, max of 10.");
            int rounds = CLI.getInt(1, 10);

            CLI.newTerminalScreen();
            CLI.flavorText(". ",6, "Awesome! What type of dice do you want to use? Enter a number representing how many sides the dice has. Min of 2, max of 20.");
            int typeOfDice = CLI.getInt(2, 20);

            CLI.newTerminalScreen();
            CLI.flavorText(". ",6, "Almost done! How many dice will each player roll per round? Min of 1, max of 10.");
            int diceAmount = CLI.getInt(1, 10);

            newDiceWarConfirmation(players, npcPlayers, rounds, typeOfDice, diceAmount);
            }

            else if (answer == 2){
                CLI.flavorText(". ",6,  "Ah yes! The Dungeons and Dragons Dice War. How many will be joining us at the table? Minimum of 2, max of 10");
                int players = CLI.getInt(2, 10);

                CLI.newTerminalScreen();
                CLI.flavorText(". ",6,  "Right right... Would you like to add extra NPC players? If you don't want to have any additional players, press 0. Otherwise! Enter in a minimum of 1, maximum of 8");
                int npcPlayers = CLI.getInt(0, 8);

                CLI.flavorText(". ",6,  "Very well. Roll for initiative!");
                new Game(players, npcPlayers,3, 0, 0, 2);
            } //Starts the dnd dice game.
        }
        else if (input.substring(0, 1).equalsIgnoreCase("N")) {
            CLI.exit("Dice Wars"); //Exits the program.
        } else if (input.equalsIgnoreCase("test")) {
            new Game(2, 0, 3, 1, 1, 1); //Quickly creates a game to test the program.
        }

    } //The Main menu of the program.

    private static void newDiceWarConfirmation(int players, int npcPlayers, int rounds, int typeOfDice, int diceAmount) {
        CLI.newTerminalScreen();

        System.out.println("Ok, lets review!\nNumber of players: " + players + "\nNumber of NPC players: " + npcPlayers + "\nNumber of Rounds: " + rounds + "\nType of dice your rolling: D" + typeOfDice + "\nThe amount of D" + typeOfDice + ": " + diceAmount);
        System.out.println("Is this all correct?\n Y to start the game or N to return to restart the form.");
        CLI.scanner.nextLine();
        String answer = CLI.getString(1, 3);
        if (answer.substring(0, 1).equalsIgnoreCase("Y")) {
            CLI.flavorText(". ",6, "Excellent! Lets get rolling!!!");
            Scoreboard.getScoreboard().clear();
            new Game(players, npcPlayers, rounds, typeOfDice, diceAmount, 1);
        } else if (answer.substring(0, 1).equalsIgnoreCase("N")) {
            CLI.flavorText(". ",6, "Ok! Restarting the form...");
        }
    } //This code takes the inputs from the Menu for Standard Dice War and asks the user to confirm their choices or start the forum again.

}