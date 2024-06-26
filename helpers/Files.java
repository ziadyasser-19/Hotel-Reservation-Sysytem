package helpers;
import java.util.ArrayList;

import models.*;
public class Files {

    //==================================================================

    // Rooms 

    // Write Rooms 

    public static void RoomFileWriter(){

        FilesHelper file = new FilesHelper(Pathes.RoomPath); //read all Rooms 

        file.emptyFile();
        
        
        for(int i = 0 ; i<RoomManagement.getRoomList().size();i++){
        String content = RoomManagement.getRoomList().get(i).getRoomID() +"-"+RoomManagement.getRoomList().get(i).getRoomType()+"-"+RoomManagement.getRoomList().get(i).getIsAvaialble()+"-"+RoomManagement.getRoomList().get(i).getPrice();
        file.writeToFile(content);
        }

    }


    //===========

    //read from rooms 

    public static void RoomFileReader(){
        
        FilesHelper RoomFiles =new FilesHelper(Pathes.RoomPath);
        String allRooms = RoomFiles.ReadFile();
        String[] rooms = allRooms.split("\\s+");

        for(String room:rooms){
            
            if(room.matches("\\d+-\\w+-(true|false)-\\d+.\\d+\\b")){
                
                String data[] = room.split("-");
                RoomManagement.addRoom(Integer.parseInt(data[0]),data[1],Boolean.parseBoolean(data[2]),Double.parseDouble(data[3]));
                
        }
        
    }
    }

    //===================================================================

    // receptionist 

    // write receptionists

    public static void ReceptionistFileWriter(){
        FilesHelper file = new FilesHelper(Pathes.ReceptionistPath);

        file.emptyFile();
        for(int i = 0 ; i<ReceptionistManagement.getAllReceptionists().size();i++){
        String content = ReceptionistManagement.getAllReceptionists().get(i).getID() +"-" + ReceptionistManagement.getAllReceptionists().get(i).getName() +"-" + ReceptionistManagement.getAllReceptionists().get(i).getPass();
        file.writeToFile(content);
    }
}

    //=================

    // read receptionist

    public static void ReceptionistFileReader(){
        //====================== READ ALL RECEPTIONISTS ============================
        FilesHelper AllReceptionists = new FilesHelper(Pathes.ReceptionistPath);
        String  allData = AllReceptionists.ReadFile();
        String Receptionistss[]=allData.split("\\s+");

        //====================== READ ALL DELETED ID ===============================
        FilesHelper file = new FilesHelper(Pathes.deletedReceptionistsIDpath);
        String alldata = file.ReadFile();
        String[] allids = alldata.split("\\s+");  // Split using any whitespace characters



        if(!allData.isEmpty() && !alldata.isEmpty()){
        
        int maxReception = 0 ;
        int maxdeleted = 0 ;

            for(String data : Receptionistss){ //=> 0 id 1 name 2 password 

            if (data.matches( "\\b\\d+-[a-zA-Z]+-\\d+\\b")){
                    String receptionist[]=data.split("-");
                    ReceptionistManagement.getAllReceptionists().add(new Receptionist(Integer.parseInt(receptionist[0]), receptionist[1], Integer.parseInt(receptionist[2])));
                
                if(Integer.parseInt(receptionist[0])>maxReception) { //loop to see the greatest number in receptionists id 
                    maxReception =Integer.parseInt(receptionist[0]);
                }
            }
        }

        for(String delete : allids){   // loop to see the greatest number in the deleted id 
            if(delete.matches("\\d+")){
                if(Integer.parseInt(delete)>maxdeleted){
                    maxdeleted= Integer.parseInt(delete);
                }
            }
        }

        if(maxReception>maxdeleted){
            Receptionist.SetReceptionistCounter(maxReception);
        }else{
            Receptionist.SetReceptionistCounter(maxdeleted);
        }


    }else if(!allData.isEmpty() && alldata.isEmpty()){ // 2nd condition if the deleted is empty 

            int maxReception = 0 ;
            
            for(String data : Receptionistss){ //=> 0 id 1 name 2 password 

                if (data.matches( "\\b\\d+-[a-zA-Z]+-\\d+\\b")){
                        String receptionist[]=data.split("-");
                        ReceptionistManagement.getAllReceptionists().add(new Receptionist(Integer.parseInt(receptionist[0]), receptionist[1], Integer.parseInt(receptionist[2])));
                    
                    if(Integer.parseInt(receptionist[0])>maxReception) { //loop to see the greatest number in receptionists id 
                        maxReception =Integer.parseInt(receptionist[0]);
                    }
                }
            }

            Receptionist.SetReceptionistCounter(maxReception);

    }else{  //3rd condition lw eldeleted mlyan w el receptionists fady 

        int maxdeleted = 0 ;

        for(String delete : allids){   // loop to see the greatest number in the deleted id 
            if(delete.matches("\\d+")){
                if(Integer.parseInt(delete)>maxdeleted){
                    maxdeleted= Integer.parseInt(delete);
                }
            }
        }

        Receptionist.SetReceptionistCounter(maxdeleted);
    }

    }


    //=====================================================

    //Reports


    //write reports

    public static void  ReportFileWriter(){
        FilesHelper file = new FilesHelper(Pathes.Reportspathes);
        file.emptyFile();
        for(int i = 0 ; i<Report.getreportlist().size();i++){
        String content = Report.getreportlist().get(i).getreportedGuest().getNationalID()+"-"+Report.getreportlist().get(i).getreportedservice().getServiceID()+"-"+Report.getreportlist().get(i).getstarrate();
        file.writeToFile(content);
        }
    }

    //======================

    //Read Reports

    public static void ReportReader(){
        FilesHelper file = new FilesHelper(Pathes.Reportspathes);

        String alldata = file.ReadFile();

        String  reports[]=alldata.split("\n");

        for(String report:reports){
            if(report.matches("\\d{14}-\\d-\\d+\\.\\d+")){ //=> 0 id - 1 national id - 2 service id - 3 rate
                String  dataparts[]=report.split("-");
                
                Report.generatereport(Long.parseLong(dataparts[0]), Integer.parseInt(dataparts[1]), Double.parseDouble(dataparts[2]));

                
            }
        }
    }
    //==================================================

    //Deleted id Receptionists 

    // write 

    public static void  DeletedIDsWriter() {
        FilesHelper file = new FilesHelper(Pathes.deletedReceptionistsIDpath);
        ArrayList<Integer> uniqueID = new ArrayList<>();

        for(int id : ReceptionistManagement.getdeletedreceptionistsid()){
            if(uniqueID.contains(id)){
                continue;
            }
            else{
                uniqueID.add(id);
            }
        }
        ReceptionistManagement.getdeletedreceptionistsid().clear();

        file.emptyFile();

        for(int id : uniqueID){
            file.writeToFile(String.valueOf(id));
        }
    }

    // Read

    public static void DeletedReceptionsistIdsReader() {
        FilesHelper file = new FilesHelper(Pathes.deletedReceptionistsIDpath);
        String alldata = file.ReadFile();
    
        String[] allids = alldata.split("\\s+");  // Split using any whitespace characters
    
        for (String id : allids) {
            if (id.matches("\\d+")) {
                ReceptionistManagement.getdeletedreceptionistsid().add(Integer.parseInt(id));
            }
        }
    }
    
    //=====================================================================

// Read Services File 
public static void readServicesFile(){
        //=========================== read all services ==================/
        FilesHelper serviceFile = new FilesHelper(Pathes.ServicesPath);
        String services = serviceFile.ReadFile();
        
        
        // ===================Read all Deleted id ========================//
        FilesHelper servicesDeletedID = new FilesHelper(Pathes.deletedServiceIDpath);
        String allID = servicesDeletedID.ReadFile();
        
        
        
        if(!services.isEmpty() && !allID.isEmpty()){  // 1st condition 
            
            String[] service = services.split("\\s+"); // h2sm elservices el3adya
        
            String[] ids = allID.split("\\s+"); //h2sm eldeleted id 

            int maxServices = 0;
            int maxDeleted = 0 ;

            for(String oneLine : service){ 
                if(oneLine.matches("\\d+-\\w+-\\w+-\\d+.\\d+\\s?")){
                    String[] oneService = oneLine.split("-");
                    ServicesManagement.addService(Integer.parseInt(oneService[0]), oneService[1], Double.parseDouble(oneService[3]), oneService[2]);
                    
                    if(Integer.parseInt(oneService[0])>maxServices){
                        maxServices = Integer.parseInt(oneService[0]); 
                    }
            }
        }
            for(String id:ids){
                if(id.matches("\\d+\\s?")){
                    if(Integer.parseInt(id) > maxDeleted){
                        maxDeleted = Integer.parseInt(id);
                    }
                }
            }

            if(maxDeleted>maxServices){
                Services.setServicesCounter(maxDeleted);
            }else{
                Services.setServicesCounter(maxServices);
            }

    }   else if(!services.isEmpty() && allID.isEmpty()){ // 2nd condition 
        
        String[] service = services.split("\\s+"); // h2sm elservices el3adya
        int maxServices = 0;

        for(String oneLine : service){ 
            if(oneLine.matches("\\d+-\\w+-\\w+-\\d+.\\d+\\s?")){
                String[] oneService = oneLine.split("-");
                ServicesManagement.addService(Integer.parseInt(oneService[0]), oneService[1], Double.parseDouble(oneService[3]), oneService[2]);
                
                if(Integer.parseInt(oneService[0])>maxServices){
                    maxServices = Integer.parseInt(oneService[0]); 
                }
        }
    }

            Services.setServicesCounter(maxServices);

    }else{       //3Rd Condition 
        
        String[] ids = allID.split("\\s+"); //h2sm eldeleted id 
        int maxDeleted = 0 ;
        for (String id : ids) {
            if ( id.matches("\\d+\\s?")) {
                if  (Integer.parseInt(id) > maxDeleted) {
                    maxDeleted = Integer.parseInt(id);
                }
            }
        } 
        Services.setServicesCounter(maxDeleted);
    }
}

//================================

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
        //========================= Read All Guests //================================
        FilesHelper guestsFile = new FilesHelper(Pathes.GuestsPath);

        String allguests = guestsFile.ReadFile();

        //==================Read All Rooms Assigned To Guests //========================
        FilesHelper guestIdRoomIdFile = new FilesHelper(Pathes.guestIDRoomIDPath);

        String allData = guestIdRoomIdFile.ReadFile();

        //================ Read All Registered Services //====================== 
        FilesHelper guestIDServiceIDFile = new FilesHelper(Pathes.guestIDServiceIDPath);

        String allDataservice = guestIDServiceIDFile.ReadFile();


        // for all guests 
        if(!allguests.isEmpty()){
            String[] guest = allguests.split("\n");

            for(String oneline : guest){

                if(oneline.matches("\\d{14}-\\w+-[A-z0-9\\.]+@[A-z0-9]+\\.[A-z]+\\s?")){
                    String[] guestData = oneline.split("-");
                    GuestManagement.addGuest(guestData[1], Long.parseLong(guestData[0]), guestData[2]);
                }
            }

            // For All registered Room with guests 

            if(!allData.isEmpty()){
                String[] data = allData.split("\\s+");
                for(String oneLine : data){
                    if(oneLine.matches("\\b\\d{14}-\\d+-\\d+\\s?")){
                        String[] guestRoom = oneLine.split("-");
                        try {
                            GuestManagement.SearchGuest(Long.parseLong(guestRoom[0])).addRoom(RoomManagement.SearchRoom(Integer.parseInt(guestRoom[1])));
                            RoomManagement.SearchRoom(Integer.parseInt(guestRoom[1])).setReservedDays(Integer.parseInt(guestRoom[2]));  
                        } catch (Exception e) {
                            
                        }
                        
                    }
                }
            }

            // For All Registered Services with guest 
            if(!allDataservice.isEmpty()){
                String[] data = allDataservice.split("\\s+");
                for(String oneline: data){
                    if(oneline.matches("\\d{14}-\\d+\\s?")){
                        String[] guestService = oneline.split("-");
                        try {
                        GuestManagement.SearchGuest(Long.parseLong(guestService[0])).addService(ServicesManagement.searchService(Integer.parseInt(guestService[1])));
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                    }
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
            String[] admin = alladmins.split("\\s+");

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
                    try {
                        GuestManagement.SearchGuest(Long.parseLong(guestRoom[0])).addRoom(RoomManagement.SearchRoom(Integer.parseInt(guestRoom[1])));
                        RoomManagement.SearchRoom(Integer.parseInt(guestRoom[1])).setReservedDays(Integer.parseInt(guestRoom[2]));  
                    } catch (Exception e) {
                        
                    }
                    
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
                    //ServicesManagement.assignService(Integer.parseInt(guestService[1]), Long.parseLong(guestService[0]));
                    try {
                        GuestManagement.SearchGuest(Long.parseLong(guestService[0])).addService(ServicesManagement.searchService(Integer.parseInt(guestService[1])));
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    
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
        ArrayList<Integer> uniqueId = new ArrayList<>();

        for(int id : ServicesManagement.getServicesDeletedID()){
            if(uniqueId.contains(id)){
                continue;
            }
            else{
                uniqueId.add(id);
            }
        }
        ServicesManagement.getServicesDeletedID().clear();

        servicesDeletedID.emptyFile();

        for(int id : uniqueId){
            servicesDeletedID.writeToFile(String.valueOf(id));
        }
    }
}
