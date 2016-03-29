package iitema.gypsypokemon;

import iitema.gypsypokemon.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Reflector {
    private static int levels = 0;
    private static boolean enabled = false;
    private static Scanner reader = new Scanner(System.in);
    private static Map<Integer, Integer> ids = new HashMap<Integer, Integer>();
    private static Map<String, Integer> objectCount = new HashMap<String, Integer>();

    private static String indent() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<levels; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }

    // not working, StackTraceElement.hashCode() does not return the callers hashCode
    private static int getId(String className, int hashCode) {
        if (!ids.containsKey(hashCode)) {
            if (objectCount.containsKey(className)) {
                int count = objectCount.get(className);
                count++;
                ids.put(hashCode, count);
                objectCount.replace(className, count);
                return count;
            }
                objectCount.put(className, 1);
                ids.put(hashCode, 1);
                return 1;
        }
        return ids.get(hashCode);
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

            String[] fullName = caller.getClassName().split("\\.");

            System.out.println(indent() + "->" + fullName[fullName.length - 1] + "." + caller.getMethodName() + "()");
            levels++;
        }
    }

    public static void end() {
        if(enabled) {
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            StackTraceElement caller = stackTraceElements[2];
            levels--;

            String[] fullName = caller.getClassName().split("\\.");

            System.out.println(indent() + "<-" + fullName[fullName.length - 1] + "." + caller.getMethodName() + "()");
        }
    }

    public static boolean ask(String question) {
        if (enabled) {
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
        } else {
            if (Thread.currentThread().getStackTrace()[2].getMethodName().equals("placeOn")){
                return false;
            }
            out("Mi legyen a válasz " + Thread.currentThread().getStackTrace()[2].getMethodName() + "fv által feltett kérdésre? (Reflector.ask())");
            return false;
        }
    }

    public static Direction silentOpposite(Direction dir) {
        off();
        Direction opposite = dir.getOpposite();
        on();
        return opposite;
    }

    public static ItemInterface askType() {
        out("Milyen tárgy van itt? Doboz (1-es kód) vagy Zpm (2-es kód)?");
        while (true) {
            int number = reader.nextInt();
            if (number == 1) {
                return new Zpm(new Ground(), new Game());
            }
            if (number == 2) {
                return new Box();


            }
        }

    }

    public static void out(String message) {
        System.out.println(indent() + message);
    }
}