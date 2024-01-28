package helpers;

import java.util.Scanner;

public class Functions {
    
    static Scanner input = new Scanner(System.in);

    // Read Positive Integer Or Zero
    public static int readPositiveOrZero(){
        int n = 0;
        while (true) {
            try {
                n = input.nextInt();
                if(n>=0){
                    return n;
                } else {
                    System.out.println("Please enter a positive integer or zero: ");
                    input.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Enter a positive integer or zero: ");
                input.nextLine();
            }
        }
    }

    // Read Positive Integer > 0
    public static int readPositive(){
        int n = 0;
        while (true) {
            try {
                n = input.nextInt();
                if(n>0){
                    return n;
                } else {
                    System.out.println("Please enter a positive integer: ");
                    input.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Enter a positive integer: ");
                input.nextLine();
            }
        }
    }

    // Read Integer
    public static int readInt(){
        int n = 0;
        while (true) {
            try {
                n = input.nextInt();
                return n;
            } catch (Exception e) {
                System.out.println("Please enter a valid integer: ");
                input.nextLine();
            }
        }
    }
}