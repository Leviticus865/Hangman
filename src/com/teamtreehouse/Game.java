package com.teamtreehouse;

public class Game {
    private String answer;
    private String hits;
    private String misses;
    public final int MAX_LIMIT = 7;

    public Game(String answer) {
        this.answer = answer.toLowerCase();
        hits = "";
        misses = "";
    }

    /**
     * Takes letter input and checks for normal-ness
     *
     * @param letter the letter input from user
     * @return the letter
     */
    private char normalizeGuess(char letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("Enter a valid letter");
        }
        letter = Character.toLowerCase(letter);
        return letter;
    }

    /**
     * Applies letter input to char to be displayed
     *
     * @param c the index that letter
     * @return isHit True if letter is in word/False if letter isn't in word
     */
    public boolean applyGuess(char c) {
        c = normalizeGuess(c);
        boolean isHit = answer.indexOf(c) != -1;
        if (isHit) {
            hits += c;
        } else {
            misses += c;
        }
        return isHit;
    }

    /**
     * Checks progress with answer
     *
     * @return progress
     */
    public String getCurrentProgress()//Well for this method to work you need to know the answer
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

    /**
     * Gets number of tries left
     *
     * @return number of tries left
     */
    public int getRemainingTries() {
        return MAX_LIMIT - (misses.length());

    }
}


