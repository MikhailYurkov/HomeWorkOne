package TicTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final int SIZE = 3;

    private static final char DOT_EMPTY = '•';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';

    private final static char[][] MAP = new char[SIZE][SIZE];
    public static int WIN_SIZE = 3;
    public static final String HEADER_FIRST_SYMBOL = "♥";
    public static final String SPACE_MAP = "    ";

    private static Scanner in = new Scanner(System.in);
    private static Random random = new Random();
    public static int rowNumber;
    public static int columnNumber;


    private static int turnsCount = 0;

    public static void main(String[] args) {
        turnGame();

    }

    public static void turnGame() {
        do {
            System.out.println("Игра начинатеся!");
            init();
            printMap();
            playGame();
        } while (isRestGame());
        endGame();
    }

    private static void endGame() {
        in.close();
        System.out.println("Приходи еще");
    }

    private static boolean isRestGame() {
        System.out.println(" хотите продолжить? y\\n");
        return switch (in.next()) {
            case "y", "yes", "+", "да" -> true;
            default -> false;
        };
    }

    private static void init() {
        turnsCount = 0;
        //получить размер поля
        //Победная серия фишек для поля
        //3-6 - 3шт.
        //7-10 - 4
        // 10+ - 5 шт.
        initMap();
    }


    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printMapHeader();
        printMapBody();
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + SPACE_MAP);
    }

    private static void printMapHeader() {
        System.out.print(HEADER_FIRST_SYMBOL + SPACE_MAP);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printMapBody() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + SPACE_MAP);
            }
            System.out.println("    ");
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
        System.out.println("ход человека");


        while (true) {
            System.out.print("Введите координату строки: ");
            rowNumber = getValidNumberFromScanner() - 1;
            System.out.print("Введите координату столбца: ");
            columnNumber = getValidNumberFromScanner() - 1;
            if (isCellFree(rowNumber, columnNumber)) {
                break;
            }
            System.out.printf("Ячейка с координатами %d:%d уже зяната%n", rowNumber + 1, columnNumber + 1);
        }


        MAP[rowNumber][columnNumber] = DOT_HUMAN;
        turnsCount++;

    }

    private static int getValidNumberFromScanner() {
        while (true) {
            if (in.hasNextInt()) {
                int n = in.nextInt();
                if (isNumberValid(n)) {
                    return n;
                }
                System.out.println("Проверьте значение координаты, должно быть от 1 до " + SIZE);
            } else {
                System.out.println("Ввод допускает только числа");
                in.next();
            }
        }
    }

    private static boolean isNumberValid(int n) {
        return n >= 1 && n <= SIZE;
    }

    private static boolean isCellFree(int rowNumber, int columnNumber) {
        return MAP[rowNumber][columnNumber] == DOT_EMPTY;
    }

    private static void aiTurn() {
        System.out.println("ход компьютера!");
        int rowNumber;
        int columnNumber;

        do {
            rowNumber = random.nextInt(SIZE);
            columnNumber = random.nextInt(SIZE);
        } while (!isCellFree(rowNumber, columnNumber));
        MAP[rowNumber][columnNumber] = DOT_AI;
        turnsCount++;
    }

    private static boolean checkEnd(char symbol) {

        if (checkWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("ТЫ выиграл!");
            } else {
                System.out.println("Комп победил");
            }
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    private static boolean checkDraw() {
        return turnsCount >= SIZE * SIZE;
    }

    private static boolean checkWin(char symbol) {/*
        if (MAP[0][0] == symbol && MAP[0][1] == symbol && MAP[0][2] == symbol) return
                true;
        if (MAP[1][0] == symbol && MAP[1][1] == symbol && MAP[1][2] == symbol) return
                true;
        if (MAP[2][0] == symbol && MAP[2][1] == symbol && MAP[2][2] == symbol) return
                true;
        if (MAP[0][0] == symbol && MAP[1][0] == symbol && MAP[2][0] == symbol) return
                true;
        if (MAP[0][1] == symbol && MAP[1][1] == symbol && MAP[2][1] == symbol) return
                true;
        if (MAP[0][2] == symbol && MAP[1][2] == symbol && MAP[2][2] == symbol) return
                true;
        if (MAP[0][0] == symbol && MAP[1][1] == symbol && MAP[2][2] == symbol) return
                true;
        if (MAP[2][0] == symbol && MAP[1][1] == symbol && MAP[0][2] == symbol) return
                true;
        return false;
    }*/
        int countV;
        int countH;
        int countDiagonalA = 0;
        int countDiagonalB = 0;
        for (int i = 0; i <= SIZE - 1; i++) {
            countH = 0;
            countV = 0;
            for (int j = 0; j <= SIZE - 1; j++) {
                //Горизонталь
                if (MAP[i][j] == symbol) {
                    countH++;
                    if (countH == SIZE) return true;
                }

                //Вертикаль
                if (MAP[j][i] == symbol) {
                    countV++;
                    if (countV == SIZE) return true;
                }
            }

            // Диагональ "\"
            if (MAP[i][i] == symbol) {
                countDiagonalA++;
                if (countDiagonalA == SIZE) return true;
            } else countDiagonalA = 0;

            // Диагональ  "/"
            if (MAP[i][SIZE - 1 - i] == symbol) {
                countDiagonalB++;
                if (countDiagonalB == SIZE) return true;
            } else countDiagonalB = 0;
        }
        return false;
    }}
