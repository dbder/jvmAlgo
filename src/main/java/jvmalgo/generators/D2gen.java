package jvmalgo.generators;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public record D2gen() {


    /**
     * @param amount amount of lists to be created
     * @param onein the change of any item beeing 1. ( else 0 )
     */
    public static List<List<Integer>> createOnesAndZeroRandom2d(int amount, int onein) {
        return Stream.iterate(1, n -> n <= amount, n -> n + 1).map(i -> D1gen.createOnesAndZeroRandom(amount, onein)).collect(toList());
    }

}
