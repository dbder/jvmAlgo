package jvmalgo.parsers.lc;

import jvmalgo.parsers.lc.LCParse;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LCParseTest {


    @Test
    void d1FromString_gives_IntArray() {
        var arr = LCParse.d1("[1,3,5,4,7]");

        String expected = Arrays.toString(new int[]{1, 3, 5, 4, 7});
        String actual = Arrays.toString(arr);

        assertEquals(expected, actual);
    }

}