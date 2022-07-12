package jvmalgo.algos.sorting;

import java.util.Arrays;
import java.util.function.Consumer;

public class SelectionSort {

    public static Consumer<int[]> algo = list -> {
        int N = list.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (list[j] < list[i]) {
                    var tmp = list[j];
                    list[j] = list[i];
                    list[i] = tmp;
                }
            }
        }
    };

    public static void main(String[] args) {
        var list = new int[]{5, 1, 2, 4, 5, 1};
        algo.accept(list);
        System.out.println(Arrays.toString(list));
    }
}
