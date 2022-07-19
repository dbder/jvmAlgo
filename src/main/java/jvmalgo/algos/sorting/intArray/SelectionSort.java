package jvmalgo.algos.sorting.intArray;

import java.util.function.Consumer;

/**
 * not stable
 */
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
}
