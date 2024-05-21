import java.util.Scanner;

public class Prompter {
    private Game game;

    /**
     * Displays game with length of word
     * @param game the string output of the set word
     */
    public Prompter(Game game)
    {
        this.game = game;
    }

    /**
     * Prompts user to guess a letter
     * @return user input
     */
    public boolean promptForGuess() {

        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        boolean isHit = false;
        do {
            System.out.println("Enter a letter :");
            String guessinput = scanner.nextLine();
            char letter = guessinput.charAt(0);
            try {
                isHit = game.applyGuess(letter);
                check = true;
            } catch (IllegalArgumentException iae) {
                System.out.printf("Try again pal %s%n", iae.getMessage());
            }

        } while (!check);
        return isHit;
    }

    /**
     * Displays amount of tries left with current progress shown
     */
    public void displayProgress() {
        System.out.printf("You %d chances left to solve %s %n :", game.getRemainingTries(), game.getCurrentProgress());
    }
}
