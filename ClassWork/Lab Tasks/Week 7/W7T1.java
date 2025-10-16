class Animal
{
    // Attribute
    String name;

    //Constructor
    Animal (String name)
    {
        this.name=name;
    }

    void speak()
    {
        System.out.println("This is a genenric animal.");
    }
}

class Dog extends Animal
{
    Dog(String name)
    {
        super(name);
    }


    @Override
    void speak()
    {
        if (this.name.equalsIgnoreCase("Buddy")) 
        {
            System.out.println("Woof Woof");
        }
        else
        {
            super.speak();
        }
        
    }

}
public class W7T1 
{
    public static void main(String[] args)
    {
        Animal a1 = new Animal("Generic animal");
        a1.speak();
        Dog d1 = new Dog("Buddy");
        d1.speak();
        Dog d2 = new Dog("Max");
        d2.speak();

    }    
}
