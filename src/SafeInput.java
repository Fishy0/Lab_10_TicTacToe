import java.util.Scanner;

public class SafeInput {


    public static String getNonZeroLenString(Scanner pipe, String prompt) {

        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int number = 0;
        String bad = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                number = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                bad = pipe.nextLine();
                System.out.println("Must enter an integer: " + bad);
            }

        } while (!done);

        return number;
    }


    public static double getDouble(Scanner pipe, String prompt) {
        double number = 0;
        String bad = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                number = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                bad = pipe.nextLine();
                System.out.println("Must enter a double: " + bad);
            }
        } while (!done);

        return number;
    }


    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int number = 0;
        String bad = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]" + ": ");
            if (pipe.hasNextInt()) {
                number = pipe.nextInt();
                pipe.nextLine();
                if (number >= low && number <= high) {
                    done = true;
                } else {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]:" + number);
                }
            } else {
                bad = pipe.nextLine();
                System.out.println("Must enter integer: " + bad);
            }
        } while (!done);

        return number;
    }


    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double number = 0;
        String bad = "";
        boolean done = false;

        do {
            System.out.println("\n" + prompt + "[" + low + "-" + high + "]: ");
            if (pipe.hasNextDouble()) {
                number = pipe.nextDouble();
                pipe.nextLine();
                if (number >= low && number <= high) {
                    done = true;
                } else {
                    System.out.println("\nNumber out of range [" + low + "-" + high + "]: ");
                }
            } else {
                bad = pipe.nextLine();
                System.out.println("Must enter a double: " + bad);
            }
        } while (!done);

        return number;
    }


    public static boolean getYNConfirm(Scanner pipe, String prompt) {

        boolean answer = true;
        boolean finished = false;
        String responded = "";


        do {
            System.out.print("\n" + prompt + " [Y/N] "); // show prompt add space
            responded = pipe.nextLine();
            if (responded.equalsIgnoreCase("Y")) {
                finished = true;
                answer = true;
            } else if (responded.equalsIgnoreCase("N")) {
                finished = true;
                answer = false;
            } else {
                System.out.println("Must answer [Y/N]! " + responded);
            }

        } while (!finished);
        return answer;
    }


    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String answer = "";
        boolean finished = false;

        do {
            System.out.println("\n" + prompt + ": ");
            answer = pipe.nextLine();
            if (answer.matches(regEx)) {
                finished = true;
            } else {
                System.out.println("\n" + answer + " must match pattern " + regEx);
                System.out.println("Try again");
            }
        } while (!finished);

        return answer;
    }


    public static void prettyHeader(String msg) {
        for (int i = 0; i < 59; i++) {
            System.out.print("*");
        }
        System.out.println("*");

        int length = msg.length();
        System.out.print("***");
        for (int i = 0; i < (60 - (6 + length)) / 2; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < (60 - (6 + length)) / 2; i++) {
            System.out.print(" ");
        }
        if (length % 2 == 0) {
            System.out.println("***");
        } else {
            System.out.println(" ***");
        }


        for (int i = 0; i < 60; i++) {
            System.out.print("*");
        }

    }


}
