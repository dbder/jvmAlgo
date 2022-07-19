package jvmalgo.algos.sorting.intArray;

import java.util.function.Consumer;

import static jvmalgo.algos.sorting.intArray.IntArrHelper.isSorted;
import static jvmalgo.algos.sorting.intArray.IntArrHelper.merge;

/**
 * stable if the merge is stable ( here the merge takes the left first on same, so stable )
 */
public class BottomUpMerge {


    public static Consumer<int[]> algo = arr -> {

        int N = arr.length;
        int[] aux = new int[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(arr, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }

        assert isSorted(arr) : "array is not sorted";
    };

}
