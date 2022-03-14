package jvmalgo.serializer.D1Ser;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class D1Ser {

    public static String ser1Darray(int[] arr) {
        return Arrays.stream(arr)
                .mapToObj(a -> "" + a)
                .collect(joining(",", "[", "]"));
    }
}
