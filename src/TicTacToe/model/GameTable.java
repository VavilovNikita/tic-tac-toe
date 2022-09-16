package TicTacToe.model;

public class GameTable {

    private final char[][] table = {
            {' ',' ',' '},
            {' ',' ',' '},
            {' ',' ',' '}};

    public boolean  isEmpty(final Cell cell){
        return table[cell.getRow()][cell.getCol()] == ' ';
    }

    public char getSign(final Cell cell){
        return table[cell.getRow()][cell.getCol()];
    }

    public void cetSign(final Cell cell, final char sign){
        table[cell.getRow()][cell.getCol()] = sign;
    }
}
