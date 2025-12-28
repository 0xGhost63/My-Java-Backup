import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class ABC implements Serializable
{
    int value;

    public ABC(int value) 
    {
        this.value=value;
    }

    

}
public class ArrayListSerialization
{
    public static void main(String[] args) throws IOException,ClassNotFoundException
    {
        ArrayList <ABC>list = new ArrayList <>();
        list.add(new ABC (12));
        list.add(new ABC (23));
        list.add(new ABC (34));
        list.add(new ABC (32));
        list.add(new ABC (54));
        list.add(new ABC (32));

        File myFile = new File("Arraylist.txt");

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(myFile));
        for (ABC item : list)
        {
            out.writeObject(item);
        }
        System.out.println("Successfully written all the files to the : "+myFile.getName());

        //reading!

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(myFile));
        ArrayList <ABC> retrieved = new ArrayList<>();

        while(true)
        {
            try
            {
                ABC obj = (ABC) in.readObject();   
                retrieved.add(obj);
            }
            catch(EOFException e)
            {
                System.out.println(e.getMessage());
                break;
            }

            System.out.println("===OBJECTS RECOVERED====");
            for (ABC item : retrieved)
            {
                System.out.println(item);
            }
        }
    }    
}
