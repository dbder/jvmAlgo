package jvmalgo.study.princeton.algorithmsone.eightpuzzle;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Board {
    private static final List<int[]> TPS = List.of(
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{0, 1}
    );

    private int hamming = -1;
    private int manhattan = -1;
    private final int[][] grid;
    private final int n;

    public Board(int[][] tiles) {
        grid = new int[tiles.length][];
        for (int r = 0; r < tiles.length; r++) {
            grid[r] = tiles[r].clone();
        }
        n = grid.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var arr : grid) {
            for (var i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        return n + "\n" + sb;
    }

    public int dimension() {
        return n;
    }

    public int hamming() {
        if (hamming != -1) return hamming;
        int nr = 1;
        int ham = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != nr++) {
                    ham++;
                }
            }
        }
        this.hamming = ham;
        return ham;
    }


    public int manhattan() {
        if (manhattan != -1) return manhattan;
        int nr = 1;
        int manh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                var v = grid[i][j];
                if (v != nr++ && v != 0) {
                    manh += Math.abs(i - (v - 1) / n) + Math.abs(j - (v - 1) % n);
                }
            }
        }
        this.manhattan = manh;
        return manh;
    }

    public boolean isGoal() {
        return hamming() == 0;
    }

    public boolean equals(Object y) {
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        var b = (Board) y;
        return Arrays.deepEquals(grid, b.grid);
    }

    public Iterable<Board> neighbors() {
        return () -> new Iterator<>() {
            final List<int[][]> neighbors = getNeighbors();
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < neighbors.size();
            }

            @Override
            public Board next() {
                if (!hasNext()) throw new NoSuchElementException();
                return new Board(neighbors.get(i++));
            }
        };
    }


    private List<int[][]> getNeighbors() {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    int finalR = r;
                    int finalC = c;
                    return TPS.stream()
                            .map(tp -> addNeighbor(finalR + tp[0], finalC + tp[1], finalR, finalC))
                            .filter(a -> a.length > 0)
                            .collect(Collectors.toList());
                }
            }
        }
        throw new NoSuchElementException("No empty tile found");
    }

    private int[][] addNeighbor(int r, int c, int r0, int c0) {
        if (r < 0 || r >= n || c < 0 || c >= n) {
            return new int[0][];
        }
        var newboard = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            newboard[i] = grid[i].clone();
        }
        newboard[r0][c0] = newboard[r][c];
        newboard[r][c] = 0;
        return newboard;
    }


    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        if (n == 0) return new Board(new int[0][0]);
        if (n == 2) {
            if (grid[0][0] == 0 || grid[0][1] == 0) {
                return new Board(new int[][]{
                        {grid[0][0], grid[0][1]},
                        {grid[1][1], grid[1][0]}
                });
            } else {
                return new Board(new int[][]{{grid[0][1], grid[0][0]}, {grid[1][0], grid[1][1]}});
            }
        }
        var newboard = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            newboard[i] = grid[i].clone();
        }

        int tmp1 = grid[0][0] == 0 ? 1 : 0;
        int tmp2 = grid[0][2] == 0 ? 1 : 2;

        int tmp = grid[0][tmp1];
        newboard[0][tmp1] = newboard[0][tmp2];
        newboard[0][tmp2] = tmp;
        return new Board(newboard);
    }

    // unit testing (not graded)
    public static void main(String[] args) {
        var c = new Board(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        var t = new Board(new int[][]{{1, 0}, {3, 2}});
        System.out.println(t);
        System.out.println(t.twin());
        System.out.println(c);

    }


}