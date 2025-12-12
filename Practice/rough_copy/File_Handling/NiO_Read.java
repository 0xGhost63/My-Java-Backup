// READING FROM THE FILE USING THE ARRAY LIST
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class NiO_Read
{
    public static void main(String[] args) 
    {
        Path path = Paths.get("Hello_NIO.txt");

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
            System.out.println("Reading from the file...!\n\n");
            List <String> content = Files.readAllLines(path);

            for (String data : content)
            {
                System.out.println(data);
            }

        }

        catch(IOException e)
        {
            System.out.println("Error opening file : "+e.getMessage());
        }   
    }
}
