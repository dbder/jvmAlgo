package jvmalgo.global;

import java.util.Random;

public class Global {
     public static final Random RND = new Random();


     public static int nextRndInt() {
         return RND.nextInt();
     }
}
