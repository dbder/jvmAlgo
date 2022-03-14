package jvmalgo.generators;

import java.util.Arrays;
import java.util.Random;

public class StringGen {

    static final Random rnd = new Random();
    static final char[] possibilities = new char[26 + 3];
    static {
        for (int x = 0; x < 26; x++) {
            possibilities[x] = (char) ('a' + x);

        }
        possibilities[26] = '/';
        possibilities[27] = '_';
        possibilities[28] = '.';
    }


    public static String randomPath(int size, char[] possibleChars, String prefix) {
        var sb = new StringBuilder();
        sb.append(prefix);

        while (sb.length() < size) {
            sb.append(possibleChars[rnd.nextInt(possibleChars.length)]);
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(randomPath(3000, possibilities, "/"));
        System.out.println(Arrays.toString(possibilities));

    }
}
