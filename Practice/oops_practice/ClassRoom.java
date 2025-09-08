import java.util.Scanner;

class Student
{
    String name;
    int roll;
    float marks;

    // Constructor
    Student(String name, int roll, float marks)
    {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
        
    }

    void printInfo()
    {
        System.out.println("The student name is: " + this.name);
        System.out.println("The roll number of the student is: " + this.roll);
        System.out.println("The marks of the student is: " + this.marks);
    }
}

class SpecialStudent extends Student
{
    // Constructor calls parent constructor
    SpecialStudent(String name, int roll, float marks)
    {
        super(name, roll, marks);
        System.out.println("This is a special student!");
    }
}

public class ClassRoom
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String name;
        int roll;
        float marks;

        System.out.println("Welcome to the class management system!");
        System.out.println("====================");

        // Student 1
        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("Enter the roll number: ");
        roll = sc.nextInt();
        System.out.print("Enter the marks: ");
        marks = sc.nextFloat();
        sc.nextLine(); // consume leftover newline
        Student s1 = new Student(name, roll, marks);

      

        // Student 2
        System.out.print("\nName: ");
        name = sc.nextLine();
        System.out.print("Enter the roll number: ");
        roll = sc.nextInt();
        System.out.print("Enter the marks: ");
        marks = sc.nextFloat();
        sc.nextLine(); // consume leftover newline
        Student s2 = new Student(name, roll, marks);


        // Special Student 3
        System.out.print("\nName: ");
        name = sc.nextLine();
        System.out.print("Enter the roll number: ");
        roll = sc.nextInt();
        System.out.print("Enter the marks: ");
        marks = sc.nextFloat();
        sc.nextLine(); // consume leftover newline
        SpecialStudent s3 = new SpecialStudent(name, roll, marks);

        


        System.out.println("====================\n       RESULT\n====================");
        s1.printInfo();
        s2.printInfo();
        s3.printInfo();
        sc.close();
    }
}
