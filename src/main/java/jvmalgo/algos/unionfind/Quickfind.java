package jvmalgo.algos.unionfind;

/**
 * stanford Algorithms I impl
 *
 * slowest union
 */
public class Quickfind extends UnionFind{

    public Quickfind(int n) {
        super(n);
    }

    public boolean isConnected(int a, int b) {
        return id[a] == id[b];
    }

    public void union(int a, int b) {
        int idA = id[a];
        int idB = id[b];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == idA) {
                id[i] = idB;
            }
        }
    }

}
