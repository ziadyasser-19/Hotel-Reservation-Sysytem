package roles;
import models.*;
import helpers.*;

import java.util.ArrayList;

public class ReceptionistRole {
    
    public static void receptionistRole(){

        Files.readGuestsFile();
        Files.RoomFileReader();
        Files.readServicesFile();
        Files.ReportReader();
        Files.readGuestIDRoomID();
        Files.readGuestIDServiceID();
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
                    String email = Functions.readEmail();

                    int add = GuestManagement.addGuest(name, guestID, email);
                    if(add == -1){
                        System.out.println("\nThis national ID is already taken.\n"); // id used before 
                    }else if(add == 2){
                        System.out.println(" \n Wrong national ID ! \n ");
                    }
                    else{
                        System.out.println("\nThe guest has been added successfully!\n"); // added successfully
                        Files.writeGuestsFile();

                    }
                    
                    int nestedChoice = ReceptionistMenu.ReceptionistAddGuest();
                    if(nestedChoice == 1){ // add another guest
                        continue;
                        
                    }else{ // back to main menu
                        Files.writeGuestsFile();
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
                            else {
                                Files.RoomFileWriter();
                                Files.writeGuestIDRoomID();        
                                back=true;          // back to menu
                            }
                    }
                    else {
                            System.out.println(" Something went wrong, try again.");
                            int n = ReceptionistMenu.ReceptionistTryAgain();  // Try again menu
                            if(n == 1){ //try to assign room again
                                continue;
                            }
                            else { 
                                Files.RoomFileWriter();
                                Files.writeGuestIDRoomID();
                                // back to menu 
                                back=true;
                            }
                    }
                    Files.RoomFileWriter();
                    Files.writeGuestIDRoomID();
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
                        else if(unassign == -2){
                            System.out.println("This isn't the room assigned by this guest");

                            int n = ReceptionistMenu.ReceptionistTryAgain(); //try again menu

                            if(n == 1){ //try to assign room again
                                continue;
                            }
                            else {
                                Files.RoomFileWriter();
                                Files.writeGuestIDRoomID();
                                back=true;   // back to menu
                            }
                        }
                        else {
                            System.out.println("Something went wrong! Please try again.");

                            int n = ReceptionistMenu.ReceptionistTryAgain(); //try again menu

                            if(n == 1){ //try to assign room again
                                continue;
                            }
                            else {
                                Files.RoomFileWriter();
                                Files.writeGuestIDRoomID();
                                back=true;   // back to menu
                            }
                        }
                        Files.RoomFileWriter();
                        Files.writeGuestIDRoomID();
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
                            ArrayList <Room> nearestRoom = Receptionist.viewNearstCheckout();
                            int i = 0;
                            if(nearestRoom.get(i).getReservedDays()==0){
                            System.out.println("===========================================");
                                System.out.println("There is empty rooms doesnt reserved : \n");
                                for( i = 0 ; i<nearestRoom.size() ;i++){
                                System.out.println("Room number :" + nearestRoom.get(i).getRoomID() + "  RoomType : " + nearestRoom.get(i).getRoomType() + "  Room Price : " + nearestRoom.get(i).getPrice() + " $");
                            }
                                back = true;
                            }else{
                                i = 0 ;
                                System.out.println("The Nearst check out is : ");
                                System.out.println("Room number :" + nearestRoom.get(i).getRoomID() + "   With in : " + nearestRoom.get(i).getReservedDays()+ "  RoomType : " + nearestRoom.get(i).getRoomType() + "  Room Price : " + nearestRoom.get(i).getPrice() + " $");
                                back = true;
                            }
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

                                Files.writeGuestIDServiceID();
                                back=true;
                            }
                            else if(assignService == 1){
                                System.out.println("Service assigned to guest successfully");
                                Files.writeGuestIDServiceID();
                                back=true;
                            }else{
                                System.out.println("the service id or the guest national id wasnt found");
                                Files.writeGuestIDServiceID();
                                back=true;
                            }
                        }
                        catch(Exception e){
                        
                            System.out.println("Error! Failed to assign service.");
                            int n = ReceptionistMenu.ReceptionistTryAgain();  // Try again menu
                            if(n == 1){      //try to assign room again
                                continue;
                            }
                            else {   
                                Files.writeGuestIDServiceID();
                                 // back to menu 
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
                                    System.out.println(guests.getId() + "   " + guests.getName() + "    " + guests.getNationalID() + "  " + guests.getemail());
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
                                System.out.println("\nGuest not found!");
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
                                    int bill = Receptionist.billDetails(idguest);

                                    if(bill == -2){
                                        System.out.println("\nGuest hasn't assigned to room and service yet!");
                                        back=true;
                                    }
                                    else if(bill == 1) {
                                        System.out.println("\nRoom Cost = No room assigned!");
                                        System.out.println("Service Cost = " + guestt.getRegServices().getServicePrice() + "$");
                                        System.out.println("Total Cost = " + guestt.getRegServices().getServicePrice() + "$");
                                        back=true;
                                    }
                                    else if(bill == 2){
                                        System.out.println("\nRoom Cost = " + guestt.getRegRoom().getPrice() + "$");
                                        System.out.println("Service Cost = No Service assigned!");
                                        System.out.println("Total Cost = " + guestt.getRegRoom().getPrice()  + "$");
                                        back=true;
                                    }
                                    else if(bill == 3) {
                                        System.out.println("\nRoom Cost = " + guestt.getRegRoom().getPrice() + "$");
                                        System.out.println("Service Cost = " + guestt.getRegServices().getServicePrice() + "$");
                                        System.out.println("Total Cost = " + (guestt.getRegRoom().getPrice() + guestt.getRegServices().getServicePrice())  + "$");
                                        back=true;
                                    }
                                }
                                catch(Exception e){
                                    System.out.println("Something went wrong!");
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

                            Guest guest2 = GuestManagement.SearchGuest(idofguest);

                            if(guest2 != null){
                                Services service2 = ServicesManagement.searchService(serviceid);
                                if(service2 != null){
                                    String report = Report.generatereport(guest2, service2, rate);
                                    System.out.println(report);
                                    back=true;
                                }
                                else{
                                    System.out.println("\nService Not Found!");
                                    int n = ReceptionistMenu.ReceptionistTryAgain();  // Try again menu
                                    if(n == 1){      //try to assign room again
                                        continue;
                                    }
                                    else {        
                                        back=true;  // back to menu 
                                    }
                                    back=true;
                                    }
                            }
                            else{
                                System.out.println("\nGuest Not Found!");
                                int n = ReceptionistMenu.ReceptionistTryAgain();  // Try again menu
                                if(n == 1){      //try to assign room again
                                    continue;
                                }
                                else {        
                                    back=true;  // back to menu 
                                }
                                back=true;
                            }
                        Files.ReportFileWriter();
                        back=true;
                        break;

                        // Delete Guest 
                        case 10:
                            System.out.println("\n**** You are now deleting a guest ****\n");

                            System.out.print("Please enter the National ID of the guest you want to delete: ");
                            long deletedguestId = Functions.ReadLong();

                            int delete = GuestManagement.deleteGuest(deletedguestId);

                            if(delete==1){
                                System.out.println("\nThe guest has been successfully deleted and unassigned the room reserved.");
                                Files.writeGuestsFile();
                                Files.RoomFileWriter();
                            }
                            else if(delete==0){
                                System.out.println("\nThe guest has been successfully deleted");
                                Files.writeGuestsFile();
                            }
                            else{
                                System.out.println("Guest not found! Try again");
                                int n = ReceptionistMenu.ReceptionistTryAgain();  // Try again menu
                                if(n == 1){ //try to delete guest again
                                    continue;
                                }
                                else { 
                                    Files.writeGuestsFile();
                                    Files.RoomFileWriter();
                                    back=true; // back to menu 
                                }
                            }
                            Files.writeGuestsFile();
                            Files.RoomFileWriter();
                            back=true;
                            break;
                            //[11] Services Rates
                        case 11 : 
                                System.out.println("The Rates Of The Services : ");
                                ArrayList<Services> servicelist = ServicesManagement.getServicesList();
                                for(int i =0 ;i<servicelist.size() ;i++){
                                    System.out.println("service id :  "+  servicelist.get(i).getServiceID() + "  Name : " + servicelist.get(i).getServiceName() + "    Service Rate :  " +Report.servicerate(servicelist.get(i).getServiceID()));
                                }
                                
                                back = true;
                                break;
                        // [0]- Log out
                        case 0:
                            Files.writeGuestsFile();
                            Files.RoomFileWriter();
                            Files.ReportFileWriter();
                            Files.writeServicesFile();
                            Files.writeGuestIDRoomID();
                            Files.writeGuestIDServiceID();
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


        Admin.addAdmin("faroha", 22);


        ServicesManagement.assignService(2,2004);
        
        // AdminRole.main(args);
        


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
