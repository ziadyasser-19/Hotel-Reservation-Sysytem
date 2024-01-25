package models;

public class Guest extends Person {
    
    // Attributes
    private final int id;
    private static int GuestNumber = 0;
    

public Guest(String name ,int NationalId , String email ){
    super(name, "Guest", NationalId, email);
    this.id=++GuestNumber;
}


public int getId(){
    return this.id;
}


}
