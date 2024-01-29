package roles;
import models.*;

import java.util.Scanner;


import helpers.*;

public class ReceptionistRole {
    
    public static void receptionistRole(int id){

        Scanner input = new Scanner(System.in);
        boolean loggedIn = true;
        Receptionist receptionist = ReceptionistManagement.search(id);
        
        
        while (loggedIn) {
            int choice = ReceptionistMenu.ReceptionistMainMenu();
            
            switch (choice){

                case 1: 
                    System.out.println("\n**** You are now adding a new guest ****");

                    System.out.print("\nEnter guest national id: ");
                    int guestID = Functions.readPositive();

                    System.out.print("Enter guest name: ");
                    String name = input.next();

                    System.out.print("Enter guest email: ");
                    String email = input.next();

                    int add = GuestManagement.addGuest(name, guestID, email);
                    if(add == -1){
                        System.out.println("\nThis national ID is already taken.\n");
                    }
                    else{
                        System.out.println("\nThe guest has been added successfully!\n");
                    }

                    
                    break;

                case 2:
                System.out.println("assign room to guest");
                choice=0;

                case 3:
                System.out.println("3");
                choice=0;

                case 4:
                System.out.println("4");
                choice=0;

                case 5:
                System.out.println("5");
                choice=0;

                case 6:
                System.out.println("6");
                choice=0;

                case 7:
                System.out.println("7");
                choice=0;

                case 8:
                System.out.println("8");
                choice=0;

                case 9:
                System.out.println("9");
                choice=0;


                case 10:
                System.out.println("10");
                choice=0;

                default:
                System.out.println("Enter valid number from the menu: ");
                choice= Functions.readPositiveOrZero();
            }
        
        }


    }

    public static void main (String args[]){
        receptionistRole(2);

    }

}
