class Student <T>
{
    T roll;

    Student (T roll)
    {
        this.roll=roll;
    }

}

public class Simple_Generic 
{
    public static void main(String[] args) 
    {
        Student<Integ> s1= new Student<>(1);

        Student <String> s2 = new Student<>("One");

        System.out.println(s1.roll);
        System.out.println(s2.roll);
    }    
}
