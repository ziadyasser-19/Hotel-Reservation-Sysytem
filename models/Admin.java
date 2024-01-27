package models;
import java.util.ArrayList;

public class Admin extends Person {
    
    // Attributes
    private final int id;
    private static int adminCount = 0;
    private static ArrayList<Person> users;
    private static ArrayList<Admin> admins = new ArrayList<Admin>();

    // Constructor
    public Admin(String name, int password){
        super(name, "Admin", password);
        this.id = ++adminCount;
        admins.add(this);      // n test l hwar dah 
    }
    
    // Setters


    // Getters
    public int getID(){
        return this.id;
    }

    public static ArrayList<Person> getAllUsers(){
        return users;
    }

    public static ArrayList<Admin> getAdmins(){
        return admins;
    }
    // Methods
    public void clearAllUsers(){
        
    }

}
