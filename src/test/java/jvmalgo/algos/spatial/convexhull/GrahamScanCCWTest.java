package jvmalgo.algos.spatial.convexhull;

import jvmalgo.algos.spatial.convexhull.GrahamScan.Vector2;
import org.junit.jupiter.api.Test;

import static jvmalgo.algos.spatial.convexhull.GrahamScan.Vector2.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GrahamScanCCWTest {

    @Test
    void test11_21_22() {
        assertCCW(1, of(1, 1), of(2, 1), of(2, 2));
        assertCCW(-1, of(1, 1), of(2, 1), of(2, 0));
        assertCCW(0, of(1, 1), of(2, 1), of(3, 1));
    }

    static void assertCCW(int expected, Vector2 a, Vector2 b, Vector2 c) {
        assertEquals(expected, GrahamScan.ccw(a, b, c));
    }

}