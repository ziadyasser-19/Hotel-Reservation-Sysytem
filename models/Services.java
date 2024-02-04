package models;

public class Services {
    
    private int serviceID;
    private static int servicecounter=0;
    private String serviceName;
    private double price;
    private String description;

    // Constructors
    public Services( String serviceName, double price, String description) {
        this.serviceID = ++servicecounter;
        this.serviceName = serviceName;
        this.price = price;
        this.description = description;
    }

    public Services( int id, String serviceName, double price, String description) {
        this.serviceName = serviceName;
        this.price = price;
        this.description = description;
        this.serviceID = id;
    }

    // Setters
    public void setServiceID(int serviceID) { 
        this.serviceID = serviceID;
    }

    public void setServiceName(String serviceName){
        this.serviceName=serviceName;
    }

    public void setPrice(double price){
        this.price=price;
    }

    public void setDescription(String desc){
        this.description=desc;
    }

    // Getters
    public int getServiceID() { 
        return this.serviceID;
    }

    public String getServiceName() { 
        return this.serviceName;
    }

    public double getServicePrice() { 
        return this.price;
    }

    public String getServiceDesc() { 
        return this.description;
    }

}
