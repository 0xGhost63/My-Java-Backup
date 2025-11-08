class Teacher
{
    // constructor + attributes


    // METHOD OVERLOADING



    void Display(int number)
    {
        System.out.println("Constructorr # 1(ONE PARAMETERS)called");
    }

    void Display (String number)
    {
        System.out.println("CONSTUCTOR WITH STRING");
    }

    void Display(int number,int number2)
    {
        System.out.println("Constructorr # 2(TWO PARAMETERS) called");
    }


    void Display(int number,int number1,int number2)
    {
        System.out.println("Constructorr # 3(THREE PARAMETERS) called");
    }
}
public class Overloading 
{
    public static void main(String[] args)
    {
        Teacher t1 = new Teacher();
        t1.Display(1);
        t1.Display("ALI");
        t1.Display(1,2);
        t1.Display(1,3,4);
    }

}
