package models;

import java.util.ArrayList;
//import java.util.List;

public class GuestManagement {
    
    private static ArrayList<Guest> GuestArray = new ArrayList<>();

    // Methods
    
    public static int addGuest(String name , int NationalId , String email){
        for(int i = 0 ; i<GuestArray.size();i++){
            if (GuestArray.get(i).getNationalID()==NationalId){
                return -1; // guest already found
        }
    }
        GuestArray.add(new Guest(name, NationalId, email));
        return 1; //added succefully 
}

    
    public static int updateGuest(int id, String email) {
        if (GuestArray.get(id).getemail().equals(email)) {
            return -1; // Email is the same
        }
        GuestArray.get(id).setemail(email);
        return 1; // Successfully updated
    }
    
    
    public static int deleteGuest(int NationalId) {
        for (int i = 0; i < GuestArray.size(); i++) {
            if (GuestArray.get(i).getNationalID() == NationalId) {
                GuestArray.remove(i);
                return 1; // Successfully deleted
            }
        }
        return -1; // Guest not found
    }
    
        
    
    public static Guest SearchGuest(int NationalId) {
        for (int i = 0; i < GuestArray.size(); i++) {
            if (GuestArray.get(i).getNationalID() == NationalId) {
                return GuestArray.get(i);
            }
        }
        return null; // Guest not found
    }

    
    public ArrayList<Guest> getGuestArray() {
        return GuestArray;
    }
    
    
} 

/*  public static int SearchIndex(int id) {
        for (int i = 0; i < GuestArray.size(); i++) {
            if (GuestArray.get(i).getId() == id) {
                return i; // Return the index of the found guest
            }
        }
        // Guest index not found
        return -1;
    } */