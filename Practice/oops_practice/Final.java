class Mid
{
    final int a;
    // a=10; ===> Throws Error
    Mid()
    {
        a=10; //Works perfecttly fine
        System.out.println("The value of A is : " +a);
    }
}
public class Final {
    public static void main(String[] args) {

        final Mid m1 = new Mid(); // Final Object
        // m1 = new Mid(); throws error
    }
    
}
