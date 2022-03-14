package jvmalgo.puzzles.chess.pieces;

import org.junit.jupiter.api.Test;

import static jvmalgo.puzzles.chess.ChessBoard.COLS;
import static jvmalgo.puzzles.chess.ChessBoard.ROWS;
import static jvmalgo.serializer.D2.D2Ser.ser2dPosArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KingTest {

    @Test
    void availableFromPosition() {
        assertFromPosition(4, 4, "[[5,4],[3,4],[4,5],[4,3],[5,5],[3,3],[3,5],[5,3]]");
        assertFromPosition(0, 0, "[[1,0],[0,1],[1,1]]");
        assertFromPosition(0, COLS - 1, "[[1,7],[0,6],[1,6]]");
        assertFromPosition(ROWS - 1, 0, "[[6,0],[7,1],[6,1]]");
        assertFromPosition(ROWS - 1, COLS - 1, "[[6,7],[7,6],[6,6]]");
    }

    private static void assertFromPosition(int r, int c, String expected) {
        var king = new King();
        king.setCol(c);
        king.setRow(r);
        assertEquals(expected, ser2dPosArray(king.getMoves(null)));
    }

}