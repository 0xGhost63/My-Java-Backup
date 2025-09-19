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

    double getArea()
    {
        return this.len_of_side*this.width;
    }

    double getPerimeter()
    {
        return 2*(this.len_of_side+this.width);
    }

    void isSquare()
    {
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

    void displayInfo()
    {
        double area=getArea();
        double perimeter=getPerimeter();
        System.out.printf("The length of each side of the rectangle is : %.2f cm\n",this.len_of_side);
        System.out.printf("The width of the rectangle is : %.2f cm\n",this.width);
        System.out.printf("The area of the Rectangle is : %.2f cm\n",area);
        System.out.printf("The Perimeter of the rectangle is : %.2f cm\n",perimeter);
        System.out.println("The colour of the Rectangle is : "+this.colour);
        isSquare();
    }
}

public class W1T4 
{
    public static void main(String[] args) 
    {
        double len_of_side,width;
        String colour;
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter the length of the Each side of the Rectangle : ");
        len_of_side=sc.nextDouble();
        System.out.print("Enter the width of the rectangle : ");
        width=sc.nextDouble();
        sc.nextLine(); // consume leftover newline
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
            int choice=sc.nextInt();
            sc.nextLine(); // consume newline after int input

            if (choice==0)
            {
                System.out.println("Have a nice day :)");
                break;
            }
            else if(choice==1)
            {
                System.out.printf("The area of the Rectangle is : %.2f cm\n",R1.getArea());
            }
            else if (choice==2)
            {
                System.out.printf("The perimeter of the Rectangle is : %.2f cm\n",R1.getPerimeter());
            }
            else if(choice==3)
            {
                R1.isSquare();
            }
            else if(choice==4)
            {
                double length,motai;
                String rung;

                System.out.print("Enter the new length of each side of the Rectangle : ");
                length=sc.nextDouble();
                System.out.print("Enter the new Width of the Rectangle : ");
                motai=sc.nextDouble();
                sc.nextLine(); // consume newline here
                System.out.print("Enter the new colour of the Rectangle : ");
                rung=sc.nextLine();

                R1.change(length, motai, rung);
                System.out.println("Dimensions and colour changed successfully\n");
            }
            else if (choice==5)
            {
                R1.displayInfo();
            }
            else
            {
                System.out.println("Invalid Operation Selected please try again : ");
            }
        }
    }
}
