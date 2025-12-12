//WRITING USING THE ARRAYLIST !!!

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class NIO_Write 
{
    public static void main(String[] args) 
    {
        Path path = Paths.get("NIO_Writing.txt");
        Scanner sc = new Scanner(System.in);

        try
        {
            if(!Files.exists(path))
            {
                System.out.println("File doesn't exists ! Creating a new one ...");
                Files.createFile(path);
            }
            else
            {
                System.out.println("File exists...moving forward");
            }
        
            System.out.println("***Enter -1 to exit !***");
            String line="";
            ArrayList <String> lineStorage = new ArrayList<>();

            while(!(line.equals("-1")))
            {
                System.out.print("> ");
                line=sc.nextLine();
                if(!(line.equals("-1")))
                lineStorage.add(line);
            }

            
            // System.out.println("In ArrayList :");
            for (String data : lineStorage)
            {
                Files.write(path,(data+System.lineSeparator()).getBytes(),StandardOpenOption.APPEND);

                // System.out.println(data);
            }
            System.out.println("Successfully Written to the File");
            System.out.println("Signing out !");


        }

        catch(IOException e)
        {
            System.out.println("Error opening file : "+e.getMessage());
        }   
    }    
}
