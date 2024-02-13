package helpers;


public class ReceptionistMenu {


    public static int ReceptionistMainMenu (){
        System.out.println("\n **** Welcome to Receptionist Menu ****\n");
        System.out.println("[1]- Add Guest Data");
        System.out.println("[2]- Assign Room to Guest");
        System.out.println("[3]- Unassign Room from Guest");
        System.out.println("[4]- Filter Rooms");
        System.out.println("[5]- View Nearest Checkout");
        System.out.println("[6]- Assign Service to Guest");
        System.out.println("[7]- View all guests");
        System.out.println("[8]- Print detailed bill for the guest");
        System.out.println("[9]- Generate report about service ");
        System.out.println("[10]- Delete Guest");
        System.out.println("[11] See Services Rates !");
        System.out.println("[0]- Log out");
        System.out.println("\nChoose one option to continue: ");
        int choice = Functions.readPositiveOrZero(11);
        return choice;
    }

    public static int ReceptionistAddGuest(){
        System.out.println("[1]- Add another guest");
        System.out.println("[0]- Back to menu");
        System.out.println("\nChoose one option to continue: ");

        int choice = Functions.readPositiveOrZero(1);
        return choice;
    }

    public static int ReceptionistTryAgain(){
        System.out.println("[1]- Try again");
        System.out.println("[0]- Back to menu");
        System.out.println("\nChoose one option to continue: ");

        int choice = Functions.readPositiveOrZero(1);
        return choice;
    }
}
