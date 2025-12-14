import java.util.ArrayList;
import java.util.List;

class FleetAnalyzer
{
    //Task 1 — Generic Method (<T>)
    public <T> void showSingleData(T data)
    {
        System.out.println(data);
    }

    //Task 2 — Unbounded Wildcard (?)
    public void printList (ArrayList<?> list)
    {
        for (Object element : list)
        {
            System.out.print(element+" ");
        }
        System.out.print(System.lineSeparator());
    }

    //Task 3 — Upper Bounded Wildcard 
    public  double  calculateValue(ArrayList<? extends Number> list)
    {
        double sum=0.0;
        int counter=0;

        for(int i =0 ; i<list.size();i++)
        {
            sum+=list.get(i).doubleValue();
            counter++;
        }

        sum=sum/counter;
        return sum; 
    }
}
public class Generic 
{
    public static void main(String[] args) 
    {
        ArrayList<String> aircraftNames = new ArrayList<>(List.of("JF-17","Mirage","F-7PG","T-37 Tweet"));
        ArrayList<Double> aircraftMaxSpeed = new ArrayList<>(List.of(1960.7,2350.5,2170.3,685.3));
        ArrayList<Integer> aircraftEntryYear = new ArrayList<>(List.of(2007,1967,2002,1954));

        FleetAnalyzer analyzeFleet = new FleetAnalyzer();

        System.out.print("Single Value : ");
        analyzeFleet.showSingleData(aircraftNames.get(3));
        double averageSpeed = analyzeFleet.calculateValue(aircraftMaxSpeed);
        System.out.println("Average speed : "+ averageSpeed);
        System.out.print("List : ");
        analyzeFleet.printList(aircraftEntryYear);



    }      
}
