package Hangman;

public class Drawer {
    private final String[] pictures =  {"""
            +---+
            |   |
            |
            |
            |
            |
            =========""", """
            +---+
            |   |
            |   O
            |
            |
            |
            =========""", """
            +---+
            |   |
            |   O
            |   |
            |
            |
            =========""", """
            +---+
            |   |
            |    O
            |   /|
            |
            |
            =========""", """
            +---+
            |   |
            |   O
            |  /|\\
            |
            =========""", """
            +---+
            |   |
            |   O
            |  /|\\
            |  /
            |
            |
            =========""", """
            +---+
            |   |
            |   O
            |  /|\\
            |  / \\
            ========="""};

    public void Draw(int state) {

        System.out.println("Your life is on the edge.... ");
        System.out.println(pictures[state]);
    }
}
