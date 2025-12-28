import java.util.ArrayList;

public class Test
{
    public static void main(String[] args) 
    {
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");

        ArrayList raw = list;
        raw.add(100);

        for (Object o : raw) {
            System.out.print("\n"+o + " ");
        }
    }
}
