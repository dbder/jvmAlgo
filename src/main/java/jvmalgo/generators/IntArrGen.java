package jvmalgo.generators;

import jvmalgo.global.Global;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class IntArrGen {

    public static int[] randomOfSize(int size) {
        return IntStream.range(0, size).map(i -> Global.nextRndInt()).toArray();
    }

    public static int[] sortedASCOfSize(int size) {
        return Arrays.stream(randomOfSize(size)).sorted().toArray();
    }

    public static int[] sortedDESCOfSize(int size) {
        return Arrays.stream(randomOfSize(size)).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
    }
}
