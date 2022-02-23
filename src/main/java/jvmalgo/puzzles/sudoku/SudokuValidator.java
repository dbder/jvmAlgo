package jvmalgo.puzzles.sudoku;

/**
 * Validates a sudoku board
 */
public class SudokuValidator {

    public static boolean isValidSudoku(char[][] board) {
        for (int x = 0; x < 9; x++) {
            int hor = 0;
            int ver = 0;

            for (int y = 0; y < 9; y++) {
                //char horC = board[x][y];
                int tmp = (int) board[x][y] - 48;
                if (tmp != -2) {
                    if ((hor & (1L << tmp)) != 0) {
                        return false;
                    }
                    hor |= 1 << tmp;
                }
                tmp = (int) board[y][x] - 48;
                if (tmp != -2) {
                    if ((ver & (1L << tmp)) != 0) {
                        return false;
                    }
                    ver |= 1 << tmp;
                }
            }
        }

        for (int x = 0; x < 9; x += 3) {
            for (int y = 0; y < 9; y += 3) {
                int bl = 0;
                for (int z = 0; z < 3; z += 1) {
                    for (int zz = 0; zz < 3; zz += 1) {
                        int tmp = (int) board[z + x][y + zz] - 48;
                        if (tmp != -2) {
                            if ((bl & (1L << tmp)) != 0) {
                                return false;
                            }
                            bl |= 1 << tmp;
                        }
                    }
                }
            }
        }
        return true;
    }
}
