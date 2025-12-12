import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Word_Replacing_Program 
{
    public static void main(String[] args) 
    {
        if(args.length<4)
        {
            System.out.println("Minimum 4 Arguments are Required !");
            System.out.println("1-Original File");
            System.out.println("2-File with desired changes");
            System.out.println("3-Change with");
            System.out.println("4-Change to ");
            System.exit(0);
        }    

        Path originalPath = Paths.get(args[0]);
        Path changePath = Paths.get(args[1]);
        String changeWith ="\\b"+args[2] +"\\b";
        String changeTo=args[3];

        

        if(!(Files.exists(originalPath)))
        {
            System.out.println("Original File not found ! ");   
            System.out.println("Exiting...");
            System.exit(1);
        }

        if(Files.exists(changePath))
        {
            System.out.println("File with desired changes found ! ");   
            System.out.println("Exiting...");
            System.exit(2);
        }
        

        try
        {
            List <String> originalData = Files.readAllLines(originalPath);
            Files.createFile(changePath);
            
            for (String line : originalData)
            {
                line=line.replaceAll(changeWith, changeTo);
                Files.write(changePath,(line+System.lineSeparator()).getBytes(),StandardOpenOption.APPEND);
            }
            System.out.println("OPERATION SUCCESSFUL !");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    
        
    }
}
