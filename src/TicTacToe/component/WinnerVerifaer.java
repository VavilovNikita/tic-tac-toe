package TicTacToe.component;

import TicTacToe.model.Cell;
import TicTacToe.model.GameTable;

public class WinnerVerifaer {
    public boolean isUserWin(final GameTable gameTable,char ch) {
        int setSymbol = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable.getSign(new Cell((i), (j))) == 'X') {
                setSymbol++;
                }
            }
            if(setSymbol == 3){
                return true;
            }else {
                setSymbol = 0;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable.getSign(new Cell((j), (i))) == 'X') {
                    setSymbol++;
                }
            }
            if(setSymbol == 3){
                return true;
            }else {
                setSymbol = 0;
            }
        }
        for (int i = 0; i < 3; i++) {
            if(gameTable.getSign(new Cell((i),(i))) == 'X'){
                setSymbol++;
            }
        }
        if(setSymbol == 3){
            return true;
        }else {
            setSymbol = 0;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 2; j >= 0; j--) {
                if(gameTable.getSign(new Cell((i),(j))) == 'X'){
                    setSymbol++;
                }
            }
            if(setSymbol == 3){
                return true;
            }else {
                setSymbol = 0;
            }
        }

        return false;
    }

    public boolean isComputerWin(final GameTable gameTable) {
        return isUserWin(gameTable, 'O');
    }
}
