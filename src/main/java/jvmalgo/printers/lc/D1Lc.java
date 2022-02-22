package jvmalgo.printers.lc;

import jvmalgo.generators.D1gen;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class D1Lc {


    static Random rnd = new Random();

    public static void main(String[] args) {
        printLists(D1gen.permSeq(1, 7)); // bug in perms too many results.
    }

    private static void printLists(List<List<Integer>> lists) {
        lists.forEach(D1Lc::printList);
    }


    private static void printList(List<Integer> list) {
        System.out.println(
                list.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",", "[", "]"))
        );
    }


    static void printPerms(int[] arr, int i, String[] strings, int si) {
        if (i >= arr.length) return;
        printPerms(arr, i + 1, strings, si);
        var s = String.valueOf(arr[i]);
        if (!s.equals(strings[si])) {
            strings[si] = String.valueOf(arr[i]);
            if (si > 0) {
                System.out.println(Arrays.stream(strings).limit(si + 1).sorted(Comparator.comparingInt(a -> rnd.nextInt())).collect(Collectors.joining(",", "[", "]")));
            }
        }
        si++;
        printPerms(arr, i + 1, strings, si);
    }

}
