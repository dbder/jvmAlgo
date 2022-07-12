package jvmalgo.puzzles.chess.pieces;

import org.junit.jupiter.api.Test;

import static jvmalgo.puzzles.chess.ChessBoard.COLS;
import static jvmalgo.puzzles.chess.ChessBoard.ROWS;
import static jvmalgo.serializer.D2.D2Ser.ser2dPosArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RookTest {

    static final int[][] EMPTYBOARD = new int[8][8];


    @Test
    void availableFromPositionEmptyBoard() {
        assertFromPosition(4, 4, EMPTYBOARD, "[[5,4],[6,4],[7,4],[3,4],[2,4],[1,4],[0,4],[4,5],[4,6],[4,7],[4,3],[4,2],[4,1],[4,0]]");
        assertFromPosition(0, 0, EMPTYBOARD, "[[1,0],[2,0],[3,0],[4,0],[5,0],[6,0],[7,0],[0,1],[0,2],[0,3],[0,4],[0,5],[0,6],[0,7]]");
        assertFromPosition(0, COLS - 1, EMPTYBOARD, "[[1,7],[2,7],[3,7],[4,7],[5,7],[6,7],[7,7],[0,6],[0,5],[0,4],[0,3],[0,2],[0,1],[0,0]]");
        assertFromPosition(ROWS - 1, 0, EMPTYBOARD, "[[6,0],[5,0],[4,0],[3,0],[2,0],[1,0],[0,0],[7,1],[7,2],[7,3],[7,4],[7,5],[7,6],[7,7]]");
        assertFromPosition(ROWS - 1, COLS - 1, EMPTYBOARD, "[[6,7],[5,7],[4,7],[3,7],[2,7],[1,7],[0,7],[7,6],[7,5],[7,4],[7,3],[7,2],[7,1],[7,0]]");
    }

    private static void assertFromPosition(int r, int c, int[][] board, String expected) {
        var piece = new Rook();
        piece.setCol(c);
        piece.setRow(r);
        assertEquals(expected, ser2dPosArray(piece.getMoves(EMPTYBOARD)));
    }

}