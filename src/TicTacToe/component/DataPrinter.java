package TicTacToe.component;

import TicTacToe.model.Cell;
import TicTacToe.model.GameTable;

public class DataPrinter {
    public void printMappingTable(final GameTable gameTable) {
        CellNumberConverter cellNumberConverter = new CellNumberConverter();
        for (int i = 0; i < 3; i++) {
            System.out.println("_________________________________________________\n|\t\t|\t\t|\t\t|\n|\t" + cellNumberConverter.toNumber(new Cell(i,0)) +
                    "\t|\t" + cellNumberConverter.toNumber(new Cell(i,1)) + "\t|\t" + cellNumberConverter.toNumber(new Cell(i,2)) + "\t|\n|\t\t|\t\t|\t\t|");
        }
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

