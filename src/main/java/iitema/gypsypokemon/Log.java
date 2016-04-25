package iitema.gypsypokemon;

public class Log {
    private static boolean enabled = true;

    /**
     * Enable logging
     */
    static void enable() {
        enabled = true;
    }

    /**
     * Disable logging
     */
    static void disable() {
        enabled = false;
    }

    /**
     * Log message into the same line
     *
     * @param s message
     */
    public static void print(String s) {
        if (enabled) {
            System.out.print(s);
        }
    }

    /**
     * Log message into a new line
     *
     * @param s message
     */
    public static void println(String s) {
        if (enabled) {
            System.out.println(s);
        }
    }
}
