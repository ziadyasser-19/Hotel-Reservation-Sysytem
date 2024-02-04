package models;
import java.util.ArrayList;

public class ServicesManagement {
    
    private static ArrayList<Services> services = new ArrayList<>();
    private static ArrayList<Integer> deletedID =  new ArrayList<>();


    // Methods 
    
    public static int addService( String name, String description, double price) {
        for (int i = 0; i < services.size(); i++) {
            if (name.equalsIgnoreCase(services.get(i).getServiceName())) {
                return -1; // service already exist
            }
        }

        if (deletedID.isEmpty()){
            services.add(new Services(name, price, description));
            return 1; // new service added with new id
        } else {
            deletedID.sort((a, b) -> a.compareTo(b));
            int id = deletedID.remove(0);

            for (int i = 0; i < services.size(); i++){
                if (services.get(i).getServiceName().equalsIgnoreCase(name)){
                    return -1; // service name already used
                }
            }

            services.add(new Services(id, name, price, description));
            return 2; // added with previously used id
        }
        
    }
    


    public static int deleteService(String serviceName) {
        for(int j=0;j<GuestManagement.getGuestArray().size();j++){
            if(serviceName.equalsIgnoreCase(GuestManagement.getGuestArray().get(j).getRegServices().getServiceName())){
                return 2; //the service assigned to guest cant be deleted 
            }
        }
        for (int i = 0; i < services.size(); i++) {
            if (services.get(i).getServiceName().equalsIgnoreCase(serviceName)) {
                deletedID.add(services.get(i).getServiceID());
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

    public static int assignService(int serviceid , long NationalId){

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
    
    public static int unassignService(long NationalId,Services serviceid){
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
