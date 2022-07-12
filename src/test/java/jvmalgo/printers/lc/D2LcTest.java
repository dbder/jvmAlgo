package jvmalgo.printers.lc;

import jvmalgo.generators.D2gen;
import org.junit.jupiter.api.Test;

class D2LcTest {



    @Test
    void printOnes2d() {

        D2Lc.printLists(D2gen.createOnesAndZeroRandom2d(200, 8));

    }

}