package models;
import java.util.ArrayList;

public class ReceptionistManagement {

    private static ArrayList<Receptionist> receptionistArray= new ArrayList<>();

    // Methods
    public static int addEmployee(String name, int pass){
        for(int i = 0; i<receptionistArray.size(); i++){
            if(receptionistArray.get(i).getPass()==pass){
                return -1; // password used already
            }
        }
        // receptionistArray.add(new Receptionist(name, pass));
        new Receptionist(name, pass);
        return 1; // New Receptionist added successfully
    }


    public static int updateEmployeePass(int id, int pass){
        for(int i = 0; i<receptionistArray.size(); i++){
            if(receptionistArray.get(i).getPass()==pass){
                return -2; // password already used
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


    public static int deleteEmployee(int id){
        for(int i = 0; i<receptionistArray.size(); i++){
            if(receptionistArray.get(i).getID() == id){
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
