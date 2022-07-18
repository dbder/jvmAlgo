package jvmalgo.sorting.intarray;

import jvmalgo.BenchCore;
import jvmalgo.algos.sorting.*;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;
import java.util.function.Consumer;


public abstract class IntArraySortBase extends BenchCore {


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

    @Benchmark
    public void merge(Blackhole bh) {
        benchAlgo(MergeSort.algo, bh);
    }

    @Benchmark
    public void bottonUpMerge(Blackhole bh) {
        benchAlgo(BottomUpMerge.algo, bh);
    }


    protected void benchAlgo(Consumer<int[]> algo, Blackhole blackhole) {
        var arr = getArrays()[getArrayIndexFromArraySize(getArraySize())].clone();
        algo.accept(arr);
        blackhole.consume(arr);
    }


    public abstract int[][] getArrays();
    public abstract int getArraySize();

    private int getArrayIndexFromArraySize(int size) {
        int index = 0;
        size /= 10;
        while ((size /= 10) != 0) {
            index++;
        }
        return index;
    }

    protected static final int MAX_RANGE_POWER = 6;


}
