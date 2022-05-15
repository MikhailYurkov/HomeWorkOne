package git@github.com:MikhailYurkov/HomeWorkOne.git;

import java.util.concurrent.ThreadLocalRandom;

public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println("Задание 2:");
        printThreeWords();
        System.out.println("Задание 3:");
        checkSumSign();
        System.out.println("Задание 4:");
        printColor();
        System.out.println("Задание 5:");
        compareNumbers();
    }

    private static void printThreeWords() {
        System.out.println ("Orange");
        System.out.println ("Banana");
        System.out.println ("Apple");
            }

    private static void checkSumSign() {
        int a = ThreadLocalRandom.current().nextInt(100) - 2, b = ThreadLocalRandom.current().nextInt(100) - 20, c ;
        c = a + b;
        System.out.println("Сумма чисел: " + c);
        if (c >= 0) {
            System.out.println("Сумма чисел - положительная");
        }
        else {
            System.out.println("Сумма чисел - отрицательная");
        }

    }

    private static void printColor() {
        int value = ThreadLocalRandom.current().nextInt(180) - 2;
        System.out.print(value);
        if (value <= 0) {
            System.out.println(" Красный");
        } else if ( value <= 100 ) {
            System.out.println(" Желтый");
        } else if (value > 100){
            System.out.println(" Зеленый");
        }
    }

    private static void compareNumbers() {
        int a = ThreadLocalRandom.current().nextInt(100) - 2, b = ThreadLocalRandom.current().nextInt(100) - 20;
        System.out.println("Число a: " + a);
        System.out.println("Число b: " + b);
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
