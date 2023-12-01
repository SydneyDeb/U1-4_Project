public class Game {
    private int lives;
    private String word;
    private String difficulty;


    public Game(int lives, String difficulty) {
        this.lives = lives;
        this.difficulty = difficulty;
    }

    public Game() {
        lives = 6;
        difficulty = "easy";
    }

    public String wordGen() {
        int num = (int) (Math.random() * 5) + 1;
        if (difficulty.equals("easy")) {
            if (num == 1) {
                word = "bean";
            }
            else if (num == 2) {
                word = "dark";
            }
            else if (num == 3) {
                word = "vain";
            }
            else if (num == 4) {
                word = "idol";
            }
            else {
                word = "acai";
            }
        }
        else {
            if (num == 1) {
                word = "kitchen";
            }
            else if (num == 2) {
                word = "edition";
            }
            else if (num == 3) {
                word = "country";
            }
            else if (num == 4) {
                word = "genetic";
            }
            else {
                word = "stomach";
            }
        }
        return word;
    }

    public int getLives () {
        return lives;
    }

    public String toString() {
        return "You have " + lives + " lives and you are on " + difficulty + " mode.";
    }


    public String revealGuess(String blank, String guess) {
        String str = word;
        int index = str.indexOf(guess);
        while (index != -1) {
            blank = blank.substring(0, index) + guess + blank.substring(index + 1);
            str = str.substring(0, index) + "*" + str.substring(index + 1);
            index = str.indexOf(guess);
        }
        return blank;
    }

    public void blankChecker(String blank, String word) {
        if (blank.contains("_")) {
            System.out.println("You lost! Better luck next time.");
            System.out.println("The mystery word was: " + word);
        }
        else {
            System.out.println("You Win! Great work.");
        }
    }
}
