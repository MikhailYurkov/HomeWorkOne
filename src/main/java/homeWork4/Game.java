package homeWork4;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private static final int SIZE = 3;

    private static final char DOT_EMPTY = '.';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';

    private static final int WIN_SIZE = 3;

    private static char[][] MAP = new char[SIZE][SIZE];
    private static final String SPACE_MAP = "\t";
    private static final String HEAD_FIRST_SYMBOL = " ";

    private static Scanner in = new Scanner(System.in);
    private static Random random = new Random();
    private static int turnsCount = 0;
    private int rowNumber;
    int lastTurnRowNumber = rowNumber;
    private int columNumber;
    int lastTurnColumNumber = columNumber;


    public static void turnGame() {
        do {
            System.out.println("\n\nДа начнется игра!");
            init();
            printMap();
            playGame();
        } while (isContinueGame());
        endGame();
    }

    private static void init() {
        initMap();
        turnsCount = 0;
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printMapHead();
        printMapBody();
    }

    private static void printMapHead() {
        System.out.print(HEAD_FIRST_SYMBOL + SPACE_MAP);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + SPACE_MAP);
    }

    private static void printMapBody() {
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + SPACE_MAP);

            }
            System.out.println();
        }
    }

    private static void playGame() {
        while (true) {
            humanTurn();
            printMap();
            if (checkEnd(DOT_HUMAN)) {
                break;
            }

            aiTurn();
            printMap();
            if (checkEnd(DOT_AI)) {
                break;
            }
        }
    }

    private static void humanTurn() {
        System.out.println("Ход человека");

        int rowNumber;
        int columnNumber;

        while (true) {
            System.out.print("Введите номер строки:");
            rowNumber = in.nextInt() - 1;

            System.out.print("Введите номер столбца:");
            columnNumber = in.nextInt() - 1;

            if (isCellFree(rowNumber, columnNumber)) {
                break;
            }
            System.out.printf("Ячейка с координатами: %d:%d уже занята или за рамками поля%n%n", rowNumber + 1, columnNumber + 1);
        }


        MAP[rowNumber][columnNumber] = DOT_HUMAN;
        turnsCount++;
    }

    private static boolean isCellFree(int rowNumber, int columnNumber) {
        if (rowNumber < 0 || rowNumber >= SIZE || columnNumber < 0 || columnNumber >= SIZE) return false;
        if (MAP[rowNumber][columnNumber] == DOT_EMPTY) return true;
        return false;
    }

    private static boolean checkEnd(char symbol) {
        if (checkWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("Вы победили!");
            } else {
                System.out.println("Тебя обыграли");
            }
            return true;
        }
        if (chekDraw()) {
            System.out.println("Ничья");
            return true;
        }

        return false;
    }

    private static boolean chekDraw() {
        return turnsCount >= SIZE * SIZE;
    }


    private static boolean checkWin(char symbol) {
        if (true) ;

      /*  if (MAP[0][0] == symbol && MAP[0][1] == symbol && MAP[0][2] == symbol) return true;
        if (MAP[1][0] == symbol && MAP[1][1] == symbol && MAP[1][2] == symbol) return true;
        if (MAP[2][0] == symbol && MAP[2][1] == symbol && MAP[2][2] == symbol) return true;
        if (MAP[0][0] == symbol && MAP[1][0] == symbol && MAP[2][0] == symbol) return true;
        if (MAP[0][1] == symbol && MAP[1][1] == symbol && MAP[2][1] == symbol) return true;
        if (MAP[0][2] == symbol && MAP[1][2] == symbol && MAP[2][2] == symbol) return true;
        if (MAP[0][2] == symbol && MAP[1][1] == symbol && MAP[2][0] == symbol) return true;
        if (MAP[0][0] == symbol && MAP[1][1] == symbol && MAP[2][2] == symbol) return true;*/
        return false;

    }

    private static void aiTurn() {
        System.out.println("Ход ИИ");

        int rowNumber;
        int columnNumber;
        do {
            rowNumber = random.nextInt(SIZE);
            columnNumber = random.nextInt(SIZE);
        } while (!isCellFree(rowNumber, columnNumber));

        MAP[rowNumber][columnNumber] = DOT_AI;
        turnsCount++;
    }

    private static boolean isContinueGame() {
        System.out.println("Хотетие продолжить y\\n");
        return switch (in.next()) {
            case "y", "yes", "Д", "Да", "+" -> true;
            default -> false;
        };

    }

    private static void endGame() {
        in.close();
        System.out.println("Возвращайся!");
    }

}

