package ocp.lang;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WSMain {

    public static void main(String[] args) {
        System.out.println(box(2));
        System.out.println(box(3));
        System.out.println(box(4));
        System.out.println(box(5));
    }

    static String box(int n) {
        return IntStream.range(1, n - 1).mapToObj(i -> "*" + " ".repeat(n - 2) + "*").collect(Collectors.joining("\n", "*".repeat(n) + "\n", "\n" + "*".repeat(n)));
    }
}
