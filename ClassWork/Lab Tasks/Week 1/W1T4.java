// NOTE: MINOR DEBUG REQUIRED SOME FUNCTIONS DON'T WORK PROPERLY (CHOICE 4 & 5) + the cursor should move to the next line when a 
// Case executes successfully :)
import java.util.Scanner;
class Rectangle
{
    double len_of_side;
    double width;
    String colour;
    

    Rectangle(double len_of_side,double width,String colour)
    {
        this.len_of_side=len_of_side;
        this.width=width;
        this.colour=colour;

    }
    double getArea(double len_of_side,double width)
    {
        double area;
        area=this.len_of_side*this.width;
        return area;
    }
    double getPerimeter(double len_of_side,double width)
    {
        double perimeter;
        double multiply;;
        multiply=(this.len_of_side+this.width);
        perimeter=multiply*2;
        return perimeter;
    }
    void isSquare(double len_of_side,double width){
        if (this.len_of_side==this.width)
        {
            System.out.println("The specific rectangle is also a Square !");

        }
        else
        {
            System.out.println("This Rectangle is not a square :(");
        }
    }
    void change(double len_of_side,double width,String colour)
    {
        this.len_of_side=len_of_side;
        this.width=width;
        this.colour=colour;
    }
    void displayInfo(double len_of_side,double width,String colour)
    {
        double area,perimeter;
        area=getArea(len_of_side,width);
        perimeter=getPerimeter(len_of_side, width);
        System.out.printf("The length of the each side of the rectangle is : %.2f cm ",len_of_side);
        System.out.printf("The width of the rectangle is : 2f% cm",width);
        System.out.printf("The area of the Rectangle is : %.2f cm",area);
        System.out.printf("The Perimeter of the rectangle is : %.2f cm ",perimeter);
        System.out.println("The colour of the Rectangle is : "+colour);
        isSquare(len_of_side, width);
    }
    

}
public class W1T4 
{
    public static void main(String[] args) 
    {
        double len_of_side,width;
        String colour;
        Scanner sc= new Scanner(System.in);
        System.out.printf("Enter the length of the Each side of the Rectangle : ");
        len_of_side=sc.nextDouble();
        System.out.print("Enter the width of the rectangle : ");
        width=sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter the colour of the Rectangle : ");
        colour=sc.nextLine();
        Rectangle R1=new Rectangle(len_of_side,width,colour);

        System.out.println("\n===Available Options====");
        System.out.println("Select one of the available options given below (0-5)");
        System.out.println("1-Get the area of the Rectangle");
        System.out.println("2-Get the perimeter of the Rectangle");
        System.out.println("3-Check whether the Rectangle is also a square");
        System.out.println("4-Change the dimensions of the Rectangle");
        System.out.println("5-Display all the info of the Rectangle :)");
        System.out.println("0-EXIT");
        while (true) 
        {
            int choice;
            choice=sc.nextInt();
            if (choice==0)
            {
                System.out.println("Have a nice day :)");
                break;
            }
            else if(choice==1)
            {
                double temp;
                temp=R1.getArea(len_of_side,width);
                System.out.printf("The area of the Rectangle is : %.2f cm",temp);
            }
            else if (choice==2)
            {
                double temp;
                temp=R1.getPerimeter(len_of_side, width);
                System.out.printf("The perimeter of the Rectangle is : %.2f cm ",temp);
            }
            else if(choice==3)
            {
                R1.isSquare(len_of_side, width);

            }
            else if(choice==4)
            {
                double length,motai;
                String rung;
                System.out.print("Enter the new length of each side of the Rectangle : ");
                length=sc.nextDouble();
                System.out.print("Enter the new Width of the Rectangle : ");
                motai=sc.nextDouble();
                System.out.print("Enter the new colour of the Rectangle : ");
                rung=sc.nextLine();
                R1.change(length, motai, rung);
                System.out.println("Dimensions and colour changed successfully ");

            }
            else if (choice==5)
            {
                R1.displayInfo(len_of_side, width,colour);
            }
            else
            {
                System.out.println("Invalid Operation Selected please try again : ");
            }
        }


        
    }
    
}
