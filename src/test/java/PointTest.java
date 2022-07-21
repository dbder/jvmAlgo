import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {


    @Test
    void reflexive1() {
        var p = new Point(421, 460);
        var q = new Point(442, 333);

        assertEquals(0, p.slopeOrder().compare(q, q));

    }

    /**
     * Failed on trial 2 of 100000
     * p                         = (7, 7)
     * q                         = (6, 7)
     * r                         = (8, 2)
     * student   p.compare(q, r) = -1
     * reference p.compare(q, r) = 1
     * reference p.slopeTo(q)    = 0.0
     * reference p.slopeTo(r)    = -5.0
     */
    @Test
    void signOfCompare() {
        var p = new Point(7, 7);
        var q = new Point(6, 7);
        var r = new Point(8, 2);

//        assertEquals(0, p.compare(q, r));

    }

    @Test
    void slope() {
        var p = new Point(2, 2);
        var q = new Point(4, 3);

        System.out.println(p.slopeTo(q));
        System.out.println();

    }
}