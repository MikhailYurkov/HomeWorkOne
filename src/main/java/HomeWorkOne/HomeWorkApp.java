package HomeWorkOne;

import java.util.concurrent.ThreadLocalRandom;

public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println("Çàäàíèå 2:");
        printThreeWords();
        System.out.println("Çàäàíèå 3:");
        checkSumSign();
        System.out.println("Çàäàíèå 4:");
        printColor();
        System.out.println("Çàäàíèå 5:");
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
        System.out.println("Ñóììà ÷èñåë: " + c);
        if (c >= 0) {
            System.out.println("Ñóììà ÷èñåë - ïîëîæèòåëüíàÿ");
        }
        else {
            System.out.println("Ñóììà ÷èñåë - îòðèöàòåëüíàÿ");
        }

    }

    private static void printColor() {
        int value = ThreadLocalRandom.current().nextInt(180) - 2;
        System.out.print(value);
        if (value <= 0) {
            System.out.println(" Êðàñíûé");
        } else if ( value <= 100 ) {
            System.out.println(" Æåëòûé");
        } else if (value > 100){
            System.out.println(" Çåëåíûé");
        }
    }

    private static void compareNumbers() {
        int a = ThreadLocalRandom.current().nextInt(100) - 2, b = ThreadLocalRandom.current().nextInt(100) - 20;
        System.out.println("×èñëî a: " + a);
        System.out.println("×èñëî b: " + b);
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
