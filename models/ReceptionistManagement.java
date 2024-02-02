package models;
import java.util.ArrayList;

public class ReceptionistManagement {

    private static ArrayList<Receptionist> receptionistArray= new ArrayList<>();
    private static ArrayList<Integer> deletedID =  new ArrayList<>();

    // Methods
/*     public static int addEmployee(String name, int pass){
        for(int i = 0; i<receptionistArray.size(); i++){
            if(receptionistArray.get(i).getName()==name){
                return -1; // password used already
            }
        }
        if(deletedID.isEmpty()){
            receptionistArray.add(new Receptionist(name, pass));
            return 1; // New Receptionist added successfully with new id
        }
        else{
            for(int i = 0; i < deletedID.size();){
                int id = deletedID.get(i);
                receptionistArray.add(new Receptionist(id, name, pass));
                deletedID.remove(i);
                return 2;  // added with previously used id
            }   
        }
        return -2;
    } */
    
    public static int addEmployee(String name, int pass) {
        // Check if the name already exists
        for (int i = 0; i < receptionistArray.size(); i++) {
            if (receptionistArray.get(i).getName().equalsIgnoreCase(name)) {
                return -1; // Name already used
            }
        }
    
        if (deletedID.isEmpty()) {
            receptionistArray.add(new Receptionist(name, pass));
            return 1; // New Receptionist added successfully with a new id
        } else {
            deletedID.sort((a, b) -> a.compareTo(b)); // sorting array list
            int id = deletedID.remove(0);
    
            // Check if the name is already used with the recovered ID
            for (int i = 0; i < receptionistArray.size(); i++) {
                if (receptionistArray.get(i).getName().equalsIgnoreCase(name)) {
                    return -1; // Name already used
                }
            }
    
            receptionistArray.add(new Receptionist(id, name, pass));
            return 2; // Added with previously used id
        }
    }
    
    


    public static int updateEmployeePass(int id, int pass){
        for(int i = 0; i<receptionistArray.size(); i++){
            if(receptionistArray.get(i).getID()==id){
                if(receptionistArray.get(i).getPass()==pass){
                        return -2; // this is the current password
                }
            }
        }
        for(int i = 0; i<receptionistArray.size(); i++){
            if(receptionistArray.get(i).getID()==id ){
                receptionistArray.get(i).setPass(pass);
                return 1; // Receptionist's Pass updated successfully
            }
        }
        return -1; // Receptionist not found
    }

    //method overload to update by name 
    public static int updateEmployeePass(String name , int pass){
        for(int i = 0; i<receptionistArray.size(); i++){
            if(receptionistArray.get(i).getName().equals(name)){
                if(receptionistArray.get(i).getPass()==pass){
                        return -2; // this is the current password
                }
            }
        }
        for(int i = 0; i<receptionistArray.size(); i++){
            if(receptionistArray.get(i).getName().equals(name)){
                receptionistArray.get(i).setPass(pass);
                return 1; // Receptionist's Pass updated successfully
            }
        }
        return -1; // Receptionist not found
    }
    


    public static int deleteEmployee(int id){
        for(int i = 0; i<receptionistArray.size(); i++){
            if(receptionistArray.get(i).getID() == id){
                deletedID.add(id);
                receptionistArray.remove(i);
                return 1; // Receptionist removed successfully
            }
        }
        return -1; // Receptionist not found
    }
    
    public static Receptionist search(int id){
        for(int i =0; i<receptionistArray.size(); i++){
            if(receptionistArray.get(i).getID()==id){
                return receptionistArray.get(i);
            }
        }
        return null; // Receptionist not found
    }

    
    public static ArrayList<Receptionist> getAllReceptionists(){
        return receptionistArray;
    }

}
