package models;

public class Guest extends Person {
    
    // Attributes
    private final int id;
    private static int GuestNumber = 0;
    private Room regRoom;
    private Services regServices;
    

public Guest(String name ,int NationalId , String email ){
    super(name, "Guest", NationalId, email);
    this.id=++GuestNumber;
}

public Room getRegRoom(){
    return regRoom;
}

public Services getRegServices(){
    return regServices;
}


public int getId(){
    return this.id;
}

// methods 
//==========================================

public int addRoom(Room room){
    if(this.regRoom!=null)
        return -1; // the guest already registerd in room
    else{
        this.regRoom=room;
        return 1; // added room to the guest succefully 
    }
}

public int deleteRoom(){
    if (this.regRoom == null )
        return -1; //room already deleted 
    else 
        this.regRoom=null;
        return 1; // deleted success
}



public int addService(Services service){      //add service to guest zy el set kda
    if(this.regServices!=null)
        return -1; // the guest already registerd in room
    else{
        this.regServices=service;
        return 1; // added value succecfully 
    }
}


public int deleteService(){    // f function tanya b nfs elesm f servicemanag take care      
    if (this.regServices == null )
        return -1; //service already deleted 
    else 
        this.regServices=null;
        return 1; // deleted success
}


}
