package myTools;

import java.util.ArrayList;
import java.util.Scanner;

public class IO {

    static Scanner sc = new Scanner(System.in);

    //input function
    ///
    public static int inputAnInteger(String inputMSG, String errorMSG) {
        int result;
        do {
            try {
                System.out.print(inputMSG);
                result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (Exception e) {
                System.out.println(errorMSG);
            }
        } while (true);
    }

    ///
    public static int inputAnInteger(String inputMSG, String errorMSG, int min, int max) {
        int result;
        do {
            try {
                System.out.print(inputMSG);
                result = Integer.parseInt(sc.nextLine());
                if (result > max && result < min) {
                    throw new Exception();
                }
                
                System.out.println("");
                return result;
            } catch (Exception e) {
                System.out.println(errorMSG);
            }
        } while (true);
    }

    ///
    public static String inputAString(String inputMSG, String errorMSG) {
        String result;
        do {
            try {
                System.out.print(inputMSG);
                result = sc.nextLine().trim();
                if(result.isEmpty())
                    throw new Exception();
                System.out.println("");
                return result;
            } catch (Exception e) {
                System.out.println(errorMSG);
            }
        } while (true);
    }

    //output function
    ///
    private static String line(int length, char token){
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < length; i++) {
            line.append(token);
        }
        return line.toString();
    }
    
    ///
    public static String header(String name, int length, char token){
        StringBuilder header = new StringBuilder();
        
        header.append(token);
        header.append(" " + name + " ");
        header.append(line(length - name.length() - 3, token));
        
        return header.toString();
    }
    
    ///
    public static String footer(int length, char token){
        return line(length, token);
    }
    
    //string
    ///
    public static String capitalize(String str){
        //trim
        str = str.trim();
        
        //check if is emty
        if(str.isEmpty())
            return null;
        
        //capitalize
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(i == 0 || i > 0 && (str.charAt(i - 1) == ' ' || str.charAt(i - 1) == '-'))
                result.append(str.toUpperCase().charAt(i));
            else
                result.append(str.charAt(i));
        }
        
        //return
        return result.toString();
    }
    
    
}
