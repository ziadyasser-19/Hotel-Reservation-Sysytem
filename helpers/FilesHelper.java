package helpers;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class FilesHelper {
    
    private File file;

    public FilesHelper(String pathname){
        file = new File(pathname);
    }
    
    public String writeToFile(String content) {
            try{
            FileWriter file = new FileWriter(this.file,true);
            file.append(content).append("\n");
            file.close();
            return "Successfully written :)";
            }catch(IOException e){
                return "Exception: " + e.getMessage();
            }
    }

    public String ReadFile(){
            
        try{
            FileReader file = new FileReader(this.file);
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


}


