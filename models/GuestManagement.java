package models;

import java.util.ArrayList;
//import java.util.List;

public class GuestManagement {
    
    private static ArrayList<Guest> GuestArray = new ArrayList<>();

    // Methods
    
    public static int addGuest(String name , long NationalId , String email){
        
        if(NationalId!=14){
            return 2; //invalid national id
        }
        for(int i = 0 ; i<GuestArray.size();i++){
            if (GuestArray.get(i).getNationalID()==NationalId){
                return -1; // guest already exist
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
    
    
    public static int deleteGuest(long NationalId) {
        for (int i = 0; i < GuestArray.size(); i++) {
            if (GuestArray.get(i).getNationalID() == NationalId) {
                if(GuestArray.get(i).getRegRoom()!=null){
                    RoomManagement.unassignRoom(GuestArray.get(i).getRegRoom().getRoomID(), NationalId);
                    GuestArray.remove(i);
                    return 1; // Successfully deleted and un assigned the room from him
                    }else{
                        GuestArray.remove(i);
                        return 0; // successfully deleted
            }
        }
    }
    return -1; // Guest not found
}
    
        
    
    public static Guest SearchGuest(long NationalId) {
        for (int i = 0; i < GuestArray.size(); i++) {
            if (GuestArray.get(i).getNationalID() == NationalId) {
                return GuestArray.get(i);
            }
        }
        return null; // Guest not found
    }

    
    public static ArrayList<Guest> getGuestArray() {
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