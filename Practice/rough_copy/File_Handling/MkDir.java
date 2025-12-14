import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MkDir
{
    public static void main(String[] args) 
    {
        if(args.length>1 || args.length<1)
        {
            System.out.println("Invalid number of arguments passed !");
            System.out.println("Correct Syntax : \"java MkDir *Directory Name*\" ");
            System.exit(0);
        }

        String dir = args [0];
        Path path = Paths.get(dir);

        try
        {
            Files.createDirectories(path);
            System.out.println("Directory Created at : "+path.toAbsolutePath());
            // Path toDelete = Paths.get("/media/sannan/SCNZ/Java/Practice/rough_copy/File_Handling/Generic_Classes/Generic.java");
            // Files.deleteIfExists(toDelete);
            // if(!Files.exists(toDelete))
            // {
            //     System.out.println("File Deleted at : "+toDelete.toAbsolutePath());
            // }
        }
        catch(IOException e)
        {
            System.out.println("Error : "+e.getMessage());
        }
        

    }
}