package jvmalgo.serializer.D2;

import jvmalgo.serializer.D1Ser.D1Ser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class D2Ser {


    public static String ser2dPosArray(int[][] arr) {
        return Arrays.stream(arr).map(D1Ser::ser1Darray).collect(Collectors.joining(",", "[", "]"));
    }


    public static String ser2dPosArray(List<int[]> list) {
        return list.stream().map(D1Ser::ser1Darray).collect(Collectors.joining(",", "[", "]"));
    }


}
