package models;
import java.util.ArrayList;
import java.util.List;
public class ServicesManagement {
    
    private static ArrayList<Services> services = new ArrayList<>();

    // Methods 
    
    public static int addService(int id, String name, String description, double price) {
        for (int i = 0; i < services.size(); i++) {
            if (name.equalsIgnoreCase(services.get(i).getServiceName())) {
                return -1; // service already exist
            }
        }
        services.add(new Services(id, name, price, description));
        return 1; // added successfully
    }
    


    public static int deleteService(int serviceID){
        for(int i = 0 ; i<services.size();i++){
            if(services.get(i).getServiceID()==serviceID){
                services.remove(i);
                return 1; //service deleted succefully
            }
        }
        return -1;// Service not found
    }



    public static int updateService(int serviceID,String newdescription){
        for(int i = 0 ; i<services.size();i++){
            if (services.get(i).getServiceID()==serviceID){
                services.get(i).setDescription(newdescription);
                return 1; //succefully updated
            }
        }
            return -1;
    }

    public static Services searchService(int serviceID){
        return services.get(serviceID);
    }


//=============================== Assign Service ==================================

    public static int assignService(int serviceid , int NationalId){

        Guest guest =  GuestManagement.SearchGuest(NationalId);
        Services services = searchService(serviceid);
            
        if(guest != null && services != null){
            guest.addService(services);
            return 1 ; // assigned succefully 
        }
        else 
            return -1 ; // the guest or service  not found 
        
    }
    
    public static int unassignService(int NationalId){
        Guest guest = GuestManagement.SearchGuest(NationalId);
            if (guest.getRegServices()==null)
                return -1 ; // the guest dont have a regservice
                
            else if (guest.getRegServices()!=null){
                guest.deleteService();
                return 1;  //service unassigned succefully
            }
            else
                return 0; // service or guest not found 
    }
//===================================================================
    public void generateReport(int serviceID){

    }

    public List<Services> getServicesList() {
    return services;
}

}
