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
            boolean back = false;

            while(back==false){
            switch (choice){

                // [1] Add guest data 
                case 1: 
                    System.out.println("\n**** You are now adding a new guest ****");

                    System.out.print("\nEnter guest national id: ");
                    int guestID = Functions.readPositive();

                    System.out.print("Enter guest name: ");
                    String name = Functions.readString();

                    System.out.print("Enter guest email: ");
                    String email = Functions.readString();

                    int add = GuestManagement.addGuest(name, guestID, email);
                    if(add == -1){
                        System.out.println("\nThis national ID is already taken.\n"); // id used before 
                    }
                    else{
                        System.out.println("\nThe guest has been added successfully!\n"); // added successfully
                    }
                    
                    int nestedChoice = ReceptionistMenu.ReceptionistAddGuest();
                    if(nestedChoice == 1){ // add another guest
                        continue;
                        
                    }else{ // back to main menu
                        back=true;
                        break;
                    }

                    
                // [2] Assign room to guest 
                case 2:
                    System.out.println("\n**** Assign room to guest ****\n");

                    System.out.println("Enter Guest National ID: ");
                    int guestId = Functions.readPositive();

                    System.out.println("Enter Room Number: ");
                    int roomNo = Functions.readPositive();

                    System.out.println("Enter Number of reservation days: ");
                    int reservationDays = Functions.readPositive();

                    int assign = RoomManagement.assignRoom(roomNo, guestId, reservationDays);

                    if(assign == 1){
                        System.out.println("\nThe room has been successfully assigned.");
                    } 
                    else if (assign == 2) {
                        System.out.println("The guest has already assigned a room before.");
                    }
                    else if (assign == -1){
                            
                            System.out.println("The room is already reserved by another guest.");
                            int n = ReceptionistMenu.ReceptionistTryAgain();  // Try again menu
                            if(n == 1){      //try to assign room again
                                continue;
                            }
                            else {        // back to menu 
                                back=true;
                            }
                    }
                    else {
                            System.out.println(" Something went wrong, try again.");
                            int n = ReceptionistMenu.ReceptionistTryAgain();  // Try again menu
                            if(n == 1){ //try to assign room again
                                continue;
                            }
                            else { // back to menu 
                                back=true;
                            }
                    }
                    
                    back=true;
                    break;
                    
                
            }
        
        }
    }


    }

    public static void main (String args[]){
        RoomManagement.addRoom(4, "single", true, 44);
        RoomManagement.addRoom(5, "single", true, 44);


        receptionistRole(2);

        // RoomManagement.assignRoom(5, 2, 5);

        // ReceptionistManagement.addEmployee("farah", 2004);
        // ReceptionistManagement.addEmployee("farah", 203);
        // ReceptionistManagement.addEmployee("ziad", 22);

        // for(Receptionist receptionist : ReceptionistManagement.getAllReceptionists()){
        //     System.out.println(receptionist.getID() + " " + receptionist.getName() + " " + receptionist.getPass());
        // }

    }

}
