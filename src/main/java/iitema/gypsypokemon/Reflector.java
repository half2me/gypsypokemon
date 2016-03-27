package iitema.gypsypokemon;

import java.util.Scanner;

public class Reflector {
    private static int levels = 0;
    private static boolean enabled = false;
    private static Scanner reader = new Scanner(System.in);

    private static String indent() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<levels; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }

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

            System.out.println(indent() + "->" + caller.getClassName() + "." + caller.getMethodName() + "()");
            levels++;
        }
    }

    public static void end() {
        if(enabled) {
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            StackTraceElement caller = stackTraceElements[2];
            levels--;

            System.out.println(indent() + "<-" + caller.getClassName() + "." + caller.getMethodName() + "()");
        }
    }

    public static boolean ask(String question) {
        System.out.print(indent() + question + " I/N: ");
        while (true) {
            String answer = reader.nextLine().toUpperCase();
            if (answer.equals("I")) {
                return true;
            } else if (answer.equals("N")) {
                return false;
            } else {
                System.out.print(indent() + "Csak 'I' vagy 'N' karakterrel válaszolhat: ");
            }
        }
    }
}