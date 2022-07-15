package jvmalgo.sorting.intarray;

import jvmalgo.generators.IntArrGen;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import static java.util.stream.IntStream.range;
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 1)
@Measurement(iterations = 1)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"}, warmups = 1)
@BenchmarkMode(Mode.AverageTime)
public class RandomIntArraySortBenchTest extends IntArraySortBase {


    // fill with pattern: "10","100"..."10 ^ MAX_RANGE_POWER"
    @Param({"10", "100", "1000", "10000", "100000"})
    protected int arraySize;
    protected static final int MAX_RANGE_POWER = 6;

    protected static int[][] arrays = range(1, MAX_RANGE_POWER)
            .mapToObj(i -> IntArrGen.randomOfSize((int) Math.pow(10, i)))
            .toArray(int[][]::new);

    @Override
    public int[][] getArrays() {
        return arrays;
    }

    @Override
    public int getArraySize() {
        return 0;
    }

}
