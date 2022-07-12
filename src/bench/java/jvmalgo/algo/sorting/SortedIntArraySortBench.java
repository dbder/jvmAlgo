package jvmalgo.algo.sorting;

import jvmalgo.algos.sorting.InsertionSort;
import jvmalgo.algos.sorting.SelectionSort;
import jvmalgo.algos.sorting.ShellSort;
import jvmalgo.generators.IntArrGen;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static java.util.stream.IntStream.range;

@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 1)
@Measurement(iterations = 1)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"}, warmups = 1)
@BenchmarkMode(Mode.AverageTime)
/**
 * SortedIntArraySortBench.insertion                10  avgt        ≈ 10⁻⁵          ms/op
 * SortedIntArraySortBench.insertion               100  avgt         0.001          ms/op
 * SortedIntArraySortBench.insertion              1000  avgt         0.093          ms/op
 * SortedIntArraySortBench.insertion             10000  avgt         8.690          ms/op
 * SortedIntArraySortBench.insertion            100000  avgt       859.226          ms/op
 * SortedIntArraySortBench.javaArraysSort           10  avgt        ≈ 10⁻⁵          ms/op
 * SortedIntArraySortBench.javaArraysSort          100  avgt        ≈ 10⁻⁴          ms/op
 * SortedIntArraySortBench.javaArraysSort         1000  avgt         0.001          ms/op
 * SortedIntArraySortBench.javaArraysSort        10000  avgt         0.006          ms/op
 * SortedIntArraySortBench.javaArraysSort       100000  avgt         0.058          ms/op
 * SortedIntArraySortBench.selection                10  avgt        ≈ 10⁻⁴          ms/op
 * SortedIntArraySortBench.selection               100  avgt         0.001          ms/op
 * SortedIntArraySortBench.selection              1000  avgt         0.090          ms/op
 * SortedIntArraySortBench.selection             10000  avgt         8.338          ms/op
 * SortedIntArraySortBench.selection            100000  avgt       822.736          ms/op
 * SortedIntArraySortBench.shell                    10  avgt        ≈ 10⁻⁵          ms/op
 * SortedIntArraySortBench.shell                   100  avgt        ≈ 10⁻⁴          ms/op
 * SortedIntArraySortBench.shell                  1000  avgt         0.002          ms/op
 * SortedIntArraySortBench.shell                 10000  avgt         0.024          ms/op
 * SortedIntArraySortBench.shell                100000  avgt         0.295          ms/op
 */
public class SortedIntArraySortBench {

    // fill with pattern: "10","100"..."10 ^ MAX_RANGE_POWER"
    @Param({"10", "100", "1000", "10000", "100000"})
//    @Param({"10", "100"})

    protected int arraySize;
    protected static final int MAX_RANGE_POWER = 6;

    protected static int[][] arrays = range(1, MAX_RANGE_POWER)
                    .mapToObj(i -> IntArrGen.sortedASCOfSize((int) Math.pow(10, i)))
                    .toArray(int[][]::new);


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


    protected void benchAlgo(Consumer<int[]> algo, Blackhole blackhole) {
        var arr = arrays[getArrayIndexFromArraySize(arraySize)].clone();
        algo.accept(arr);
        blackhole.consume(arr);
    }


    private int getArrayIndexFromArraySize(int size) {
        int index = 0;
        size /= 10;
        while ((size /= 10) != 0) {
            index++;
        }
        return index;
    }
}
