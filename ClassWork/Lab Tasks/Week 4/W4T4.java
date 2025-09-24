import java.util.Scanner;

public class W4T4
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Input first array
        System.out.print("Enter size of first array: ");
        int n1 = sc.nextInt();
        int[] a = new int[n1];
        System.out.print("Enter elements of first array:");
        for(int i = 0; i < n1; i++)
        {
            a[i] = sc.nextInt();
        }

        // Input second array
        System.out.print("Enter size of second array: ");
        int n2 = sc.nextInt();
        int[] b = new int[n2];
        System.out.print("Enter elements of second array:");
        for(int i = 0; i < n2; i++)
        {
            b[i] = sc.nextInt();
        }

        // Find values that appear in BOTH arrays and mark them
        boolean[] removeA = new boolean[n1];
        boolean[] removeB = new boolean[n2];
        for(int i = 0; i < n1; i++)
        {
            for(int j = 0; j < n2; j++)
            {
                if(a[i] == b[j])
                {
                    removeA[i] = true;
                    removeB[j] = true;
                }
            }
        }

        // Collect remaining values into a single list
        int[] temp = new int[n1 + n2];
        int k = 0;
        for(int i = 0; i < n1; i++)
        {
            if(!removeA[i]) temp[k++] = a[i];
        }
        for(int j = 0; j < n2; j++)
        {
            if(!removeB[j]) temp[k++] = b[j];
        }

        // Sort the collected values
        for(int i = 0; i < k - 1; i++)
        {
            for(int j = 0; j < k - i - 1; j++)
            {
                if(temp[j] > temp[j + 1])
                {
                    int swap = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = swap;
                }
            }
        }

        // Print the result
        System.out.print("Merged and Sorted Array (with duplicates removed): [");
        for(int i = 0; i < k; i++)
        {
            System.out.print(temp[i]);
            if(i < k - 1) System.out.print(", ");
        }
        System.out.println("]");

        sc.close();
    }
}
