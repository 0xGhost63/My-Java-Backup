import java.util.Scanner;
import java.util.Arrays;
import java.IllegalArgumentException;
class Player_1
{
    String name;
    Player_1(String name)
    {
        this.name=name;
    }
    void win ()
    {
        System.out.printf("%s wins the game !",this.name);
    }
}
class Player_2 extends Player_1
{
    Player_2(String name)
    {
        super(name);
    }
}
enum Translate
{
    //Uses lower-case letters for better input handling !
    One(0,0),
    Two(0,1),
    Three(0,2),
    Four(1,0),
    Five(1,1),
    Six(1,2),
    Seven(2,0),
    Eight(2,1),
    Nine(2,2);

    private final int row;
    private final int coloumn;

    Translate(int row,int coloumn)
    {
        this.row=row;
        this.coloumn=coloumn;
    }
     
    public int getRow()
    {
        return this.row;
    }
    public int getColoumn ()
    {
        return this.coloumn;
    }


}
public class TicTacToe 
{
    //Static Attribute
    public static int turns;

    static void showBoard()
    {
        System.out.print("");
    }
    static void showArray(int [][] array,char symbol,int row,int coloumn)
    {

    }
    public static void main(String[] args) 
    {
        //Scanner object creation
        Scanner sc = new Scanner(System.in);
        //Variables
        String name_1=null,name_2=null;
        //Names Input
        System.out.print("Enter player 1's name : ");
        name_1=sc.nextLine();
        System.out.print("Enter player 2's name : ");
        name_2=sc.nextLine();
        //2 Objects Creations
        Player_1 p1=new Player_1(name_1);
        Player_2 p2 = new Player_2(name_2);
        //Arrays creation
        int [][] board = new int[3][3];
        int [] check =  new int [9];
        //Game Start
        System.out.printf("%50s\n","====  TIC TAC TOE  ====");
        showBoard();
        System.out.println("Enter a corresponding number(in alphabets like One,Two...) of the box to make a turn !");
        while (TicTacToe.turns<9)
        {
            String Player_one=null;
            String Player_two=null;
            int index=0;
            Arrays.sort(check);
            boolean isLegit;

            System.out.print("Player 1 turn : ");
            Player_one=sc.next();
            Player_one= Player_one.substring(0,1).toUpperCase() + Player_one.substring(1).toLowerCase();
            System.out.println(Translate.valueOf(Player_one));//Print the Enum 
            
            while(!(Translate.valueOf(Player_one)))
            {
                System.out.println("Invalid Entry !");
                System.out.print("Player 1 turn : ");
                Player_one=sc.next();
            }

            // CHANGES REQUIRED :-

            //---> MOVE THE TURN FUNCTION TO THE ACTUAL CLASS AND THEN OVERRIDE WHERE IT IS NEEDED !
            // INSTEAD OF REDUNDANCY IN THE MAIN CLASS
            // STORE THE valueOF IN A VARIABLE AND THEN USE THE GETTERS TO GET ROWS AND COLOUMNS
            //  USE EXCEPTION HANDLING FOR A GRACEFUL INVALID USER INPUT HANDLING
        




            // Arrays.binarySearch(check,Player_one);
            // if(index<0)
            // isLegit=false;
            // else
            // isLegit=true;

            
            System.out.print("Player 2 turn : ");
            Player_two=sc.next();
        }




        sc.close();

    }    
}
