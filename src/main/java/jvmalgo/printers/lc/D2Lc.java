package jvmalgo.printers.lc;

import jvmalgo.JvmAlgoException;

import java.util.List;
import java.util.stream.Collectors;

public class D2Lc {

    private D2Lc() {
        throw new JvmAlgoException("may not instantiate Util");
    }

    /**
     * prints lists of list like:
     * [1,2,3]
     * [2,4,1]
     */
    public static void printLists(List<List<Integer>> lists) {

        System.out.println(lists.stream().map(List::toString).collect(Collectors.joining(",","[","]")));
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
