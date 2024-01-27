package models;

public class Authentication {
    

    public static boolean AdminLogin(String name, int pass){
        for(Admin admin : Admin.getAdmins()){
            if(admin.login(name.trim(), pass)){
                return true;    // Admin logged in successfully
            }
        }
        return false;   // Admin login failed
    }

    public static boolean ReceptionistLogin(String name, int pass){
        for(Receptionist receptionist : ReceptionistManagement.getAllReceptionists()){
            if(receptionist.login(name, pass)){
                return true; // Receptionist logged in successfully
            }
        }
        return false;  // Receptionist login failed 
    }
}
