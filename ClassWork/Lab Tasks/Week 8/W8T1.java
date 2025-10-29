import java.util.Date;

abstract class GeometricObject
{
    //Attributes
    private String color;
    private boolean filled;
    private java.util.Date dateCreated;

    //Constructors
    GeometricObject()
    {
        this.dateCreated=new Date();
    }

    GeometricObject(String color,boolean filled)
    {
        this.color=color;
        this.filled=filled;
        this.dateCreated=new Date();
    }

    //Getters & Setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() 
    {
        return this.filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    //Abstract Methods !
    abstract public double getArea();
    abstract public double getPerimeter();


    //Normal Method 
    @Override
    public String toString()
    {
        return "Abstract Geometric Object";
    }
}

class Circle extends GeometricObject
{
    //Attribute : 
    private double radius;

    //Constructors
    public Circle()
    {

    }

    public Circle(double radius)
    {
        setRadius(radius);
    }

    public Circle (double radius,String color,boolean filled)
    {
        super(color,filled);
        setRadius(radius);
    }


    //Getters & Setters

    public double getDiameter()
    {
        double diameter=2*this.radius;
        return diameter;
    }
    
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    //Implementation of the abstract methods !

    public double getArea()
    {
        double area = (3.14159)*(getRadius()*getRadius());
        return area;
    }
    public double getPerimeter()
    {
        System.out.println("Can't find the Perimeter of a Circle !");
        return 0.0;
    }

    @Override
    public String toString()
    {
        return "Circle";
    }
    
}
class Rectangle extends GeometricObject
{
    //Attributes
    private double width;
    private double height;

    //Constructors
    public Rectangle()
    {

    }

    public Rectangle(double width,double height)
    {
        setWidth(width);        
        setHeight(height);
    }

    public Rectangle(double width,double height,String color,boolean filled)
    {
        super(color,filled);
        setWidth(width);
        setHeight(height);
    }




    //Getters & Setters
    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    //Implementation of the abstract methods !
    public double getArea()
    {
        double area=getHeight()*getWidth();
        return area;
    }

    public double getPerimeter() 
    {
        double perimeter=2*(getHeight()+getWidth());
        return perimeter;
    }

    @Override
    public String toString()
    {
        return "Rectangle";
    }

}

public class W8T1
{
    public static void main(String[] args) 
    {

        //Circle
        Circle c1 = new Circle(3.5, "Red", true);
        String isFilled = (c1.isFilled()) ? "FILLED" : "NOT FILLED";
          System.out.println("\n==========      CIRCLE      ==========");
        System.out.printf("%-25s : %s\n", "Created On", c1.getDateCreated());
        System.out.printf("%-25s : %s\n", "Shape", c1.toString());
        System.out.printf("%-25s : %s\n", "Status", isFilled);
        System.out.printf("%-25s : %.2f\n", "Radius", c1.getRadius());
        System.out.printf("%-25s : %.2f\n", "Diameter", c1.getDiameter());
        System.out.printf("%-25s : %s\n", "Colour", c1.getColor());
        System.out.printf("%-25s : %.2f\n", "Area", c1.getArea());
        System.out.printf("%-25s : %.2f\n", "Perimeter", c1.getPerimeter());
        //Rectangle
        Rectangle r1 = new Rectangle(3.6,6.3,"Yellow",false);
        String isRectangleFilled = (r1.isFilled()) ? "FILLED" : "NOT FILLED";
        System.out.println("\n==========      RECTANGLE      ==========");
        System.out.printf("%-25s : %s\n", "Created On", r1.getDateCreated());
        System.out.printf("%-25s : %s\n", "Shape", r1.toString());
        System.out.printf("%-25s : %s\n", "Status", isRectangleFilled);
        System.out.printf("%-25s : %.2f\n", "Height", r1.getHeight());
        System.out.printf("%-25s : %.2f\n", "Width", r1.getWidth());
        System.out.printf("%-25s : %s\n", "Colour", r1.getColor());
        System.out.printf("%-25s : %.2f\n", "Area", r1.getArea());
        System.out.printf("%-25s : %.2f\n", "Perimeter", r1.getPerimeter());
    }
}

