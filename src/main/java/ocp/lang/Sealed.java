package ocp.lang;

public class Sealed {

    public static void main(String[] args) {
        Cachable l  = new Last() {

        };

        System.out.println(l.VAL);
    }

}

sealed interface Cachable permits Valu, Result {
    int VAL = 1;
}

sealed interface Valu extends Cachable {
    int VAL = 2;

}
non-sealed interface Result extends Cachable {
    int VAL = 3;
}

non-sealed interface Last extends Valu {
    int VAL = 4;
}