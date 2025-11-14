import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling 
{
    public static void main(String[] args) 
    {
        // Creating 
        try 
        {
            File file = new File("File-Handling.txt");  
            file.createNewFile(); 
        } 
        catch (IOException e) 
        {
            System.out.println("Unable to create file !");  

        }

        // Writing to file !
        try 
        {
            FileWriter file = new FileWriter("File-Handling.txt",true);
            file.write("Hi this is my first file handling program in Java :)\nGood Bye !");
            file.append("\nThis is appended text !");
            String fin;
            fin = String.format("\n%40s\n","FIN !");
            file.append(fin);
            file.close();

        } 
        catch (IOException e) 
        {
            System.out.println("Unable to write to file !");
        }

        // Reading from file !
        try
        {
            Scanner file = new Scanner(new File("File-Handling.txt"));
            while(file.hasNextLine())
            {
                String line = file.nextLine();
                System.out.println(line);
            }
        }
        catch(IOException e)
        {
            System.out.println("Unable to access the file !"+e.getMessage());

        }
    }
    
}
