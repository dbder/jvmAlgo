package jvmalgo.algo.sorting;

import jvmalgo.algos.sorting.InsertionSort;
import jvmalgo.algos.sorting.SelectionSort;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 1)
@Measurement(iterations = 1)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"}, warmups = 1)
public class SortBench {

    static Random rnd = new Random();
    static int[] arr10;
    static int[] arr100;
    static int[] arr1000;
    static int[] arr10000;

    static {
        arr10 = Stream.generate(() -> rnd.nextInt()).mapToInt(i -> i).limit(10).toArray();
        arr100 = Stream.generate(() -> rnd.nextInt()).mapToInt(i -> i).limit(100).toArray();
        arr1000 = Stream.generate(() -> rnd.nextInt()).mapToInt(i -> i).limit(1000).toArray();
        arr10000 = Stream.generate(() -> rnd.nextInt()).mapToInt(i -> i).limit(10000).toArray();
    }


    @Benchmark
    public void selection10(Blackhole blackhole) {
        var arr = arr10.clone();
        SelectionSort.algo.accept(arr);
        blackhole.consume(arr);
    }

    @Benchmark
    public void selection100(Blackhole blackhole) {
        var arr = arr100.clone();
        SelectionSort.algo.accept(arr);
        blackhole.consume(arr);
    }

    @Benchmark
    public void selection1000(Blackhole blackhole) {
        var arr = arr1000.clone();
        SelectionSort.algo.accept(arr);
        blackhole.consume(arr);
    }

    @Benchmark
    public void selection10000(Blackhole blackhole) {
        var arr = arr10000.clone();
        SelectionSort.algo.accept(arr);
        blackhole.consume(arr);
    }

    @Benchmark
    public void insertion10(Blackhole blackhole) {
        var arr = arr10.clone();
        InsertionSort.algo.accept(arr);
        blackhole.consume(arr);
    }

    @Benchmark
    public void insertion100(Blackhole blackhole) {
        var arr = arr100.clone();
        InsertionSort.algo.accept(arr);
        blackhole.consume(arr);
    }

    @Benchmark
    public void insertion1000(Blackhole blackhole) {
        var arr = arr1000.clone();
        InsertionSort.algo.accept(arr);
        blackhole.consume(arr);
    }

    @Benchmark
    public void insertion10000(Blackhole blackhole) {
        var arr = arr10000.clone();
        InsertionSort.algo.accept(arr);
        blackhole.consume(arr);
    }


}
