import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Generic_Class <T> implements Serializable
{
    T objValue;
    static int static_value = 20;
    transient int transient_Value=10; 


    public Generic_Class(T objValue) 
    {
        this.objValue=objValue;
    }

    public T getObjValue ()
    {
        return this.objValue;
    }

    public  int getStatic_value()
    {
        return static_value;
    }
    

    public int getTransient_value()
    {
        return this.transient_Value;
    }

    public  <T  extends Number,U extends Number> double sum (T value_1,U value_2)
    {
        double sum =(double) value_1.doubleValue() + value_2.doubleValue()  ;
        return sum;
    }


}

public class Generics 
{
    public static void main (String [] args) throws IOException,ClassNotFoundException
    {
        Generic_Class<String> obj = new Generic_Class("Hehehehe");

        System.out.printf("Sum is : %.2f\n",obj.sum(63.5,149.00009));
        System.out.println("Object value is : "+obj.getObjValue());

        File myFile = new File ("Generic_Class.ser");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(myFile));
        out.writeObject(obj);
        System.out.println("Successfully Written to the file : "+myFile.getName());
        out.close();

        System.out.println("\n====BEFORE CHANGING===");
        
        System.out.println("Transient Value : "+obj.getTransient_value());
        System.out.println("Static Value : "+obj.getStatic_value());
        

        //Changing the STATIC AND THE TRANSISENT VALUES !
        obj.static_value=63;
        obj.transient_Value=63;


        System.out.println("\n====AFTER CHANGING===");
        {
            System.out.println("Transient Value : "+obj.getTransient_value());
            System.out.println("Static Value : "+obj.getStatic_value());
        }

        //Reading from the file !

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(myFile));
        Generic_Class obj2 =(Generic_Class) in.readObject();

        System.out.println("\nReading from the file..."+myFile.getName());
        System.out.printf("Sum is : %.2f\n",obj2.sum(63,149));
        System.out.println("Object value is : "+obj2.getObjValue());

        System.out.println("\n====READING THE OBJECT===");
        {
            System.out.println("Transient Value : "+obj2.getTransient_value());
            System.out.println("Static Value : "+obj2.getStatic_value());
            System.out.println("Static Value : "+Generic_Class.static_value);

        }
        in.close();

    }
}
