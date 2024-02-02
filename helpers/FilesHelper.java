package helpers;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class FilesHelper {
    
    
public static String writeToFile(String filePath, String content) {
        try{
        FileWriter file = new FileWriter(filePath,true);
        file.append(content).append("\n");
        file.close();
        return "Succefully written :)";
        }catch(IOException e){
            return "Exception: " + e.getMessage();
        }
}





public static String ReadFile(String filepath){
        
    try{
        FileReader file = new FileReader(filepath);
        String x =""; //string fady agm3 mnh elcharacters elflfile
        int data = file.read(); // by2ra el file char , char w btfdl trg3 -1 lw el file fady 

        while(data != -1){
            x=x+(char)data;
            data  =file.read();
        }
        file.close();
        
        return x;

    }catch(FileNotFoundException e){
        return "File not found ! "; 
    }catch(IOException ex){
        return "Exception " + ex.getMessage();
    }
}

    






public static void main(String[] args) {
    
    System.out.println(ReadFile(""));
}
}


