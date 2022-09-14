package ocp.resources;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceStuff {

    static Locale locale = new Locale("en", "US");
    static ResourceBundle rb = ResourceBundle.getBundle("myBundle");


    public static void main(String[] args) {
        var k = rb.getKeys();
        rb.keySet().forEach(key -> {
            System.out.println(rb.getString(key));
        });
    }

    public static int getTeamForPlayer(int teams, int player) {
        return (player % teams) + 1;
    }
}
