package TicTacToe.component;

import TicTacToe.model.Cell;
import TicTacToe.model.GameTable;

public class DataPrinter {
    public void printMappingTable(final GameTable gameTable) {
        System.out.println("_________________________________________________\n|\t\t|\t\t|\t\t|\n|\t" + 1 +
                "\t|\t" + 2 + "\t|\t" + 3 + "\t|\n|\t\t|\t\t|\t\t|");
        System.out.println("_________________________________________________\n|\t\t|\t\t|\t\t|\n|\t" + 4 +
                "\t|\t" + 5 + "\t|\t" + 6 + "\t|\n|\t\t|\t\t|\t\t|");
        System.out.println("_________________________________________________\n|\t\t|\t\t|\t\t|\n|\t" + 7 +
                "\t|\t" + 8 + "\t|\t" + 9 + "\t|\n|\t\t|\t\t|\t\t|");
        System.out.println("_________________________________________________");
    }

    public void printGameTable(final GameTable gameTable) {
        for (int i = 0; i < 3; i++) {
            System.out.println("_________________________________________________\n|\t\t|\t\t|\t\t|\n|\t" + gameTable.getSign(new Cell(i, 0)) +
                    "\t|\t" + gameTable.getSign(new Cell(i, 1)) + "\t|\t" + gameTable.getSign(new Cell(i, 2)) + "\t|\n|\t\t|\t\t|\t\t|");
        }
        System.out.println("_________________________________________________");
    }
}

