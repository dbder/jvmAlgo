package jvmalgo.generators;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static jvmalgo.generators.D1gen.nRandomFromInRangeInclusive;

public class D2Gen {


    /**
     *
     * @param lists how many list<list> are printed
     * @param n hoe many list are in the list
     * @param start the nested list will contain no lower than this
     * @param end the nested list will contain no higher than this
     */
    public static List<List<Integer>> listNRandomRanges(int lists, int n, int start, int end) {
        return Stream.iterate(0, i -> i + 1).limit(lists).map(i -> nRandomFromInRangeInclusive(n, start, end)).collect(toList());
    }

}
