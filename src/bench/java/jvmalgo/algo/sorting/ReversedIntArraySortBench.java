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
 * ReversedIntArraySortBench.insertion                10  avgt         ≈ 10⁻⁴          ms/op
 * ReversedIntArraySortBench.insertion               100  avgt          0.003          ms/op
 * ReversedIntArraySortBench.insertion              1000  avgt          0.308          ms/op
 * ReversedIntArraySortBench.insertion             10000  avgt         30.631          ms/op
 * ReversedIntArraySortBench.insertion            100000  avgt       5190.294          ms/op
 * ReversedIntArraySortBench.javaArraysSort           10  avgt         ≈ 10⁻⁴          ms/op
 * ReversedIntArraySortBench.javaArraysSort          100  avgt         ≈ 10⁻⁴          ms/op
 * ReversedIntArraySortBench.javaArraysSort         1000  avgt          0.001          ms/op
 * ReversedIntArraySortBench.javaArraysSort        10000  avgt          0.008          ms/op
 * ReversedIntArraySortBench.javaArraysSort       100000  avgt          0.084          ms/op
 * ReversedIntArraySortBench.selection                10  avgt         ≈ 10⁻⁴          ms/op
 * ReversedIntArraySortBench.selection               100  avgt          0.003          ms/op
 * ReversedIntArraySortBench.selection              1000  avgt          0.266          ms/op
 * ReversedIntArraySortBench.selection             10000  avgt         26.186          ms/op
 * ReversedIntArraySortBench.selection            100000  avgt       2615.473          ms/op
 * ReversedIntArraySortBench.shell                    10  avgt         ≈ 10⁻⁴          ms/op
 * ReversedIntArraySortBench.shell                   100  avgt          0.001          ms/op
 * ReversedIntArraySortBench.shell                  1000  avgt          0.011          ms/op
 * ReversedIntArraySortBench.shell                 10000  avgt          0.135          ms/op
 * ReversedIntArraySortBench.shell                100000  avgt          1.851          ms/op
 */
public class ReversedIntArraySortBench {

    // fill with pattern: "10","100"..."10 ^ MAX_RANGE_POWER"
    @Param({"10", "100", "1000", "10000", "100000"})
//    @Param({"10", "100"})

    protected int arraySize;
    protected static final int MAX_RANGE_POWER = 6;

    protected static int[][] arrays = range(1, MAX_RANGE_POWER)
                    .mapToObj(i -> IntArrGen.sortedDESCOfSize((int) Math.pow(10, i)))
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
