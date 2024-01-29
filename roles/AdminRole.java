package roles;

import helpers.Functions;
import helpers.adminrolemenu;
import models.ReceptionistManagement;

import java.util.Scanner;
public class AdminRole {
    boolean x = true; 
    static Scanner input = new Scanner(System.in);
    
    while (x){
        adminrolemenu.Adminmenu();

        if(adminrolemenu.Adminmenu()==1){
            adminrolemenu.EmployeeservicesMenu();
            if(adminrolemenu.EmployeeservicesMenu()==1){ //awl option fl menu elhwa add new employee
                String name;
                int password;
                System.out.println("enter employee name : ");
                name=Functions.readString();
                System.out.println("Enter the employee Password with in integer number :");
                password=Functions.readInt();
                if(ReceptionistManagement.addEmployee(name, password)==-1){
                    boolean z= true;
                    while(z){
                        System.out.println("\n this username is already exist enter another one : ");
                    }
                }
            }
        }




    }
}

