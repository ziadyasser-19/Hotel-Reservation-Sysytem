package models;

import java.util.ArrayList;
//import java.util.List;

public class RoomManagement {
    
    private static ArrayList<Room> rooms = new ArrayList<>();

    // Methods
    public static int addRoom(int roomID, String roomType, boolean isAvailable){
        for(int i = 0; i < rooms.size(); i++){
            if (rooms.get(i).getRoomID() == roomID){
                return -1 ; // room already exists
            }
        } 
        rooms.add(new Room(roomID, roomType, isAvailable));
        return 1; // new room added 
    }

    public static int updateRoom(int roomID, boolean isAvailable){
        for(int i = 0; i < rooms.size(); i++){
            if(rooms.get(i).getRoomID() == roomID){
                rooms.get(i).setIsAvailable(isAvailable);
                return 1; // availability updated
            }
        }
        return -1; // failed to update 
    }

    public static int deleteRoom(int roomID){
        for(int i = 0; i < rooms.size(); i++){
            if(rooms.get(i).getRoomID() == roomID){
                rooms.remove(i);
                return 1; // deleted successfully
            }
        }
        return -1; // failed to delete 
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

public static int assignRoom(int roomid , int NationalId,int reservedDays){

    Guest guest = GuestManagement.SearchGuest(NationalId);
    Room room = SearchRoom(roomid);
        if(room.getIsAvaialble()){
            if(guest != null && room != null){
                guest.addRoom(room);
                room.setIsAvailable(false); // make the room reserved
                room.setReservedDays(reservedDays);  // set the number of days to reserve
                return 1 ; // assigned succefully 
            }
            else 
                return -1 ; // the guest or room not found 
        }
        else
            return 0 ; // the room is reserved
        
    }

public static int unassignRoom(int roomid,int NationalId){
    Guest guest =  GuestManagement.SearchGuest(NationalId);
    Room room = SearchRoom(roomid);
        if (guest.getRegRoom()==null)
            return -1 ; // the guest dont have a regroom

        else if (guest.getRegRoom()!=null){
            guest.deleteRoom();
            room.setIsAvailable(true); //make the room available again
            return 1;  //room unassigned succefully
        }
        else
            return 0; // room or guest not found 
}

}
