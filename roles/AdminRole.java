package roles;

import java.util.ArrayList;

import helpers.Functions;
import helpers.adminrolemenu;
import models.GuestManagement;
import models.Receptionist;
import models.ReceptionistManagement;
import models.RoomManagement;
import models.ServicesManagement;
import models.Guest;
import models.Room;
import models.Services;


public class AdminRole {
public static void main(String[] args) {
        
    
    
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
    
                    while (z) {
                        System.out.println("\n This username is already exist. Enter another one: ");
                        name = Functions.readString();
                        if (ReceptionistManagement.addEmployee(name, password) != -1) {
                            z = false;
                            ReceptionistManagement.addEmployee(name, password);
                            System.out.println("\nReceptionist added succefully :) ");
                        }
                    }
                }else{
                    ReceptionistManagement.addEmployee(name, password);
                    System.out.println("\nReceptionist added succefully : ) ");
                }
                System.out.println("\n==============================");
                int y = adminrolemenu.anotherservicemenu();
                if (y == 1) {
                    continue outerLoop;
                }else{
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
                while (z) {
                    System.out.println("enter a valid employee id :");
                    id=Functions.readInt();
                    if (ReceptionistManagement.deleteEmployee(id)!=-1) {
                        z = false;
                        System.out.println("employee deleted succefully ");
                    }
                    }
                }
                int y = adminrolemenu.anotherservicemenu(); // 3shan lw 3awz y3ml operation tanya 
                if (y == 1) {
                    continue outerLoop;
                }else{
                    System.out.println("logged out");
                    break outerLoop;
                }
            } else if(m==3){
                System.out.println("enter employee id : ");
                int x = Functions.readInt();
                if (ReceptionistManagement.search(x)== null){ // lw d5l id 8lt 
                    boolean z =true;
                    while(z){
                    System.out.println("Receptionist does not exist enter a valid id : ");
                    x = Functions.readInt();
                    if(ReceptionistManagement.search(x)!= null){ // lw l2a el id tmam
                        z = false;
                        System.out.println("enter the new password :  ");
                        int y= Functions.readPositive();
                                if(ReceptionistManagement.updateEmployeePass(x, y)==-2){ // lw d5l nfs el password 
                                    boolean f = true;
                                while(f){
                                    System.out.println("this is the current password enter another one : ");
                                    y = Functions.readPositive();
                                    if(ReceptionistManagement.updateEmployeePass(x, y)!=-2){
                                        f =false ;
                                        ReceptionistManagement.updateEmployeePass(x, y);
                                        System.out.println("the password updated succefully :)");
                                    }
                                }
                            }
                    }
                    }
                }else if (ReceptionistManagement.search(x)!= null){ // lw l2a el id tmam
                    System.out.println("enter the new password :  ");
                    int y= Functions.readPositive();
                            if(ReceptionistManagement.updateEmployeePass(x, y)==-2){ // lw d5l nfs el password 
                                boolean f = true;
                            while(f){
                                System.out.println("this is the current password enter another one : ");
                                y = Functions.readPositive();
                                if(ReceptionistManagement.updateEmployeePass(x, y)!=-2){
                                    f =false ;
                                    ReceptionistManagement.updateEmployeePass(x, y);
                                    System.out.println("the password updated succefully :)");
                                }
                            }
                        }
                }
                int y = adminrolemenu.anotherservicemenu();
                if (y == 1) {
                    continue outerLoop;
                }else{
                    System.out.println("logged out");
                    break outerLoop;
                }
            }else if(m==4){
                System.out.println("all employees are : ");
                ArrayList<Receptionist>receptionist= ReceptionistManagement.getAllReceptionists(); 
                for(Receptionist employee : receptionist ){
                    System.out.println( "\n" + "ID:" +employee.getID() + "  Name: " +employee.getName() + "   password: " + employee.getPass());
                }
                System.out.println("\n =====================================");
                int y = adminrolemenu.anotherservicemenu();
                if (y == 1) {
                    continue outerLoop;
                }else{
                    System.out.println("logged out");
                    break outerLoop;
                }
            }
            else if(m==5){
                System.out.println("all Guest are : ");
                ArrayList<Guest>Guest= GuestManagement.getGuestArray();
                for(Guest  guest:Guest){
                    System.out.println("\n"+"national id : " + guest.getNationalID() + " reserve room number : " + guest.getRegRoom().getRoomID() + "  and service " + guest.getRegServices().getServiceName());
            }
            System.out.println("\n =====================================");
                int y = adminrolemenu.anotherservicemenu();
                if (y == 1) {
                    continue outerLoop;
                }else{
                    System.out.println("logged out");
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
        System.out.println("enter the type of the room ");
        String type = Functions.readString();
        System.out.println("enter the price of the room : ");
        double price = Functions.readPositive();
        if(RoomManagement.addRoom(Roomnum, type, true,price)==-1){
            boolean z = true;
            while(z){
                System.out.println("Room already exist enter another room number : ");
                Roomnum = Functions.readPositive();
                if(RoomManagement.addRoom(Roomnum, type,true ,price)!=-1){
                    z = false;
                    RoomManagement.addRoom(Roomnum, type, true,price);
                    
                    System.out.println("Room added Succefully :) ");
                }
            }
        }else if(RoomManagement.addRoom(Roomnum, type, true,price)!=-1){
            
            RoomManagement.addRoom(Roomnum, type, true,price);
            
            System.out.println("Room added Succefully :) ");
        }
            int y = adminrolemenu.anotherservicemenu();
                if (y == 1) {
                    continue outerLoop;
                }else{
                    System.out.println("logged out");
                    break outerLoop;
                }
    }else if (m==2){
        
        System.out.println("enter the room number to delete :");
        int roomnum = Functions.readPositive();

        if(RoomManagement.SearchRoom(roomnum)==null){
            boolean z =true;
            while(z){
                System.out.println("Wrong room number enter a Valid one : ");
                roomnum=Functions.readPositive();
                if(RoomManagement.SearchRoom(roomnum)!=null){
                    z=false;
                    RoomManagement.deleteRoom(roomnum);
                    System.out.println("room deleted succefully :) ");
                }
            }
        }else{
                    RoomManagement.deleteRoom(roomnum);
                    System.out.println("room deleted succefully :) ");
        }
        int y = adminrolemenu.anotherservicemenu();
                if (y == 1) {
                    continue outerLoop;
                }else{
                    System.out.println("logged out");
                    break outerLoop;
                }
    }else if  (m==3){
        System.out.println("enter the room number to update : ");
        int x = Functions.readPositive();
        if(RoomManagement.SearchRoom(x)==null){
            boolean z = true ; 
            while(z){
                System.out.println("enter a valid room number to update : ");
                x = Functions.readPositive() ;
                if(RoomManagement.SearchRoom(x)!=null){
                    z=false;
                    System.out.println("enter the new price of the room : ");
                    double y = Functions.readPositive();
                    RoomManagement.updateRoom(x, y);
                    System.out.println("price updated successfully :) ");
                }
            }
        }else{
                System.out.println("enter the new price of the room : ");
                    double y = Functions.readPositive();
                    RoomManagement.updateRoom(x, y);
                    System.out.println("price updated successfully :) ");
        }
        int y = adminrolemenu.anotherservicemenu();
                if (y == 1) {
                    continue outerLoop;
                }else{
                    System.out.println("logged out");
                    break outerLoop;
                }
    }else if(m==4){
        ArrayList<Room>rooms=RoomManagement.getRoomList();
        for(Room room : rooms){
            System.out.println("\n" + "room number : " + room.getRoomID() + "    roomtype : " + room.getRoomType() + "   room price : "+room.getPrice() +"$"+ "   room availability : " +room.getIsAvaialble());
        }
        System.out.println("\n============================================");
        int y = adminrolemenu.anotherservicemenu();
                if (y == 1) {
                    continue outerLoop;
                }else{
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
        double price = Functions.readPositive();
        
        int z= ServicesManagement.addService(servicename, description, price);
        
        if(z==-1){ // lw el esm mogod
            boolean f = true;
            while(f){
                System.out.println("the name already exist choose another one : ");
                servicename = Functions.readString();
                if(ServicesManagement.addService(servicename, description, price)!=-1){ // lw zbt el esm 
                    f=false;
                    ServicesManagement.addService(servicename, description, price);
                    System.out.println("Service added succefully :) ");
                }
            }
        }else{ // lw d5l esm tmam 
            ServicesManagement.addService(servicename, description, price);
            System.out.println("Service added succefully :) ");
        }
            int y = adminrolemenu.anotherservicemenu();
                if (y == 1) {
                    continue outerLoop;
                }else{
                    System.out.println("logged out");
                    break outerLoop;
                }
}else if(x==2){ // option bta3 el delete 

    System.out.println("enter the Service name you want to delete : ");
    String servicename = Functions.readString();
    if(ServicesManagement.searchServices(servicename)==null){ // bst5dm fn el search lw ml2tsh el elsm dh 
        boolean z = true;
        while(z){
            System.out.println("the service doesnt exist enter another service name : ");
            servicename = Functions.readString();
            if (ServicesManagement.searchServices(servicename)!=null) {
                ServicesManagement.deleteService(servicename);
                System.out.println("Service deleted succefully :) ");
            }
        }
    }else{ // lw el2sm tmam 
                ServicesManagement.deleteService(servicename);
                System.out.println("Service deleted succefully :) ");
    }
    int y = adminrolemenu.anotherservicemenu();
    if (y == 1) {
        continue outerLoop;
    }else{
        System.out.println("logged out");
        break outerLoop;
    }

}else if (x==3){   // Update option
    
    System.out.println("enter the service name to search for ");
    String name = Functions.readString();
    
    if(ServicesManagement.searchServices(name)==null){ // lw el esm msh mogod 
        boolean z = true; 
        while(z){
            System.out.println("Service not found  , please try again : ");
            name = Functions.readString();
            if(ServicesManagement.searchServices(name)!=null){ // lw d5l el esm s7 a5yra 
                z=false;
                System.out.println("enter the new price for "+ServicesManagement.searchServices(name).getServiceName()+" Service :");
                int serviceprice = Functions.readPositive();
                ServicesManagement.updateService(name, serviceprice);
            }
        }
    }else{ // lw d5l el 2sm s7 mn awl mra
        System.out.println("enter the new price for "+ServicesManagement.searchServices(name).getServiceName()+" Service :");
                int serviceprice = Functions.readPositive();
                ServicesManagement.updateService(name, serviceprice);
    }
    int y = adminrolemenu.anotherservicemenu();
    if (y == 1) {
        continue outerLoop;
    }else{
        System.out.println("logged out");
        break outerLoop;
    }


}   else if (x==4){ // show all services 
    
    System.out.println("All Services in the system : \n"); 
    ArrayList<Services> services = ServicesManagement.getServicesList(); // b3ml loop gdeda feha el lista bt3ty w blf 3leha 
    
    for(Services service :services){
        System.out.println("\n"+ "ID : "+service.getServiceID()+"    Name: " + service.getServiceName() + "    Description : " + service.getServiceDesc() + "    Price : " + service.getServicePrice() + "$");
    }
    System.out.println("\n =========================================");
    int y = adminrolemenu.anotherservicemenu();
    if (y == 1) {
        continue outerLoop;
    }else{
        System.out.println("logged out");
        break outerLoop;
    }
} else if (x==5){ // option el back 
    continue outerLoop;
}
}else if(t==4){ // Logout option 
    System.out.println("logged out succefully !");
    break outerLoop;
}
}
}
}

