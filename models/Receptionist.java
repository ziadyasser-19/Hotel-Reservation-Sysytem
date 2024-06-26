package models;

import java.util.ArrayList;


public class Receptionist extends Person {
    
    // Attributes 
    private final int id;
    private static int receptionistCounter = 0;
    
    // Constructor 
    public Receptionist(String name, int password) {
        super(name, "Receptionist", password);
        this.id = ++receptionistCounter;
    }

    
    public Receptionist(int id, String name, int password){
        super(name, "Receptionist", password);
        this.id=id;
    }
    
    // Setters

    public static void SetReceptionistCounter(int x) {
        receptionistCounter = x;
    }

    // Getters
    public int getID(){
        return this.id;
    }

// Methods  ** To be implemented later 

public static ArrayList<Room> filterRooms() {
    ArrayList<Room> availablerooms = new ArrayList<>(); // new list to show available rooms only 
    ArrayList<Room> allrooms = RoomManagement.getRoomList(); // the official list
    
    for (int i=0;i <allrooms.size();i++){
        if (allrooms.get(i).getIsAvaialble()) // if room is available 
            availablerooms.add(allrooms.get(i));
        }
    return availablerooms;
}


//
    
    /* public static Room viewNearestCheckout( ){
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
    } */

    public static ArrayList<Room> viewNearstCheckout(){
        ArrayList <Room> NearestRooms = new ArrayList<>();
        ArrayList <Room>  allRooms = RoomManagement.getRoomList();
        int max = 2500;
        for(int i = 0 ; i<allRooms.size();i++){
            if(allRooms.get(i).getReservedDays()<max){
                max = allRooms.get(i).getReservedDays();
            }
        }
        for(int i =0 ; i<allRooms.size();i++){
            if(allRooms.get(i).getReservedDays() == max){
                NearestRooms.add(allRooms.get(i));
            }
        }
        return  NearestRooms;
    }


    public static int billDetails(long NationalId){
        Guest guest = GuestManagement.SearchGuest(NationalId); // get the guest you want
    

        if(guest.getRegRoom() == null){
                if(guest.getRegServices() == null){
                    return -2; // guest has no room and service reserved
                }
                else{
                    return 1; // guest has assigned to service only
                }
            }
        else{
                if(guest.getRegServices() == null){
                    return 2; // guest has assigned to room only
                }
                else{
                    return 3; // guest assigned to room and service
                }
            }
    }
}
