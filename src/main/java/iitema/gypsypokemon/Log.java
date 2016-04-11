package iitema.gypsypokemon;

public class Log {
    private static boolean enabled = true;

    public static void enable() {
        enabled = true;
    }

    public static void disable() {
        enabled = false;
    }

    public static void print(String s) {
        if (enabled) {
            System.out.print(s);
        }
    }

    public static void println(String s) {
        if (enabled) {
            System.out.println(s);
        }
    }
}
