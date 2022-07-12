package jvmalgo.algos.unionfind;

abstract class UnionFind {
    protected int[] id;

    public UnionFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public abstract boolean isConnected(int a, int b);

    public abstract void union(int a, int b);

}
