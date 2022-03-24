package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scoreboard {

    private static List<Player> scoreboard = new ArrayList<>();

    public void showScoreboard() {
        if (scoreboard.size() != 0) {
            System.out.println("Here is the scoreboard from our previous game!");
            Collections.sort(scoreboard);
            Collections.reverse(scoreboard);
            for (int i = 0; i < scoreboard.size(); i++) {
                System.out.println((i + 1) + ") " + scoreboard.get(i).getName() + "....." + scoreboard.get(i).getScore() + " Points");
            }
        }
        CLI.flavorText(". ", 6,  "MAIN MENU");
    } //Takes the Arraylist full of the player scores from last game and shows.

    public static List<Player> getScoreboard() {
        return scoreboard;
    }
}
