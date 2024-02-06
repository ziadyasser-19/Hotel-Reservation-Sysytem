package helpers;

import models.*;

public class FilesF {
    

    // Read Services File 
    public static void readServicesFile(){
        FilesHelper serviceFile = new FilesHelper(Pathes.ServicesPath);

        String services = serviceFile.ReadFile();

        if(!services.isEmpty()){
            String[] service = services.split("\n");

            for(String oneLine : service){
            
                if(oneLine.matches("\\d+-\\w+-\\w+-\\d+\\s?")){

                    String[] oneService = oneLine.split("-");
                    ServicesManagement.addService(Integer.parseInt(oneService[0]), oneService[1], Double.parseDouble(oneService[3]), oneService[2]);
                    Services.setServicesCounter(Integer.parseInt(oneService[0]));
                }
            }
        }
    }

    // Write Services File 
    public static void writeServicesFile(){
        FilesHelper serviceFile =  new FilesHelper(Pathes.ServicesPath);

        serviceFile.emptyFile();

        for(Services service : ServicesManagement.getServicesList()){
            serviceFile.writeToFile(service.getServiceID()+ "-" + service.getServiceName()+ "-" + service.getServiceDesc() + "-" + service.getServicePrice());
        }
    }

    //===================================================================================

    // Read Guests File 
    public static void readGuestsFile(){
        FilesHelper guestsFile = new FilesHelper(Pathes.GuestsPath);

        String allguests = guestsFile.ReadFile();

        if(!allguests.isEmpty()){
            String[] guest = allguests.split("\n");

            for(String oneline : guest){

                if(oneline.matches("\\d{14}-\\w+-[A-z0-9\\.]+@[A-z0-9]+\\.[A-z]+\\s?")){
                    System.out.println(oneline);
                    String[] guestData = oneline.split("-");
                    GuestManagement.addGuest(guestData[1], Long.parseLong(guestData[0]), guestData[2]);
                }
            }
        }
    }

    // Write Guests File
    public static void writeGuestsFile(){
        FilesHelper guestsFile = new FilesHelper(Pathes.GuestsPath);

        guestsFile.emptyFile();

        for(Guest guest : GuestManagement.getGuestArray()){
            guestsFile.writeToFile(guest.getNationalID() + "-" + guest.getName() + "-" + guest.getemail());
        }
    }

    //=======================================================================================================

    // Read Admin file 
    public static void readAdminFile(){
        FilesHelper adminFile = new FilesHelper(Pathes.adminspathes);

        String alladmins = adminFile.ReadFile();

        if(!alladmins.isEmpty()){
            String[] admin = alladmins.split("\n");

            for(String oneline : admin){

                if(oneline.matches("\\d+-\\w+-\\d+")){
                    String[] adminData = oneline.split("-");
                    Admin.addAdmin(Integer.parseInt(adminData[0]), adminData[1], Integer.parseInt(adminData[2]));
                }
            }
        }
    }

    // ========================================================================================

    // Read GuestID_ReservedRoomID File 
    public static void readGuestIDRoomID(){
        FilesHelper guestIdRoomIdFile = new FilesHelper(Pathes.guestIDRoomIDPath);

        String allData = guestIdRoomIdFile.ReadFile();

        if(!allData.isEmpty()){
            String[] data = allData.split("\\s+");

            for(String oneLine : data){
                
                if(oneLine.matches("\\b\\d{14}-\\d+-\\d+\\s?")){
                    
                    String[] guestRoom = oneLine.split("-");
                    RoomManagement.assignRoom(Integer.parseInt(guestRoom[1]), Long.parseLong(guestRoom[0]),Integer.parseInt(guestRoom[2]));
                }
            }
        }
    }

    // Write GuestID_ReservedRoomID File 
    public static void writeGuestIDRoomID(){
        FilesHelper guestIDRoomIDFile = new FilesHelper(Pathes.guestIDRoomIDPath);

        guestIDRoomIDFile.emptyFile();

        for(Guest guest : GuestManagement.getGuestArray()){
            if(guest.getRegRoom() != null){
                guestIDRoomIDFile.writeToFile(guest.getNationalID() + "-" + guest.getRegRoom().getRoomID() + "-" + guest.getRegRoom().getReservedDays());
            }
            
        }
    }

    // ========================================================================================


    // Read GuestID_ServiceID
    public static void readGuestIDServiceID(){
        FilesHelper guestIDServiceIDFile = new FilesHelper(Pathes.guestIDServiceIDPath);

        String allData = guestIDServiceIDFile.ReadFile();

        if(!allData.isEmpty()){
            String[] data = allData.split("\\s+");

            for(String oneline: data){
                
                if(oneline.matches("\\d{14}-\\d+\\s?")){

                    String[] guestService = oneline.split("-");
                    ServicesManagement.assignService(Integer.parseInt(guestService[1]), Long.parseLong(guestService[0]));
                }
            }
        }
    }

    // Write GuestID_ServiceID
    public static void writeGuestIDServiceID(){
        FilesHelper guestIDServiceIDFile = new FilesHelper(Pathes.guestIDServiceIDPath);

        guestIDServiceIDFile.emptyFile();

        for(Guest guest : GuestManagement.getGuestArray()){
            if(guest.getRegServices() != null){
                guestIDServiceIDFile.writeToFile(guest.getNationalID() + "-" + guest.getRegServices().getServiceID());
            }
        }
    }

    // ==================================================================================================

    // Read Services Deleted ID
    public static void readServicesDeletedID(){
        FilesHelper servicesDeletedID = new FilesHelper(Pathes.deletedServiceIDpath);

        String allID = servicesDeletedID.ReadFile();

        if(!allID.isEmpty()){
            String[] ids = allID.split("\\s+");

            for (String id : ids){
                if(id.matches("\\d+\\s?")){
                    
                    ServicesManagement.getServicesDeletedID().add(Integer.parseInt(id));
                    
                }
            }
        }
    }

    // Write Services Deleted ID
    public static void writeServicesDeletedID(){
        FilesHelper servicesDeletedID = new FilesHelper(Pathes.deletedServiceIDpath);

        servicesDeletedID.emptyFile();

        for(int id : ServicesManagement.getServicesDeletedID()){
            servicesDeletedID.writeToFile(String.valueOf(id));
        }
    }
    

    public static void main(String[] args) {
        // readServicesFile();
        // System.out.println("services");
        // System.out.println("array size= " +ServicesManagement.getServicesList().size());
        // for(Services service : ServicesManagement.getServicesList()){
        //     System.out.println(service.getServiceID()+ "   " + service.getServiceName() + "   "+ service.getServiceDesc()+ "  " + service.getServicePrice());
        // }
        readGuestsFile();
        // readGuestIDRoomID();
        // readGuestIDServiceID();
        // readServicesDeletedID();

        // ServicesManagement.addService("servicef", "frommain", 2000);
        // ServicesManagement.addService("Servicefff", "farah", 9999);
        // writeServicesFile();

        // GuestManagement.addGuest("farah", 992, "farah@gmail.com");
        // GuestManagement.addGuest("farahhhh", 993222232, "farah@gmail.com");
        // writeGuestsFile();

        // RoomManagement.addRoom(2, "single", true, 2020);
        // RoomManagement.addRoom(3, "double", true, 2400);

        // RoomManagement.assignRoom(2, 992, 4);
        // RoomManagement.assignRoom(3, 993222232, 7);
        // writeGuestIDRoomID();
        
        // ServicesManagement.addService("servicew", "d", 2000);
        // ServicesManagement.addService("serrrr", "r", 100);

        // ServicesManagement.assignService(1, 992);
        // ServicesManagement.assignService(2, 993222232);
        // writeGuestIDServiceID();

        // ServicesManagement.deleteService("servicew");
        // ServicesManagement.deleteService("serrrr");

        
        // writeServicesDeletedID();


    }
}
