package models;

import java.util.ArrayList;
//import java.util.List;

public class RoomManagement {
    
    private static ArrayList<Room> rooms = new ArrayList<>();

    
    // Methods
    public static int addRoom(int roomID, String roomType, boolean isAvailable,double price){
        for(int i = 0; i < rooms.size(); i++){
            if (rooms.get(i).getRoomID() == roomID){
                return -1 ; // room already exists
            }
        } 
        rooms.add(new Room(roomID, roomType, isAvailable,price));
        return 1; // new room added 
    }

    public static int updateRoom(int roomID, double price){
        for(int i = 0; i < rooms.size(); i++){
            if(rooms.get(i).getRoomID() == roomID){
                rooms.get(i).setPrice(price);;
                return 1; // availability updated
            }
        }
        return -1; // failed to update 
    }

    
    
    public static int deleteRoom(int roomID){
        
        for(int i = 0; i < rooms.size(); i++){
            if(rooms.get(i).getRoomID() == roomID){
                if(rooms.get(i).getIsAvaialble()==false){
                    return -2; // the room is reserved it can't be deleted
                }
                else{
                rooms.remove(i);
                return 1; // deleted successfully
                }
            }
        }
        return -1; // room not exist
    }




    public static Room SearchRoom(int RoomId) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomID() == RoomId) {
                return rooms.get(i);
            }
        }
        return null; // Room not found
    }
    
    public static ArrayList<Room> getRoomList(){
        return rooms;
    }


//===================================Assign Room ================================

public static int assignRoom(int roomid , long NationalId,int reservedDays){

    try {
    Guest guest = GuestManagement.SearchGuest(NationalId);
    Room room = SearchRoom(roomid);
        
        if(guest.getRegRoom()!=null)
            return 2 ; // the guest has a room regestierd already 
        else if(guest != null && room != null){
                if(room.getIsAvaialble()){
                            guest.addRoom(room);
                            room.setIsAvailable(false); // make the room reserved
                            room.setReservedDays(reservedDays);  // set the number of days to reserve
                            return 1 ; // assigned succefully 
                        }
                        else 
                            return -1 ; // the room is reversed 
                    }
        else
                    return 0; // the guest or room not found
    }
    catch (NullPointerException e) {
        return 0;
    }}

public static int unassignRoom(int roomid,long NationalId){

    try {
    Guest guest =  GuestManagement.SearchGuest(NationalId);
    Room room = SearchRoom(roomid);
        if (guest.getRegRoom()==null)
            return -1 ; // the guest dont have a regroom

        else if (guest.getRegRoom()!=null){
            guest.deleteRoom();
            room.setIsAvailable(true); //make the room available again
            room.setReservedDays(0);
            return 1;  //room unassigned succefully
        }
        else
            return 0; // room or guest not found 
        }
        catch (NullPointerException e){
            return 0; // room or guest not found 
        }
    }

}
