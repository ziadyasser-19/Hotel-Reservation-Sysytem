package test;
import java.util.Scanner;

class test {
    public static void main(String arg[]){

        System.out.println("Test");

        System.out.println("Kindly Enter your name :)");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();

        System.out.println("Hello " + name + " !");
    } 
}