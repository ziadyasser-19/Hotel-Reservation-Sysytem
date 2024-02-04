package helpers;

import models.Receptionist;
import models.Room;
import models.RoomManagement;
import models.Report;
import models.Guest;
import models.Services;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FilesZ {
    
    // rooms + receptionists + report + deleted id receptionists 

    // Write functions 

    //==================================================================

    // Rooms 

    // Write Rooms 

    public static void RoomFileWriter(Room room){
        FilesHelper file = new FilesHelper(Pathes.RoomPath);
        String content = room.getRoomID() +"-"+room.getRoomType()+"-"+room.getIsAvaialble()+"-"+room.getPrice();
        file.writeToFile(content);
    }

//===========

    //read from rooms 

    public static void RoomFileReader(){
        FilesHelper file =new FilesHelper(Pathes.RoomPath);

        for(int i = 0 ; i<RoomManagement.getRoomList().size();i++){
            
        }
    }


    //===================================================================
    public static void ReceptionistFileWriter(Receptionist receptionist){
        FilesHelper file = new FilesHelper(Pathes.ReceptionistPath);
        String content = receptionist.getID() +"-" + receptionist.getName() +"-" + receptionist.getPass();
        file.writeToFile(content);
    }

    public static void  ReportFileWriter(Report report){
        FilesHelper file = new FilesHelper(Pathes.Reportspathes);
        String content = report.getreportedGuest().getNationalID()+"-"+report.getreportedservice().getServiceID()+"-"+report.getstarrate();
        file.writeToFile(content);
    }


    public static void main(String[] args) {
        Room room1 = new Room(10, "double", false, 130);
        Receptionist receptionist1 = new Receptionist("mohamed", 1001);
        Guest guest1 = new Guest("null", 3030701, "ziadadelashour@gmail.com");
        Services service = new Services("ziad", 130, "zzzzz");
        Report report1 = new Report(null, guest1, service, 5);

        RoomFileWriter(room1);
        ReceptionistFileWriter(receptionist1);
        ReportFileWriter(report1);
        
    }


}
