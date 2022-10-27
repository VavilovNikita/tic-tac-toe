package TicTacToe;

import TicTacToe.component.*;

public class Launcher {
    public static void main(String[] args) {
        final Game game = new Game(new DataPrinter(),
                new ComputerMove(),
                new UserMove(),
                new WinnerVerifaer(),
                new DrawVerifaer());

        game.play();
    }
}
