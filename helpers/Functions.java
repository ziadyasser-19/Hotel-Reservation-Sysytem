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


    //Read Double 
    public static double ReadDouble(){
        double x = 0 ;
        while(true){
            try{
            x=input.nextDouble();
            if(x>0){
                return x;
            }else{
                System.out.println("Enter a positive Double : ");
                input.nextLine();
            }
            }catch(Exception e){
                System.out.println("please enter a positive Double : ");
                input.nextLine();
            }
        }
    }

    //Read Long 
    
    public static long ReadLong(){
        long x = 0 ;
        while(true){
            try{
            x=input.nextLong();
            if(x>0){
                return x;
            }else{
                System.out.println("Enter a positive Long number ex :(30210120213230) : ");
                input.nextLine();
            }
            }catch(Exception e){
                System.out.println("Enter a positive Long number ex :(30210120213230) : ");
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

    public static String readString(){
        String s = "";
        while (true) {
            try{
                s = input.next();

                if(s.matches(".*-?\\d+(\\.\\d+)?.*")){
                    System.out.println("Cannot contain an integer. Please enter a string: ");
                }
                else{
                    return s;
                }
            } catch(Exception e){
                System.out.println("Invalid entry, please enter a string :");
                input.nextLine();
            }
        }
    }

    // overload function Read positive integer or zero from a menu
    public static int readPositiveOrZero(int max){
        int n = 0;
        while (true) {
            try {
                n = input.nextInt();
                if(n>=0){
                    if(n<=max){
                        return n;
                    } else {
                        System.out.println("Enter a number from the menu: ");
                    }
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

    // overload function Read Positive Integer > 0 from the menu
    public static int readPositive(int max){
        int n = 0;
        while (true) {
            try {
                n = input.nextInt();
                if(n>0){
                    if(n<=max){
                        return n;
                    } else{
                        System.out.println("Enter a number from the menu: ");
                    }
                } 
                else {
                    System.out.println("Please enter a positive integer: ");
                    input.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Enter a positive integer: ");
                input.nextLine();
            }
        }
    }

    // read double rating 
    public static double readDouble(int max){
        double n = 0;
        while (true){
            try {
                n = input.nextDouble();
                if(n>0){
                    if(n<=max){
                        return n;
                    } else {
                        System.out.println("Enter a number between 0 and " + max);
                    }
                }
                else {
                    System.out.println("Please enter a positive double number: ");
                    input.nextLine();
                }
            } catch (Exception e){
                System.out.println("Enter a valid positive double number: ");
                input.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter a name: ");
        String string = readString();
        System.out.println("your name is "+ string);
    }
}
