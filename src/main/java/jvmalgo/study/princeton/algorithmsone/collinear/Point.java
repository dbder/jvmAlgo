//package jvmalgo.study.princeton.algorithmsone.collinear;
//
//import edu.princeton.cs.algs4.StdDraw;
//
//import java.util.Comparator;
//
//public class Point implements Comparable<Point> {
//
//    private final int x;     // x-coordinate of this point
////    private final int y;     // y-coordinate of this point
//
//    public Point(int x, int y) {
//        /* DO NOT MODIFY */
//        this.x = x;
//        this.y = y;
//    }
//
//    public void draw() {
//        /* DO NOT MODIFY */
//        StdDraw.point(x, y);
//    }
//
//    public void drawTo(Point that) {
//        /* DO NOT MODIFY */
//        StdDraw.line(this.x, this.y, that.x, that.y);
//    }
//
//    public double slopeTo(Point that) {
//        if (that == null) throw new NullPointerException();
//        if (x == that.x && y == that.y) return Double.NEGATIVE_INFINITY;
//        if (y == that.y) return 0;
//        if (x == that.x) return Double.POSITIVE_INFINITY;
//        return ((double) y - that.y) / ((double) x - that.x);
//    }
//
//    public int compareTo(Point that) {
//        if (that == null) throw new NullPointerException();
//        if (that.y == y) return x - that.x;
//        return y - that.y;
//    }
//
//    public Comparator<Point> slopeOrder() {
//        return (a, b) -> {
//            if (a == null) throw new NullPointerException();
//            if (b == null) throw new NullPointerException();
//            double slope = a.slopeTo(b);
//            if (slope == Double.NEGATIVE_INFINITY || slope == Double.POSITIVE_INFINITY) return 0;
//            return Double.compare(slope, 0);
//        };
//    }
//
//    public String toString() {
//        /* DO NOT MODIFY */
//        return "(" + x + ", " + y + ")";
//    }
//
//    public static void main(String[] args) {
////          * reflexive, where p and q have coordinates in [0, 500)
////        Failed on trial 1 of 100000
////        p                              = (421, 460)
////        q                              = (442, 333)
////        p.slopeOrder().compare(q, q))  = -1
////        new Point()
//    }
//}
