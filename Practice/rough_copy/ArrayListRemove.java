import java.util.ArrayList;
public class ArrayListRemove 
{
    public static void main(String[] args) 
    {
        ArrayList <String> list = new ArrayList<>();
        list.add("Keyboard");
        list.add("Mouse");
        list.remove(0);
        System.out.println(list.get(0));

    }
 
}
