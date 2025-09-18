class Distance
{
    double inches;
    double feet;

    Distance()
    {
        System.out.println("Distance Obj created with UN-PARAMETERIZED constructor");
    }
    Distance(double inches,double feet)
    {
        System.out.println("Distance Obj created with PARAMETERIZED constructor");
        this.inches=inches;
        this.feet=feet;
    }
    void displayData()
    {
        System.out.println("\nThe dimensions of the object are : ");
        System.out.printf("%.2f Feet & %.2f Inches ",this.feet,this.inches);
    }

}
public class W2T3 
{
    public static void main(String[] args) 
    {
        Distance obj1=new Distance();
        obj1.feet=20.1;
        obj1.inches=3.2;
        Distance obj2=new Distance(19.2,2.6);

        System.out.printf("%30s","===OUTPUT====\n");
        obj1.displayData();
        obj2.displayData();
    }
    
}
