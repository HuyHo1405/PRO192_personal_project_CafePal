package util;

import java.util.Scanner;

public class IO {

    // Declare the Scanner object to read user input
    private static Scanner sc = new Scanner(System.in);

    // Input function to read an integer from the user with a custom error message
    public static int inputAnInteger(String inputMSG, String errorMSG) {
        int result;
        do {
            try {
                System.out.print(inputMSG);  // Prompt the user
                result = Integer.parseInt(sc.nextLine());  // Try to read and convert the input to an integer
                return result;  // If successful, return the result
            } catch (Exception e) {
                System.out.println(errorMSG);  // If there's an error (e.g., non-integer input), print the error message
            }
        } while (true);  // Keep trying until valid input is entered
    }

    // Input function to read an integer within a given range (min and max)
    public static int inputAnInteger(String inputMSG, String errorMSG, int min, int max) {
        int result;
        do {
            try {
                System.out.print(inputMSG);  // Prompt the user
                result = Integer.parseInt(sc.nextLine());  // Try to read and convert the input to an integer

                // Check if the result is within the valid range
                if (result < min || result > max) {
                    throw new Exception();  // Throw an exception if it's out of range
                }

                System.out.println("");  // Print an empty line for clarity
                return result;  // Return the valid result
            } catch (Exception e) {
                System.out.println(errorMSG);  // Print the error message if input is invalid
            }
        } while (true);  // Keep trying until valid input is entered
    }

    // Input function to read a non-empty string from the user
    public static String inputAString(String inputMSG, String errorMSG) {
        String result;
        do {
            try {
                System.out.print(inputMSG);  // Prompt the user
                result = sc.nextLine().trim();  // Read and trim the input (remove leading/trailing spaces)
                if (result.isEmpty()) {  // Check if the string is empty
                    throw new Exception();  // Throw an exception if it's empty
                }
                System.out.println("");  // Print an empty line for clarity
                return result;  // Return the valid result
            } catch (Exception e) {
                System.out.println(errorMSG);  // Print the error message if input is invalid
            }
        } while (true);  // Keep trying until valid input is entered
    }

    // Output function to generate a line of a given length with a specific character
    private static String line(int length, char token) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < length; i++) {
            line.append(token);  // Append the token character to the line
        }
        return line.toString();  // Return the generated line
    }

    // Output function to generate a header for displaying a section or menu
    public static String header(String name, int length, char token) {
        StringBuilder header = new StringBuilder();

        header.append(token);  // Start the header with the token character
        header.append(" " + name + " ");  // Add the name in the center
        header.append(line(length - name.length() - 3, token));  // Fill the remaining space with the token character

        return header.toString();  // Return the complete header string
    }

    // Output function to generate a footer of a given length with a specific character
    public static String footer(int length, char token) {
        return line(length, token) + "\n";  // Generate the footer and append a newline character
    }

    // String function to capitalize the first letter of each word in a string
    public static String capitalize(String str) {
        // Trim the string to remove leading/trailing spaces
        str = str.trim();

        // Return null if the string is empty
        if (str.isEmpty()) {
            return null;
        }

        // StringBuilder to build the result with capitalization
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 || i > 0 && (str.charAt(i - 1) == ' ' || str.charAt(i - 1) == '-')) {
                result.append(str.toUpperCase().charAt(i));  // Capitalize the first letter of each word
            } else {
                result.append(str.charAt(i));  // Otherwise, keep the letter as is
            }
        }

        return result.toString();  // Return the capitalized string
    }

}
