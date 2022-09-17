package TicTacToe.component;

import TicTacToe.model.Cell;
import TicTacToe.model.GameTable;

import java.util.Scanner;

public class UserMove {
    public void make(final GameTable gameTable) {
        System.out.println("Enter number between 1 and 9");
        String EnterNumber = new Scanner(System.in).nextLine();//считать строка
        if (EnterNumber.length() == 1) {
            char digit = EnterNumber.charAt(0);
            if (digit >= '1' && digit <= '9') {
                char[][] MappingTable = {
                        {'7', '8', '9'},
                        {'4', '5', '6'},
                        {'1', '2', '3'}};
                for (int i = 0; i < MappingTable.length; i++) {
                    for (int j = 0; j < MappingTable[i].length; j++) {
                        if (MappingTable[i][j] == digit) {
                            if (gameTable.getSign(new Cell(i,j)) == ' ') {
                                gameTable.setSign(new Cell(i,j),'X');
                            } else {
                                System.out.println("point " + EnterNumber + " not empty. Try again");
                                make(gameTable);
                            }
                        }
                    }
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
