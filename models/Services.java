package models;

public class Services {
    
    private int serviceID;
    private String serviceName;
    private double price;
    private String description;

    // Constructors
    public Services(int serviceID, String serviceName, double price, String description) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.price = price;
        this.description = description;
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
