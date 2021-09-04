package com.company;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> playerList = new ArrayList<Player>();
    private int numOfRounds;
    private int numOfDice;
    private Player winner;

    public Game(int numOfPlayers, int numOfRounds, int numOfDice) {
        this.numOfRounds = numOfRounds;
        this.numOfDice = numOfDice;
        generatePlayers(numOfPlayers);
    }

    public void startGame(){

    }

    private void playerTurn(Player player){

    }

    public void printScore(){

    }

    private void generatePlayers(int numOfPlayers){

        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Enter your name!");
            String name = CLI.getString();
            Player newPlayer = new Player(name, 0);
            playerList.add(newPlayer);
            //scanner prompts for asking for their name
            //adding the player to the arraylist
        }

    }

    private ArrayList<Die> generateDice(){

        return null;
    }

}