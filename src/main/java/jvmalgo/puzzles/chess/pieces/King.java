package jvmalgo.puzzles.chess.pieces;

import java.util.ArrayList;
import java.util.List;

public class King extends ChessPiece {



    private int[][] tp = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},

            {1, 1},
            {-1, -1},
            {-1, 1},
            {1, -1}
    };


    @Override
    List<int[]> getMoves(int[][] board) {
        var list = new ArrayList<int[]>();
        for (var p : tp) {
            if (inbound(row + p[0], col + p[1])) {
                list.add(new int[]{row + p[0], col + p[1]});
            }
        }
        return list;
    }

    public static void main(String[] args) {
        var k = new King();
    }
}
