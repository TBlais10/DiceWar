package com.company;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> playerList = new ArrayList<Player>();
    private int numOfRounds;
    private int numOfDice;
    private Die dice;

    public Game(int numOfPlayers, int numOfRounds, int typeOfDice, int numOfDice) {
        this.numOfRounds = numOfRounds;
        this.numOfDice = numOfDice;
        this.dice = new Die(typeOfDice);
        generatePlayers(numOfPlayers);
    }

    public void startGame() {
        Menu.flavorText("Welcome to Dice War! The rules are simple, roll the highest number of dice to win the game! This game will last for " + numOfRounds + "rounds. May you roll well!");
//        System.out.println("Dice type: " + dice.getSides());
        for (int i = 1; i <= numOfRounds; i++) {
            Menu.flavorText("Round " + i + "!");

            for (Player player : playerList) {
                playerTurn(player);
            }
            printScore(i);
        }

    }

    private void playerTurn(Player player) {
        int roundScore = 0;
//        System.out.println("Dice type: " + dice.getSides());

        System.out.println("It's " + player.getName() + "'s turn! Press Enter to roll!!!");
        String enter = CLI.getString(0, 1);
        if (CLI.scanner.hasNextLine()) {
            enter = CLI.scanner.nextLine();
        }
        if (enter.equals("")) {
            for (int i = 1; i <= numOfDice; i++) {
                dice.rollDie();
                System.out.println("Dice " + i + " rolled a " + dice.getValue() + "!");
                roundScore += dice.getValue();
            }
            player.setScore(player.getScore() + roundScore);
            Menu.flavorText(player.getName() + " rolled a total of " + roundScore + " for this round!");
//            System.out.println(player.getScore() + " The score");
        }
    }


    public void printScore(int roundNum) {
        int highestScore = 0;
        System.out.println("\n---\nTotal Scores as of Round " + roundNum + " !\n---");
        for (Player player : playerList) {
            System.out.println(player.getName() + " has a total of " + player.getScore() + " points.");

            if (player.getScore() >= highestScore) {
                highestScore = player.getScore();
            }
        }

        for (Player scores : playerList){
            if (roundNum != numOfRounds && highestScore == scores.getScore()) {
                System.out.println("\n---\n" + scores.getName() + " is in the lead with " + scores.getScore() + " points!\n---");
        } //TODO: Make a conditional that checks if multiple players have the same score.

            if (roundNum == numOfRounds && highestScore == scores.getScore()) {
                Menu.flavorText("\n---\nAnd our winner for this Dice war is..." + scores.getName() + " with " + scores.getScore() + " points! Congratulations!!!\n---");
                for (Player players : playerList) {
                    Menu.getScoreboard().add(players);
                }
                Menu.mainMenu();
            } //TODO: Make a conditional that checks if multiple players have the same score.

        }

    }

    private void generatePlayers(int numOfPlayers) {

        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Enter your name!");
            String name = CLI.getString();
            Player newPlayer = new Player(name);
            playerList.add(newPlayer);
            //scanner prompts for asking for their name
            //adding the player to the arraylist
        }
        startGame();

    }

    private ArrayList<Die> generateDice() {

        return null;
    }

}