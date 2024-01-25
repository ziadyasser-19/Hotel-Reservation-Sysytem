package models;

public class Receptionist extends Person {
    
    // Attributes 
    private final int id;
    private static int receptionistCounter = 0;
    
    // Constructor 
    public Receptionist(String name, int password) {
        super(name, "Receptionist", password);
        this.id = ++receptionistCounter;
    }
    
    // Setters


    // Getters
    public int getID(){
        return this.id;
    }

    // Methods  ** To be implemented later 
    public void filterRooms(){

    }

    public void enterClientData(){

    }

    public void assignRoomToGuest(){

    }

    public void viewNearestCheckout(){

    }

    public void billDetails(){

    }

    public void assignService(){

    }
}
