package models;

import java.util.ArrayList;

public class RoomManagement {
    
    private static ArrayList<Room> rooms = new ArrayList<>();

    // Methods
    public int addRoom(int roomID, String roomType, boolean isAvailable){
        for(int i = 0; i < rooms.size(); i++){
            if (rooms.get(i).getRoomID() == roomID){
                return -1 ; // room already exists
            }
        } 
        rooms.add(new Room(roomID, roomType, isAvailable));
        return 1; // new room added 
    }

    public int updateRoom(int roomID, boolean isAvailable){
        for(int i = 0; i < rooms.size(); i++){
            if(rooms.get(i).getRoomID() == roomID){
                rooms.get(i).setIsAvailable(isAvailable);
                return 1; // availability updated
            }
        }
        return -1; // failed to update 
    }

    public int deleteRoom(int roomID){
        for(int i = 0; i < rooms.size(); i++){
            if(rooms.get(i).getRoomID() == roomID){
                rooms.remove(i);
                return 1; // deleted successfully
            }
        }
        return -1; // failed to delete 
    }

    public Room searchRoom(int roomID){
        return rooms.get(roomID);
    }
    
}
