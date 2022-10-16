//package jvmalgo.study.princeton.algorithmsone.collinear;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.Objects;
//
///**
// * Just the brute force one was enough to pass for 80%
// */
//public class FastCollinearPoints {
//
//    private final int nrSegments;
//    private final List<LineSegment> lineSegments = new ArrayList<>();
//
//    public FastCollinearPoints(Point[] points) {    // finds all line segments containing 4 points
//        if (points == null) throw new IllegalArgumentException();
//
//        if (Arrays.stream(points).anyMatch(Objects::isNull)) {
//            throw new IllegalArgumentException();
//        }
//        points = points.clone();
//        Arrays.sort(points);
//
//        for (int i = 1; i < points.length; i++) {
//            Point p1 = points[i];
//            Point p2 = points[i - 1];
//            if (p1.compareTo(p2) == 0) {
//                throw new IllegalArgumentException();
//            }
//        }
//
//        final List<Pair> pairs = new ArrayList<>();
//        for (int i = 0; i < points.length; i++) {
//            for (int j = i + 1; j < points.length; j++) {
//                Point p1 = points[i];
//                Point p2 = points[j];
//                double s1 = p1.slopeTo(p2);
//                double s2 = p2.slopeTo(p1);
//                List<Point> sameslope = new ArrayList<>();
//                sameslope.add(p1);
//                sameslope.add(p2);
//
//                for (int k = j + 1; k < points.length; k++) {
//                    Point p3 = points[k];
//                    if (p3.slopeTo(p1) == s1) {
//                        sameslope.add(p3);
//                    } else if (p3.slopeTo(p1) == s2) {
//                        sameslope.add(p3);
//                    }
//                }
//
//                if (sameslope.size() == 4) {
//                    Collections.sort(sameslope);
//                    Point first = sameslope.get(0);
//                    Point last = sameslope.get(sameslope.size() - 1);
//                    Pair pair = new Pair(first, last);
//                    if (pairs.stream().noneMatch(s -> s.getFirst().compareTo(pair.getFirst()) == 0 && s.getLast().compareTo(pair.getLast()) == 0)) {
//                        pairs.add(pair);
//                    }
//                }
//            }
//        }
//        nrSegments = pairs.size();
//        for (int x = 0; x < pairs.size(); x++) {
//            lineSegments.add(new LineSegment(pairs.get(x).getFirst(), pairs.get(x).getLast()));
//        }
//    }
//
//    public int numberOfSegments() {      // the number of line segments
//        return nrSegments;
//    }
//
//    public LineSegment[] segments() {       // the line segments
//        return lineSegments.toArray(new LineSegment[0]);
//    }
//
//    private static class Pair {
//        private final Point first;
//        private final Point last;
//
//        Pair(Point fst, Point lst) {
//            first = fst;
//            last = lst;
//        }
//
//        public Point getFirst() {
//            return first;
//        }
//
//        public Point getLast() {
//            return last;
//        }
//
//
//    }
//
//    public static void main(String[] args) {
//        // not used
//    }
//
//
//}