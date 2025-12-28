class Address
{
    int street;
    String colony;

    Address(int street,String colony)
    {
        this.street=street;
        this.colony=colony;
    }
}

class Student 
{
    int roll;
    String name;
    Address adr;

    Student(int roll,String name,int street,String colony)
    {
        this.roll=roll;
        this.name=name;
        this.adr=(new Address(street,colony));
        
    }


    public void show()
    {
        System.out.println(this.name);
        System.out.println(this.roll);
        System.out.println(this.adr.colony);
        System.out.println(this.adr.street);
    }

}




public class Constructor 
{
    public static void main (String [] args)
    {
        Student ali = new Student(10, "Sanan",21,"Gulgasht Colony");
        System.out.print("s1 : ");
        ali.show();




    }    
}
