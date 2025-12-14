public class GenericExample
{
    public static <T> void swap(T[] array, int i, int j)
    {
        T temp = array[i];   
        array[i] =array[j];
        array[j]= temp;
    }

    public static void main(String[] args)
    {
        Integer[] nums ={1,2,3};
        String[] words = {"A","B","C"};

        swap(nums, 0, 2);
        swap(words, 0, 1);

        for (Integer n : nums)
        {
            System.out.print(n + " ");
        }

        System.out.println();
        for (String s : words)
        {
            System.out.print(s + " ");
        }
    }
}
