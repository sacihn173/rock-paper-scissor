package com.example.rockpaperscissor.Controller;

import com.example.rockpaperscissor.Utility.judgeResult;
import com.example.rockpaperscissor.Utility.randomResultGenerator;
import com.example.rockpaperscissor.resultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class HomeController {

    @Autowired
    randomResultGenerator randomresultgenerator;

    @GetMapping("/judge/{choice}")
    public ResponseEntity<?> getGameResult(@PathVariable("choice") String userChoice) {
        if(judgeResult.validateUserChoice(userChoice)) {
            Logger.getLogger(HomeController.class.getName()).log(Level.INFO, "Valid Choice Passed");

            String computerChoice = randomresultgenerator.generateRandomChoice();
            Logger.getLogger(HomeController.class.getName()).log(Level.INFO, "Computer choice : " +
                    computerChoice + ", User Choice : " + userChoice);

            String judgement = judgeResult.judgement(userChoice,computerChoice);
            Logger.getLogger(HomeController.class.getName()).log(Level.INFO, "Judgement : " + judgement);

            return ResponseEntity.ok(new resultResponse(judgement));
        }
        else {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, "Invalid request, Bad Choice : "
                    + userChoice);
            return ResponseEntity.status(400).body("Invalid Choice : " + userChoice);
        }
    }

}
