import java.util.ArrayList;
import java.util.Collections;

public class Sorting_ArrayList
{
    public  static void main (String [] args)
    {
        ArrayList <String> listOfStudents = new ArrayList <>(); 
        listOfStudents.add("Abdullah");
        listOfStudents.add("Hajra");
        listOfStudents.add("Abrish");
        listOfStudents.add("Nabiha");
        listOfStudents.add("Zoha");
        Collections.sort(listOfStudents);
        System.out.println(listOfStudents);
    }
}