import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.Scanner;

import models.*;


public class Main {
    
    public static void main(String[] args){

        /* ArrayList<Guest> guest = new ArrayList<>();
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Services> services  = new ArrayList<>();


        Room room1 = new Room(1, "double", false);
        Room room2 = new Room(2, "double", false);
        Room room3 = new Room(3, "double", true);

        Services service1 = new Services(1, "5-stars", 500, "bf+din+fin");
        Services service2 = new Services(2, "5-stars", 500, "bf+din+fin");

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        services.add(service1);
        services.add(service2); */


        GuestManagement.addGuest("ziad", 0000, "ziadamin");
        GuestManagement.addGuest("mohsen", 1111, "ziadamin");
        GuestManagement.addGuest("fawzy", 2222, "ziadamin");

        System.out.println(GuestManagement.SearchGuest(1111).getId());
        System.out.println(GuestManagement.SearchGuest(0000).getId());
        System.out.println(GuestManagement.SearchGuest(2222).getId());

        RoomManagement.addRoom(1, "double", true);
        RoomManagement.addRoom(2, "double", true);
        RoomManagement.addRoom(3, "double", false);


        RoomManagement.assignRoom(1, 0000, 3);

        System.out.println(GuestManagement.SearchGuest(0000).getRegRoom());
        
        
        RoomManagement.assignRoom(1, 1111, 3);

        System.out.println(GuestManagement.SearchGuest(1111).getRegRoom());

        System.out.println(RoomManagement.SearchRoom(1).getIsAvaialble());



        RoomManagement.unassignRoom(1, 0000);
        System.out.println(RoomManagement.SearchRoom(1).getIsAvaialble());

        System.out.println("***********************************************");

        Admin admin = new Admin("farah", 123);
        Admin admin2 = new Admin("ziad", 456);

        for(Admin admins : Admin.getAdmins()){
            System.out.println(admins.getName() + " " + admins.getPass());
        }

        // Scanner input = new Scanner(System.in);
        // System.out.println("Enter admin name: ");
        // String name = input.nextLine();
        // System.out.println("Enter Admin Password: ");
        // int pass = input.nextInt();
        if(Authentication.AdminLogin("farah", 123)){
            System.out.println("Logged in successfully");
        }
        else{
            System.out.println("Login Failed");
        }

        System.out.println("**********************************");
        Receptionist recep1 = new Receptionist("Allen", 123);
        Receptionist recep2 = new Receptionist("Atlas", 896);
        ReceptionistManagement.addEmployee("Ava", 222);
        ReceptionistManagement.addEmployee("Ryle", 414);

        for(Receptionist receptionist : ReceptionistManagement.getAllReceptionists()){
            System.out.println(receptionist.getID() + " " +receptionist.getName() + " " + receptionist.getPass());
        }

        if(Authentication.ReceptionistLogin("Allen", 123)){
            System.out.println("logged in successfully");
        }
        else{
            System.out.println("login failed");
        }

        System.out.println(ReceptionistManagement.getAllReceptionists().size());
    }
}
