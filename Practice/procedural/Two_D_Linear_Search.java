import java.util.Scanner;
public class Two_D_Linear_Search 
{
    public static void main(String[] args) 
    {
        System.out.println("===Welcome===");
        //Scanner Obj Creation
        Scanner sc= new Scanner(System.in);

        // Variables Declaration
        int rows;
        int col;
        int toFind;
        //Special Case variables :
        boolean specialCase=false;
        int specialCol=0;
        int specialRow=0;
        String choice;


        //Array Creation
        System.out.print("Enter the number of the rows for your 2-D Array : ");
        rows=sc.nextInt();
        System.out.print("Enter the number of coloumns for your 2-D Array : ");
        col=sc.nextInt();
        System.out.print("Do you want to customize the number of coloumns in any row ? (Yes/No) : ");
        choice=sc.next();
        int [][] array;

        if (choice.equalsIgnoreCase("Yes")) 
        {
            specialCase=true;
            System.out.print("On which row ? : ");
            specialRow=sc.nextInt();
            specialRow-=1;
            System.out.print("How many numbers of coloumns required ? ");
            specialCol=sc.nextInt();
            if (specialCol==col)
            {
                System.out.printf("WARNING ! The special numbers of coloumns (%d) and normal (%d) coloumns number are same ! \n",specialCol,col);

            }


            // Special Case                
            array = new int[rows][];
            for (int i = 0;i<rows;i++)
            {
                
                if (i==specialRow )
                {
                    array[i]=new int[specialCol];
                }
                else
                {
                    array[i]=new int[col];
                }

            }

        }
        else
        {
                // Normal Case
                specialCol=col;
                specialRow=rows;
                array = new int[rows][col];

        }
        // Input Taking Part
        int counter = 1;

        for(int i = 0;i<rows;i++)
        {
            if (i==specialRow)
            {
                System.out.printf("Enter the %d elements of row %d : ",specialCol,(specialRow+1));
                for(int j =0 ; j<specialCol;j++)
                {
                    array[i][j]=sc.nextInt();
                }
                counter++;
                continue;

                
            }
            else
            {
                System.out.printf("Enter the %d elements of row %d : ",col,counter);
                counter++;

            }
            
            for(int j =0;j<col;j++)
            {
                array[i][j]=sc.nextInt();
            }

        }
        // Finding Logic !
        sc.nextLine();
        System.out.printf("Which number to find ? ");
        toFind=sc.nextInt();

        // Found array to store the index numbers of the found number
        
        int maxPossible=(rows*col)+specialCol; // Not used "long" here cuz its a long task and out of scope of my task...

        int [] foundArray=new int[maxPossible];
        int index=0;
        int finderCounter=0;

        for (int i =0;i<array.length;i++)
        {

            for(int j=0;j<array[i].length;j++)
            {
                
                if (array[i][j]==toFind)
                {
                    finderCounter++;
                    foundArray[index]=i;
                    index++;
                    foundArray[index]=j;
                    index++;
                }
            }
        }


        System.out.println("\n====OUTPUT===");
        if (finderCounter==0)
        {
            System.out.println("No finding number found with : "+toFind);
            
        }
        else
        {
            int appearnceCounter=1;
            System.out.printf("The number \"%d\" is found %d times on indices : \n",toFind,finderCounter);
            for(int i=0;i<index;i+=2)
            {
                System.out.printf("Appearance # %d  ",appearnceCounter);
                System.out.printf("At row : %d  ",(foundArray[i])+1);
                System.out.printf("and at coloumn : %d \n",(foundArray[i+1])+1);
                appearnceCounter++;
            }
        
        }

        // Displaying the output

        System.out.println("\n===OVERALL ARRAY===");
        for(int[] row : array)
        {
            for(int value : row)
            {
                System.out.print(value+" ");
            }
            System.out.println("");
        }

        sc.close();
    }

}
