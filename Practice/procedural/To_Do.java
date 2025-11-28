import java.util.Scanner;

public class To_Do
{
    //Array
    String [] tasks = new String[100]; // FIXED: initialized array, otherwise NullPointerException
    int taskCount = 0; // FIXED: added a counter instead of resetting i=0 in add_task

    //Scanner
    Scanner sc=new Scanner (System.in);

    //Modules for the tasks
    public static void show_tasks()
    {
        System.out.println("1-Add Task");
        System.out.println("2-View Tasks");
        System.out.println("3-Mark Task as Done");
        System.out.println("4-Delete Task");
        System.out.println("5-Exit");
    }

    public void add_task()
    {
        System.out.println("Enter the task !");
        sc.nextLine(); // FIXED: consume newline left by nextInt()
        tasks[taskCount]=sc.nextLine(); // FIXED: use taskCount, not i=0 always
        taskCount++;
        System.out.println("Task Saved successfully !");
    }

    public void view_tasks()
    {
        if (taskCount == 0) { // FIXED: prevent printing null when list is empty
            System.out.println("No tasks yet !");
            return;
        }
        System.out.println("Your all To-Do tasks are : ");
        for(int i=0;i<taskCount;i++) // FIXED: loop only till taskCount, not full array length
        {
            System.out.print((i+1) + " - ");
            System.out.println(tasks[i]);
        }
    }

    public void task_done()
    {
        view_tasks();
        if (taskCount == 0) return; // FIXED: if no tasks, return safely
        System.out.println("Which task would you like to mark as done");
        int task_numb=sc.nextInt();
        while(task_numb<1 || task_numb>taskCount) // FIXED: use taskCount, not full array length
        {
            System.out.println("Invalid task number...Plz try again !");
            task_numb=sc.nextInt();
        }
        task_numb-=1;
        String old=tasks[task_numb];
        String new_task=old + " " + "(DONE)";
        tasks[task_numb]=new_task;
        System.out.println("Task Marked as Done !");
    }

    public void delete_task()
    {
        view_tasks();
        if (taskCount == 0) return; // FIXED: prevent deleting when list is empty
        System.out.println("Which task would you like to Delete ? ");
        int choice=sc.nextInt();
        while(choice<1 || choice>taskCount) // FIXED: validate with taskCount
        {
            System.out.println("Invalid task number...Plz try again !");
            choice=sc.nextInt();
        }
        choice-=1;

        // FIXED: shift tasks to remove the selected one instead of marking as DELETED
        for (int i = choice; i < taskCount - 1; i++) {
            tasks[i] = tasks[i + 1];
        }
        taskCount--;

        System.out.println("Task Deleted !");
    }

    public static void main(String args [])
    {
        To_Do app = new To_Do(); // FIXED: create object to access non-static methods

        //While True Loop
        while (true) 
        {
            System.out.println("==== TO-DO LIST ====\n");
            System.out.println("Select an operation\n");
            show_tasks();
            int choice=app.sc.nextInt(); // FIXED: use app.sc because sc is non-static
            while (choice>5 || choice<1)
            {
                System.out.println("Invalid operation number entered...Plz try again !");
                choice=app.sc.nextInt();
            }
            if (choice==5)
            {
                System.out.println("Signing out...");
                System.out.println("Ciao !");
                break; // FIXED: added break to exit loop
            }
            switch (choice) {
                case 1:
                app.add_task();
                break;
                case 2:
                app.view_tasks();
                break;
                case 3:
                app.task_done();
                break;
                case 4:
                app.delete_task();
                break;
                case 5:
                break;
                default:
                System.out.println("Fazool case");
            }
        }
    }
}

// import java.util.Scanner;
// public class To_Do
// {
//     //Array
//     String [] tasks;
//     //Scanner
//     Scanner sc=new Scanner (System.in);

//     //Modules for the tasks
//     public static void show_tasks()
//     {
//         System.out.println("1-Add Task");
//         System.out.println("2-View Tasks");
//         System.out.println("3-Mark Task as Done");
//         System.out.println("4-Delete Task");
//         System.out.println("5-Exit");
//     }
//     public  void add_task()
//     {
//         int i=0;
//         System.out.println("Enter the task !");
//         tasks[i]=sc.nextLine();
//         i++;
//         System.out.println("Task Saved successfully !");
//     }
//     public void view_tasks()
//     {
//         System.out.println("Your all To-Do tasks are : ");
//         for(int i=0;i<tasks.length;i++)
//         {
//             System.out.print(i+1);
//             System.out.println(" -");
//             System.out.println(tasks[i]);
//         }
//     }
//     public void task_done()
//     {
//         view_tasks();
//         System.out.println("Which task would you like to mark as done");
//         int task_numb=sc.nextInt();
//         while(task_numb<1 || task_numb>tasks.length)
//         {
//             System.out.println("Invalid task number...Plz try again !");
//             task_numb=sc.nextInt();
//         }
//         task_numb-=1;
//         String old=tasks[task_numb];
//         String new_task=old + " " + "✅";
//         tasks[task_numb]=new_task;
//         System.out.println("Task Marked as Done !");
//     }
//     public void delete_task()
//     {
//         System.out.println("Which task would you like to Delete ? ");
//         int choice=sc.nextInt();
//         while(choice<1 || choice>tasks.length)
//         {
//             System.out.println("Invalid task number...Plz try again !");
//             choice=sc.nextInt();
//         }
//         choice-=1;
//         String new_task="DELETED TASK";
//         tasks[choice]=new_task;
//         System.out.println("Task Deleted !");

//     }
//     public  static void main(String args [])
//     {

//         //While True Loop
//         while (true) 
//         {
//             System.out.println("==== TO-DO LIST ====\n");
//             System.out.println("Select an operation\n");
//             show_tasks();
//             int choice=sc.nextInt();
//             while (choice>5 || choice<1)
//             {
//                 System.out.println("Invalid operation number entered...Plz try again !");
//                 choice=sc.nextInt();
//             }
//             if (choice==5)
//             {
//                 System.out.println("Signing out...");
//                 System.out.println("Ciao !");
//             }
//             switch (choice) {
//                 case 1:
//                 add_task();
//                 break;
//                 case 2:
//                 view_tasks();
//                 break;
//                 case 3:
//                 task_done();
//                 break;
//                 case 4:
//                 delete_task();
//                 break;
//                 case 5:
//                 break;
//                 default:
//                 System.out.println("Fazool case");
//             }


            
//         }
        
//     }
// }
