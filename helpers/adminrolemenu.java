package roles;

public class adminrolemenu {
    
    public static void Adminmenu() {
        System.out.println("=============  Admin Main Page  =============");
        System.out.println("\n( 1 ) Employees Services ");
        System.out.println("( 2 ) Rooms services ");
        System.out.println("( 3 ) Services services");
        System.out.println("( 4 ) logout ");
        System.out.println("\nEnter your choice : ");
    }

    public static void EmployeeservicesMenu() {
        System.out.println("============= Employee Services =============");
        System.out.println("\n( 1 ) Add Employee ");
        System.out.println("( 2 ) Delete Employee ");
        System.out.println("( 3 ) Update Employee Information ");
        System.out.println("( 4 ) Show all Employees ");
        System.out.println("( 5 ) Show all Guests ");
        System.out.println("( 6 ) <== back to the admin main page ");
        System.out.println("\n Enter your choice : ");
    }

    public static void RoomsservicesMenu() {
        System.out.println("============= Rooms Services =============");
        System.out.println("\n( 1 ) Add a Room ");
        System.out.println("( 2 ) Delete Room ");
        System.out.println("( 3 ) Update Room Information ");
        System.out.println("( 4 ) Show all Rooms ");
        System.out.println("( 5 ) <== back to the admin main page ");
        System.out.println("\n Enter your choice : ");
    }

    public static void ServicesservicesMenu() {
        System.out.println("============= Service Services =============");
        System.out.println("\n( 1 ) Add a service ");
        System.out.println("( 2 ) Delete service ");
        System.out.println("( 3 ) Update Service Information ");
        System.out.println("( 4 ) Show all services ");
        System.out.println("( 5 ) <== back to the admin main page ");
        System.out.println("\n Enter your choice : ");
    }

    public static void main(String[] args) {
        ServicesservicesMenu();
    }
}

