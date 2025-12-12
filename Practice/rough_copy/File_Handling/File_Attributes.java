import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import javax.swing.text.html.HTMLDocument;
public class File_Attributes 
{
    public static void main(String[] args) 
    {
        Path path = Paths.get("Hello_NIO.txt");

        try 
        {
            BasicFileAttributes fileAttributes = Files.readAttributes(path,BasicFileAttributes.class);
            Path temp = Files.createTempFile("tempFile",".tmp");
            BasicFileAttributes fileAttributes1 = Files.readAttributes(temp,BasicFileAttributes.class);

            System.out.println("FILE 1 : ");

            System.out.println("Creation Time : "+fileAttributes.creationTime());
            System.out.println("Last Access Time : " +fileAttributes.lastAccessTime());
            System.out.println("Last Modified Time : "+fileAttributes.lastModifiedTime());
            System.out.println("Is a Directory ? "+fileAttributes.isDirectory());

            System.out.println("\nFILE 2 : ");
            System.out.println("Creation Time : "+fileAttributes1.creationTime());
            System.out.println("Last Access Time : " +fileAttributes1.lastAccessTime());
            System.out.println("Last Modified Time : "+fileAttributes1.lastModifiedTime());
            System.out.println("Is a Directory ? "+fileAttributes1.isDirectory());
            
            
        } 
        catch (Exception e) 
        {
            System.out.println("Abra ka Dabra !");
        }
    }    
}
