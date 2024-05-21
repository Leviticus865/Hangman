import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter word to be guessed:");
        String input = console.nextLine();

        Game game = new Game(input);
        Prompter prompter = new Prompter(game);
        while (game.getRemainingTries() > 0) {
            prompter.displayProgress();
            prompter.promptForGuess();

        }
    }
}
