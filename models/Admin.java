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

    public static int addAdmin(String name, int pass){
        for(Admin admin : admins){
            if(admin.getName().equalsIgnoreCase(name)){
                return -1; // admin name already exists
            }
    }
    admins.add(new Admin(name, pass));
    return 1; // added admin successfully
    }
}
