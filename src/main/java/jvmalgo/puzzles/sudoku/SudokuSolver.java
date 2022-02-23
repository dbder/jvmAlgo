package jvmalgo.puzzles.sudoku;

import java.util.BitSet;

/**
 * Sudoku solver by deboder
 */
public class SudokuSolver {


    static int[] finalgrid = null;

    private static boolean backtrack(int r, int c, int[] grid) {
        if (r == 8 && c == 8) {
            if (grid[80] != 0) {
                finalgrid = grid;
                return true;
            }
            final int[] getoptions = getoptions(r, c, grid);
            if (getoptions.length == 0) {
                return false;
            }
            grid[80] = getoptions[0];
            finalgrid = grid;

            return true;
        }

        if (grid[toindex(r, c)] != 0) {
            c++;
            if (c == 9) {
                r++;
                c = 0;
            }
            backtrack(r, c, grid);
        } else {
            final int[] getoptions = getoptions(r, c, grid);
            int index = toindex(r, c);
            c++;
            if (c == 9) {
                r++;
                c = 0;
            }

            for (int x : getoptions) {
                final int[] clone = grid.clone();
                clone[index] = x;
                if (backtrack(r, c, clone)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void solveSudoku(char[][] board) {
        int[] grid = new int[9 * 9];
        finalgrid = null;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                char tmp = board[r][c];
                if (tmp == '.') continue;
                grid[toindex(r, c)] = tmp - 48;
            }
        }
        backtrack(0, 0, grid);
        int i = 0;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                board[r][c] = Character.valueOf((char) (finalgrid[i++] + 48));
            }
        }
    }

    static int toindex(int r, int c) {
        return c + r * 9;
    }

    static int[] getoptions(int r, int c, int[] grid) {
        BitSet bs = new BitSet(10);
        for (int x = 0; x < 9; x++) {
            bs.set(grid[(r * 9) + x]);
            bs.set(grid[(9 * x) + c]);
        }

        int sr = (r / 3) * 3;
        int sc = (c / 3) * 3;

        for (int x = sr; x < sr + 3; x++) {
            for (int y = sc; y < sc + 3; y++) {
                bs.set(grid[(x * 9) + y]);
            }
        }
        bs.flip(0, 10);
        return bs.stream().toArray();
    }

}
