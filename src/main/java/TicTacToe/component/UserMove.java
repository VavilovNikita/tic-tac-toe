package TicTacToe.component;

import TicTacToe.model.Cell;
import TicTacToe.model.GameTable;

import java.util.Scanner;

public class UserMove {
    public void make(final GameTable gameTable) {
        System.out.println("Enter number between 1 and 9");
        String EnterNumber = new Scanner(System.in).nextLine();//считать строка
        CellNumberConverter number = new CellNumberConverter();
        if (EnterNumber.length() == 1) {
            Cell cell = number.toCell(EnterNumber.charAt(0));
            if (EnterNumber.charAt(0) >= '1' && EnterNumber.charAt(0) <= '9') {
                    if (gameTable.getSign(cell) == ' ') {
                        gameTable.setSign(cell, 'X');
                    } else {
                        System.out.println("point " + EnterNumber + " not empty. Try again");
                        make(gameTable);
                    }
            } else {
                System.out.println("invalid digit " + EnterNumber + " try again");
                make(gameTable);
            }
        } else {
            System.out.println("invalid digit " + EnterNumber + " try again");
            make(gameTable);
        }

    }
}
