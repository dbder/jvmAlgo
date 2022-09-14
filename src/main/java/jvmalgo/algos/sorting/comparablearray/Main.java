package jvmalgo.algos.sorting.comparablearray;

import java.util.Collections;
import java.util.UUID;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Main {
    public static int solve(String[] shows, int[] durations, int k) {
        record Show(String show, int duration) {
            static Show of(String s, int d) {
                return new Show(s, d);
            }
        }
        var map = IntStream.range(0, shows.length)
                .mapToObj(i -> Show.of(shows[i], durations[i]))
                .collect(groupingBy(Show::show, summingInt(Show::duration)));

        System.out.println(map);

        return map.values().stream().sorted(Collections.reverseOrder()).mapToInt(i -> i).limit(k).sum();
    }


    public static void main(String[] args) {

        UUID uniqueId = UUID.randomUUID();

        System.out.println(uniqueId);

        System.out.println(uniqueId.toString().substring(0, 10));
        System.out.println(uniqueId.toString().substring(0, Math.min(uniqueId.toString().length(), 10)));


        System.out.println("short".toString().substring(0, Math.min(10, "short".length())));
        System.out.println("short".toString().substring(0, 10));


    }

}