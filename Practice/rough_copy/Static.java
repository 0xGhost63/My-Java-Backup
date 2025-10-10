class Student
{
    int roll;

    Student(int roll)
    {
        this.roll=roll;
    }

    void sayHI()
    {
        System.out.println("Hi im a student !");
    }

    static void sayBye()
    {
        System.out.println("Bye from the student");
    }
}

// MAIN CLASS

public class Static {
    public static void main(String[] args) 
    {
        Student s1 = new Student(1);
        s1.sayHI();

        Student.sayBye();
        // Student.sayHi(); THROWS AN ERROR 


    }
    
}
