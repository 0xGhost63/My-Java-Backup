abstract class Abstract_Class
{
    public abstract void draw();
    
}

class Concrete_Class extends Abstract_Class
{
    @Override
    public void draw()
    {
        System.out.println("Drawing !");
    }
}

public class Abstract_Method 
{
    public static void main (String [] args)    
    {
        Abstract_Class obj1 = new Concrete_Class();
        obj1.draw();
    }
}
