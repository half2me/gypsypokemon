package iitema.gypsypokemon;

public class Reflector {
    private static int levels = 0;
    private static boolean enabled = false;

    public static void on() {
        enabled = true;
    }

    public static void off() {
        enabled = false;
    }

    public static void start() {
        if (enabled) {
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            StackTraceElement caller = stackTraceElements[2];

            for (int i = 0; i<levels; i++) {
                System.out.print("  ");
            }
            System.out.println("->" + caller.getClassName() + "." + caller.getMethodName() + "()");
            levels++;
        }
    }

    public static void end() {
        if(enabled) {
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            StackTraceElement caller = stackTraceElements[2];
            levels--;

            for (int i = 0; i<levels; i++) {
                System.out.print("  ");
            }
            System.out.println("<-" + caller.getClassName() + "." + caller.getMethodName() + "()");
        }
    }
}