package jvmalgo.algos.unionfind;

public class WeightedQuickUnionPathCompression extends UnionFind{

    private int[] sz;

    public WeightedQuickUnionPathCompression(int n) {
        super(n);
        sz= new int[n];
    }


    /**
     * chase parent pointers until root
     */
    private int getRoot(int i) {
        while (i != id[i]) {

            //Path compression
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean isConnected(int a, int b) {
        return getRoot(a) == getRoot(b);
    }

    public void union(int a, int b) {
        int ra = getRoot(a);
        int rb = getRoot(b);
        if (ra == rb) return;
        if (sz[ra] < sz[rb]) {
            id[ra] = rb;
            sz[rb] += sz[ra];
        } else {
            id[rb] = ra;
            sz[ra] += sz[rb];
        }
    }
}
