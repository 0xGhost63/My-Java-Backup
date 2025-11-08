class Class_1 
{
   public void Display()
    {
        System.out.print("CLASS 1 METHOD");
    }
    
}

class Class_2 extends Class_1
{
    public void Display()
    {
        System.out.print("CLASS 2 METHOD");
    } 
}

public class Main 
{
    public static void main(String[] args) {
        System.out.println("Class 1 refrence");
        Class_1 c1 = new Class_2(); 
        c1.Display();
        System.out.println();

    }
    
}
