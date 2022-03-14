package jvmalgo.generators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public record D1gen() {

    /**
     * Return List for every count spread per digit.
     * e.g. 10-99 gives: "[[1, 0], [1, 1], [1, 2], [1, 3], [1, 4], [1, 5], [1, 6], [1, 7], [1, 8], [1, 9], [2, 0], [2, 1], [2, 2], [2, 3], [2, 4], [2, 5], [2, 6], [2, 7], [2, 8], [2, 9], [3, 0], [3, 1], [3, 2], [3, 3], [3, 4], [3, 5], [3, 6], [3, 7], [3, 8], [3, 9], [4, 0], [4, 1], [4, 2], [4, 3], [4, 4], [4, 5], [4, 6], [4, 7], [4, 8], [4, 9], [5, 0], [5, 1], [5, 2], [5, 3], [5, 4], [5, 5], [5, 6], [5, 7], [5, 8], [5, 9], [6, 0], [6, 1], [6, 2], [6, 3], [6, 4], [6, 5], [6, 6], [6, 7], [6, 8], [6, 9], [7, 0], [7, 1], [7, 2], [7, 3], [7, 4], [7, 5], [7, 6], [7, 7], [7, 8], [7, 9], [8, 0], [8, 1], [8, 2], [8, 3], [8, 4], [8, 5], [8, 6], [8, 7], [8, 8], [8, 9], [9, 0], [9, 1], [9, 2], [9, 3], [9, 4], [9, 5], [9, 6], [9, 7], [9, 8], [9, 9]]"
     *
     * @param start inclusive
     * @param end   inclusive
     * @return list of every count spread as list.
     */
    public static List<List<Integer>> spreadCount(int start, int end) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int x = start; x <= end; x++) {
            LinkedList<Integer> list = new LinkedList<>();
            int tmp = x;
            while (tmp > 0) {
                list.addFirst(tmp % 10);
                tmp /= 10;
            }
            lists.add(list);
        }
        return lists;
    }

    /**
     * gives all the numbers from start till end in order in a list
     *
     * @param start inclusive start
     * @param end   inclusive end
     * @return List from start to end.
     */
    public static List<Integer> createSequence(int start, int end) {
        return Stream.iterate(start, n -> n <= end, n -> n + 1).collect(toList());
    }

    static final Random rnd = new Random();


    public static List<Integer> createOnesAndZeroRandom(int amount, int onein) {
        return Stream.iterate(1, n -> n <= amount, n -> n + 1).map(i -> rnd.nextInt(onein) == 1 ? 1 : 0).collect(toList());
    }
}
