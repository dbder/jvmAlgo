package jvmalgo.algos.sorting;

import java.util.function.Consumer;

public class InsertionSort {


    public static final Consumer<int[]> algo = list -> {
        int N = list.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (list[j] < list[j - 1]) {
                    var tmp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = tmp;
                }
            }
        }
    };
}
