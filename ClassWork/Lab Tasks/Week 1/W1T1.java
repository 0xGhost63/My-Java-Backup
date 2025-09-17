import java.util.Scanner;

class Student
{
    String name;
    int bari_class;
    int age;
    float marks;
    int roll;
    String behaviour;

    // Constructor
    Student(String name, int bari_class, int age, float marks, int roll, String behaviour)
    {
        this.name = name;
        this.bari_class = bari_class;
        this.age = age;
        this.marks = marks;
        this.roll = roll;
        this.behaviour = behaviour;
    }

    // Method to display student data
    void show_data()
    {
        System.out.println("The name of the student is : " + name);
        System.out.println("The bari_class of the student is : " + bari_class);
        System.out.println("The age of the student is : " + age);
        System.out.println("The marks of the student is : " + marks);
        System.out.println("The roll number of the student is : " + roll);
        System.out.println("The remarks about the student is : " + behaviour);
    }
}

public class W1T1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== Welcome to the University Management System =====");

        String name;
        int bari_class;
        int age;
        float marks;
        int roll;
        String behaviour;

        System.out.print("Enter the name of the Student: ");
        name = sc.nextLine();

        System.out.print("Enter the bari_class of the Student: ");
        bari_class = sc.nextInt();

        System.out.print("Enter the age of the Student: ");
        age = sc.nextInt();

        System.out.print("Enter the marks of the Student: ");
        marks = sc.nextFloat();

        System.out.print("Enter the roll number of the Student: ");
        roll = sc.nextInt();
        sc.nextLine(); // consume newline left after nextInt()

        System.out.print("Remarks about the student: ");
        behaviour = sc.nextLine();

        Student s1 = new Student(name, bari_class, age, marks, roll, behaviour);

        char choice;
        System.out.print("Do you want to see the student's data (y/n)? ");
        choice = sc.next().charAt(0);

        if (choice == 'y' || choice == 'Y')
        {
            System.out.println("\n===== Data-Base =====\n");
            s1.show_data();
        }

        sc.close();
    }
}

