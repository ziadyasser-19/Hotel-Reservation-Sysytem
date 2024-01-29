package roles;

import java.util.ArrayList;

import helpers.Functions;
import helpers.adminrolemenu;
import models.GuestManagement;
import models.Receptionist;
import models.ReceptionistManagement;
import models.RoomManagement;
import models.Guest;


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
                            System.out.println("Receptionist added succefully");
                        }
                    }
                }else{
                    System.out.println("added succefully");
                }

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
        if(RoomManagement.addRoom(Roomnum, type, false)==-1){
            boolean z = true;
            while(z){
                
            }
        }
    }

}
}
}
}

