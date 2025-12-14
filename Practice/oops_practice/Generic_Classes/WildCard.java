import  java.util.ArrayList;
import java.util.List;

class MyClass
{

    public static  void printArrayList(ArrayList<?> list)
    {       
        
        for(Object element : list)
        {
            System.out.print(element + " ");
        }

        System.out.print(System.lineSeparator());
    }
}

public class WildCard 
{
    public static void main(String[] args)
    {
        ArrayList <String> aircraftsList = new ArrayList<>(List.of("Jeff","Viper","Mirage","F-7 PG","T-37"));
        ArrayList<Integer> aircraftNumbers = new ArrayList<>(List.of(5, 7, 37, 39, 16));
 
        MyClass.printArrayList(aircraftsList);
        MyClass.printArrayList(aircraftNumbers);
        

    }    
}
