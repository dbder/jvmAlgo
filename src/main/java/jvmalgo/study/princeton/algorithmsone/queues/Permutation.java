package jvmalgo.study.princeton.algorithmsone.queues;

import java.util.Arrays;

public class Permutation {

    /**
     * main method
     */
    public static void main(String[] args) {

        Deque<Integer> deque = new Deque<>();
        Arrays.stream(args).forEach(i -> deque.addLast(Integer.parseInt(i)));
    }
}
