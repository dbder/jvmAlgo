package jvmalgo.puzzles.chess.pieces;

import java.util.List;

import static jvmalgo.puzzles.chess.ChessBoard.COLS;
import static jvmalgo.puzzles.chess.ChessBoard.ROWS;

public abstract class ChessPiece {

    int row;
    int col;


    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

//    abstract int[][] tp;


    List<int[]> getMoves(int[][] board) {
        return null;
    }


    protected static boolean inbound(int[] pos) {
        return inbound(pos[0], pos[1]);
    }

    protected static boolean inbound(int r, int c) {
        return r >= 0 && c >= 0 && r < ROWS && c < COLS;
    }

    protected static int[] applyTP(int[] tp, int[] pos) {
        pos[0] += tp[0];
        pos[1] += tp[1];
        return pos;
    }

    protected static boolean collides(int[] pos, int[][] board) {
        return board[pos[0]][pos[1]] != 0;
    }
 }
