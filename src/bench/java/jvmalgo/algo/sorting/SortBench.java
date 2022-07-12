package jvmalgo.algo.sorting;

import jvmalgo.algos.sorting.InsertionSort;
import jvmalgo.algos.sorting.SelectionSort;
import jvmalgo.algos.sorting.ShellSort;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;

public class SortBench extends RandomIntArraySortBenchBase {

    @Benchmark
    public void selection(Blackhole bh) {
        benchAlgo(SelectionSort.algo, bh);
    }

    @Benchmark
    public void insertion(Blackhole bh) {
        benchAlgo(InsertionSort.algo, bh);
    }

    @Benchmark
    public void shell(Blackhole bh) {
        benchAlgo(ShellSort.algo, bh);
    }

    @Benchmark
    public void javaArraysSort(Blackhole bh) {
        benchAlgo(Arrays::sort, bh);
    }

}
