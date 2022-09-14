package ocp.lang;

public record Rcrd(int id) {


    public Rcrd {

    }


    public Rcrd() {
        this(1);
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        var r = new Rcrd(1).clone();

        System.out.println(r);
    }
}
