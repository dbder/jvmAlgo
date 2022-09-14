package ocp.lang;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var list = getInput();
        printStats(list);
    }

    static List<Integer> getInput() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(7);
        list.add(9);
        list.add(4);
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Write numbers: ");
        return list;
    }

    static void printStats(List<Integer> list) {
        int even = 0;
        int odd = 0;
        for (var i : list) {
            if (i % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Even:" + even);
        System.out.println("Odd: " + odd);
    }
}
