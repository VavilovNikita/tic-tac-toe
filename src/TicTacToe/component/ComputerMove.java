package TicTacToe.component;

import TicTacToe.model.Cell;
import TicTacToe.model.GameTable;

import java.util.Random;

public class ComputerMove {

    public void make(GameTable gameTable){
        while (true) {
            int row = new Random().nextInt(3);
            int string = new Random().nextInt(3);
            if (gameTable.getSign(new Cell((row),(string))) == ' ') {
                gameTable.setSign(new Cell((row),(string)),'O');
                break;
            }
        }
    }
}
