import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
class Student
{
    //Attributes
    String studentName;
    int [] marks;

    Student(String studentName,int[] marks) //Constructor
    {
        this.studentName=studentName;
        this.marks=marks;
    }

    static double calculateGPA(int[]marks,String studentName) //GPA caculating function
    {
        double GPA;
        double sum=0;
        double subjects=marks.length;
        for(int mark :marks) //Array Iteration
        {
            sum+=mark;
        }
        GPA=(sum/subjects)/25;
        GPA=(GPA>4.0) ? 4.0:GPA; //Ternary operator like W1T1
        return GPA;
    }
    //Grade assigning function !
    char [] getGrades()
    {
        int len;
        len=this.marks.length;
        char [] grades=new char [len];
        for(int i=0;i<len;i++)
        {
            if (marks[i]>=90)
            {
                grades[i]='A';
            }
            else if (marks[i]>=80 && marks[i]<=89)
            {
                grades[i]='B';
            }
            else if (marks[i]>=70 && marks[i]<=79)
            {
                grades[i]='C';
            }
            else if(marks[i]>=60 && marks[i]<=69)
            {
                grades[i]='D';
            }
            else if(marks[i]>=50 && marks[i]<=59)
            {
                grades[i]='E';
            }
            else
            {
                grades[i]='F';
            }
        }
        return grades;
        
    }
    void displayDetails()
    {
        System.out.print("Student : "+this.studentName);
        System.out.printf(", GPA : %.2f", this.calculateGPA(this.marks,this.studentName));
        System.out.println(", Grades : "+Arrays.toString(getGrades()));
    }

}
public class W3T4 
{
    public static void main(String[] args) 
    {
        //Scanner obj
        Scanner sc=new Scanner(System.in);
        //Array
        int no_of_students;

        //Input Loop
        System.out.println("How many Student's data would you like to store ?");
        no_of_students=sc.nextInt();
        //Array of Student objects
        Student[] students = new Student[no_of_students];

        for(int i=0;i<no_of_students;i++)
        {
            String studentName;
            int [] marks=new int [3];
            System.out.printf("Enter the name of the student %d : ",i+1);
            sc.nextLine(); //To clear the buffer issue and to resolve the skippping the input ignoring issue
            studentName=sc.nextLine();
            for (int j=0;j<3;j++)
            {
                System.out.printf("Enter the marks for subject # %d ",j+1);
                marks[j]=sc.nextInt();
            }
            //Dynamic Creation of the Objects of Student Clas ;)
            students[i]=new Student(studentName, marks);

        }

        //Displaying + Top Performer decision 
        String topPerformer=null;
        double topGPA=0;
        System.out.println("====Output====");
        for(Student individual : students)
        {
            individual.displayDetails();
            if (Student.calculateGPA(individual.marks,individual.studentName)>topGPA) 
            {
                topPerformer=individual.studentName;
            }
            
        }
        System.out.println("The Top Performer is : "+topPerformer);






        
    }
    
}
