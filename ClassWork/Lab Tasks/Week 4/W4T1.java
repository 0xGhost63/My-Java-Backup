import java.util.Scanner;

public class W4T1
{
        public static void reverseArray(int[] arr)
    {
        int left = 0, right = arr.length - 1;
        while(left < right)
        {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void reverseOddIndices(int[] arr)
    {
        int left = 1, right = (arr.length % 2 == 0) ? arr.length - 1 : arr.length - 2;

        while(left < right)
        {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left += 2;
            right -= 2;
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        boolean isOdd=false;

        System.out.print("Enter the number of chapters : ");
        int number_of_chapters = sc.nextInt();

        int[] chapters = new int[number_of_chapters];
        System.out.print("Enter chapter numbers: ");
        for(int i = 0; i < chapters.length; i++)
        {
            chapters[i] = sc.nextInt();
        }

        System.out.print("Original Array : ");
        System.out.print("[");
        for(int i =0; i<chapters.length;i++)
        {
            if(i==(chapters.length-1))
            {
                System.out.printf("%d",chapters[i]);
            }
            else
            {
                System.out.printf("%d ,",chapters[i]);

            }
            
        }
        System.out.print("]\n");
        

        if(number_of_chapters % 2 == 0)
        {
            reverseArray(chapters);
        }
        else
        {
            reverseOddIndices(chapters);
            isOdd=true;
        }

        if (isOdd)
        {
            System.out.print("Reversed Array (odd indices) : ");
        }        
        else
        {
            System.out.print("Reversed Array: ");
        }

        System.out.print("[ ");
        for(int i =0; i<chapters.length;i++)
        {
        
            if(i==(chapters.length-1))
            {
                System.out.printf("%d",chapters[i]);
            }
            else
            {
                System.out.printf("%d ,",chapters[i]);

            }
            
        }
        System.out.print("]\n");
    }



}
