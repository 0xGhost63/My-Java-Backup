//PERFECT !
import java.util.Scanner;

class Circle
{
    double radius;
    double two=2.00;
    final double pie =3.14; 

    Circle ()
    {
        System.out.println("Circle created WITHOUT parameterized constructor");

    }
    Circle(double radius)
    {
        System.out.println("Circle created WITH parameterized constructor !");
        this.radius=radius;
    }
    double calculateCircumfernece()
    {
        double result=2*pie*this.radius;
        return result;
    }

}
public class W2T1 {
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        double c1_circum,c2_circum,radius;
        System.out.println("Welcome to the CIRCLE :)");
        System.out.print("Enter the radius of the Circle 2 : ");
        radius=sc.nextDouble();

        Circle c1=new Circle();
        Circle c2=new Circle(radius);
        c1.radius=2.14;
        c1_circum=c1.calculateCircumfernece();
        c2_circum=c2.calculateCircumfernece();
        System.out.printf("The Circumference of the Circle 1 is : %.2f cm\n",c1_circum);
        System.out.printf("The Circumference of the Circle 2 is : %.2f cm\n",c2_circum);
        System.out.println("The radius of the circle 2 is : "+radius);
        sc.close();
        System.out.println("Signing out...");


        


    }
    
}
