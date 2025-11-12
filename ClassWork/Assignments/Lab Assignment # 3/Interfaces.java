import java.util.Scanner;
interface Shape
{
    public double area();   
}

class Rectangle implements Shape
{
    double length;
    double width;
    double rectangleArea;

    Rectangle(double length,double width)
    {
        this.length=length;
        this.width=width;
        this.rectangleArea=this.length*this.width;

    }

    public double area ()
    {
        return this.rectangleArea;
    }
}

class Circle implements Shape
{
    final double pie = Math.PI;

    double radius;
    double circleArea;

    Circle(double radius)
    {
        this.radius=radius;
        this.circleArea = pie*(radius*radius);

    }

    public double area()
    {
        return this.circleArea;
    }
}

class Triangle implements Shape
{
    double base;
    double height;
    double triangleArea;
    final double half=0.5;

    Triangle(double base,double height)
    {
        this.base=base;
        this.height=height;
        this.triangleArea=(half)*(this.base*this.height);
    }

    public double area()
    {
        return this.triangleArea;
    }

}

class CalculateArea
{

    static double [] calulateArea (Shape [] array ) 
    {
        int lengthOfArray=array.length;

        double [] valuesArray = new double[lengthOfArray];

        for (int i =0;i<array.length;i++)
        {
            valuesArray[i]=array[i].area();
        } 

        return valuesArray;
    }
}
public class Interfaces 
{   public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.printf("How many Shapes would you like to create ? : ");
        int lengthOfArray=sc.nextInt();

        Shape [] array = new Shape[lengthOfArray];

        for(int i =0;i<array.length;i++)
        {
            int choice;
            do 
            {
                System.out.println();
                System.out.printf("Available options for Shape # %d are : ",(i+1));
                System.out.println("\n1-Rectangle\n2-Circle\n3-Triangle\n");
                System.out.print("> ");
                choice=sc.nextInt();
                
            } while (choice>3 || choice <1);


            switch (choice) 
            {
                case 1:
                    double length;
                    double width;
                    System.out.printf("%40s\n","=====RECTANGLE=====");
                    System.out.print("Enter the length of the rectangle : ");
                    length=sc.nextDouble();
                    System.out.print("Enter the width of the Rectangle : ");   
                    width=sc.nextDouble();
                    System.out.println("Successfully Created the RECTANGLE :)");
                    Rectangle r = new Rectangle(length, width);
                    array[i]=r;
                    break;

                case 2 :
                    double radius;
                    System.out.printf("%40s\n","=====CIRCLE=====");
                    System.out.print("Enter the radius of the circle : ");
                    radius=sc.nextDouble();
                    System.out.println("Successfully Created the CIRCLE :)");
                    Circle c = new Circle(radius);
                    array[i]=c;

                    break;
            
                case 3:
                    double base;
                    double height;
                    System.out.printf("%40s\n","=====TRI-ANGLE=====");
                    System.out.print("Enter the base of the triangle : ");
                    base=sc.nextDouble();
                    System.out.print("Enter the height of the Rectangle : ");   
                    height=sc.nextDouble();
                    System.out.println("Successfully Created the TRI-ANGLE :)");
                    Triangle t = new Triangle(base, height);
                    array[i]=t;
                    break;

                default:
                    System.out.println("This block will never execute :)");
                    break;
            }
            
        }
        System.out.println();
        System.out.printf("All %d shapes created ! \n",lengthOfArray);
        System.out.println("The Areas of the shapes are : ");

        //PRINTING-PHASE
        double [] valuesArray = new double [lengthOfArray]; 
        valuesArray=CalculateArea.calulateArea(array);

        System.out.println();
        System.out.printf("%-20s  %-27s\n","Shape","Area");
        System.out.println();
        for(int i = 0 ;i<valuesArray.length;i++)
        {
            System.out.printf("%d-%-20s%.2f\n",(i+1),array[i].getClass().getSimpleName(),valuesArray[i]);

        }

    }   
}
