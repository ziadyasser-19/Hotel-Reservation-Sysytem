package models;

public class Room {
    
    // Attributes 
    private int roomID;
    private String roomType;
    private boolean isAvailable=true;
    private static int roomCount = 0;
    private double price;
    private int reservedDays;


    // Constructor
    public Room(int roomID, String roomType, boolean isAvailable,double price) {
        this.roomID=roomID;
        this.roomType = roomType;
        this.isAvailable=isAvailable;
        this.price=price;
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

    public static void setroomcounter(int x){
        roomCount=x;
    }
}
