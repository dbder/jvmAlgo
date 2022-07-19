package jvmalgo.algos.sorting.intArray;

import jvmalgo.global.Global;

import java.util.Arrays;

public class IntArrHelper {


    /**
     * Part of Mergesort algo.
     * <p>
     * sorts range lo-hi by:
     * copying: lo-mid and mid+1-hi  to aux.
     * then it will copy that range back sorted ( stable )
     *
     * @param aux Must be provided ( same size as a, or at least hi ).
     */
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

    /**
     * returns true is arr is sorted
     */
    static boolean isSorted(int[] arr) {
        var clone = arr.clone();
        Arrays.sort(clone);
//        clone[0] =0;
        return Arrays.compare(clone, arr) == 0;
    }

    /**
     * swaps item at index 'i' with item at index 'j'
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void shuffle(int[] arr) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            int j = Global.RND.nextInt(N);
            swap(arr, i, j);
        }
    }
}
