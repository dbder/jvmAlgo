package jvmalgo.algos.sorting.comparablearray;

public class M {

    private final Dependency dependency;

    public M(Dependency dependency) {
        this.dependency = dependency;

        this.dependency.print();
    }

    public static void main(String[] args) {
        Dependency d = new Dependency();
        new M(d);
    }
}

class Dependency {

    void print() {
        System.out.println("hello");
    }
}

class Pair<F, S> {

    Pair(F f, S s) {
        first = f;
        second = s;
    }

    final F first;
    final S second;

    @Override
    public String toString() {
        return first + " " + second;
    }
}
