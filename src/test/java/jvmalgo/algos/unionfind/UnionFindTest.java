package jvmalgo.algos.unionfind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnionFindTest {


    @Test
    void simple() {
        int n = 3;
        var qf = new Quickfind(n);
        var qu = new QuickUnion(n);
        var wqu = new WeightedQuickUnion(n);
        var wqupc = new WeightedQuickUnionPathCompression(n);

        qf.union(1,2);
        qu.union(1,2);
        wqu.union(1,2);
        wqupc.union(1,2);


        assertTrue(qf.isConnected(1,2));
        assertTrue(qu.isConnected(1,2));
        assertTrue(wqu.isConnected(1,2));
        assertTrue(wqupc.isConnected(1,2));

    }


}