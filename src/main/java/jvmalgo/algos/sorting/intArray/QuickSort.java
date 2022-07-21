package jvmalgo.algos.sorting.intArray;

import jvmalgo.generators.IntArrGen;

import java.util.Arrays;
import java.util.function.Consumer;

import static jvmalgo.algos.sorting.intArray.IntArrHelper.*;

/**
 * in place
 * not stable
 * <a href="https://www.coursera.org/learn/algorithms-part1/lecture/vjvnC/quicksort">Quicksort lecture/code</a>
 */
public class QuickSort {


    public static Consumer<int[]> algo = (arr) -> {
        shuffle(arr);
        sort(arr, 0, arr.length - 1);
        assert isSorted(arr) : "Not sorted: " + Arrays.toString(arr);
    };

    private static void sort(int[] arr, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (a[++i] < a[lo]) {
                if (i == hi) break;
            }
            while (a[lo] < a[--j]) {
                if (j == lo) break;
            }
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        var arr = IntArrGen.sortedASCOfSize(20);
        algo.accept(arr);

    }

}
