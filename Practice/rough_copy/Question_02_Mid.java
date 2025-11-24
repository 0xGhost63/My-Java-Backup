class Person 
{
    final String address ;
    Person(String address)
    {
        this.address=address;
    }


    
}
public class Question_02_Mid 
{
    public static void main(String[] args) 
    {
        Person p1 = new Person("Lahore");
        System.out.println("Address set at the time of object Creation : "+p1.address);
        // p1.address="Faisalabad"; (THROWS AN ERROR !)
        /*  error: cannot assign a value to final variable address
            p1.address="Faisalabad";  */
        // System.out.println("Address assigned after : "+p1.address); 

    }    
}
