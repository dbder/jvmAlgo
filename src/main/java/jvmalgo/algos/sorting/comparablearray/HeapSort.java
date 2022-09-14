package jvmalgo.algos.sorting.comparablearray;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * <a href="https://www.coursera.org/learn/algorithms-part1/lecture/ZjoSM/heapsort">Princeton-Heapsort</a>
 */
public class HeapSort {


    public static final Consumer<Comparable<?>[]> algo = (arr) -> {
    };

    public static final Function<Comparable<?>[], Comparable<?>[]> heapToSortedArr = (arr) -> {
        var standard = new Comparable<?>[arr.length];


        return standard;
    };


    private static void sort(Comparable<?>[] pq) {
//        int N = pq.length;
//        for (int k = N / 2; k >= 1; k--) {
//            sink(pq, k, N);
//        }
//        while (N > 1) {
//            swap(pq, 1, N);
//            sink(pq, 1, --N);
//        }
    }


    private static void sink(Comparable<Comparable<?>>[] pq, int k, final int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && pq[j].compareTo(pq[j +1]) < 0) {

            }
        }

    }


    private static void fill(Comparable[] source, Comparable[] target, int index, int[] tindex) {
        if (index >= source.length) return;
        System.out.print(source[index]);
        fill(source, target, index * 2, tindex);
        target[tindex[0]++] = source[index];
        fill(source, target, index * 2 + 1, tindex);
    }


    public static void main(String[] args) {
        Integer[] integers = {null, 1, 2, 5, 9};
        Integer[] target = new Integer[integers.length - 1];
        fill(integers, target, 1, new int[1]);
//        algo.accept(integers);

        System.out.println(Arrays.toString(integers));
        System.out.println(Arrays.toString(target));
    }
}
