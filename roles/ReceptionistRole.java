package roles;
import models.*;
import helpers.*;

import java.util.ArrayList;

public class ReceptionistRole {
    
    public static void receptionistRole(){

        boolean loggedIn = true;
        
        outerloop:while (loggedIn) {
            int choice = ReceptionistMenu.ReceptionistMainMenu();
            boolean back = false;

            while(back==false){
            switch (choice){

                // [1] Add guest data 
                case 1: 
                    System.out.println("\n**** You are now adding a new guest ****");

                    System.out.print("\nEnter guest national id: ");
                    long guestID = Functions.ReadLong();

                    System.out.print("Enter guest name: ");
                    String name = Functions.readString();

                    System.out.print("Enter guest email: ");
                    String email = Functions.readString();

                    int add = GuestManagement.addGuest(name, guestID, email);
                    if(add == -1){
                        System.out.println("\nThis national ID is already taken.\n"); // id used before 
                    }else if(add == 2){
                        System.out.println(" \n Wrong national ID ! \n ");
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
                    long guestId = Functions.ReadLong();

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


                    // [3] - Unassign Room from guest
                    case 3:
                        System.out.println("\n**** Unassign Room From Guest ****\n");

                        System.out.println("Enter guest national ID: ");
                        long guestid = Functions.ReadLong();

                        System.out.println("Enter room number: ");
                        int roomno = Functions.readPositive();

                        int unassign = RoomManagement.unassignRoom(roomno, guestid);

                        if(unassign == 1){
                            System.out.println("The Room unassigned successfully");
                        }
                        else if(unassign == -1){
                            System.out.println("This guest does not have a room assigned");
                        }
                        else {
                            System.out.println("Something went wrong! Please try again.");

                            int n = ReceptionistMenu.ReceptionistTryAgain(); //try again menu

                            if(n == 1){ //try to assign room again
                                continue;
                            }
                            else { // back to menu 
                                back=true;
                            }
                        }
                        back=true;
                    break;


                    // [4] - Filter Rooms 
                    case 4:
                        System.out.println("\n**** Available Rooms ****\n");

                        ArrayList<Room> availablerooms = Receptionist.filterRooms();

                        if (!availablerooms.isEmpty()){
                            for(Room room : availablerooms){
                                System.out.println(room.getRoomID() + "    " + room.getRoomType() + "    " + room.getPrice() + "$");
                            }
                        }
                        else{
                            System.out.println("There are no available rooms at this time.");
                        }

                        back=true;
                    break;


                    // [5] - View Nearest Checkout
                    case 5:
                        try{
                            Room nearestRoom = Receptionist.viewNearestCheckout();

                            System.out.println("\nNearest room will checked out is room number  :    " + nearestRoom.getRoomID() + "    with in  " +nearestRoom.getReservedDays() + "  Days !");
                            back=true;
                        }
                        catch(Exception e){
                            System.out.println("There is no rooms in the system");
                            back=true;
                        }
                    break;


                    // [6] Assign guest to service  
                    case 6:
                        System.out.println("\n**** Assign Service To Guest ****\n");

                        System.out.println("Enter guest national ID: ");
                        long guest = Functions.ReadLong();

                        System.out.println("Enter service ID: ");
                        int service = Functions.readPositive();

                        try{
                            int assignService = ServicesManagement.assignService(service, guest);

                            if(assignService==-2){
                                System.out.println("This guest already assigned a service!");
                                back=true;
                            }
                            else if(assignService == 1){
                                System.out.println("Service assigned to guest successfully");
                                back=true;
                            }else{
                                System.out.println("the service id or the guest national id wasnt found");
                                back=true;
                            }
                        }
                        catch(Exception e){
                        
                            System.out.println("Error! Failed to assign service.");
                            int n = ReceptionistMenu.ReceptionistTryAgain();  // Try again menu
                            if(n == 1){      //try to assign room again
                                continue;
                            }
                            else {        // back to menu 
                                back=true;
                            }

                        }
                        break;

                        // [7]- View all guests
                        case 7:
                            System.out.println("\n**** All Registered Guests ***\n");

                            ArrayList<Guest> allGuests = GuestManagement.getGuestArray();

                            if(!allGuests.isEmpty()){
                                for(Guest guests : allGuests){
                                    System.out.println(guests.getId() + "   " + guests.getName() + "    " + guests.getNationalID());
                                }
                                back=true;
                            }
                            else{
                                System.out.println("There are no guests registered yet.\nPlease add some guests first.");
                                back=true;
                            }
                        break;


                        // [8]- Print detailed bill for the guest
                        case 8:
                            System.out.println("Enter guest national ID: ");
                            long idguest = Functions.ReadLong();

                            Guest guestt = GuestManagement.SearchGuest(idguest);

                            if(guestt==null){
                                System.out.println("Guest not found!");
                                int n = ReceptionistMenu.ReceptionistTryAgain();  // Try again menu
                                if(n == 1){      //try to assign room again
                                    continue;
                                }
                                else {        // back to menu 
                                    back=true;
                                }
                            }
                            else{
                                try{
                                    double bill = Receptionist.billDetails(idguest);
                                    
                                    System.out.println("\nTotal Bill Cost for the guest= " + bill + "    Room cost : " +guestt.getRegRoom().getPrice() +" $   " + "  Service cost : " +guestt.getRegServices().getServicePrice() +" $" );
                                    back=true;
                                }
                                catch(Exception e){
                                    System.out.println("Guest has not assigned to room or service yet!");
                                    back=true;
                                }
                            }
                        break;

                        // [9]- Generate report about service
                        case 9:
                            System.out.println("Enter guest national ID: ");
                            long idofguest = Functions.ReadLong();
                            
                            System.out.println("Enter Service id: ");
                            int serviceid = Functions.readPositive();
                            
                            System.out.println("Enter rating from 1 to 5: ");
                            double rate = Functions.readDouble(5);
                            
                            try{
                                Guest guest2 = GuestManagement.SearchGuest(idofguest);
                                Services service2 = ServicesManagement.searchService(serviceid);

                                String report = Report.generatereport(guest2, service2, rate);
                                System.out.println(report);
                                back=true;
                            } 
                            catch (Exception ex) {
                                System.out.println("\nEither guest or service is not available");
                                int n = ReceptionistMenu.ReceptionistTryAgain();  // Try again menu
                                if(n == 1){      //try to assign room again
                                    continue;
                                }
                                else {        // back to menu 
                                    back=true;
                                }
                                back=true;
                            }
                        break;

                        // [0]- Log out
                        case 0:
                            break outerloop;
                }
        
            }   
        }
    }



    public static void main (String args[]){
        // RoomManagement.addRoom(4, "single", false, 44);
        RoomManagement.addRoom(5, "single", true, 44);
        GuestManagement.addGuest("farah", 2004, "farahhh");
        ServicesManagement.addService("gym", "", 250);
        ServicesManagement.addService("spa", "", 300);

        


        receptionistRole();

        // RoomManagement.assignRoom(5, 2, 5);

        // ReceptionistManagement.addEmployee("farah", 2004);
        // ReceptionistManagement.addEmployee("farah", 203);
        // ReceptionistManagement.addEmployee("ziad", 22);

        // for(Receptionist receptionist : ReceptionistManagement.getAllReceptionists()){
        //     System.out.println(receptionist.getID() + " " + receptionist.getName() + " " + receptionist.getPass());
        // }

    }

}
