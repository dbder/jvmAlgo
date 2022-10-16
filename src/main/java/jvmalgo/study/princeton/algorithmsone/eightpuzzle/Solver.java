package jvmalgo.study.princeton.algorithmsone.eightpuzzle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;
import java.util.List;

public class Solver {

    private int moves = -1;
    private List<Board> solution;
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }
        MinPQ<BoardQ> minPQ = new MinPQ<>();
        MinPQ<BoardQ> minPQLock = new MinPQ<>();
        minPQ.insert(new BoardQ(initial, 0, null));
        minPQLock.insert(new BoardQ(initial.twin(), 0, null));

        while (true) {
            BoardQ boardQ = minPQ.delMin();
            BoardQ boardQLock = minPQLock.delMin();
            if (boardQLock.board.isGoal()) {
                moves = -1;
                break;
            }
            if (boardQ.board.isGoal()) {
                var list = new LinkedList<Board>();
                while (boardQ != null) {
                    list.addFirst(boardQ.board);
                    boardQ = boardQ.prev;
                }
                solution = list;
                moves = list.size() -1;
                break;
            }
            for (Board b : boardQ.board.neighbors()) {
                if (boardQ.prev == null || !b.equals(boardQ.prev.board)) {
                    var nb = new BoardQ(b, boardQ.moves + 1, boardQ);
                    minPQ.insert(nb);
                }
            }
            for (Board b : boardQLock.board.neighbors()) {
                if (boardQLock.prev == null || !b.equals(boardQLock.prev.board)) {
                    var nb = new BoardQ(b, boardQLock.moves + 1, boardQLock);
                    minPQLock.insert(nb);
                }
            }
        }
    }

    public boolean isSolvable() {
        return moves >= 0;
    }

    public int moves() {
        return moves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        return solution;
    }

    private static class BoardQ implements Comparable<BoardQ> {

        private final BoardQ prev;
        private final int priority;
        private final int moves;
        private final Board board;

        BoardQ(Board board, int moves, BoardQ prev) {
            this.board = board;
            this.moves = moves;
            priority = board.manhattan() + moves;
            this.prev = prev;
        }

        @Override
        public int compareTo(BoardQ other) {
            return priority - other.priority;
        }

        @Override
        public String toString() {
            return "BoardQ{" +
                    "priority=" + priority +
                    ", moves=" + moves +
                    ", board=" + board +
                    '}';

        }
    }

    public static void main(String[] args) {

        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

}