import java.util.Scanner;
public class GameRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Word Guesser! Enter letters to make up the mystery word before you loose all your lives!");
        System.out.println("Would difficulty would you like to play, please enter \"basic\" or \"hard\": ");
        String mode = scan.nextLine();
        boolean basicMode = mode.equals("basic");


        if (basicMode) {
            Game g = new Game();
            String word = g.wordGen();
            int lives = g.getLives();
            System.out.println("Game loading...");
            System.out.println(g);
            String blank = "____";
            System.out.println(blank);


            while (lives > 0 && blank.contains("_")) {
                System.out.println("Please enter a letter in lowercase");
                String guess = scan.nextLine();
                if (word.contains(guess)) {
                    System.out.println("This letter is in the mystery word!");
                    blank = g.revealGuess(blank, guess);
                    System.out.println(blank);
                } else {
                    lives--;
                    System.out.println("This letter is not in the mystery word. -1 life");
                    System.out.println("You have " + lives + " lives left.");
                    System.out.println(blank);
                }
            }
            g.blankChecker(blank, word);

        } else {
            Game g2 = new Game(5, "hard");
            String word = g2.wordGen();
            int lives = g2.getLives();
            System.out.println("Game loading...");
            System.out.println(g2);
            String blank = "_______";
            System.out.println(blank);


            while (lives > 0 && blank.contains("_")) {
                System.out.println("Please enter a letter in lowercase");
                String guess = scan.nextLine();
                if (word.contains(guess)) {
                    System.out.println("This letter is in the mystery word!");
                    blank = g2.revealGuess(blank, guess);
                    System.out.println(blank);
                } else {
                    lives--;
                    System.out.println("This letter is not in the mystery word. -1 life");
                    System.out.println("You have " + lives + " lives left.");
                    System.out.println(blank);
                }
            }
            g2.blankChecker(blank, word);
        }
    }
}