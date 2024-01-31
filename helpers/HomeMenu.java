package helpers;

public class HomeMenu {
    
    public static int mainMenu(){

        System.out.println("\nChoose one of the following options to log in: \n");
        System.out.println("[1]- Admin");
        System.out.println("[2]- Receptionist");
        System.out.println("[0]- Exit");
        System.out.println("\nEnter your choice: ");

        int choice = Functions.readPositiveOrZero(2);
        return choice;
    }


    public static int tryAgain(){

        System.out.println("[1]- Try Again");
        System.out.println("[0]- Exit");
        System.out.println("\nEnter your choice: ");

        int choice = Functions.readPositiveOrZero(1);
        return choice;
    }

    public static int tryAgainOrBack(){

        System.out.println("[1]- Try Again");
        System.out.println("[0]- Back");
        System.out.println("\nEnter your choice: ");

        int choice = Functions.readPositiveOrZero(2);
        return choice;
    }

    public static int backOrExit(){
        System.out.println("[1]- Back to home menu");
        System.out.println("[0]- Exit");
        System.out.println("\nEnter your choice: ");

        int choice = Functions.readPositiveOrZero(1);
        return choice;
    }

    public static int loginOrSignUp(){
        System.out.println("\n[1]- Log in ");
        System.out.println("[2]- Sign up");
        System.out.println("[0]- Back");
        System.out.println("\nEnter your choice: ");

        int choice = Functions.readPositiveOrZero(2);
        return choice;
    }
}
