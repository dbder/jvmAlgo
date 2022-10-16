//package jvmalgo.study.princeton.algorithmsone;
//
//public class PercolationStats {
//
//    private final double[] opendistr;
//
//    // perform independent trials on an n-by-n grid
//    public PercolationStats(int n, int trials) {
//        if (n <= 0 || trials <= 0) {
//            throw new IllegalArgumentException();
//        }
//        opendistr = new double[trials];
//        for (int x = 0; x < trials; x++) {
//            Percolation p = run(n);
//            opendistr[x] = 1d - (double) n / p.numberOfOpenSites();
//        }
//    }
//
//    public static void main(String[] args) {
////        PercolationStats stats = new PercolationStats(5, 10000);
//        PercolationStats stats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
//        System.out.println("mean                    = " + stats.mean());
//        System.out.println("stddev                  = " + stats.stddev());
//        System.out.println("95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
//    }
//
//    private Percolation run(int n) {
//        Percolation percolation = new Percolation(n);
//
//        Pos[] positions = new Pos[n * n];
//        int i = 0;
//        for (int r = 1; r <= n; r++) {
//            for (int c = 1; c <= n; c++) {
//                positions[i++] = new Pos(r, c);
//            }
//        }
//        StdRandom.shuffle(positions);
//        for (int x = 0; x < positions.length; x++) {
//            percolation.open(positions[x].r, positions[x].c);
//            if (percolation.percolates()) {
//                return percolation;
//            }
//        }
//        throw new RuntimeException("must perculate. opened: ");
//    }
//
//    // sample mean of percolation threshold
//    public double mean() {
//        return StdStats.mean(opendistr);
//    }
//
//    // sample standard deviation of percolation threshold
//    public double stddev() {
//        return StdStats.stddev(opendistr);
//    }
//
//    // low endpoint of 95% confidence interval
//    public double confidenceLo() {
//        return 0;
//    }
//
//    // high endpoint of 95% confidence interval
//    public double confidenceHi() {
//        return 0;
//    }
//
//    private static class Pos {
//        int r;
//        int c;
//
//        Pos(int row, int col) {
//            r = row;
//            c = col;
//        }
//    }
//}
