package jvmalgo.study.princeton.algorithmsone;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {

    private static final int[][] TPS = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    private boolean percolates;

    private int openSites = 0;
    private final WeightedQuickUnionUF uf;
    private final int side;
    private final int max;
    private final boolean[] opened;


    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        n += 2;
        this.side = n;
        max = n * n;
        opened = new boolean[max];

        uf = new WeightedQuickUnionUF(max);

        for (int x = 1; x < n; x++) {
            uf.union(x - 1, x);
            opened[x] = true;
            opened[max - 1 - x] = true;
            uf.union(max - 1 - x, max - x);
        }
        opened[0] = true;
        opened[max - 1] = true;
    }


    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!percolates && isOpen(row, col)) {
            return;
        }
        openSites++;
        opened[to1D(row, col)] = true;

        for (int[] tp : TPS) {
            int r = row + tp[0];
            int c = col + tp[1];
            if (isOpen(r, c)) {
                uf.union(to1D(row, col), to1D(r, c));
                if (uf.find(0) == uf.find(max - 1)) {
                    percolates = true;
                }
            }
        }

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateN(row);
        validateN(col);
        return opened[to1D(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validateN(row);
        validateN(col);
        return uf.find(0) == uf.find(to1D(row, col));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return percolates;
    }

    private void validateN(int n) {
        if (n < 0 || n >= this.side) throw new IllegalArgumentException("n can not be: " + n + " this n:" + this.side);
    }

    private int to1D(int r, int c) {
        return r * side + c;
    }

}
