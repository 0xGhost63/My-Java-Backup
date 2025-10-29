import java.util.Scanner;
class Triangle extends GeometricObject
{
    //Attributes :
    private double side1;
    private double side2;
    private double side3;

    //Constructors !
    Triangle()
    {
        this.side1 = this.side2 = this.side3 = 1.0;
    }
    Triangle(double side1, double side2, double side3)
    {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    Triangle(double side1, double side2, double side3, String color, boolean filled)
    {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    //Getters & Setters
    public double getSide1() { return side1; }
    public double getSide2() { return side2; }
    public double getSide3() { return side3; }

    public double getPerimeter()
    {
        return side1 + side2 + side3;
    }

    public double getArea()
    {
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3)); // Heron's formula
    }

    public String toString()
    {
        return "Triangle";
    }
}
public class W8T2 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter side 1  : ");
        double side1 = input.nextDouble();
        System.out.print("Enter side 2  : ");
        double side2 = input.nextDouble();
        System.out.print("Enter side 3  : ");
        double side3 = input.nextDouble();
        System.out.print("Enter color   : ");
        String color = input.next();
        System.out.print("Is the triangle filled? (true/false): ");
        boolean filled = input.nextBoolean();

        Triangle t1 = new Triangle(side1, side2, side3, color, filled);
        String filledStatus = (t1.isFilled()) ? "FILLED" : "NOT FILLED";

        System.out.println("\n==========      TRIANGLE      ==========");
        System.out.printf("%-25s : %s\n", "Created On", t1.getDateCreated());
        System.out.printf("%-25s : %s\n", "Shape", t1.toString());
        System.out.printf("%-25s : %s\n", "Status", filledStatus);
        System.out.printf("%-25s : %.2f\n", "Side 1", t1.getSide1());
        System.out.printf("%-25s : %.2f\n", "Side 2", t1.getSide2());
        System.out.printf("%-25s : %.2f\n", "Side 3", t1.getSide3());
        System.out.printf("%-25s : %s\n", "Colour", t1.getColor());
        System.out.printf("%-25s : %.2f\n", "Area", t1.getArea());
        System.out.printf("%-25s : %.2f\n", "Perimeter", t1.getPerimeter());


    }    
}
