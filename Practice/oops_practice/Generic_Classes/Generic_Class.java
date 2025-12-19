import java.util.ArrayList;
import java.util.Collections;

class Employee <T,U>
{
    U ID;
    T age;

    public Employee(U ID,T age) 
    {
        this.ID=ID;
        this.age=age;
    }

    public void showData()
    {
        System.out.println(this.toString() +" ID  : "+this.ID);
        System.out.println(this.toString() +" Age : "+this.age);

    }

    public static <Z extends Number> void printNumber (Z numb)
    {
        System.out.println(numb);
    }


}
public class Generic_Class 
{
    public static void main(String[] args) 
    {
        Employee <String,String> e1 = new Employee <>("Eight","Sixty-Three");
        Employee <Integer,Integer> e2 = new Employee <>(8,63);

        e1.showData();
        e2.showData();
        Employee.printNumber(5000);
        ArrayList <String> list = new ArrayList<>();
        list.add("Car");
        list.add("Bilal");
        list.add("Ali");
    
     
        Collections.sort(list);
        System.out.println("List after sorting : "+list);





    }    
}
