package jvmalgo.algo.sorting;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static java.util.stream.IntStream.generate;
import static java.util.stream.IntStream.range;

@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 1)
@Measurement(iterations = 1)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"}, warmups = 1)
@BenchmarkMode(Mode.AverageTime)
public class RandomIntArraySortBenchBase {

    private static final Random rnd = new Random();
    static final int MAX_RANGE_POWER = 5;


    // Arrays with random data
    protected static final int[][] arrays =
            range(1, MAX_RANGE_POWER)
                    .mapToObj(i -> generate(rnd::nextInt)
                            .limit((long) Math.pow(10, i))
                            .toArray()
                    )
                    .toArray(int[][]::new);

    // fill in values that are both the arraysize pow10 and the index of the array -1. ( size must be =< MAX_RANGE_POWER
    @Param({"1", "2", "3", "4"})
    protected int arraySize_log10;

    // The actual benching
    protected void benchAlgo(Consumer<int[]> algo, Blackhole blackhole) {
        var arr = arrays[arraySize_log10 - 1].clone();
        algo.accept(arr);
        blackhole.consume(arr);
    }

}
