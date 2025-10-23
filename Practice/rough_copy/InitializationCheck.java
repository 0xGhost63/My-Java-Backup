class Student
{
    int ID=01;
    String name="UNKNOWN";

    Student()
    {
        ID=0;
        name="DEFAULT";
    }

    Student(int ID,String name)
    {
        this.ID=ID;
        this.name=name;
    }

    void tellID()
    {
        System.out.printf("Name : %s  ID : %02d\n",this.name,this.ID);
    }
}

public class InitializationCheck {
    public static void main(String[] args) 
    {   
        Student s1= new Student(02,"Ali");

        Student s2 = new Student();
        Student s3 = new Student();
        s1.tellID(); 
        s2.tellID();
        s3.tellID();

    }
}
