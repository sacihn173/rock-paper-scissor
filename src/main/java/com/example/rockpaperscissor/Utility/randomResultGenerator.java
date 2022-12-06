package com.example.rockpaperscissor.Utility;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class randomResultGenerator {

    private final String[] options = {"Rock", "Paper", "Scissors"};

    public String generateRandomChoice() {
        Random random = new Random();
        int randomChoice = random.nextInt(3);
        return options[randomChoice];
    }

}
