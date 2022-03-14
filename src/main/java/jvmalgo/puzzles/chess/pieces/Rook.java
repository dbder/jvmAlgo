package jvmalgo.puzzles.chess.pieces;

import java.util.ArrayList;
import java.util.List;

public class Rook extends ChessPiece {

    private int[][] tps = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };


    @Override
    List<int[]> getMoves(int[][] board) {
        var list = new ArrayList<int[]>();
        for (int[] tp : tps) {
            var tmp = new int[]{row, col};
            while (inbound(applyTP(tp, tmp)) && !collides(tmp, board)) {
                list.add(tmp.clone());
            }
        }
        return list;
    }
}
