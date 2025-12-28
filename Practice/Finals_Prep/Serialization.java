import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class InactiveUserException extends Exception
{

    public InactiveUserException(String msg) 
    {
        super(msg);
    }
    
}
class UserSession implements Serializable
{
    int userId;
    String username;
    boolean isActive;
    int loginCount;

    UserSession(int userId, String username, boolean isActive, int loginCount)
    {
        this.userId = userId;
        this.username = username;
        this.isActive = isActive;
        this.loginCount = loginCount;
    }
    @Override
    public String toString() 
    {
        return String.format("UserId=%-2d, username=%-10s, isActive=%-5b, loginCount=%-2d",userId, username, isActive, loginCount);
    }


}

public class Serialization 
{
    public static void main(String[] args) throws IOException,InactiveUserException,ClassNotFoundException
    {
        ArrayList<UserSession> usersList = new ArrayList<>();
        usersList.add(new UserSession(12,"0xGhost", true, 3));
        usersList.add(new UserSession(1, "0xAlpha", true, 5));
        usersList.add(new UserSession(2, "0xBeta", false, 2));
        usersList.add(new UserSession(3, "0xGamma", true, 7));
        usersList.add(new UserSession(4, "0xDelta", false, 1));
        usersList.add(new UserSession(5, "0xEpsilon", true, 3));
        usersList.add(new UserSession(6, "0xZeta", true, 4));
        usersList.add(new UserSession(7, "0xEta", false, 6));
        usersList.add(new UserSession(8, "0xTheta", true, 2));
        usersList.add(new UserSession(9, "0xIota", false, 5));
        usersList.add(new UserSession(10, "0xKappa", true, 3));


        File myfile = new File("User_Sessions.ser");
        myfile.createNewFile();

        ObjectOutputStream writer = new ObjectOutputStream (new FileOutputStream(myfile));
        for(UserSession user : usersList)
        {
            try 
            {
                if (!user.isActive)
                {
                    throw new InactiveUserException("User : "+user.username +" is INACTIVE !");
                }    
            } 
            catch (InactiveUserException e) 
            {
                System.out.println(e.getMessage());
            }
            
            if(user.isActive)
            writer.writeObject(user);
            
        }
        System.out.println("Successfully Writtent to the file !");


        //Reading from the File !

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(myfile));
        ArrayList<UserSession> retrieved = new ArrayList<>();

        
        while(true)
        {
            try
            {
                UserSession user = (UserSession) input.readObject();
                retrieved.add(user);
            }
            catch (EOFException e)
            {
                break; 
            }
        }

        for(UserSession user : retrieved)
        {
            System.out.println(user.toString());
        }
        
        
        
        
        

    }    
}
