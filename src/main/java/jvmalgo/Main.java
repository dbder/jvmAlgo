package jvmalgo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

    static final Random rnd = new Random();

    public static void main(String[] args) {

        int[] arr = {1, 5, 4, 7, 5, 9, 8, 3};

        System.out.println("INCREASING");
        sort(arr, (a, b) -> a - b);
        System.out.println(Arrays.toString(arr));
        System.out.println("");
        System.out.println("DECREASING");
        sort(arr, (a, b) -> b - a);
        System.out.println(Arrays.toString(arr));
        System.out.println("");
        System.out.println("RANDOM");
        sort(arr, (a, b) -> rnd.nextInt());
        System.out.println(Arrays.toString(arr));
        System.out.println("");
        System.out.println("RANDOM");
        sort(arr, (a, b) -> rnd.nextInt());
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, Comparator<Integer> comparator) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
