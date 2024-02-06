package helpers;

import models.*;


public class FilesZ {
    
    // rooms + receptionists + report + deleted id receptionists 

    // Write functions 

    //==================================================================

    // Rooms 

    // Write Rooms 

    public static void RoomFileWriter(){

        FilesHelper file = new FilesHelper(Pathes.RoomPath);

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

        String[] rooms = allRooms.split("\n");

        for(String room:rooms){
            
            if(room.matches("\\d+-\\w+-(true|false)-\\d+\\b")){
                
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
        FilesHelper AllReceptionists = new FilesHelper(Pathes.ReceptionistPath);

        String  allData = AllReceptionists.ReadFile();

        String Receptionistss[]=allData.split("\n");

        for(String data : Receptionistss){ //=> 0 id 1 name 2 password 

            if (data.matches( "\\b\\d+-[a-zA-Z]+-\\d+\\b")){
                
                String receptionist[]=data.split("-");
                
                ReceptionistManagement.addEmployee(receptionist[1], Integer.parseInt(receptionist[2]));
                
                Receptionist.SetReceptionistCounter(Integer.parseInt(receptionist[0])); //=> set llcounter 3shan lw hdef b3dh
            } 
        }
    }

    //=====================================================

    //Reports


    //write reports

    public static void  ReportFileWriter(){
        FilesHelper file = new FilesHelper(Pathes.Reportspathes);
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
            if(report.matches("\\b\\d+-\\d+-\\d+(?:-\\d+(\\.\\d+)?)?\\b")){ //=> 0 id - 1 national id - 2 service id - 3 rate
                String  dataparts[]=report.split("-");
                
                Report.generatereport(Long.parseLong(dataparts[1]), Integer.parseInt(dataparts[2]), Double.parseDouble(dataparts[3]));

                Report.SetReportCounter(Integer.parseInt(dataparts[0]));
            }
        }
    }
    //==================================================

    //Deleted id Receptionists 

    // write 

    public static void  DeletedIDsWriter() {
        FilesHelper file = new FilesHelper(Pathes.deletedReceptionistsIDpath);
        for(int i = 0 ; i <ReceptionistManagement.getdeletedreceptionistsid().size();i++){
        String content = String.valueOf(ReceptionistManagement.getdeletedreceptionistsid().get(i));
        file.writeToFile(content);
    }
    }
    //=================

    //read deleted id 
/* 
    public static void DeletedReceptionsistIdsReader(){
        
        FilesHelper file = new FilesHelper(Pathes.deletedReceptionistsIDpath);

        String alldata = file.ReadFile();

        String  allids[]=alldata.split("\n");

        for(String id : allids){
            if(id.matches("\\d+\\s?")){
                //String dataparts[] =id.split("\n"); 
                ReceptionistManagement.getdeletedreceptionistsid().add(Integer.parseInt(id));
                
    }
}
} */

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

    public static void main(String[] args) {
    
        DeletedReceptionsistIdsReader();
        System.out.println("array size = " +ReceptionistManagement.getdeletedreceptionistsid().size());
    
    
    }


}
