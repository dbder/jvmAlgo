package jvmalgo.datastructures.lc;

public class Pos {

    public Pos(int r, int c) {
        row = r;
        col = c;
    }

    public int row;
    public int col;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        return obj instanceof Pos && ((Pos) obj).row == this.row && ((Pos) obj).col == this.col;
    }

    @Override
    public String toString() {
        return "[" + row + "," + col + "]";
    }
}