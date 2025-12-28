import java.io.*;

class A implements Serializable { static { System.out.print("S "); } { System.out.print("I "); } A(){ System.out.print("C "); } }
class B extends A implements Serializable { A a = new A(); B(){ System.out.print("B "); } }

public class Extreme {
    public static void main(String[] args) throws Exception {
        B b = new B();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(b);

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        B b2 = (B) ois.readObject();
    }
}
