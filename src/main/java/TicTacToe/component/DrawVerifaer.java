package TicTacToe.component;

import TicTacToe.model.Cell;
import TicTacToe.model.GameTable;

public class DrawVerifaer {
    public boolean isDraw(final GameTable gameTable) {
        boolean draw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable.isEmpty(new Cell((i), (j)))) {
                    draw = false;
                }

            }
        }
        return draw;
    }
}

