package models;
import java.util.ArrayList;

public class Admin extends Person {
    
    // Attributes
    private final int id;
    private static int adminCount = 0;
    private ArrayList<Person> users;

    // Constructor
    public Admin(String name, int password){
        super(name, "Admin", password);
        this.id = ++adminCount;
    }
    
    // Setters


    // Getters
    public int getID(){
        return this.id;
    }

    public ArrayList<Person> getAllUsers(){
        return users;
    }

    // Methods
    public void clearAllUsers(){
        
    }

}
