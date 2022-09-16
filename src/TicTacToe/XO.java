package TicTacToe;

import java.util.Random;
import java.util.Scanner;

public class XO {
    public static void main(String[] args) {
        char[][] gameTable = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
        printField();
        boolean UserFirstStep = ChooseFirst();
        if (!UserFirstStep) {
            makeComputerMove(gameTable);
            printGameTable(gameTable);
        }
        while (true) {
            makeUserMove(gameTable);
            printGameTable(gameTable);
            if (userWin(gameTable)) {
                System.out.println("YOU WIN!");
                break;
            }
            if (isDraw(gameTable)) {
                System.out.println("DRAW!");
                break;
            }
            makeComputerMove(gameTable);
            printGameTable(gameTable);
            if (computerWin(gameTable)) {
                System.out.println("COMPUTER WIN!");
                break;
            }
            if (isDraw(gameTable)) {
                System.out.println("DRAW!");
                break;
            }
        }
        System.out.println("GAME OVER");
        new Scanner(System.in).nextInt();//считать число
    }

    private static void makeUserMove(char[][] gameTable) {
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
                            if (gameTable[i][j] == ' ') {
                                gameTable[i][j] = 'X';
                            } else {
                                System.out.println("point " + EnterNumber + " not empty. Try again");
                                makeUserMove(gameTable);
                            }
                        }
                    }
                }
            } else {
                System.out.println("invalid digit " + EnterNumber + " try again");
                makeUserMove(gameTable);
            }
        } else {
            System.out.println("invalid digit " + EnterNumber + " try again");
            makeUserMove(gameTable);
        }


    }

    private static void makeComputerMove(char[][] gameTable) {
        if (gameTable[1][1] == ' ') {
            gameTable[1][1] = '0';
            return;
        }
        if (ifWIN(gameTable, '0')) {
            findLineAndMakeMove(gameTable, '0');
        } else if (ifWIN(gameTable, 'X')) {
            findLineAndMakeMove(gameTable, 'X');
        } else {
            find0AndMakeMove(gameTable);
        }
    }


    private static void find0AndMakeMove(char[][] gameTable) {
        boolean status0 = false;
        boolean ifEmpty = false;
        boolean findX = false;
        int[] find0 = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable[i][j] == '0') {
                    status0 = true;
                    find0[0] = i;
                    find0[1] = j;
                }
                if (gameTable[i][j] == ' ') {
                    ifEmpty = true;
                }
                if (gameTable[i][j] == 'X') {
                    findX = true;
                }

            }
            if (findX) {
                status0 = false;
                ifEmpty = false;
            }
            findX = false;
            if (status0 && ifEmpty) {//закончить если в строке есть пробел и ноль
                break;
            }
        }
        if (!status0) {
            randomMove(gameTable);
        } else if (ifEmpty) {//ищем пустые клетки рядом с 0
            int count_ = 0;
            for (int i = 0; i < 3; i++) {
                if (gameTable[find0[0]][i] == ' ') {
                    count_++;
                }
            }
            if (count_ == 2) {
                for (int i = 0; i < 3; i++) {
                    if (gameTable[find0[0]][i] == ' ') {
                        gameTable[find0[0]][i] = '0';
                        return;
                    }
                }
                count_ = 0;
                for (int i = 0; i < 3; i++) {
                    if (gameTable[find0[1]][i] == ' ') {
                        count_++;
                    }
                }
                if (count_ == 2) {
                    for (int i = 0; i < 3; i++) {
                        if (gameTable[find0[1]][i] == ' ') {
                            gameTable[find0[1]][i] = '0';
                            return;
                        }
                    }
                } else {
                    randomMove(gameTable);
                }
            }
        }
    }

    private static void randomMove(char[][] gameTable) {
        while (true) {
            int row = new Random().nextInt(3);
            int string = new Random().nextInt(3);
            if (gameTable[row][string] == ' ') {
                gameTable[row][string] = '0';
                break;
            }
        }
    }


    private static void findLineAndMakeMove(char[][] gameTable, char ch) {
        int countCH = 0;
        int count_ = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable[i][j] == ch) {
                    countCH++;
                }
                if (gameTable[i][j] == ' ') {
                    count_++;
                }
            }
            if (countCH == 2 && count_ == 1) {
                for (int j = 0; j < 3; j++) {
                    if (gameTable[i][j] == ' ') {
                        gameTable[i][j] = '0';
                        return;
                    }
                }
            } else {
                countCH = 0;
                count_ = 0;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable[j][i] == ch) {
                    countCH++;
                }
                if (gameTable[j][i] == ' ') {
                    count_++;
                }
            }
            if (countCH == 2 && count_ == 1) {
                for (int j = 0; j < 3; j++) {
                    if (gameTable[j][i] == ' ') {
                        gameTable[j][i] = '0';
                        return;
                    }
                }
            } else {
                countCH = 0;
                count_ = 0;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (gameTable[i][i] == ch) {
                countCH++;
            }
            if (gameTable[i][i] == ' ') {
                count_++;
            }
        }
        if (countCH == 2 && count_ == 1) {
            for (int j = 0; j < 3; j++) {
                if (gameTable[j][j] == ' ') {
                    gameTable[j][j] = '0';
                    return;
                }
            }
        } else {
            countCH = 0;
            count_ = 0;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 2; j >= 0; j--) {
                if (gameTable[i][j] == ch) {
                    countCH++;
                }
                if (gameTable[i][j] == ' ') {
                    count_++;
                }
            }
        }
        if (countCH == 2 && count_ == 1) {
            for (int i = 0; i < 3; i++) {
                for (int j = 2; j >= 0; j--) {
                    if (gameTable[i][j] == ' ') {
                        gameTable[i][j] = '0';
                        return;
                    }
                }
            }
        }

    }

    private static boolean ifWIN(char[][] gameTable, char ch) {
        int countCH = 0;
        int count_ = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable[i][j] == ch) {
                    countCH++;
                }
                if (gameTable[i][j] == ' ') {
                    count_++;
                }
            }
            if (countCH == 2 && count_ == 1) {
                return true;
            } else {
                countCH = 0;
                count_ = 0;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable[j][i] == ch) {
                    countCH++;
                }
                if (gameTable[j][i] == ' ') {
                    count_++;
                }
            }
            if (countCH == 2 && count_ == 1) {
                return true;
            } else {
                countCH = 0;
                count_ = 0;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (gameTable[i][i] == ch) {
                countCH++;
            }
            if (gameTable[i][i] == ' ') {
                count_++;
            }
        }
        if (countCH == 2 && count_ == 1) {
            return true;
        } else {
            countCH = 0;
            count_ = 0;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 2; j >= 0; j--) {
                if (gameTable[i][j] == ch) {
                    countCH++;
                }
                if (gameTable[i][j] == ' ') {
                    count_++;
                }
            }

        }
        return countCH == 2 && count_ == 1;
    }

    private static boolean userWin(char[][] gameTable) {
        return isWinner(gameTable, 'X');
    }

    private static boolean computerWin(char[][] gameTable) {
        return isWinner(gameTable, '0');
    }

    private static boolean isWinner(char[][] gameTable, char ch) {
        boolean win = false;
        for (char[] chars : gameTable) {
            if (chars[0] == ch && chars[1] == ch && chars[2] == ch) {
                win = true;
                break;
            }
        }
        for (int i = 0; i < gameTable.length; i++) {
            if (gameTable[0][i] == ch && gameTable[1][i] == ch && gameTable[2][i] == ch) {
                win = true;
                break;
            }
        }
        if (gameTable[0][0] == ch && gameTable[1][1] == ch && gameTable[2][2] == ch) {
            win = true;
        }
        if (gameTable[2][0] == ch && gameTable[1][1] == ch && gameTable[0][2] == ch) {
            win = true;
        }
        return win;
    }

    private static boolean isDraw(char[][] gameTable) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean ChooseFirst() {
        while (true){
            System.out.println("Do you want to go first? enter \"y\" and then enter \"n\"");
            String FirstStep = new Scanner(System.in).nextLine();//считать строка
            if (FirstStep.equals("y")) {
                System.out.println("You go first");
                return true;
            } else if (FirstStep.equals("n")) {
                System.out.println("Computer go first");
                return false;
            } else {
                System.out.println("invalid command " + FirstStep + " try again");
            }
        }
    }

    private static void printGameTable(char[][] gameTable) {
        for (int i = 0; i < 3; i++) {
            System.out.println("_________________________________________________\n|\t\t|\t\t|\t\t|\n|\t" + gameTable[i][0] +
                    "\t|\t" + gameTable[i][1] + "\t|\t" + gameTable[i][2] + "\t|\n|\t\t|\t\t|\t\t|");
        }
        System.out.println("_________________________________________________");
    }

    private static void printField() {
        char[][] gameTable = {
                {'7', '8', '9'},
                {'4', '5', '6'},
                {'1', '2', '3'}};
        printGameTable(gameTable);

    }
}
