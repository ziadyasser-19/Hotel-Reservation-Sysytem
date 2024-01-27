package models;

import java.util.ArrayList;
import java.util.List;

public class Receptionist extends Person {
    
    // Attributes 
    private final int id;
    private static int receptionistCounter = 0;
    
    // Constructor 
    public Receptionist(String name, int password) {
        super(name, "Receptionist", password);
        this.id = ++receptionistCounter;
        ReceptionistManagement.getAllReceptionists().add(this);
    }
    
    // Setters


    // Getters
    public int getID(){
        return this.id;
    }

// Methods  ** To be implemented later 

public static List<Room> filterRooms() {
    ArrayList<Room> availablerooms = new ArrayList<>(); // new list to show available rooms only 
    ArrayList<Room> allrooms = RoomManagement.getRoomList(); // the official list
    
    for (int i=0;i <allrooms.size();i++){
        if (allrooms.get(i).getIsAvaialble()) // if room is available 
            availablerooms.add(allrooms.get(i));
        }
    return availablerooms;
}


//
    
    public static Room viewNearestCheckout( ){
        ArrayList<Room> room = RoomManagement.getRoomList();
        int max = 1500;
        int index = 0; // to know the index of the lowest reserved day
        for(int i = 0 ; i<room.size();i++){
            if(room.get(i).getReservedDays()<max){
                max=room.get(i).getReservedDays();    // to get the lowest reserved days 
                index=i;
            }
        }
        return room.get(index);
    }


    public static double billDetails(int NationalId){
        Guest guest = GuestManagement.SearchGuest(NationalId); // get the guest you want

        if (guest == null )
        return -1 ; // guest not found
        else
            return guest.getRegRoom().getPrice() + guest.getRegServices().getServicePrice();
    }


}
