package models;
import java.util.ArrayList;

public class ServicesManagement {
    
    private static ArrayList<Services> services = new ArrayList<>();

    // Methods 
    
    public static int addService( String name, String description, double price) {
        for (int i = 0; i < services.size(); i++) {
            if (name.equalsIgnoreCase(services.get(i).getServiceName())) {
                return -1; // service already exist
            }
        }
        services.add(new Services( name, price, description));
        return 1; // added successfully
    }
    


    public static int deleteService(String serviceName) {
        for (int i = 0; i < services.size(); i++) {
            if (services.get(i).getServiceName().equalsIgnoreCase(serviceName)) {
                services.remove(i);
                return 1; // Service deleted successfully
            }
        }
        return -1; // Service not found
    }
    
    



    public static int updateService(String name ,double newprice){
        for(int i = 0 ; i<services.size();i++){
            if (name.equalsIgnoreCase(services.get(i).getServiceName())){
                services.get(i).setPrice(newprice);;
                return 1; //succefully updated
            }
        }
            return -1;
    }

    public static Services searchService(int serviceID){
        for(int i = 0 ;i<services.size();i++){
            if(services.get(i).getServiceID()==serviceID){
                return services.get(i); // return this service
            }
        }
            return null; //if service not found
    }

    //overloaded method 
    public static Services searchServices(String name ){
        for(int i=0; i<services.size() ; i ++ ){
            if(name.equalsIgnoreCase(services.get(i).getServiceName())){
                return services.get(i);
            }
        }
        return null;
    }

//=============================== Assign Service ==================================

    public static int assignService(int serviceid , int NationalId){

        Guest guest =  GuestManagement.SearchGuest(NationalId);
        Services services = searchService(serviceid);
        
        if(guest.getRegServices()!=null)
            return -2; //this user has already registered in service before
        if(guest != null && services != null){
            guest.addService(services);
            return 1 ; // assigned succefully 
        }
        else 
            return -1 ; // the guest or service  not found 
    }
    
    public static int unassignService(int NationalId,Services serviceid){
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

    public static ArrayList<Services> getServicesList() {
    return services;
}

}
