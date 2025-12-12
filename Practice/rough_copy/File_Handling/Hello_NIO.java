
import java.io.IOException;
import java.nio.file.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Hello_NIO
{
    static void printSleep(String content)
    {
        System.out.println(content);
        try
        {
            Thread.sleep(500);
        }
        catch(Exception e)
        {
            System.out.println("Sleep Error : "+e.getMessage());
        }
    }
    public static void main (String [] args )
    {
        printSleep("Finally Writing in file");

        Scanner sc = new Scanner (System.in);
        System.out.println("What would you like to write in the file ?");
        System.out.print("> ");
        String content = sc.nextLine();

        Path path = Paths.get("Hello_NIO.txt");

    
        Scanner output = null;
           
        try
        {
            // Files.createFile(path);
            Files.write(path,(content+ System.lineSeparator()).getBytes(),StandardOpenOption.APPEND);

            System.out.println("Successfully Added the TEXT !");
            output = new Scanner(new File("Hello_NIO.txt"));

        }
        catch(IOException e)
        {
            System.out.println("Error : "+e.getMessage());
        }
        
        printSleep("\nReading from the file now (USING SCANNER)!");


        System.out.println("Content Fetched : ");
        while(output.hasNextLine())
        {
            String line = output.nextLine();
            System.out.println(line);
        }

        printSleep("\nReading from the file now (USING NIO)!");

    try 
    {
        byte[] bytes = Files.readAllBytes(path);  
        String damn= new String(bytes);  
        System.out.println(damn);          
    } 
    catch (IOException e) 
    {
        System.out.println("Reading file not found, Error: "+e.getMessage());
    }

  




        
    
        

    }
}