package jvmalgo.printers.lc;

import org.junit.jupiter.api.Test;

import static jvmalgo.generators.D2Gen.listNRandomRanges;
import static jvmalgo.printers.lc.D2LC.printD2;

public class D2LCTest {

    /**
     * prints 2d arrays  with random content like:
     *[[16,20,5,12,8],[9,9,13,12,9],[1,12,8,2,4],[6,2,9,9,1]]
     * [[3,13,17,15,3],[9,14,16,13,7],[8,20,13,13,5],[7,19,12,2,15]]
     * [[13,16,16,16,1],[17,5,8,10,12],[18,14,6,15,6],[13,5,2,17,5]]
     */
    @Test
    void printD2randomFixedRanges() {

        for (int x = 1; x <= 3; x++) {

            printD2(listNRandomRanges(4, 5, 1, 20));
        }
    }
}
