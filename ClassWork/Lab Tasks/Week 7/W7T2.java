class Vehicle
{
    // Attribute

    int speed;

    // Constructor

    Vehicle(int speed)
    {
        this.speed=speed;
    }

    //Method

    void displaySpeed()
    {
        System.out.println("Speed : "+this.speed);
    }
}

class Car extends Vehicle
{
    // Attribute

    String brand;

    // Constructor

    Car (int speed,String brand)
    {
        super(speed);
        this.brand=brand;
    }

    void displayBrand() 
    {
        if (this.speed>0) 
        {
            System.out.println("Brand : "+brand);    
        }
        else
        {
            System.out.println("Brand : Unknown");
        }
    }

    
}
public class W7T2 
{
    public static void main(String[] args) 
    {
        Car c1 = new Car(0,"BMW");
        c1.displaySpeed();
        c1.displayBrand();
        Car c2 = new Car(100,"Toyota");
        c2.displaySpeed();
        c2.displayBrand();

    }
    
}
