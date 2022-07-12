package jvmalgo.algos.unionfind;
/**
 * stanford Algorithms I impl
 *
 * bit better than Quickfind
 */
public class QuickUnion extends UnionFind{


    QuickUnion(int n) {
        super(n);
    }


    /**
     * chase parent pointers until root
     */
    private int getRoot(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }

    public boolean isConnected(int a, int b) {
        return getRoot(a) == getRoot(b);
    }

    public void union(int a, int b) {
        int ra = getRoot(a);
        int rb = getRoot(b);
        id[ra] = rb;
    }
}