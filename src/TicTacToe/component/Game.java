package TicTacToe.component;

import TicTacToe.model.GameTable;

import java.util.Random;

public class Game {

    private final DataPrinter dataPrinter;
    private final ComputerMove computerMove;
    private final UserMove userMove;
    private final WinnerVerifaer winnerVerifaer;
    private final DrawVerifaer drawVerifaer;

    public Game(final DataPrinter dataPrinter,
                final ComputerMove computerMove,
                final UserMove userMove,
                final WinnerVerifaer winnerVerifaer,
                final DrawVerifaer drawVerifaer) {
        this.dataPrinter = dataPrinter;
        this.computerMove = computerMove;
        this.userMove = userMove;
        this.winnerVerifaer = winnerVerifaer;
        this.drawVerifaer = drawVerifaer;
    }


    public void play() {
        final GameTable gameTable = new GameTable();
        System.out.println("HELLO");
        dataPrinter.printMappingTable(gameTable);
        if (new Random().nextBoolean()) {
            computerMove.make(gameTable);
            dataPrinter.printGameTable(gameTable);
        }
        while (true) {
            userMove.make(gameTable);
            dataPrinter.printGameTable(gameTable);
            if (winnerVerifaer.isUserWin(gameTable)) {
                System.out.println("YOU WIN");
                break;
            }
            if (drawVerifaer.isDraw(gameTable)) {
                System.out.println("DRAW");
                break;
            }
            computerMove.make(gameTable);
            dataPrinter.printGameTable(gameTable);
            if (winnerVerifaer.isComputerWin(gameTable)) {
                System.out.println("COMPUTER WIN");
                break;
            }
            if (drawVerifaer.isDraw(gameTable)) {
                System.out.println("DRAW");
                break;
            }
        }
        System.out.println("GAME OVER");
    }
}
