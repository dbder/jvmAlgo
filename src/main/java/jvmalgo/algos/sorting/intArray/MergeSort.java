package jvmalgo.algos.sorting.intArray;

import java.util.Arrays;
import java.util.function.Consumer;

import static jvmalgo.algos.sorting.intArray.IntArrHelper.isSorted;
import static jvmalgo.algos.sorting.intArray.IntArrHelper.merge;


/**
 * stable if the merge is stable ( here the merge takes the left first on same, so stable )
 */
public class MergeSort {

    public static Consumer<int[]> algo = list -> {
        var aux = new int[list.length];
        sort(list, aux, 0, list.length-1);
        assert isSorted(list) : "array is not sorted";
    };





    private static void sort(int[] a, int[] aux, int lo, int hi) {

        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
//        if (a[mid +1] < a[mid]) {
            merge(a, aux, lo, mid, hi);
//        }
    }



}
