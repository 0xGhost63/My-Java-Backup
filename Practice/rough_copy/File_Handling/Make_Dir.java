import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Make_Dir 
{
    public static void main(String[] args) 
    {
        try 
        {
            
            Path folder = Paths.get("Made_With_NIO");
            if(!(Files.exists(folder)))
            {
                Files.createDirectory(folder);
                System.out.println("Created a directory !");
            }
            Path fileInFolder = Paths.get("Made_With_NIO/Hehe.txt");
            if(!(Files.exists(fileInFolder)))
            {
                Files.createFile(fileInFolder);
                System.out.println("Created a File in directory  !");
            }    

            String quote ="""
                          Aur tu badlay jese badlay mausam
                          You know how summer ends
                          Phir sard hawayen aur khaali raaton mein
                          Jab tere khayal se baatein karoon
                          Tera ghar saja hai koi mehfil tou hogi
                          Aur hogi is mehfil ki jaan bhi tu
                          Pareshan nahi par heraan tou hun
                          Han bura hun, sar-e-aam hun mein
                          Mujhe jhutla diya tumne ese
                          Jese tum pe laga hua koi ilzaam hun mein
                          """;

            Files.write(fileInFolder,quote.getBytes(),StandardOpenOption.APPEND);
            System.out.println("Lyrice wrote in Dir : "+folder.toString()+" and in file : "+fileInFolder.toString() );
        } 
        catch (Exception e) 
        {
            System.out.println("Abra ka Dabra "+ e.getMessage());
        }    
    }    
}
