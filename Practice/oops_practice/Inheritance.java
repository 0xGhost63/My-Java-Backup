class Teacher
{
    int ID;
    String name;

    Teacher (int ID,String name)
    {
        this.ID=ID;
        this.name=name;
    }

    void Teaching()
    {
        System.out.println("Teacher is teaching");
    }

    void showDetails()
    {
        System.out.println("Teacher's name is "+ this.name);
        System.out.println("The id of the teacher is : "+ this.ID);
    }
}





class AK extends Teacher
{
    AK (int ID,String name)
    {
        super(ID, name);
    }

    @Override
    void Teaching ()
    {
        System.out.println("Sir Abdul Karim is teaching ");
    }
}






public class Inheritance
{
    public static void main(String[] args)
    {
        Teacher t1 = new Teacher(1, "Teacher");
        AK t2 = new AK (2, "Abdul karim shahid");

        t1.Teaching();
        t2.Teaching();

        t1.showDetails();
        t2.showDetails();
        
    }
    
}
