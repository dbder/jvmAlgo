package jvmalgo.printers.lc;

import jvmalgo.generators.D1gen;
import org.junit.jupiter.api.Test;

import static jvmalgo.printers.lc.D1Lc.printLists;

/**
 * Tests are here as a convenient way to generate and save situations.
 * (explaining the lack of asserts)
 */
class D1LcTest {

    @Test
    void lcPrintTestCount() {
        printLists(D1gen.spreadCount(2222, 3333));
    }


}