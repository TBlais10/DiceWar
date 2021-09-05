package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {

    static Scanner scanner = new Scanner(System.in);

    public static int getInt(int min, int max) {
        try {
            //String[] blarg = {}; //This is a test for error messages
            System.out.print("Input: ");
            int input = scanner.nextInt();
            //String asdf = blarg[1]; //This is a test for error messages
            if (input > max || input < min) {
                System.out.println("Input is out of range! Please try again with a number between " + min + " and " + max + ".");
                return getInt(min, max);
            }
            return input;
        } catch (InputMismatchException exception) {//testing for data types outside of int
            System.out.println("Incorrect input! Please provide a number and try again.");
            scanner.nextLine();
            return getInt(min, max);
        } catch (Exception exception) {//testing for unknown errors
            System.out.println("An unknown error appeared.");
            scanner.nextLine();
            return getInt(min, max);
        }
    }

    public static int getInt() {
        System.out.print("Input: ");
        int input = scanner.nextInt();
        return input;
    }

    public static void exit() {
        System.out.println("\n---\nAlrighty! Exiting the program. Please come again!\n---");
        System.exit(0);
    }

    public static String getString(int min, int max) {
        try {
            System.out.print("Input: ");
            String userInput = scanner.nextLine().trim();

            if (userStringCheck(min, max, userInput)) return getString(min, max);
            return userInput;

        } catch (InputMismatchException exception) {
            System.out.println("Incorrect input! Please provide a word or phrase and try again.");
            scanner.nextLine();
            return getString(min, max);
        } catch (Exception exception) {
            System.out.println("An unknown error appeared.");
            scanner.nextLine();
            return getString(min, max);
        }
    }

    public static String getString() {
        System.out.print("Input: ");
        String input = scanner.nextLine().trim();
        if (input.length() == 0) {
            System.out.println("The text box cannot be empty! Please try again.");
            return getString();
        }
        return input;
    }

    private static boolean userStringCheck(int min, int max, String userInput) {
        if (userInput == " ") {System.out.println("Your input cannot be empty! Please try again.");
            return true;
        }
        else if (userInput.length() < min){
            System.out.println("You cannot have less than " + min + " characters! Please try again");
            return true;
        }
        else if (userInput.length() > max) {
            System.out.println("You have exceeded the character limit of " + max + " by " + (userInput.length() - max) + "! Please try again.");
            return true;
        }
        return false;
    }

}
