package com.teamtreehouse;

import java.util.Scanner;

public class Prompter {
private Game game;

    public Prompter(Game game) //we dont have any other option apart from doin this if we use Game game=new Game();
    {
        this.game = game;
    }                            //then that wont be valid, as Game construction is parametrized.Also, We can not pass the answer
                                     // to the prompter because its front end and shouod be kept isolated
     public boolean promptForGuess() {

         Scanner scanner = new Scanner(System.in);
         boolean check = false;
         boolean isHit=false;
         do {// this loop cause prompter will keep asking for a letter
             //so this loop will keep runing as long as exception is thrown and this check variable is a way to chech no. of times exception is thrown
             System.out.println("Enter a letter :");
             String guessinput = scanner.nextLine();
             char letter = guessinput.charAt(0);
             try {
                isHit= game.applyGuess(letter);
                 check = true;
             } catch (IllegalArgumentException iae) {
                 System.out.printf("Try again pal %s%n",iae.getMessage()); }

         } while (!check);
         return isHit;
     }
    public void displayProgress() {
        System.out.printf("You %d chances left to solve %s %n :",game.getRemainingTries(),game.getCurrentProgress());
    }

}
