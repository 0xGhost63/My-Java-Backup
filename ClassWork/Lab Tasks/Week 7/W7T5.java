class Appliance
{
    //Attribute
    boolean isOperational=true;

    //Constructors
    Appliance()
    {

    }
    Appliance(boolean isOperational)
    {
        this.isOperational=isOperational;
    }

    //Methods
    void turnOn()
    {
        System.out.println("Appliance is turned on.");
    }

    void turnOff()
    {
        System.out.println("Appliance is turned off.");
    }
}

class Fan extends Appliance
{
    //Attributes
    boolean isSummer;
    boolean isBroken;

    //Constructor
    Fan(boolean isSummer,boolean isBroken)
    {
        this.isSummer=isSummer;
        this.isBroken=isBroken;

        if (!isBroken)
        {
            this.isOperational=true;
        }
        else
        {
            this.isOperational=false;
        }
    }

    @Override
    void turnOn()
    {
        if (isOperational && isSummer)
        {
            System.out.println("Fan is turned on.");
        }
        else if (isOperational && !isSummer) 
        {
            System.out.println("Fan cannot be turned on in winter.");
        }
        else if (!isOperational)
        {
            System.out.println("Fan is broken and cannot be turned on.");
        }
    }

    @Override
    void turnOff()
    {
        System.out.println("Fan is turned off.");
    }


}
class Light extends Appliance
{
    //Attributes
    boolean isDaytime;
    int powerLevel;

    //Constructor
    Light(boolean isDaytime,int powerLevel)
    {
        this.isDaytime=isDaytime;
        this.powerLevel=powerLevel;
        if (this.powerLevel>0)
        {
            this.isOperational=true;    
        }
        else
        {
            this.isOperational=false;
        }
    }

    //Methods
    @Override
    void turnOn()
    {
        if (isOperational && !isDaytime)
        {
            System.out.printf("Light is turned on at [%d]%% brightness.\n",this.powerLevel);
        }
        else if (isOperational && isDaytime)
        {
            System.out.println("Light cannot be turned on during the day.");
        }
        else if (!isOperational)
        {
            System.out.println("Light is broken and cannot be turned on.");
        }
    }

    @Override
    void turnOff()
    {
        System.out.println("Light is turned off.");
    }
}
public class W7T5 
{
    public static void main(String[] args) 
    {
        Fan f1 = new Fan(false, false);
        f1.turnOn();
        f1.turnOff();
        Light l1 = new Light(false,75);
        l1.turnOn();
        l1.turnOff();
        Fan f2 =  new Fan(true, true);
        f2.turnOn();
        f2.turnOff();
        Light l2 = new Light(true, 0);
        l2.turnOn();
        l2.turnOff();
    }
    
}
