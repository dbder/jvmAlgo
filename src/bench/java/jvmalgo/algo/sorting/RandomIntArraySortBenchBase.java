package jvmalgo.algo.sorting;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.IntStream;

@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 1)
@Measurement(iterations = 1)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"}, warmups = 1)
@BenchmarkMode(Mode.AverageTime)
public class RandomIntArraySortBenchBase {

    private static final Random rnd = new Random();

    // Array sizes to be generated ( change in 3 spots int this file if you change )
    protected static final String SIZE_10 = "10";
    protected static final String SIZE_100 = "100";
    protected static final String SIZE_1000 = "1000";
    protected static final String SIZE_10000 = "10000";
    protected static final String SIZE_100000 = "100000";

    // Arrays with random data
    protected static final int[][] arrays =
            IntStream
                    .of(
                            Arrays
                                    .stream(new String[]{
                                            SIZE_10,
                                            SIZE_100,
                                            SIZE_1000,
                                            SIZE_10000,
                                            SIZE_100000,
                                    })
                                    .mapToInt(Integer::parseInt)
                                    .toArray()
                    )
                    .mapToObj(i -> IntStream.generate(rnd::nextInt)
                            .limit(i)
                            .toArray()
                    )
                    .toArray(int[][]::new);

    // params given to the test
    @Param({
            SIZE_10,
            SIZE_100,
            SIZE_1000,
            SIZE_10000,
            SIZE_100000
    })
    protected int arraySize;


    // convert from arraysize to it's index in 'arrays'
    protected static int getIndex(int count) {
        int index = 0;
        count /= 10;
        while ((count /= 10) != 0) {
            index++;
        }
        return index;
    }

    // The actual benching
    protected void benchAlgo(Consumer<int[]> algo, Blackhole blackhole) {
        var arr = arrays[getIndex(arraySize)].clone();
        algo.accept(arr);
        blackhole.consume(arr);
    }
}
