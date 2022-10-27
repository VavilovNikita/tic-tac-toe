package TicTacToe.component;

import TicTacToe.model.Cell;
import TicTacToe.model.GameTable;

public class WinnerVerifaer {

    public boolean isUserWin(final GameTable gameTable) {
        return isWinner(gameTable, 'X');
    }

    public boolean isComputerWin(final GameTable gameTable) {
        return isWinner(gameTable, 'O');
    }

    private boolean isWinner(GameTable gameTable, char ch) {

        return isWinnerByRows(gameTable, ch) ||
                isWinnerByCols(gameTable, ch) ||
                isWinnerByMailDiagonal(gameTable, ch) ||
                isWinnerBySecondDiagonal(gameTable, ch);
    }

    private boolean isWinnerBySecondDiagonal(final GameTable gameTable, final char ch) {
        int setSymbol = 0;
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell((i), (i))) == 'X') {
                setSymbol++;
            }
        }
        if (setSymbol == 3) {
            return true;
        } else {
            setSymbol = 0;
        }

        return false;
    }

    private boolean isWinnerByMailDiagonal(final GameTable gameTable, final char ch) {
       if(gameTable.getSign(new Cell(0,2)) == ch && gameTable.getSign(new Cell(1,1)) == ch && gameTable.getSign(new Cell(2,0)) == ch){
           return true;
       }
        return false;
    }

    private boolean isWinnerByCols(final GameTable gameTable, final char ch) {
        int setSymbol = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable.getSign(new Cell((j), (i))) == 'X') {
                    setSymbol++;
                }
            }
            if (setSymbol == 3) {
                return true;
            } else {
                setSymbol = 0;
            }
        }
        return false;
    }

    private boolean isWinnerByRows(final GameTable gameTable, final char ch) {
        int setSymbol = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable.getSign(new Cell((i), (j))) == 'X') {
                    setSymbol++;
                }
            }
            if (setSymbol == 3) {
                return true;
            } else {
                setSymbol = 0;
            }
        }
        return false;
    }
}
