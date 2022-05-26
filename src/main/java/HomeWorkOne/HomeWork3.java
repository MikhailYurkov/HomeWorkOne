package HomeWorkOne;

import java.util.Arrays;

public class HomeWork3 {

    public static void main(String[] args) {
        int[] arr3 = {1, 1, 2, 2};
        System.out.println("\nЗадание 1:");
        reversArray();
        System.out.println("\nЗадание 2:");
        fillInTheArray();
        System.out.println("\nЗадание 3:");
        multiplyLessThan6();
        System.out.println("\nЗадание 4:");
        squareArray();
        System.out.println("\nЗадание 5:");
        initArray(5,1);
        System.out.println("\nЗадание 6:");
        minMaxArray();
        System.out.println("\nЗадание 7:");
        System.out.println(arrayInHalf(arr3));



    }

    private static void reversArray() {
        {
            int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) arr[i] = 0;
                else
                    arr[i] = 1;
            }

            System.out.println(Arrays.toString(arr));
        }


    }

    private static void fillInTheArray() {
        int[] arr1 = new int[100];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i+1;
        }
        System.out.println(Arrays.toString(arr1));
    }

    private static void multiplyLessThan6() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6){
                arr[i] *=  2;
            }
    }
        System.out.println(Arrays.toString(arr));
    }

    private static void squareArray() {
        int[][] sqArr = new int[3][3];
        {

            for (int i = 0; i < sqArr.length; i++) {
                for (int j = 0; j < sqArr.length; j++) {
                    if (i == j) {
                        sqArr[i][j] = 1;
                    }
                    System.out.print(sqArr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static void initArray(int len, int initialValue){
        int arr[] = new int[len];
        for (int i = 0; i < arr.length; i++){
            arr[i] = initialValue;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void minMaxArray() {
        int  [] arr  = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int max = arr[0];
        int min = arr[0];

        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        for (int j : arr) {
            if (j < min) {
                min = j;
            }
        }
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
    }

    private static boolean arrayInHalf(int[] arr3) {
        int rightSum = 0;
        int leftSum = 0;
        // Нахожу сумму всех элементов
        for (int i = 0; i < arr3.length; i++) {
            rightSum += arr3[i];
        }
        //Перебираю сумму с начала массива и сравниваю с разницей (правой частью)
        for (int i = 0; i < arr3.length; i++) {
            leftSum += arr3[i];
            if (leftSum == rightSum - leftSum) {
                return true;
            }
        }
        return false;

    }

}
