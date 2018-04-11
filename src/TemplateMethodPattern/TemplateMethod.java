package TemplateMethodPattern;

abstract class Game {
    private int playerCount;

    abstract void initializeGame();

    abstract void makePlay(int player);

    abstract boolean endOfGame();

    final void playOneGame(int playerCount) {
        this.playerCount = playerCount;
        initializeGame();
        while (!endOfGame()) {
            makePlay(playerCount);
        }
    }
}

class Monopoly extends Game {
    @Override
    void initializeGame() {

    }

    @Override
    void makePlay(int player) {

    }

    @Override
    boolean endOfGame() {
        return false;
    }
}

class Chess extends Game {
    @Override
    void initializeGame() {

    }

    @Override
    void makePlay(int player) {

    }

    @Override
    boolean endOfGame() {
        return false;
    }
}

public class TemplateMethod {
    public static void main(String[] args) {
        Game game = new Chess();
        game.playOneGame(9);

    }
}
