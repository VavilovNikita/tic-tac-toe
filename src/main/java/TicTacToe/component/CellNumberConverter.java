package TicTacToe.component;

import TicTacToe.model.Cell;

public class CellNumberConverter {

    private final char[][] Mapping = {
            {'7', '8', '9'},
            {'4', '5', '6'},
            {'1', '2', '3'}};


//    private final char[][] Mapping = {
//            {'1', '2', '3'},
//            {'4', '5', '6'},
//            {'7', '8', '9'}};

    public Cell toCell(final char number) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Mapping[i][j] == number) {
                    return new Cell(i, j);
                }
            }
        }
        return null;
    }


    public char toNumber(final Cell cell){
        return Mapping[cell.getRow()][cell.getCol()];
    }
}
