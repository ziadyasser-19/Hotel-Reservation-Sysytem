package models;

public class Room {
    
    // Attributes 
    private int roomID;
    private String roomType;
    private boolean isAvailable;


    // Constructor
    public Room(int roomID, String roomType, boolean isAvailable) {
        this.roomID=roomID;
        this.roomType = roomType;
        this.isAvailable=isAvailable;
    }

    // Setters
    public void setRoomID(int id){
        this.roomID=id;
    }

    public void setRoomType(String roomType){
        this.roomType = roomType;
    }

    public void setIsAvailable(boolean isAvailable){
        this.isAvailable=isAvailable;
    }

    // Getters
    public int getRoomID(){
        return this.roomID;
    }

    public String getRoomType(){
        return this.roomType;
    }

    public boolean getIsAvaialble(){
        return this.isAvailable;
    }
}
