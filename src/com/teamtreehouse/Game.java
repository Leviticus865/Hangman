package com.teamtreehouse;

public class Game {
    private String answer;
    private String hits;
    private String misses;
    public final int MAX_LIMIT=7;

    public Game(String answer) {
        this.answer=answer.toLowerCase();
        hits="";
        misses="";
    }

    private char normalizeGuess(char letter) {
        if(!Character.isLetter(letter)){
            throw new IllegalArgumentException("Enter a valid letter");
        }
        letter=Character.toLowerCase(letter);
        return letter;
    }

    public boolean applyGuess(char c) {
        c=normalizeGuess(c);
        boolean isHit = answer.indexOf(c) !=-1 ;
            if(isHit){
                hits+=c ;
            }
            else {
                misses+=c;
        }
        return isHit;
    }
    public String getCurrentProgress()// why this method here?? well for this method to work you need to know the answer
                                    //only Game class has the answer, while prompter
    {
        String progress = "";
        for (char letter : answer.toCharArray()) {
            if (hits.indexOf(letter) != -1) {
                progress += letter;
            } else {
                progress += '-';
            }
        }
        return progress;
    }
public int getRemainingTries() {
        return MAX_LIMIT-(misses.length());

}
  }


