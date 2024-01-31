import models.*;
import helpers.*;
import roles.*;



public class Main {
    public static void main(String[] args){

        Admin.addAdmin("farah", 2004);
        boolean running = true;
        
        outerLoop:while(running){

            System.out.println("\n------ Welcome to the Hotel Management System! ------");
            int choice = HomeMenu.mainMenu();

            // log in as admin 
            if(choice==1){
                boolean logged = false;

                while(!logged){

                    System.out.println("\nEnter your name: ");
                    String name = Functions.readString();
    
                    System.out.println("\nEnter your password: ");
                    int pass = Functions.readInt();
    
                    if ( Authentication.AdminLogin(name, pass) ){
                        System.out.println("\nLogged in as admin successfully!\n");
                        AdminRole.main(args);
                        logged=true;
                    }
                    else {
                        System.out.println("\nLog in failed! Try again.\n");
                        int option = HomeMenu.tryAgain();
    
                        if (option==1){
                            continue;
                        } 
                        else{
                            break outerLoop;
                        }
                    }
                }
            }

            // Log in as receptionist
            else if(choice == 2){

                boolean logged= false;

                while(!logged){
                    System.out.println("\nEnter your name: ");
                    String name = Functions.readString();

                    System.out.println("\nEnter your password: ");
                    int pass = Functions.readInt();

                    if( Authentication.ReceptionistLogin(name, pass) ){
                        System.out.print("\nLogged in as Receptionist!\n");
                        ReceptionistRole.receptionistRole();
                        logged=true;
                    }
                    else{
                        System.out.println("\nLog in failed! Try again Or Sign up!\n");
                        int option = HomeMenu.tryAgainOrSignUp();

                        if(option==1){
                            continue;
                        }
                        else if(option==2){

                            boolean signedUp = false;

                            while(!signedUp){
                                System.out.println("\nEnter your name: ");
                                String username = Functions.readString();

                                System.out.println("\nEnter your password: ");
                                int password = Functions.readInt();

                                int returnInt = ReceptionistManagement.addEmployee(username, password);

                                if(returnInt==-1){ // name already used 
                                    System.out.println("\nUsername already exists. Try again to sign up\n");
                                    int returnTry = HomeMenu.tryAgain();
                                    if(returnTry==1){
                                        continue;
                                    }
                                    else{
                                        break outerLoop;
                                    }
                                }
                                else { // added successfully
                                    System.out.println("\nSigned up successfully!\n");
                                    int returnTry = HomeMenu.backOrExit();

                                    if(returnTry==1){
                                        continue outerLoop;
                                    }
                                    else{
                                        break outerLoop;
                                    }
                                }
                            }
                        }
                        else if(option==0) {
                            break;
                        }
                    }
                }
            }
            else{
                running = false;
            }
        }
    }
}
