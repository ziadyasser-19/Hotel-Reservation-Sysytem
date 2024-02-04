package helpers;

import models.*;

public class FilesF {
    

    // Read Services File 
    public static void readServicesFile(){
        FilesHelper serviceFile = new FilesHelper(Pathes.ServicesPath);

        String services = serviceFile.ReadFile();
        // System.out.println(services);

        if(!services.isEmpty()){
            String[] service = services.split("\n");

            for(String oneLine : service){
                // System.out.println(oneLine);
                if(oneLine.matches("\\d+-\\w+-\\w+-\\d+\\s?")){

                    String[] oneService = oneLine.split("-");
                    // for (String servicee : oneService){
                    //     System.out.println(servicee);
                    // }
                    ServicesManagement.addService(Integer.parseInt(oneService[0]), oneService[1], Double.parseDouble(oneService[3]), oneService[2]);
                }
            }
        }
    }
    

    public static void main(String[] args) {
        readServicesFile();
        System.out.println("services");
        System.out.println("array size= " +ServicesManagement.getServicesList().size());
        for(Services service : ServicesManagement.getServicesList()){
            System.out.println(service.getServiceID()+ "   " + service.getServiceName() + "   "+ service.getServiceDesc()+ "  " + service.getServicePrice());
        }
    }
}
