package com.company;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> playerList = new ArrayList<Player>();
    private int numOfRounds;
    private int numOfDice;
    private Die dice;
    private int typeOfDice;
    private ArrayList<Player> winner = new ArrayList<>();

    public Game(int numOfPlayers, int numOfRounds, int typeOfDice, int numOfDice) {
        this.numOfRounds = numOfRounds;
        this.numOfDice = numOfDice;
        this.typeOfDice = typeOfDice;
        this.dice = new Die(typeOfDice);
        generatePlayers(numOfPlayers);
    }

    public void startGame() {
        CLI.flavorText("Welcome to Dice War! The rules are simple, roll the highest number of dice to win the game! This game will last for " + numOfRounds + "rounds. May you roll well!");
//        System.out.println("Dice type: " + dice.getSides());
        for (int i = 1; i <= numOfRounds; i++) {
            CLI.flavorText("Round " + i + "!...Out of " + numOfRounds);

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
            CLI.flavorText(player.getName() + " rolled a total of " + roundScore + " for this round!");
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
                winner.add(scores);
                if (winner.size() > 1){
                    System.out.println("And we have " + winner.size() + " winners! Congratulations to");
                    for (Player winner : winner) {
                        System.out.println(winner.getName() + " with " + winner.getScore() + "points!");
                    }
                }
                CLI.flavorText("\n---\nAnd our winner for this Dice war is..." + scores.getName() + " with " + scores.getScore() + " points! Congratulations!!!\n---");
                for (Player players : playerList) {
                    Menu.getScoreboard().add(players);
                }
                Menu.mainMenu();
            } //TODO: Make a conditional that checks if multiple players have the same score.

        }

    }

    private void generatePlayers(int numOfPlayers) {
        playerList.clear();
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Enter your name!");
            String name = CLI.getString();
            Player newPlayer = new Player(name);
            playerList.add(newPlayer);
            Hand hand = new Hand(); //new code added from class
            hand.setDice(generateDice());
            newPlayer.setHand(hand);
            //scanner prompts for asking for their name
            //adding the player to the arraylist
        }
        startGame();
    }

    private ArrayList<Die> generateDice() {
        ArrayList<Die>tempArr = new ArrayList<>();
        for (int i = 0; i < numOfDice; i++) {
            Die newDice = new Die(typeOfDice);
        }
        return tempArr;
    }

}