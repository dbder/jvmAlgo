package jvmalgo.generators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public record D1gen() {


    static Random rnd = new Random();


    /**
     * Permutate Sequence: for an inclusive range return all permutations.
     * <p>
     * !not tested, too many results from perm i think.
     */
    public static List<List<Integer>> permSeq(int start, int end) {
        return perm(createSequence(start, end));
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


    /**
     * ! not tested ( buggy)
     */
    private static List<List<Integer>> perm(List<Integer> list) {
        var lists = new ArrayList<List<Integer>>();
        fillPerms(list.size(), list, lists);
        return lists;
    }


    /**
     * ! not tested ( buggy, too many results)
     */
    private static void fillPerms(int n, List<Integer> elements, List<List<Integer>> lists) {

        if (n == 1) {
            lists.add(new ArrayList<>(elements));
        } else {
            for (int i = 0; i < n - 1; i++) {
                fillPerms(n - 1, elements, lists);
                if (n % 2 == 0) {
                    swap(elements, i, n - 1);
                } else {
                    swap(elements, 0, n - 1);
                }
            }
            fillPerms(n - 1, elements, lists);
        }
    }

    private static void swap(List<Integer> input, int a, int b) {
        Integer tmp = input.get(a);
        input.set(a, input.get(b));
        input.set(b, tmp);
    }

}
