import java.time.LocalDate;
// i don't think its necessary after *
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

abstract class Record implements Comparable<Record>
{
    private int numb;
    private String title;
    private String courseName;
    private LocalDate deadline;
    private Priority priority;
    private int totalMarks;


    Record(int numb,String title,String courseName,int totalMarks,LocalDate deadline,Priority priority)
    {
        setnumb(numb);
        setTitle(title);
        setCourseName(courseName);
        setTotalMarks(totalMarks);
        setDeadline(deadline);
        setPriority(priority);

    }
    //setters
    public void setnumb(int numb) {
        this.numb = numb;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;

    }

    //Getters
    public String getCourseName() {
        return courseName;
    }
    public LocalDate getDeadline() {
        return deadline;
    }
    public int getnumb() {
        return numb;
    }
    public Priority getPriority() {
        return priority;
    }
    public String getTitle() {
        return title;
    }
        public int getTotalMarks() {
        return totalMarks;
    }

    //Compare to

    @Override
    public int compareTo(Record that)
    {
        return this.getDeadline().compareTo(that.getDeadline());
    }

    //Abstract Methods !
    public abstract void display();
    public abstract String toFileString();


}


//Assignment Class
class Assignment extends Record
{
    private boolean isLab;

    // //EXTRA CONSTRUCTOR FOR NON-LAB QUIZ DEAL WITH IT LATER
    // Assignment(int numb,String title,String courseName,LocalDate deadline,Priority priority,int totalMarks)
    // {
    //     super(numb,title, courseName, deadline,priority);
    // }

    Assignment(int numb,String title,String courseName,int totalMarks,LocalDate deadline,Priority priority,boolean isLab)
    {
        super(numb, title, courseName, totalMarks, deadline, priority);
        setLab(isLab);
    }


    //Setter


    public void setLab(boolean isLab) {
        this.isLab = isLab;
    }

    //Getter


    public boolean getIsLab()
    {
        return isLab;
    }



    @Override
    public void display()
    {
        System.out.printf("%30s\n","===== Assignment Details =====");
        System.out.println("Number      : " + getnumb());
        System.out.println("Title       : " + getTitle());
        System.out.println("Course      : " + getCourseName());
        System.out.println("Deadline    : " + getDeadline());
        System.out.println("Priority    : " + getPriority());
        System.out.println("Total Marks : " + getTotalMarks());
        System.out.println("Is Lab      : " + (isLab ? "Yes" : "No"));
        System.out.println("==========================");
    }

    @Override
    public String toFileString()
    {
        String lab;
        lab=(isLab) ? "Lab" : "Theory" ;
        return String.join("|",
            "Assignment",
            String.valueOf(getnumb()),
            getTitle(),
            getCourseName(),
            getDeadline().toString(),
            String.valueOf(getTotalMarks()),
            String.valueOf(getIsLab()),
            getPriority().name()

        );
    }


}

class Quiz extends Assignment
{

    private boolean isViva;

    Quiz(int numb,String title,String courseName,int totalMarks,LocalDate deadline,Priority priority,boolean isLab)
    //,int totalMarks
    {
        super(numb, title, courseName,totalMarks,deadline, priority,isLab);
        setViva(isViva);

    }

    //Setter
    public void setViva(boolean isViva) {
        this.isViva = isViva;
    }

    //Getter
    public boolean getViva()
    {
        return isViva;
    }

    @Override
    public void display()
    {
        System.out.printf("%30s\n", "===== Quiz Details =====");
        System.out.println("Number      : " + getnumb());
        System.out.println("Title       : " + getTitle());
        System.out.println("Course      : " + getCourseName());
        System.out.println("Deadline    : " + getDeadline());
        System.out.println("Priority    : " + getPriority());
        System.out.println("Total Marks : " + getTotalMarks());
        System.out.println("Lab/Theory  : " + (getIsLab() ? "Lab" : "Theory"));
        System.out.println("Is Viva     : " + (isViva ? "Yes" : "No"));
        System.out.println("==========================");
    }

    @Override
    public String toFileString()
    {
        return String.join("|",
            "Quiz",
            String.valueOf(getnumb()),
            getTitle(),
            getCourseName(),
            getDeadline().toString(),
            getPriority().name(),
            String.valueOf(getTotalMarks()),
            String.valueOf(getIsLab()),
            String.valueOf(isViva)
        );
    }

    

}

class Exam extends Record
{
    private String examType;

    Exam(int numb,String title,String courseName,int totalMarks,LocalDate deadline,Priority priority,String examType)
    {
        super(numb, title, courseName, totalMarks, deadline, priority);
        setExamType(examType);

    }

    public void setExamType(String examType) {
        this.examType = examType;
    }
    public String getExamType() {
        return examType;
    }

    @Override
    public void display()
    {
        System.out.printf("%30s\n", "===== Exam Details =====");
        System.out.println("Number      : " + getnumb());
        System.out.println("Title       : " + getTitle());
        System.out.println("Course      : " + getCourseName());
        System.out.println("Deadline    : " + getDeadline());
        System.out.println("Priority    : " + getPriority());
        System.out.println("Total Marks : " + getTotalMarks());
        System.out.println("Exam Type   : " + (examType != null ? examType : "N/A"));
        System.out.println("==========================");
    }

    @Override
    public String toFileString()
    {
        return String.join("|",
            "Exam",
            String.valueOf(getnumb()),
            getTitle(),
            getCourseName(),
            getDeadline().toString(),
            getPriority().name(),
            String.valueOf(getTotalMarks()),
            (examType != null ? examType : "NOT-DEFINED")
        );
    }
}

class Reminder extends Record
{
    String [] note;

    Reminder(int numb,String title,String courseName,int totalMarks,LocalDate deadline,Priority priority,String [] note)
    {
        super(numb, title, courseName, totalMarks, deadline, priority);
        setNote(note);
    }

    //Getters & Setters

    public void setNote(String[] note) {
        this.note = note;
    }
    public String[] getNote() {
        return note;
    }

    @Override
    public void display()
    {
        System.out.printf("%30s\n", "===== Reminder Details =====");
        System.out.println("Number      : " + getnumb());
        System.out.println("Title       : " + getTitle());
        System.out.println("Course      : " + getCourseName());
        System.out.println("Deadline    : " + getDeadline());
        System.out.println("Priority    : " + getPriority());
        System.out.println("Notes       :");
        if (note != null && note.length > 0) {
            for (String n : note) {
                System.out.println("  - " + n);
            }
        } else {
            System.out.println("  (No notes)");
        }
        System.out.println("============================");
    }

    @Override
    public String toFileString()
    {
        // Join multiple note lines into one string separated by semicolon
        String notesStr = (note != null && note.length > 0) ? String.join(";", note) : "";

        return String.join("|",
            "Reminder",
            String.valueOf(getnumb()),
            getTitle(),
            getCourseName(),
            getDeadline().toString(),
            getPriority().name(),
            notesStr
        );
    }

    
}


//Comparators + Hashmaps !
class RecordUtil
{
        Comparator <Record> classComparator = new Comparator<Record>() 
        {
            @Override
            public int compare (Record a , Record b)
            {
                if(a instanceof Assignment && b instanceof Quiz)
                {
                    return 1;
                }
                else if(a instanceof Quiz && b instanceof Assignment)
                {
                    return -1;
                }
                else 
                {
                    return 0;
                }
            }
        };

        Comparator <Record> deadlineComparator = (Record a1,Record a2)
        -> a1.getDeadline().compareTo(a2.getDeadline());

        // HashMap

        public static final Map <String,Integer> coursePriority = new HashMap<>();
        static
            {
                coursePriority.put("OOP",1);
                coursePriority.put("DS",2);
                coursePriority.put("Expo",3);
                coursePriority.put("PP",4);
                coursePriority.put("CCE",5);
                coursePriority.put("ICP",6);
                coursePriority.put("Pre-Cal",7);

            }

}


//Enum
enum Priority 
{
    LOW,
    MEDIUM,
    HIGH,
    CRITICAL
}



public class Project 
{
    public static void showMenu()
    {
        System.out.println("\n====  Welcome :)  ====");
        System.out.println("Which option would you like to proceede with ?");
        System.out.println("1-Create a new Task");
        System.out.println("2-Add a new note");
        System.out.println("");
        System.out.println("0-EXIT");
    }

    public static void showProgress (String toPrint)
    {
        java.util.Date date= new Date();
        System.out.printf("[ %s ] ",date.toString());
        System.out.printf("%s ",toPrint);
        for (int i = 0; i < 3; i++)
        {
            System.out.print(".");
            try 
            {
                Thread.sleep(300);   
            } 
            catch (InterruptedException e) 
            {
                System.out.println("Sleep Error: " + e.getMessage());
            }
        }
        System.out.println();
   
    }

    public static ArrayList<String> loadData()
    {
        ArrayList <String> data = new ArrayList<>();
        boolean isFileFound=true;
        


        try 
        {
            showProgress("LOADING DATA");
            Scanner fileReader = (new Scanner(new File("SCNZ.txt")));   

            while (fileReader.hasNextLine())
            {
                String line;
                line=fileReader.nextLine();
                data.add(line);
                System.out.println();
            }
            fileReader.close();
        } 
        catch (IOException e) 
        {
            System.out.println("Unable to load data : "+e.getMessage());
            System.out.println("Creating new file !");
            isFileFound=false;
        }
        finally
        {
            if(!isFileFound)
            try 
            {
                File newFile = new File("SCNZ.txt");
                newFile.createNewFile();
            } 
            catch (IOException ex) 
            {
                System.out.println("Could not create new file either :P");
            }
           
        }

        return data;

    }

    public static void backUP(ArrayList<String> newData)
    {
        
        try 
        {
            FileWriter writer = new FileWriter("SCNZ.txt",true);
            showProgress("BACKING UP");

            for (String lines : newData)
            {
                writer.append(lines);
            }
            writer.close();
        }
        catch (IOException e) 
        {
            System.out.println("Unable to backup data error : "+e.getMessage());
        }
    }

    public static void createObject ()
    {
        int numb;
        String title;
        String courseName;
        int totalMarks;
        LocalDate deadline;
        Priority priority;

        // For all !
        
    }

    public static void main(String[] args) 
    {
        //ESSENTIALS !
        ArrayList <Record> objects = new ArrayList<>();
        ArrayList<String> loadedData = new ArrayList<>();
        ArrayList<String> toLoad = new ArrayList<>();
        loadedData=loadData();


        Scanner input = new Scanner(System.in);
        int choice=0;

        do
        {
            showMenu();    
            System.out.print("Enter the choice (0-10)\n> ");
            choice=input.nextInt();

            switch(choice)
            {
                case 1:
                    int taskType=0;
                    System.out.print("Which type of task would you like to create ?\n");
                    System.out.println("1-Assignment(Theory/Lab)");
                    System.out.println("2-Quiz");
                    System.out.println("3-Note/Reminder");
                    System.out.println("4-Exam");
                    System.out.print("> ");
                    taskType=input.nextInt();
                    if (taskType==1)
                    {
                        int numb;
                        String title;
                        String courseName;
                        int totalMarks;
                        LocalDate deadline;
                        Priority priority;
                        int pri;
                        boolean isLab;   

                        System.out.print("Enter the assignment title : ");
                        input.nextLine();
                        title=input.nextLine();
                        System.out.print("Enter the assignment number : ");
                        numb=input.nextInt();
                        input.nextLine();
                        System.out.println("Available Course are : ");

                        List<String> keys = new ArrayList<>(RecordUtil.coursePriority.keySet());

                        for (int i = 0; i < keys.size(); i++) 
                        {
                            String key = keys.get(i);
                            System.out.printf("%d-%s\n", (i + 1), key);             
                        }

                        System.out.print("\nEnter the Course name : ");
                        courseName=input.nextLine();
                        System.out.print("Enter total marks : ");
                        totalMarks=input.nextInt();
                        // System.out.println("Enter the deadline date : ");
                        // deadline=input.next();
                        // QUESTIONABLE
                        //FIXED :
                        System.out.print("Enter deadline (YYYY-MM-DD): ");
                        deadline = LocalDate.parse(input.next());

                        System.out.println("Set priority : ");
                        System.out.println("1-Low");
                        System.out.println("2-Medium");
                        System.out.println("3-High");
                        System.out.println("4-Critical");
                        System.out.print("> ");
                        pri=input.nextInt();
                        if (pri >= 1 && pri <= 4)
                        {
                            priority = Priority.values()[pri - 1];  
                        }
                        else 
                        {
                            System.out.println("Invalid choice, defaulting to LOW.");
                            priority = Priority.LOW;
                        }
                        
                        System.out.println("Select the nature of the Assignment : ");
                        System.out.println("1-Theory");
                        System.out.println("2-Lab");
                        int nature;
                        nature=input.nextInt();
                        input.nextLine();
                        if (nature==1)
                        {
                            isLab=false;    
                        }
                        else
                        {
                            isLab=true;
                        }

                        Assignment a = new Assignment(numb, title, courseName, totalMarks, deadline, priority, isLab);
                        objects.add(a);
                        toLoad.add(a.toFileString());
                        System.out.println("Successfully Created the Assignment Task !");

                        break;
   
                    }
                    
                    case 2:
                    {

                        

                        break;
                    }


            }
            


        }while(choice!=0);


        backUP(toLoad);
        showProgress("SIGNING OUT");



    }
    
}
 


// EDITING AVAILABILTY
// OVERALL BACKUP
// SORT BY CLASS
