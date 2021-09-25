package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Game {

    private ArrayList<Player> playerList = new ArrayList<>();
    private ArrayList<Player> npcPlayers = new ArrayList<>();
    private int numOfRounds;
    private int numOfNPCs;
    private int numOfDice;
    private Die dice;
    private int typeOfDice;
    private int answer; //To select the type of game. 1 = Standard Dice War, 2 = DnD Dice Game.
    private Hand hand; //new code added from class
    private ArrayList<Player> winner = new ArrayList<>();

    public Game(int numOfPlayers, int numOfNPCs, int numOfRounds, int typeOfDice, int numOfDice, int answer) {
        this.numOfNPCs = numOfNPCs;
        this.numOfRounds = numOfRounds;
        this.numOfDice = numOfDice;
        this.typeOfDice = typeOfDice;
        this.dice = new Die(typeOfDice);
        this.answer = answer;
        generatePlayers(numOfPlayers);
    }

    public void startGame() {
        CLI.newTerminalScreen();
        CLI.flavorText(". ", 6, "Welcome to Dice War! The rules are simple, roll the highest number of dice to win the game! This game will last for " + numOfRounds + "rounds. May you roll well!");
//        System.out.println("Dice type: " + dice.getSides());
        for (int i = 1; i <= numOfRounds; i++) {
            CLI.flavorText(". ", 6, "Round " + i + "!...Out of " + numOfRounds);

            for (Player player : playerList) {
                playerTurn(player);
            }
            printScore(i);
            if (i != numOfRounds) {
                System.out.println("\nReady for the next round? Press enter to continue.");
                String answer = CLI.getString(0, 1);
                if (Objects.equals(answer, "")) {
                    System.out.println("Moving to round " + (i + 1) + " !");
                }
                } else {
                    System.out.println("\nThat was the Last Round! Ready to see the final scores? Press enter to continue.");
                    String answer = CLI.getString(0,1);
                    if (Objects.equals(answer, "")) {
                        System.out.println("Moving to scoring...");
                        winnerCircle();
                    }
            }
        }
    }

    public void startDnDGame() {
        CLI.newTerminalScreen();
        CLI.flavorText(". ", 6, "Welcome to the Dungeons and Dragons dice war. Here you will roll a d8, a d6, and a d4 to determine who wins each round...");
        CLI.flavorText(". ",6,  "Imagine for me if you wandered your way into a high steaks game inside of a high profile gambling table within the prestigious Glass Tower's Casino, 'The Diamond Sleight'. Win or lose is up to the roll of the dice. Who ever among you rolls highest in three rounds takes the pot...");
        for (int i = 1; i <= 3; i++) {
            CLI.flavorText(". ",6,  "Round " + i + "!...Out of " + numOfRounds);

            for (Player player : playerList) {
                playerTurn(player);
            }
            printScore(i);
            if (i + 1 != numOfRounds) {
                System.out.println("\nReady for the next round? Press enter to continue.");
                String answer = CLI.getString(0, 1);
                if (Objects.equals(answer, "")) {
                    System.out.println("Moving to round " + (i + 1) + " !");
                } else {
                    System.out.println("\nThat was the Last Round! Ready to see the final scores? Press enter to continue.");
                    if (Objects.equals(answer, "")) {
                        System.out.println("Moving to scoring...");
                    }
                }
            }
        }
    }

    private void playerTurn(Player player) {
        int roundScore = 0;
//        System.out.println("Dice type: " + dice.getSides());

        System.out.println("It's " + player.getName() + "'s turn! Press Enter to roll!!!");
        String enter = CLI.getString(0, 1);
        if (enter.equals("")) {
            hand.rollDice();
            for (int i = 0; i < hand.dice.size(); i++) {
                roundScore += hand.dice.get(i).getValue();
            }
            player.setScore(player.getScore() + roundScore);
            CLI.flavorText(". ", 6, player.getName() + " rolled a total of " + roundScore + " for this round!");
//            System.out.println(player.getScore() + " The score");
        }
    }

    public void printScore(int roundNum) {

        int highestScore = 0; //to keep track of who is leading
        CLI.flavorText("-",6, "Total Scores as of Round " + roundNum + "!");
        for (Player player : playerList) {
            System.out.println(player.getName() + " has a total of " + player.getScore() + " points.");

            if (player.getScore() >= highestScore) {
                highestScore = player.getScore();
            }
        }

        for (Player scores : playerList) {
            if (roundNum != numOfRounds && highestScore == scores.getScore()) {
                System.out.println("\n---\n" + scores.getName() + " is in the lead with " + scores.getScore() + " points!\n---");
            }

            if (roundNum == numOfRounds && highestScore == scores.getScore()) {
                winner.add(scores);
            }

        }

    }

    private void winnerCircle() {
        CLI.newTerminalScreen();
        if (winner.size() == 1) { //if there is one winner.
            CLI.flavorText(". ", 6,  "And our winner for this Dice war is..." + winner.get(0).getName() + " with " + winner.get(0).getScore() + " points! Congratulations!!!");
        } else {
            System.out.println(". ".repeat(6) + "\n");
            System.out.println("And we have " + winner.size() + " winners! Congratulations to...");
            for (Player winner : winner) {
                System.out.println(winner.getName() + " with " + winner.getScore() + " points!");
            }//Following code is for multiple winners.
            System.out.println("\n" + ". ".repeat(6));
        }
        Menu.getScoreboard().clear();//clears the board from the last game to make way for this new set of scores.
        for (Player players : playerList) {
            Menu.getScoreboard().add(players);
        }
        Menu.mainMenu();
    }

    private void generatePlayers(int numOfPlayers) {
        getNpcPlayers().clear();
        generateNPCPlayers();
        if (answer == 1) {
            playerList.clear();
            for (int i = 0; i < numOfPlayers; i++) {
                System.out.println("Enter your name!");
                String name = CLI.getString();
                Player newPlayer = new Player(name);
                playerList.add(newPlayer);
                hand = new Hand(); //creates a new Dice arraylist which is unique for each player.
                hand.setDice(generateDice());
                newPlayer.setHand(hand);
            }
            if (numOfNPCs > 1) {
                addNPCPlayers(numOfNPCs);
            }
            startGame();
        } else if (answer == 2) {
            playerList.clear();
            for (int i = 0; i < numOfPlayers; i++) {
                System.out.println("What's your name adventurer?");
                String name = CLI.getString();
                Player newPlayer = new Player(name);
                playerList.add(newPlayer);
                hand = new Hand(); //creates a new Dice arraylist which is unique for each player.
                hand.setDice(generateDnDDice());
                newPlayer.setHand(hand);
            }
            if (numOfNPCs > 1) {
                addNPCPlayers(numOfNPCs);
            }
            startDnDGame();
        }
    }

    private ArrayList<Die> generateDice() {
        ArrayList<Die> tempArr = new ArrayList<>();
        for (int i = 0; i < numOfDice; i++) {
            Die newDice = new Die(typeOfDice);
            tempArr.add(newDice);
        }
        return tempArr;
    }

    private ArrayList<Die> generateDnDDice() {
        ArrayList<Die> tempArr = new ArrayList<>();
        Die d8 = new Die(8);
        tempArr.add(d8);

        Die d6 = new Die(6);
        tempArr.add(d6);

        Die d4 = new Die(4);
        tempArr.add(d4);

        return tempArr;
    } //generates a d8, d6, and d4 Die objects and returns the arraylist.

    public void generateNPCPlayers() {
        Player npc1 = new Player("Avatar Aang");
        getNpcPlayers().add(npc1);

        Player npc2 = new Player("Cid");
        getNpcPlayers().add(npc2);

        Player npc3 = new Player("Obi-Wan");
        getNpcPlayers().add(npc3);

        Player npc4 = new Player("Princess Zelda");
        getNpcPlayers().add(npc4);

        Player npc5 = new Player("Steve Rodgers");
        getNpcPlayers().add(npc5);

        Player npc6 = new Player("Pike Trickfoot");
        getNpcPlayers().add(npc6);

        Player npc7 = new Player("Liliana Vess");
        getNpcPlayers().add(npc7);

        Player npc8 = new Player("Jester Lavore");
        getNpcPlayers().add(npc8);

        Player npc9 = new Player("Grog Strongjaw");
        getNpcPlayers().add(npc9);
    } //generates a list of non player objects and adds them to npcPlayer Arraylist

    public void addNPCPlayers(int numOfNPCs) {
        for (int i = 0; i < numOfNPCs; i++) { //Loops through to add npc Players to the game.
            int getNPC = (int) (Math.random() * numOfNPCs);
            playerList.add(npcPlayers.get(getNPC));
            getNpcPlayers().remove(getNPC); //removes from the npc Arraylist, so they cannot be chosen again for that game.
        }

    }//Takes the npcPlayer Arraylist and randomly adds x number of players based on the input from the user.

    public ArrayList<Player> getNpcPlayers() {
        return npcPlayers;
    }
}
