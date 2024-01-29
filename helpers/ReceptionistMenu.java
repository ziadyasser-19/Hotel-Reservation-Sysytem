package helpers;


public class ReceptionistMenu {


    public static int ReceptionistMainMenu (){
        System.out.println("[1]- Add Guest Data");
        System.out.println("[2]- Assign Room to Guest");
        System.out.println("[3]- Unassign Room from Guest");
        System.out.println("[4]- Filter Rooms");
        System.out.println("[5]- View Nearest Checkout");
        System.out.println("[6]- Assign Service to Guest");
        System.out.println("[7]- Unassign Service from Guest");
        System.out.println("[8]- View all guests");
        System.out.println("[9]- Print detailed bill for the guest");
        System.out.println("[10]- Generate report about service ");
        System.out.println("[0]- Log out");
        System.out.println("Choose one option to continue: ");
        int choice = Functions.readPositiveOrZeroMax(10);
        return choice;
    }

    public static int ReceptionistAddGuest(){
        System.out.println("[1]- Add another guest");
        System.out.println("[0]- Back to menu");

        int choice = Functions.readPositiveOrZeroMax(1);
        return choice;
    }

    public static void main(String[] args) {
        ReceptionistMainMenu();
    }
}
