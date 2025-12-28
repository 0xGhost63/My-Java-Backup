import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public  class CollectionMethods
{
    public static void main(String[] args) 
    {
        System.out.println("Hello World !");    


        // ARRAYLIST

        List <Integer> list = new ArrayList<>(List.of(1,2,3,4,1,2,3,11,22,33));
        // List <Integer> secondaryList= new ArrayList<>(List.of(101,102,103,104,105));
        

        // System.out.println("List Before : "+list);

        // LIST METHODS HERE --->
        // list.remove(Integer.valueOf(33)); // Specific Value
        // list.remove(0);
        // list.add(1,63); // Adds 63 at index 1
        // list.add(50); // adds 50 at the end
        // list.addAll(secondaryList);
        // list.removeAll(List.of(101,102,103,104,105));
        // list.clear();



        // System.out.println("List After Sorting : "+list);
        // System.out.println("Found 3 at index : "+Collections.binarySearch(list,3));

        // Collections.fill(list,63);
        // System.out.println("List After: "+list);

        // System.out.println("List after fill   : "+list);
        // list.remove(Integer.valueOf(63));
        // System.out.println("List after Delete : "+list);

        // list.addAll(secondaryList);
        // Collections.reverse(list);
        // System.out.println("List after reverse : "+list);
        // Collections.shuffle(list);
        // System.out.println("List after shuffle : "+list);


        // List <Integer> thirdList = new ArrayList<>();
        // Collections.copy(list,thirdList);
        // System.out.println("Third list      : "+thirdList);

        // System.out.println("Secondary & Third Different ? "+ Collections.disjoint(secondaryList, thirdList));

        // System.out.printf("102 in List is %d time(s)\n",Collections.frequency(secondaryList,102));

        // //Stack

        Stack <String> stack = new Stack<>();

        // Stack METHODS --->

        // stack.push("Sannan");
        // stack.push("Ijlal");
        // stack.push("Ahmad");
        // stack.push("Junejo");

        // System.out.println("Stack : "+stack);

        // System.out.println("Peek : "+stack.peek());

        // System.out.println("Pop : "+stack.pop());

        // System.out.println("Stack : "+stack);


        
        // //Queue

        // Queue <String> queue = new Queue() {
            
        // }<>();

        // // Queue METHODS --->

        

    
    }
}