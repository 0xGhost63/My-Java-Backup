class X 
{
    int a =10;
    void show()
    {
        System.out.println("X");
    }
}
class Y extends X
{
    int a =20;
    @Override
    void show()
    {
        System.out.println("Y");
    }
}
public class Dynamic_Method_Dispatch
{
    public static void main(String [] args)
    {
        X obj = new Y();
        System.out.println(obj.a);
        obj.show();
    }
}