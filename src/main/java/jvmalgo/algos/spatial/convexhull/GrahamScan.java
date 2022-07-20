package jvmalgo.algos.spatial.convexhull;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/**
 * https://www.coursera.org/learn/algorithms-part1/lecture/KHJ1t/convex-hull
 */
public class GrahamScan {


    /**
     * GrahamScan will give you the convex hull in order for a List of dots ( Vector2 )
     */
    public static final Function<List<Vector2>, List<Vector2>> algo = (l) -> {

        //! take care of points on same line ( collinear )
        // choose point P with lowest Y
        // sort points by 'polar angle' with P
        // for every point in order: discard unless it creates a CCW(Counter Clock Wise) turn

        LinkedList<Vector2> chull = new LinkedList<>();

        sortByYThenPolarOrderToFirst(l);

        chull.add(l.get(0));
        chull.add(l.get(1));

        for (int i = 2; i < l.size(); i++) {
            Vector2 top = chull.pollLast();
            while (ccw(chull.peekLast(), top, l.get(i)) <= 0) {
                top = chull.pollLast();
            }
            chull.add(top);
            chull.add(l.get(i));
        }

        return chull;
    };

    /**
     * CounterClockWise will return:
     *   1 if C is CounterClockWise to line AB
     *   0 if C is On the same line as AB
     *   -1 if C is ClockWise to line AB
     */
    public static int ccw(Vector2 a, Vector2 b, Vector2 c) {
//        geometry, you can have a method ccw() that just with this
//        little math calculation (b.x - a.x)(c.y - a.y) minus (b.y - a.y)(c.x - a.x) and we
        float area = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        return area < 0 ? -1 : area > 0 ? 1 : 0;
    }

    public static List<Vector2> sortByYThenPolarOrderToFirst(List<Vector2> l) {
        l.sort((a, b) -> Float.compare(a.y, b.y));
        Vector2 initial = l.get(0);
        l.sort((a, b) -> {
            double cotanA = -(a.x - initial.x) / (a.y - initial.y);
            double cotanB = -(b.x - initial.x) / (b.y - initial.y);
            if (cotanA - cotanB < 0) {
                return -1;
            } else if (cotanA - cotanB > 0) {
                return 1;
            }
            return 0;
        });
        return l;
    }

    record Vector2(float x, float y) {

        static Vector2 of(float x, float y) {
            return new Vector2(x, y);
        }

        @Override
        public String toString() {
            return "[x:" + x + ", y:" + y + "]";
        }
    }
}


