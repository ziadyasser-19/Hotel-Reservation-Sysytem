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

    // Read Guests File 
    public static void readGuestsFile(){
        FilesHelper guestsFile = new FilesHelper(Pathes.GuestsPath);

        String allguests = guestsFile.ReadFile();

        if(!allguests.isEmpty()){
            String[] guest = allguests.split("\n");

            for(String oneline : guest){

                if(oneline.matches("\\d+-\\w+-[A-z0-9\\.]+@[A-z0-9]+\\.[A-z]+\\s?")){
                    String[] guestData = oneline.split("-");
                    GuestManagement.addGuest(guestData[1], Long.parseLong(guestData[0]), guestData[2]);
                }
            }
        }
    }

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
    

    public static void main(String[] args) {
        readServicesFile();
        // System.out.println("services");
        // System.out.println("array size= " +ServicesManagement.getServicesList().size());
        // for(Services service : ServicesManagement.getServicesList()){
        //     System.out.println(service.getServiceID()+ "   " + service.getServiceName() + "   "+ service.getServiceDesc()+ "  " + service.getServicePrice());
        // }
        readGuestsFile();
    }
}
