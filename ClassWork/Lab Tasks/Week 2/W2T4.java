class Marks 
{
    int subject_1;
    int subject_2;
    int subject_3;

    Marks(int subject_1,int subject_2)
    {
        this.subject_1=subject_1;
        this.subject_2=subject_2;
        this.subject_3=0;
    }
    Marks(int subject_1,int subject_2,int subject_3)
    {
        this.subject_1=subject_1;
        this.subject_2=subject_2;
        this.subject_3=subject_3;
    }
    void displaySum()
    {
        int sum;
        sum=this.subject_1+this.subject_2+this.subject_3;
        System.out.println("The detailed marks of the student are : ");
        System.out.println("Subject 1 : "+subject_1);
        System.out.println("Subject 2 : "+subject_2);
        if (subject_3==0)
        {
            System.out.println("Student failed the Subject 3 !");   
        }
        else
        {
            System.out.println("Subject 3 : "+subject_3);
        }
        System.out.printf("The grand sum is : %d/300\n",sum);
    }

    
}
public class W2T4 
{
    public static void main(String[] args) 
    {
        Marks student_1=new Marks(90,57);
        Marks student_2=new Marks(69, 64, 80);    
        System.out.printf("%40s","===OUTPUT===\n");
        student_1.displaySum();
        student_2.displaySum();
    }

    
}
