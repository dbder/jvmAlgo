package jvmalgo.algos.unionfind;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list);
        Integer tmp = 0;
        list.remove((int)tmp);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);


    }


}
