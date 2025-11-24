interface TestInterface
{
    // DEFAULT --> HAVE TO CREATE AN OBJECT
    default void print()
    {
        System.out.println("Hello from default method");
    }

    // STATIC --> DOES NOT HAVE TO CREATE AN OBJECT
    static void hello()
    {
        System.out.println("Hello from static method");
    }
    
}

public class Interface_Methods implements TestInterface
{
    public static void main(String[] args) 
    {
        TestInterface.hello();
        Interface_Methods a = new Interface_Methods();
        a.print();
    }    
}
