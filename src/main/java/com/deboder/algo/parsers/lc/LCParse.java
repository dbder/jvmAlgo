package com.deboder.algo.parsers.lc;

import java.util.Arrays;

public class LCParse {

    /**
     * returns array for input similar to: [1,3,6]
     * - not really tested convenience method
     */
    public static int[] d1(String input) {
        var split = input.substring(1, input.length() - 1).split(",");
        return Arrays.stream(split)
                .filter(str -> !str.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
