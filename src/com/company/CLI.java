package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class CLI {

    static Scanner scanner = new Scanner(System.in);

    public static int getInt(int min, int max) {
        int input;
        while (true) {
            try {
                //String[] blarg = {}; //This is a test for error messages
                System.out.print("Input: ");
                input = Integer.parseInt(scanner.nextLine());
                //String asdf = blarg[1]; //This is a test for error messages
                if (input > max || input < min) {
                    System.out.println("Input is out of range! Please try again with a number between " + min + " and " + max + ".");
                } else {
                    break;
                }
            } catch (InputMismatchException exception) {//testing for data types outside of int
                System.out.println("Incorrect input! Please provide a number and try again.");
            } catch (Exception exception) {//testing for unknown errors
                System.out.println("An unknown error appeared.");

            }
        }
        return input;
    }


    public static void exit() {
        System.out.println("\n---\nClosing the program. See you soon!\n---");
        System.exit(0);
    }

    public static void exit(String statement) {
        System.out.println("Are you sure you want to exit " + statement + " ? Y/N");
        String answer = getString(1, 3);
        if (answer.equalsIgnoreCase("Y")) {
            System.out.println("Closing program! See you soon!");
            System.exit(0);
        } else if (answer.equalsIgnoreCase("N")) { // this statement will be dependent on the scope of the program.
            System.out.println("Ok, returning to main menu!");
            Menu.mainMenu();
        }
    }

    public static String getString(int min, int max) {
        String userInput;
        while (true) {
            try {
                System.out.print("Input: ");
                userInput = scanner.nextLine().trim();

                if (Objects.equals(userInput, " ")) {
                    System.out.println("Your input cannot be empty! Please try again.");
                } else if (userInput.length() < min) {
                    System.out.println("You cannot have less than " + min + " characters! Please try again");
                } else if (userInput.length() > max) {
                    System.out.println("You have exceeded the character limit of " + max + " by " + (userInput.length() - max) + "! Please try again.");
                } else {
                    break;
                }

            } catch (InputMismatchException exception) {
                System.out.println("Incorrect input! Please provide a word or phrase and try again.");
                scanner.nextLine();
            } catch (Exception exception) {
                System.out.println("An unknown error appeared.");
                scanner.nextLine();
            }
        }
        return userInput;
    }

    public static float getFloat(float min, float max){
        float input = 0;
        try{
            while(true){
                System.out.print("Input: ");
                input = scanner.nextFloat();
                if (max < input || min > input){
                    System.out.println("Input out of range! Please provide a number between " + min + " and " + max + ".");
                } else {
                    break;
                }
            }
        } catch (InputMismatchException exception){
            System.out.println("Incorrect input! Please try again.");
        }
        catch (Exception exception){
            System.out.println("Unknown error! Please try again.");
        }
            return input;
    }

    public static byte getByte(byte min, byte max){
        byte input = 0;
        try{
            while(true){
                input = scanner.nextByte();
                if (input > max || input < min){
                    System.out.println("Input out of range! Please enter a different number.");
                } else {
                    break;
                }
            }
        } catch (InputMismatchException exception){
            System.out.println("Incorrect input! Please try again.");
        }
        catch (Exception exception){
            System.out.println("Unknown error! Please try again.");
        }
        return input;
    }

    public static String getString() {
        String input;
        while (true){
            try {
        System.out.print("Input: ");
        input = scanner.nextLine().trim();

        if (input.length() == 0) {
            System.out.println("The text box cannot be empty! Please try again.");
        } else {
            break;
        }
            } catch (Exception exception){
                System.out.println("An unknown error appeared. Please try again.");
            }
        }
        return input;
    }

    public static void flavorText(String flavor, int repeat, String statement) {
        System.out.println(flavor.repeat(repeat));
        System.out.println(statement);
        System.out.print(flavor.repeat(repeat));
        System.out.println("\n");
    }

    public static void flavorText(String flavor, int repeat, ArrayList<String> statement) {
        int randomQuote = (int) (Math.random() * statement.size());

        System.out.println(flavor.repeat(repeat));
        System.out.println("\n");
        System.out.println(statement.get(randomQuote));
        System.out.println("\n");
        System.out.print(flavor.repeat(repeat) + "\n");
    }

    public static void newTerminalScreen(){
        System.out.println("\n".repeat(30));
    }

}
