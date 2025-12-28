
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Lambda_Notation 
{
    public static void main(String[] args) 
    {
        //SORTING ON THE BASIS OF THE LENGTH OF THE STRINGS !
        ArrayList <String> listOfFruits = new ArrayList<>();
        listOfFruits.add("Apple");
        listOfFruits.add("Mango");
        listOfFruits.add("Banana");
        listOfFruits.add("Kiwi");
        listOfFruits.add("Orange");
        // System.out.println("Length of the Apple String is : "+listOfFruits.get(0).length());

        System.out.println("====Unsorted List of Fruits====");
        for (String fruit : listOfFruits)
        {
            System.out.println(fruit);
        }

        Comparator<String> fruitsComparator =(String f1,String f2)->
        {
            return f1.length()-f2.length();
        };

        Collections.sort(listOfFruits,fruitsComparator);

        System.out.println("====Sorted List of Fruits====");
        for (String fruit : listOfFruits)
        {
            System.out.println(fruit);
        }
    }    
}
