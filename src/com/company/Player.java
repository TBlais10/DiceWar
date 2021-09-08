package com.company;

public class Player implements Comparable<Player> {

    private String name;
    private int score;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    @Override
    public int compareTo(Player anotherScore) {
        return this.score - anotherScore.getScore();
    }
}
