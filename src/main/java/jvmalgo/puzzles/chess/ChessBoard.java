package jvmalgo.puzzles.chess;

public class ChessBoard {

    private static String[] pieces = {
            "--",
            "BR", // 1
            "BK", // 2
            "BB", // 3
            "BQ", // 4
            "BG", // 5
            "BP", // 6
            "WR", // 7
            "WK", // 8
            "WB", // 9
            "WQ", // 10
            "WG", // 11
            "WP"  // 12
    };

    public static final int ROWS = 8;
    public static final int COLS = 8;

    final int[] positions;

    public ChessBoard() {
        positions = new int[ROWS * COLS];

    }


    public void print() {
        System.out.println("-------------------------");
        char c = 'H';
        for (int p = 0; p < ROWS * COLS; p++) {
            if (p % 8 == 0) {
                System.out.println();
                System.out.print(c-- + "|");
            }
            System.out.print(pieces[positions[p]] + "|");
        }
        System.out.println();
        System.out.println("---1--2--3--4--5--6--7--8-");
    }

    ChessBoard place(int r, int c, int piece) {
        positions[(r * COLS) + c] = piece;
        return this;
    }

    public static void main(String[] args) {
        new ChessBoard()
                .setup()
                .print();
    }

//    Piece[] bpieces = {BROOK, BKNIGHT, BBISSHOP, BQUEEN, BKING, BBISSHOP, BKNIGHT, BROOK};
//    Piece[] wpieces = {WROOK, WKNIGHT, WBISSHOP, WQUEEN, WKING, WBISSHOP, WKNIGHT, WROOK};

    private ChessBoard setup() {
        for (int x = 0; x < 8; x++) {
            place(1, x, 5);
            place(6, x, 12);
        }
        place(0, 0, 1);
        place(0, 1, 2);
        place(0, 2, 3);
        place(0, 3, 4);
        place(0, 4, 5);
        place(0, 5, 3);
        place(0, 6, 2);
        place(0, 7, 1);

        place(7, 0, 7);
        place(7, 1, 8);
        place(7, 2, 9);
        place(7, 3, 10);
        place(7, 4, 11);
        place(7, 5, 9);
        place(7, 6, 8);
        place(7, 7, 7);

        return this;
    }

}
