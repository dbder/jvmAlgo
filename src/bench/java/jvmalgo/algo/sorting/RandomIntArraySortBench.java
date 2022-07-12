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
 * RandomIntArraySortBench.insertion                10  avgt          ≈ 10⁻⁴          ms/op
 * RandomIntArraySortBench.insertion               100  avgt           0.005          ms/op
 * RandomIntArraySortBench.insertion              1000  avgt           0.592          ms/op
 * RandomIntArraySortBench.insertion             10000  avgt          34.451          ms/op
 * RandomIntArraySortBench.insertion            100000  avgt        3854.375          ms/op
 * RandomIntArraySortBench.javaArraysSort           10  avgt          ≈ 10⁻⁴          ms/op
 * RandomIntArraySortBench.javaArraysSort          100  avgt           0.001          ms/op
 * RandomIntArraySortBench.javaArraysSort         1000  avgt           0.016          ms/op
 * RandomIntArraySortBench.javaArraysSort        10000  avgt           0.383          ms/op
 * RandomIntArraySortBench.javaArraysSort       100000  avgt           5.175          ms/op
 * RandomIntArraySortBench.selection                10  avgt          ≈ 10⁻⁴          ms/op
 * RandomIntArraySortBench.selection               100  avgt           0.004          ms/op
 * RandomIntArraySortBench.selection              1000  avgt           0.773          ms/op
 * RandomIntArraySortBench.selection             10000  avgt          89.861          ms/op
 * RandomIntArraySortBench.selection            100000  avgt       12824.986          ms/op
 * RandomIntArraySortBench.shell                    10  avgt          ≈ 10⁻⁴          ms/op
 * RandomIntArraySortBench.shell                   100  avgt           0.001          ms/op
 * RandomIntArraySortBench.shell                  1000  avgt           0.040          ms/op
 * RandomIntArraySortBench.shell                 10000  avgt           0.831          ms/op
 * RandomIntArraySortBench.shell                100000  avgt          13.297          ms/op
 *
 * Process finished with exit code 0
 */
public class RandomIntArraySortBench {

    // fill with pattern: "10","100"..."10 ^ MAX_RANGE_POWER"
    @Param({"10", "100", "1000", "10000", "100000"})
//    @Param({"10", "100"})
    protected int arraySize;
    protected static final int MAX_RANGE_POWER = 6;

    protected static int[][] arrays = range(1, MAX_RANGE_POWER)
            .mapToObj(i -> IntArrGen.randomOfSize((int) Math.pow(10, i)))
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

    private void benchAlgo(Consumer<int[]> algo, Blackhole blackhole) {
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
