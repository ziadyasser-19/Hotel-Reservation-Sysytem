package models;

public abstract class Person {
    
    // Attributes
    private String name;
    private final String role;
    private int password;
    private static int count = 0;
    private String email;
    private int NationalId;

    // Constructor
    public Person(String name, String role, int password){
        this.name = name;
        this.role = role;
        this.password = password;
        count++;
    }

    // constructor overrload for guest
    public Person(String name , String role , int NationalId,String email){
        this.name = name;
        this.role = role;
        this.NationalId = NationalId;
        this.email = email;
        count++;
    }

    // Setters
    public void setName(String name){
        this.name=name;    
    }

    public void setPass(int password){
        this.password=password;
    }

    // Getters
    public String getName(){
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getPass(){
        return password;
    }

    public int getNoOfUsers(){
        return count;
    }

    public void setemail(String email){
        this.email = email;
    }

    public String getemail(){
        return email;
    }

    public void SetNational(int NationalId){
        this.NationalId = NationalId;
    }

    public int getNationalID(){
        return NationalId;
    }
    // Methods 
    
    public boolean login(String name, int pass){
        if(this.name==name && this.password==pass){
            return true; //login successfully
        }
        return false; //login failed
    }

}
