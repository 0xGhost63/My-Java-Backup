class Shape 
{
    // Attribute
    String name;

    //Constructor
    Shape(String name)
    {
        this.name=name;
    }

    //Method
    void display()
    {
        System.out.printf("Shape %s \n",name);
    }
}

class Circle extends Shape
{
    // Attribute
    final double pie = 3.14;
    final int r = 5;

    //Constructor
    Circle(String name)
    {
        super(name);
    }

    //Method
    void calculateArea()
    {
        double area;
        area=pie*(r*r);
        if(this.name.equalsIgnoreCase("Circle"))
        {
            System.out.println("Area : "+area);
        }
        else
        {
            System.out.println("Invalid Shape !");
        }
        
    }
}

class Rectangle extends Shape
{
    // Attributes
    final int length=6;
    final int width=4;

    //Constructor
    Rectangle(String name)
    {
        super(name);
    }

    //Method
    void calculateArea()
    {
        int area;
        area=width*length;
        if(this.name.equalsIgnoreCase("Rectangle"))
        {
            System.out.println("Area : "+area);
        }
        else
        {
            System.out.println("Invalid Shape !");
        }
        
    }

}
public class W7T3
{    // Attributes

    public static void main(String[] args)
    {
        Circle c1 = new Circle("Circle");
        c1.display();
        c1.calculateArea();
        Rectangle r1=new Rectangle("Rectangle");
        r1.display();
        r1.calculateArea();
        
        // Invalid Shape Handling Case
        Circle c2 = new Circle("Triangle");
        c2.display();
        c2.calculateArea();
    }
}