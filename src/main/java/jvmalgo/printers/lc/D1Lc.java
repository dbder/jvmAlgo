package jvmalgo.printers.lc;

import jvmalgo.JvmAlgoException;
import jvmalgo.generators.D1gen;

import java.util.List;
import java.util.stream.Collectors;

public class D1Lc {

    private D1Lc() {
        throw new JvmAlgoException("may not instantiate Util");
    }

    /**
     * prints lists of list like:
     * [1,2,3]
     * [2,4,1]
     */
    public static void printLists(List<List<Integer>> lists) {
        lists.forEach(D1Lc::printList);
    }


    /**
     * prints list of integers like: [1,2,3]
     */
    public static void printList(List<Integer> list) {
        System.out.println(
                list.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",", "[", "]"))
        );
    }

}
