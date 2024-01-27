import java.security.Provider.Service;
import java.util.ArrayList;

import models.Guest;
import models.Room;
import models.RoomManagement;
import models.Services;

public class Main {
    
    public static void main(String[] args){

        ArrayList<Guest> guest = new ArrayList<>();
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Services> services  = new ArrayList<>();

        Guest  guest1 = new Guest("ziad", 0000, "ziadamin908@gmail.com");
        Guest  guest2 = new Guest("ziad", 1111, "ziadamin908@gmail.com");
        Guest  guest3 = new Guest("ziad", 2222, "ziadamin908@gmail.com");
        Guest  guest4 = new Guest("ziad", 3333, "ziadamin908@gmail.com");

        Room room1 = new Room(1, "double", false);
        Room room2 = new Room(2, "double", false);
        Room room3 = new Room(3, "double", true);

        Services service1 = new Services(1, "5-stars", 500, "bf+din+fin");
        Services service2 = new Services(2, "5-stars", 500, "bf+din+fin");
        
        guest.add(guest1);
        guest.add(guest2);
        guest.add(guest3);
        guest.add(guest4);

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        services.add(service1);
        services.add(service2);
        
        System.out.println("the room of guest1 is : " + guest1.getRegRoom());

        RoomManagement.assignRoom(1,0000,3);

        System.out.println("the room of guest1 is : " + guest1.getRegRoom());
    }
}
