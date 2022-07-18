package jvmalgo.algos.sorting;

import java.util.Arrays;
import java.util.function.Consumer;


/**
 * stable if the merge is stable ( here the merge takes the left first on same, so stable )
 */
public class MergeSort {

    public static Consumer<int[]> algo = list -> {
        var aux = new int[list.length];
        sort(list, aux, 0, list.length-1);
        assert isSorted(list) : "array is not sorted";
    };


    static boolean isSorted(int[] arr) {
        var clone = arr.clone();
        Arrays.sort(clone);
//        clone[0] =0;
        return Arrays.compare(clone, arr) == 0;
    }


    private static void sort(int[] a, int[] aux, int lo, int hi) {

        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
//        if (a[mid +1] < a[mid]) {
            merge(a, aux, lo, mid, hi);
//        }
    }

    static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j] < aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }


}
