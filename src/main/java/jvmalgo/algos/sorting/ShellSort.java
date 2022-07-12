package jvmalgo.algos.sorting;

import java.util.function.Consumer;

public class ShellSort {

    public static final Consumer<int[]> algo = arr -> {
        int N = arr.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                    var tmp = arr[j];
                    arr[j] = arr[j - h];
                    arr[j - h] = tmp;
                }
            }
            h = h/3;
        }
    };
}
