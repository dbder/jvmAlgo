package jvmalgo.printers.lc;

import java.util.List;
import java.util.stream.Collectors;

public class D2LC {


    /**
     * prints list of integers like: [1,2,3]
     */
    private static String listToString(List<Integer> list) {
        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",", "[", "]"));
    }

    public static void printD2(List<List<Integer>> lists) {
        var str = lists.stream().map(D2LC::listToString).collect(Collectors.joining(",", "[", "]"));
        System.out.println(str);
    }
}
