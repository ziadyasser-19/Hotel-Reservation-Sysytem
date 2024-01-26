package models;
import java.util.ArrayList;
import java.util.List;
public class ServicesManagement {
    
    private static ArrayList<Services> services = new ArrayList<>();

    // Methods 
    
    public int addService(int id, String name, String description, double price) {
        for (int i = 0; i < services.size(); i++) {
            if (name.equalsIgnoreCase(services.get(i).getServiceName())) {
                return -1; // service already exist
            }
        }
        services.add(new Services(id, name, price, description));
        return 1; // added successfully
    }
    


    public int deleteService(int serviceID){
        for(int i = 0 ; i<services.size();i++){
            if(services.get(i).getServiceID()==serviceID){
                services.remove(i);
                return 1; //service deleted succefully
            }
        }
        return -1;// Service not found
    }



    public int updateService(int serviceID,String newdescription){
        for(int i = 0 ; i<services.size();i++){
            if (services.get(i).getServiceID()==serviceID){
                services.get(i).setDescription(newdescription);
                return 1; //succefully updated
            }
        }
            return -1;
    }

    public Services searchService(int serviceID){
        return services.get(serviceID);
    }

    

    public void generateReport(int serviceID){

    }

    public List<Services> getServicesList() {
    return services;
}

}
