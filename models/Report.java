package models;
import java.util.ArrayList;
import java.util.Date;
public class Report {
    
    private int id;
    private static int ReportCounter=0;
    private Date reportdate;
    private double starrate;
    private Guest reportedguest;
    private Services reportedservice;
    private static ArrayList<Report> reports = new  ArrayList<Report>();  
    /* private String guestname;
    private long guestid;
    private int serviceid; */

    public Report(Date date, Guest guest, Services service,double starrate) {
        this.id = ++ReportCounter;
        this.reportdate=date;
        this.reportedguest=guest;
        this.reportedservice=service;
        this.starrate=starrate;
}

    /* public Report(int id ,Date date , String guestname ,long guestid, int serviceid ,double starrate ){
        this.id = id ;
        this.reportdate=date;
        this.guestname=guestname;
        this.guestid=guestid;
        this.serviceid=serviceid;
        this.starrate=starrate;
    } */


 //setter and getter

    public static ArrayList<Report> getreportlist(){
        return reports;
    }

    public static void SetReportCounter(int x){
        ReportCounter=x;
    }

    public double getstarrate(){
        return this.starrate;
    }
    
    public  int getId(){
        return this.id;
    }

    public  Date getreporDate(){
        return this.reportdate;
    }

    public Guest getreportedGuest(){
        return this.reportedguest;
    }

    public Services  getreportedRoom() {
        return this.reportedservice ;
    }

    public int getReportCounter() {
        return ReportCounter; 
    }

    public Services getreportedservice(){
        return this.reportedservice;
    }

    public static ArrayList<Report> getReportlist(){
        return reports;
    }

    public static String generatereport(Guest guest,Services service,double starrate){
        Date currentdate = new Date(); // to set up the current date of the generated report then added it to constructor
        reports.add(new Report(currentdate,guest,service,starrate));
        return "The report of "+guest.getName()+ " has been added successfully " + "with rate "+starrate ;
    }

    //OVERLOAD REPORTFILE
    public static String generatereport(Long id , int serviceid,double starrate){
        Date currentdate = new Date(); // to set up the current date of the generated report then added it to constructor
        Guest guest = GuestManagement.SearchGuest(id);
        Services service = ServicesManagement.searchService(serviceid);
        
        reports.add(new Report(currentdate,guest,service,starrate));
        
        return "The report of "+guest.getName()+ " has been added successfully " + "with rate "+starrate ;
        
    } 

    public static double servicerate(){
        double x = 0;
        double result;
        if (reports.size()!=0){  // condition 3shan lw el mfesh report mynf3sh a2sm 3 zero
        for(int i = 0 ; i<reports.size();i++){
            x+=reports.get(i).starrate;
        }
        result = x /  reports.size();
        return result;
        }else
        return 0; // mfesh t2yym lsa
    }

}
