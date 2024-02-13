package roles;

import java.util.ArrayList;

import helpers.Files;
import helpers.Functions;
import helpers.adminrolemenu;
import models.*;


public class AdminRole {
public static void main(String[] args) {

    Files.readGuestsFile();
    Files.readServicesFile();
    Files.RoomFileReader();
    Files.ReportReader();
    Files.readServicesDeletedID();
    Files.readGuestIDServiceID();
    Files.DeletedReceptionsistIdsReader();
    Files.readAdminFile();
    Files.readGuestIDRoomID();
    
    
    
    outerLoop: while (true) {
        int t = adminrolemenu.Adminmenu();
        if (t == 1) { // y5sh 3 awl menu bta3t empoloyees services 

            int m = adminrolemenu.EmployeeservicesMenu();
            
            if (m == 1) {
                System.out.println("Enter employee name: ");
                String name = Functions.readString();
                System.out.println("Enter the employee Password with an integer number: ");
                int password = Functions.readPositive();
    
                if (ReceptionistManagement.addEmployee(name, password) == -1) { //lw l2a nfs elname 
                    
                    boolean z = true; // 3shan lw d5l nfs elname zy mho tany
                    innerloop : while (z) {
                        System.out.println("\n This username is already exist. Enter another one: ");
                        name = Functions.readString();
                        if (ReceptionistManagement.addEmployee(name, password) != -1) {
                            z = false;
                            ReceptionistManagement.addEmployee(name, password);
                            System.out.println("\nReceptionist added successfully :) ");
                        }else{
                        System.out.println("\nthis user name already exist choose option : ");
                        System.out.println("=======================================\n");
                        int y = adminrolemenu.Wrongmenu();
                        if(y==0)
                            continue innerloop;
                        else if(y==1)
                            continue outerLoop;
                        else
                            Files.DeletedIDsWriter();
                            Files.ReceptionistFileWriter();
                            Files.ReportFileWriter();
                            Files.RoomFileWriter();
                            Files.writeGuestIDRoomID();
                            Files.readGuestIDServiceID();
                            Files.writeGuestsFile();
                            Files.writeServicesDeletedID();
                            Files.writeServicesFile();
                            System.out.println("Logged out !");
                            break outerLoop;
                    }
                }
                }else{
                    ReceptionistManagement.addEmployee(name, password);
                    System.out.println("\nReceptionist added successfully : ) ");
                }
                System.out.println("==============================\n");
                int y = adminrolemenu.anotherservicemenu();
                if (y == 1) {
                    continue outerLoop;
                }else{
                            Files.DeletedIDsWriter();
                            Files.ReceptionistFileWriter();
                            Files.ReportFileWriter();
                            Files.RoomFileWriter();
                            Files.writeGuestIDRoomID();
                            Files.readGuestIDServiceID();
                            Files.writeGuestsFile();
                            Files.writeServicesDeletedID();
                            Files.writeServicesFile();
                    System.out.println("logged out");
                    break outerLoop;
                }
        }
        else if(m == 2){ // option 2 fl menu 3shan ams7 employee  
            System.out.println("enter emplyee id to be deleted : ");
            int id = Functions.readInt();
            if (ReceptionistManagement.deleteEmployee(id)==1){ // lw el id s7
                ReceptionistManagement.deleteEmployee(id);
                System.out.println("Deleted Successfully!");
            }else{ // lw d5l id 5lt
                boolean z = true;
                innerloop : while (z) {
                    System.out.println("enter a valid employee id :");
                    id=Functions.readInt();
                    if (ReceptionistManagement.deleteEmployee(id)!=-1) {
                        z = false;
                        System.out.println("\nemployee deleted successfully :) ");
                    }else{
                        System.out.println("\nthis id doesnt exist choose another option =>");
                        System.out.println("=======================================\n");
                        int y = adminrolemenu.Wrongmenu();
                        if(y==0)
                            continue innerloop;
                        else if(y==1)
                            continue outerLoop;
                        else
                            Files.DeletedIDsWriter();
                            Files.ReceptionistFileWriter();
                            Files.ReportFileWriter();
                            Files.RoomFileWriter();
                            Files.writeGuestIDRoomID();
                            Files.readGuestIDServiceID();
                            Files.writeGuestsFile();
                            Files.writeServicesDeletedID();
                            Files.writeServicesFile();
                            System.out.println("\nLogged Out !");
                            break outerLoop;
                    }
                }
                }
                System.out.println("=============================\n");
                int y = adminrolemenu.anotherservicemenu(); // 3shan lw 3awz y3ml operation tanya 
                if (y == 1) {
                    continue outerLoop;
                }else{
                            Files.DeletedIDsWriter();
                            Files.ReceptionistFileWriter();
                            Files.ReportFileWriter();
                            Files.RoomFileWriter();
                            Files.writeGuestIDRoomID();
                            Files.readGuestIDServiceID();
                            Files.writeGuestsFile();
                            Files.writeServicesDeletedID();
                            Files.writeServicesFile();
                    System.out.println("logged out");
                    break outerLoop;
                }
            } else if(m==3){ // update employee
                System.out.println("enter employee id : ");
                int x = Functions.readInt();
                if (ReceptionistManagement.search(x)== null){ // lw d5l id 8lt 
                    boolean z =true;
                    innerloop: while(z){
                    System.out.println("Receptionist does not exist enter a valid id : ");
                    x = Functions.readInt();
                    if(ReceptionistManagement.search(x)!= null){ // lw l2a el id tmam
                        z = false;
                        System.out.println("enter the new password :  ");
                        int y= Functions.readInt();
                                if(ReceptionistManagement.updateEmployeePass(x, y)==-2){ // lw d5l nfs el password 
                                    boolean f = true;
                                secondinnerloop: while(f){
                                    System.out.println("this is the current password enter another one : ");
                                    y = Functions.readInt();
                                    if(ReceptionistManagement.updateEmployeePass(x, y)!=-2){
                                        f =false ;
                                        System.out.println("\nthe password updated successfully :)");
                                        ReceptionistManagement.updateEmployeePass(x, y);
                                        
                                    }else{
                                    System.out.println("\nthis is the current password choose option 0 to change it or return to the main menu =>");
                                    System.out.println("=======================================\n");
                                    int h = adminrolemenu.Wrongmenu();
                                    if(h==0)
                                        continue secondinnerloop;
                                    else if(h==1)
                                        continue outerLoop;
                                    else
                                    Files.DeletedIDsWriter();
                                    Files.ReceptionistFileWriter();
                                    Files.ReportFileWriter();
                                    Files.RoomFileWriter();
                                    Files.writeGuestIDRoomID();
                                    Files.readGuestIDServiceID();
                                    Files.writeGuestsFile();
                                    Files.writeServicesDeletedID();
                                    Files.writeServicesFile();
                                        System.out.println("Logged out");
                                        break outerLoop;
                                }
                            }
                            }
                    }else{
                        System.out.println("\nValid id to search choose option =>");
                        System.out.println("=======================================\n");
                        int h = adminrolemenu.Wrongmenu();
                        if(h==0)
                            continue innerloop;
                        else if(h==1)
                            continue outerLoop;
                        else
                            Files.DeletedIDsWriter();
                            Files.ReceptionistFileWriter();
                            Files.ReportFileWriter();
                            Files.RoomFileWriter();
                            Files.writeGuestIDRoomID();
                            Files.readGuestIDServiceID();
                            Files.writeGuestsFile();
                            Files.writeServicesDeletedID();
                            Files.writeServicesFile();
                            System.out.println("\nLogged out !");
                            break outerLoop;
                    }
                }
                }else if (ReceptionistManagement.search(x)!= null){ // lw l2a el id tmam
                    System.out.println("enter the new password :  ");
                    int y= Functions.readInt();
                            if(ReceptionistManagement.updateEmployeePass(x, y)==-2){ // lw d5l nfs el password 
                                boolean f = true;
                            thirdinnerloop : while(f){
                                System.out.println("this is the current password enter another one : ");
                                y = Functions.readInt();
                                if(ReceptionistManagement.updateEmployeePass(x, y)!=-2){
                                    f =false ;
                                    System.out.println("\nthe password updated successfully :)");
                                    ReceptionistManagement.updateEmployeePass(x, y);
                                    
                                }else{
                                System.out.println("\nthis is the current password choose option try again to change it or return to the main menu  =>");
                                System.out.println("=======================================\n");
                                int h = adminrolemenu.Wrongmenu();
                                if(h==0)
                                    continue thirdinnerloop;
                                else if(h==1)
                                    continue outerLoop;
                                else
                                    Files.DeletedIDsWriter();
                                    Files.ReceptionistFileWriter();
                                    Files.ReportFileWriter();
                                    Files.RoomFileWriter();
                                    Files.writeGuestIDRoomID();
                                    Files.readGuestIDServiceID();
                                    Files.writeGuestsFile();
                                    Files.writeServicesDeletedID();
                                    Files.writeServicesFile();
                                    System.out.println("Logged out ! \n");
                                    break outerLoop;
                            }
                        }
                        }
                }
                System.out.println("=========================\n");
                int y = adminrolemenu.anotherservicemenu();
                if (y == 1) {
                    continue outerLoop;
                }else{
                            Files.DeletedIDsWriter();
                            Files.ReceptionistFileWriter();
                            Files.ReportFileWriter();
                            Files.RoomFileWriter();
                            Files.writeGuestIDRoomID();
                            Files.readGuestIDServiceID();
                            Files.writeGuestsFile();
                            Files.writeServicesDeletedID();
                            Files.writeServicesFile();
                    System.out.println("logged out ! \n");
                    break outerLoop;
                }
            }else if(m==4){
                ArrayList<Receptionist>receptionist= ReceptionistManagement.getAllReceptionists(); 
                if(receptionist.isEmpty()){
                    System.out.println("\nThere's no employee yet ! ");
                }else{
                System.out.println("all employees are : ");
                
                for(Receptionist employee : receptionist ){
                    System.out.println( "\n" + "ID:" +employee.getID() + "  Name: " +employee.getName() + "   password: " + employee.getPass());
                }
            }
                System.out.println("\n =====================================");
                int y = adminrolemenu.anotherservicemenu();
                if (y == 1) {
                    continue outerLoop;
                }else{
                            Files.DeletedIDsWriter();
                            Files.ReceptionistFileWriter();
                            Files.ReportFileWriter();
                            Files.RoomFileWriter();
                            Files.writeGuestIDRoomID();
                            Files.readGuestIDServiceID();
                            Files.writeGuestsFile();
                            Files.writeServicesDeletedID();
                            Files.writeServicesFile();
                    System.out.println("logged out ! \n");
                    break outerLoop;
                }
            }
            else if(m==5){
                System.out.println("all Guest are : ");
                ArrayList<Guest>Guest= GuestManagement.getGuestArray();
                
                for(Guest  guest:Guest){
                    if(guest.getRegRoom()==null && guest.getRegServices()==null){
                        System.out.println("\n"+"national id : " + guest.getNationalID() + "    reserve room number : Not registered Yet !      "+ "  and service : not registered in any service");
                        
                    }
                    else if(guest.getRegRoom()==null){
                        System.out.println("\n"+"national id : " + guest.getNationalID() + " reserve room number : Not registered Yet ! "+ "  and service " + guest.getRegServices().getServiceName());
                    }else if(guest.getRegServices()==null){
                        System.out.println("\n"+"national id : " + guest.getNationalID() + " reserve room number :  "+guest.getRegRoom().getRoomID() +"  and service : not registered in any services ");
                    }else{
                    System.out.println("\n"+"national id : " + guest.getNationalID() + " reserve room number : " + guest.getRegRoom().getRoomID() + "  and service :" + guest.getRegServices().getServiceName());
                }
            }
            System.out.println("\n =====================================");
                int y = adminrolemenu.anotherservicemenu();
                if (y == 1) {
                    continue outerLoop;
                }else{
                            Files.DeletedIDsWriter();
                            Files.ReceptionistFileWriter();
                            Files.ReportFileWriter();
                            Files.RoomFileWriter();
                            Files.writeGuestIDRoomID();
                            Files.readGuestIDServiceID();
                            Files.writeGuestsFile();
                            Files.writeServicesDeletedID();
                            Files.writeServicesFile();
                    System.out.println("logged out ! \n");
                    break outerLoop;
                }
        }else if(m==6){
            continue outerLoop;
        }
}else if (t==2){
    int m = adminrolemenu.RoomsservicesMenu();
    if(m==1){
        System.out.println("enter the room number : ");
        int Roomnum = Functions.readPositive();
        System.out.println("enter the type of the room : ");
        String type = Functions.readString();
        System.out.println("enter the price of the room : ");
        double price = Functions.ReadDouble();
        if(RoomManagement.addRoom(Roomnum, type, true,price)==-1){
            boolean z = true;
            innerloop : while(z){
                System.out.println("Room Number already exist enter another room number : ");
                Roomnum = Functions.readPositive();
                if(RoomManagement.addRoom(Roomnum, type,true,price)!=-1){
                    z = false;
                    System.out.println("\nRoom added Successfully :) ");
                    RoomManagement.addRoom(Roomnum, type, true,price);
                    
                }else{
                    System.out.println("\nRoom number already Exist choose option =>");
                    System.out.println("=======================================\n");
                    int h = adminrolemenu.Wrongmenu();
                    if(h==0)
                        continue innerloop;
                    else if(h==1)
                        continue outerLoop;
                    else
                        Files.DeletedIDsWriter();
                        Files.ReceptionistFileWriter();
                        Files.ReportFileWriter();
                        Files.RoomFileWriter();
                        Files.writeGuestIDRoomID();
                        Files.readGuestIDServiceID();
                        Files.writeGuestsFile();
                        Files.writeServicesDeletedID();
                        Files.writeServicesFile();
                        System.out.println("Logged out !");
                        break outerLoop;
                }
            }
        }else if(RoomManagement.addRoom(Roomnum, type, true,price)!=-1){
            System.out.println("\nRoom added Successfully :) ");
            RoomManagement.addRoom(Roomnum, type, true,price);
        }
        System.out.println("\nRoom added Successfully :) ");
        System.out.println("================================\n");
            int y = adminrolemenu.anotherservicemenu();
                if (y == 1) {
                    continue outerLoop;
                }else{
                            Files.DeletedIDsWriter();
                            Files.ReceptionistFileWriter();
                            Files.ReportFileWriter();
                            Files.RoomFileWriter();
                            Files.writeGuestIDRoomID();
                            Files.readGuestIDServiceID();
                            Files.writeGuestsFile();
                            Files.writeServicesDeletedID();
                            Files.writeServicesFile();
                    System.out.println("logged out");
                    break outerLoop;
                }
    }else if (m==2){
        
        System.out.println("enter the room number to delete :");
        int roomnum = Functions.readPositive();

        if(RoomManagement.SearchRoom(roomnum)==null){
            boolean z =true;
            innerloop : while(z){
                System.out.println("Wrong room number enter a Valid one : ");
                roomnum=Functions.readPositive();
                if(RoomManagement.SearchRoom(roomnum)!=null){
                    z=false;
                    if(RoomManagement.deleteRoom(roomnum)==-2){
                    System.out.println("the room assigned to guest cant be deleted right now ! ");
                    }else{
                    RoomManagement.deleteRoom(roomnum);
                    System.out.println("\nthe room deleted successfully :) ");
                }
            }else{
                System.out.println("\ninValid Room-number to search choose option =>");
                System.out.println("=======================================\n");
                int h = adminrolemenu.Wrongmenu();
                if(h==0)
                    continue innerloop;
                else if(h==1)
                    continue outerLoop;
                else
                    Files.DeletedIDsWriter();
                    Files.ReceptionistFileWriter();
                    Files.ReportFileWriter();
                    Files.RoomFileWriter();
                    Files.writeGuestIDRoomID();
                    Files.readGuestIDServiceID();
                    Files.writeGuestsFile();
                    Files.writeServicesDeletedID();
                    Files.writeServicesFile();
                    System.out.println("Logged out !");
                    break outerLoop;
            }
            }
        }else{
            if(RoomManagement.deleteRoom(roomnum)==-2){
                System.out.println("\nthe room assigned to guest cant be deleted right now ! ");
            }else{
                RoomManagement.deleteRoom(roomnum);
                System.out.println("\nthe room deleted successfully :) ");
            }
        }
        System.out.println("===================================\n");
        int y = adminrolemenu.anotherservicemenu();
                if (y == 1) {
                    continue outerLoop;
                }else{
                            Files.DeletedIDsWriter();
                            Files.ReceptionistFileWriter();
                            Files.ReportFileWriter();
                            Files.RoomFileWriter();
                            Files.writeGuestIDRoomID();
                            Files.readGuestIDServiceID();
                            Files.writeGuestsFile();
                            Files.writeServicesDeletedID();
                            Files.writeServicesFile();
                    System.out.println("logged out");
                    break outerLoop;
                }
    }else if  (m==3){
        System.out.println("enter the room number to update : ");
        int x = Functions.readPositive();
        if(RoomManagement.SearchRoom(x)==null){
            boolean z = true ; 
            innerloop : while(z){
                System.out.println("enter a valid room number to update : ");
                x = Functions.readPositive() ;
                if(RoomManagement.SearchRoom(x)!=null){
                    z=false;
                    System.out.println("enter the new price of the room : ");
                    double y = Functions.ReadDouble();
                    RoomManagement.updateRoom(x, y);
                    System.out.println("\nprice updated successfully :) ");
                }else{
                    System.out.println("\ninValid Room-number to search choose option =>");
                    System.out.println("=======================================\n");
                    int h = adminrolemenu.Wrongmenu();
                    if(h==0)
                        continue innerloop;
                    else if(h==1)
                        continue outerLoop;
                    else
                        Files.DeletedIDsWriter();
                        Files.ReceptionistFileWriter();
                        Files.ReportFileWriter();
                        Files.RoomFileWriter();
                        Files.writeGuestIDRoomID();
                        Files.readGuestIDServiceID();
                        Files.writeGuestsFile();
                        Files.writeServicesDeletedID();
                        Files.writeServicesFile();
                        System.out.println("\nLogged out !");
                        break outerLoop;
                }
            }
        }else{
                System.out.println("enter the new price of the room : ");
                    double y = Functions.ReadDouble();
                    RoomManagement.updateRoom(x, y);
                    System.out.println("\nprice updated successfully :) ");
        }
        System.out.println("=================================\n");
        int y = adminrolemenu.anotherservicemenu();
                if (y == 1) {
                    continue outerLoop;
                }else{
                            Files.DeletedIDsWriter();
                            Files.ReceptionistFileWriter();
                            Files.ReportFileWriter();
                            Files.RoomFileWriter();
                            Files.writeGuestIDRoomID();
                            Files.readGuestIDServiceID();
                            Files.writeGuestsFile();
                            Files.writeServicesDeletedID();
                            Files.writeServicesFile();
                    System.out.println("logged out");
                    break outerLoop;
                }
    }else if(m==4){
        ArrayList<Room>rooms=RoomManagement.getRoomList();
        if (rooms.isEmpty()){
            System.out.println("\nThere is no rooms in the system yet !\n");
        }else{
        for(Room room : rooms){
            System.out.println("\n" + "room number : " + room.getRoomID() + "    room type : " + room.getRoomType() + "   room price : "+room.getPrice() +"$"+ "   room availability : " +room.getIsAvaialble());
        }}
        System.out.println("\n============================================");
        int y = adminrolemenu.anotherservicemenu();
                if (y == 1) {
                    continue outerLoop;
                }else{
                            Files.DeletedIDsWriter();
                            Files.ReceptionistFileWriter();
                            Files.ReportFileWriter();
                            Files.RoomFileWriter();
                            Files.writeGuestIDRoomID();
                            Files.readGuestIDServiceID();
                            Files.writeGuestsFile();
                            Files.writeServicesDeletedID();
                            Files.writeServicesFile();
                    System.out.println("logged out");
                    break outerLoop;
                }
    }else if(m==5){
        continue outerLoop;
    }

}else if (t==3){
    int x = adminrolemenu.ServicesservicesMenu();
    if(x==1){   // option bta3 ADD service

        System.out.println("enter Service name : ");
        String servicename = Functions.readString();
        System.out.println("enter service description : ");
        String description =  Functions.readString();
        System.out.println("enter service Price : ");
        double price = Functions.ReadDouble();
        
        int z= ServicesManagement.addService(servicename, description, price);
        
        if(z==-1){ // lw el esm mogod
            boolean f = true;
            innerloop : while(f){
                System.out.println("the name already exist choose another one : ");
                servicename = Functions.readString();
                if(ServicesManagement.addService(servicename, description, price)!=-1){ // lw zbt el esm 
                    f=false;
                    ServicesManagement.addService(servicename, description, price);
                    System.out.println("\nService added successfully :) ");
                }else{
                    System.out.println("\nName already exist choose option =>");
                    System.out.println("=======================================\n");
                    int h = adminrolemenu.Wrongmenu();
                    if(h==0)
                        continue innerloop;
                    else if(h==1)
                        continue outerLoop;
                    else
                        Files.DeletedIDsWriter();
                        Files.ReceptionistFileWriter();
                        Files.ReportFileWriter();
                        Files.RoomFileWriter();
                        Files.writeGuestIDRoomID();
                        Files.readGuestIDServiceID();
                        Files.writeGuestsFile();
                        Files.writeServicesDeletedID();
                        Files.writeServicesFile();
                        System.out.println("\nLogged out !");
                        break outerLoop;
                }
            }
        }else{ // lw d5l esm tmam 
            ServicesManagement.addService(servicename, description, price);
            System.out.println("\nService added successfully :) ");
        }
        System.out.println("=============================\n");
            int y = adminrolemenu.anotherservicemenu();
                if (y == 1) {
                    continue outerLoop;
                }else{
                            Files.DeletedIDsWriter();
                            Files.ReceptionistFileWriter();
                            Files.ReportFileWriter();
                            Files.RoomFileWriter();
                            Files.writeGuestIDRoomID();
                            Files.readGuestIDServiceID();
                            Files.writeGuestsFile();
                            Files.writeServicesDeletedID();
                            Files.writeServicesFile();
                    System.out.println("logged out");
                    break outerLoop;
                }
}else if(x==2){ // option bta3 el delete 

    System.out.println("enter the Service name you want to delete : ");
    String servicename = Functions.readString();
    if(ServicesManagement.searchServices(servicename)==null){ // bst5dm fn el search lw ml2tsh el elsm dh 
        boolean z = true;
        innerloop : while(z){
            System.out.println("the service doesn't exist enter another service name : ");
            servicename = Functions.readString();
            if (ServicesManagement.searchServices(servicename)!=null) {
                z=false;
                if(ServicesManagement.deleteService(servicename)==2){
                    System.out.println("Service assigned to guests cant be deleted !");
                }else{
                ServicesManagement.deleteService(servicename);
                System.out.println("\nService deleted successfully :) ");
                }
            }else{
                System.out.println("\nInvalid name to search choose option =>");
                System.out.println("=======================================\n");
                int h = adminrolemenu.Wrongmenu();
                if(h==0)
                    continue innerloop;
                else if(h==1)
                    continue outerLoop;
                else
                    Files.DeletedIDsWriter();
                    Files.ReceptionistFileWriter();
                    Files.ReportFileWriter();
                    Files.RoomFileWriter();
                    Files.writeGuestIDRoomID();
                    Files.readGuestIDServiceID();
                    Files.writeGuestsFile();
                    Files.writeServicesDeletedID();
                    Files.writeServicesFile();
                    System.out.println("Logged out !");
                    break outerLoop;
            }
        }
    }else{ // lw el2sm tmam 
                if(ServicesManagement.deleteService(servicename)==2){
                    System.out.println("Service assigned to guests cant be deleted ! ");
                }else{
                ServicesManagement.deleteService(servicename);
                System.out.println("\nService deleted successfully :) ");
                }
    }
    System.out.println("==================================\n");
    int y = adminrolemenu.anotherservicemenu();
    if (y == 1) {
        continue outerLoop;
    }else{
                            Files.DeletedIDsWriter();
                            Files.ReceptionistFileWriter();
                            Files.ReportFileWriter();
                            Files.RoomFileWriter();
                            Files.writeGuestIDRoomID();
                            Files.readGuestIDServiceID();
                            Files.writeGuestsFile();
                            Files.writeServicesDeletedID();
                            Files.writeServicesFile();
        System.out.println("logged out");
        break outerLoop;
    }

}else if (x==3){   // Update option
    
    System.out.println("enter the service name to search for ");
    String name = Functions.readString();
    
    if(ServicesManagement.searchServices(name)==null){ // lw el esm msh mogod 
        boolean z = true; 
        innerloop : while(z){
            System.out.println("Service not found  , please try again : ");
            name = Functions.readString();
            if(ServicesManagement.searchServices(name)!=null){ // lw d5l el esm s7 a5yra 
                z=false;
                System.out.println("enter the new price for "+ServicesManagement.searchServices(name).getServiceName()+" Service :");
                double serviceprice = Functions.ReadDouble();
                ServicesManagement.updateService(name, serviceprice);
                System.out.println("\nService Updated Successfully ! ");
            }else{
                System.out.println("\ninvalid name choose option =>");
                System.out.println("=======================================\n");
                int h = adminrolemenu.Wrongmenu();
                if(h==0)
                    continue innerloop;
                else if(h==1)
                    continue outerLoop;
                else
                    Files.DeletedIDsWriter();
                    Files.ReceptionistFileWriter();
                    Files.ReportFileWriter();
                    Files.RoomFileWriter();
                    Files.writeGuestIDRoomID();
                    Files.readGuestIDServiceID();
                    Files.writeGuestsFile();
                    Files.writeServicesDeletedID();
                    Files.writeServicesFile();
                    System.out.println("\nLogged out !");
                    break outerLoop;
            }
        }
    }else{ // lw d5l el 2sm s7 mn awl mra
        System.out.println("enter the new price for "+ServicesManagement.searchServices(name).getServiceName()+" Service :");
                double serviceprice = Functions.ReadDouble();
                ServicesManagement.updateService(name, serviceprice);
                System.out.println("\nService updated successfully !");
    }
    System.out.println("===================================\n");
    int y = adminrolemenu.anotherservicemenu();
    if (y == 1) {
        continue outerLoop;
    }else{
        Files.DeletedIDsWriter();
        Files.ReceptionistFileWriter();
        Files.ReportFileWriter();
        Files.RoomFileWriter();
        Files.writeGuestIDRoomID();
        Files.readGuestIDServiceID();
        Files.writeGuestsFile();
        Files.writeServicesDeletedID();
        Files.writeServicesFile();
        System.out.println("logged out");
        break outerLoop;
    }


}   else if (x==4){ // show all services 
    
    ArrayList<Services> services = ServicesManagement.getServicesList(); // b3ml loop gdeda feha el lista bt3ty w blf 3leha 

    if(services.isEmpty()){
        System.out.println("\nThere's no services in the system yet !");
    }else{
    System.out.println("All Services in the system : \n"); 
    
    for(Services service :services){
        System.out.println("\n"+ "ID : "+service.getServiceID()+"    Name: " + service.getServiceName() + "    Description : " + service.getServiceDesc() + "    Price : " + service.getServicePrice() + "$");
    }}
    System.out.println("\n =========================================");
    int y = adminrolemenu.anotherservicemenu();
    if (y == 1) {
        continue outerLoop;
    }else{
                            Files.DeletedIDsWriter();
                            Files.ReceptionistFileWriter();
                            Files.ReportFileWriter();
                            Files.RoomFileWriter();
                            Files.writeGuestIDRoomID();
                            Files.readGuestIDServiceID();
                            Files.writeGuestsFile();
                            Files.writeServicesDeletedID();
                            Files.writeServicesFile();
                            System.out.println("logged out");
                            break outerLoop;
    }
} else if (x==5){ // option el back 
    continue outerLoop;
}
}else if(t==4){ // Logout option 
                            Files.DeletedIDsWriter();
                            Files.ReceptionistFileWriter();
                            Files.ReportFileWriter();
                            Files.RoomFileWriter();
                            Files.writeGuestIDRoomID();
                            Files.readGuestIDServiceID();
                            Files.writeGuestsFile();
                            Files.writeServicesDeletedID();
                            Files.writeServicesFile();
    System.out.println("logged out successfully !");
    break outerLoop;
}
}
}
}

