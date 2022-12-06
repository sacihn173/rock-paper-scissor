package com.example.rockpaperscissor.Utility;

import java.util.Arrays;
import java.util.HashSet;

public class judgeResult {

    private final static String userWins = "Player wins";
    private final static  String computerWins = "Computer wins";
    private final static String tie = "It is a tie";
    private final static  HashSet<String> gameChoices = new HashSet<>(Arrays.asList("Paper", "Rock", "Scissors"));

    public static String judgement(String userChoice, String computerChoice) {
        String gameResult;
        if(userChoice.equals(computerChoice)) {
            gameResult = tie;
        }
        else if((userChoice.equals("Rock") && computerChoice.equals("Scissors"))
                || (userChoice.equals("Paper")&& computerChoice.equals("Rock"))
                || (userChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
                gameResult = userWins;
        }
        else {
            gameResult = computerWins;
        }
        return gameResult;
    }

    public static boolean validateUserChoice(String userChoice) {
        if(gameChoices.contains(userChoice)) return true;
        else return false;
    }

}
