import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Parent implements Serializable 
{
    Parent() 
    {
        System.out.println("Parent Constructor");
    }
}

class Child extends Parent 
{
    Child() 
    {
        System.out.println("Child Constructor");
    }
}

public class UltraScenario3 {
    public static void main(String[] args) throws Exception {

        Child c = new Child();

        ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("c.txt"));
        oos.writeObject(c);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c.txt"));
        Child obj = (Child) ois.readObject();
        ois.close();
    }
}