package jvmalgo.puzzles.chess;

public class ChessPieceHolder {

    private Piece piece = Piece.NONE;

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }


    enum Piece {
        NONE("--"),
        BPAWN("BP"), BKNIGHT("BK"), BROOK("BR"), BKING("BK"), BQUEEN("BQ"), BBISSHOP("BB"),
        WPAWN("WP"), WKNIGHT("WK"), WROOK("WR"), WKING("WG"), WQUEEN("WQ"), WBISSHOP("WB");
        private final String code;

        Piece(String code) {
            this.code = code;
        }

        String getCode() {
            return code;
        }
    }


}
