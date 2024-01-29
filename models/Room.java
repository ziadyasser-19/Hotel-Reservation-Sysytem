package models;

public class Room {
    
    // Attributes 
    private int roomID;
    private String roomType;
    private boolean isAvailable=false;
    private static int roomCount = 0;
    private double price;
    private int reservedDays;


    // Constructor
    public Room(int roomID, String roomType, boolean isAvailable) {
        this.roomID=roomID;
        this.roomType = roomType;
        this.isAvailable=isAvailable;
        ++roomCount;
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

    public void setPrice(double price){
        this.price=price;
    }

    public void setReservedDays(int days){
        this.reservedDays=days;
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

    public int getRoomCount(){
        return Room.roomCount;
    }

    public double getPrice(){
        return this.price;
    }

    public int getReservedDays(){
        return this.reservedDays;
    }
}
