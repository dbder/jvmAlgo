package jvmalgo.algos.spatial.convexhull;

import jvmalgo.algos.spatial.convexhull.GrahamScan.Vector2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static jvmalgo.algos.spatial.convexhull.GrahamScan.Vector2.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GrahamScansortByYThenPolarOrderToFirstTest {

    static List<Vector2> list;
    static {
        list = new ArrayList<>();
        list.add(of(7, 0));
        list.add(of(7, 2));
        list.add(of(6, 4));
        list.add(of(4, 5));
        list.add(of(2, 4));
        list.add(of(1, 2));
    }
    static List<Vector2> getList() {
        return new ArrayList<>(list);
    }

    @Test
    void sortTest() {
        var l3 = getList();
        Collections.shuffle(l3);
        GrahamScan.sortByYThenPolarOrderToFirst(l3);
        for (int x = 0; x < list.size(); x++) {
            assertEquals(list.get(x), l3.get(x));
        }
    }
}