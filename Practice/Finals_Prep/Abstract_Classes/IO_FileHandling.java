import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IO_FileHandling
{
    public static void main(String[] args) throws IOException
    {
        File myfile = new File("Simple.txt");

        FileWriter writer = new FileWriter(myfile);

        writer.write("Hi,I'm learning the file handling in the Java IO now !\n");
        writer.write("Ok, Bye !");
        writer.close();

        Scanner reader = new Scanner (myfile);

        while(reader.hasNextLine())
        {
            String line;
            line = reader.nextLine();
            System.out.println(line);
        }
        reader.close();
    }    

}
