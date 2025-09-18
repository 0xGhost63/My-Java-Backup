//DONE

class Order
{
    // Attributes

    int orderId;
    String productName;
    int quantity;
    double pricePerUnit;
    
    double off; 
    
   
    // Static Fields 

    public  static int   totalOrders=0;
    public static double totalRevenue;

    Order(int orderId,String productName,int quantity,double pricePerUnit)
    {
        //Attribute for calculating total price
        double TotalPrice;

        this.orderId=orderId;
        this.productName=productName;
        this.pricePerUnit=pricePerUnit;
        this.quantity=quantity;

        TotalPrice=pricePerUnit*quantity;

        if (quantity>50)
        {
            off=TotalPrice-(TotalPrice*0.1);
        }
        else
        {
            off=TotalPrice;
        }
        totalOrders++;
        totalRevenue+=off;
    }
    //double TotalPrice=pricePerUnit*quantity;
    public static void getTotalOrders()
    {
        System.out.println("Total Orders are : "+totalOrders);
    }

    void displayOrderDetails() 
    {


        System.out.print("Order Id : " + this.orderId);
        System.out.print(", Product : " + this.productName);
        System.out.print(", Quantity : " + this.quantity);
        System.out.printf("Total Price is %.2f PKR\n" ,this.off); //prints the final discounted price

        // System.out.print("Price per unit is : " + pricePerUnit);

    }

}
public class W3T5
{
    public static void main(String [] args)
    {
        //Creating Objects !

        Order first=new Order(111,"Coke",50,200);
        Order second=new Order(222,"Pepsi",64,100);
        Order third=new Order(333,"Sting",24,120);

        // Double percentage signs (%) are used to escape the format specifers error
        if (first.quantity  > 50.0){
            System.out.printf("Quantity is more than 50 on order id %d so 10%% discount applies\n",first.orderId);
        }
        if (second.quantity  > 50.0){
            System.out.printf("Quantity is more than 50 on order id %d so 10%% discount applies\n",second.orderId);
        }
        if (third.quantity  > 50.0){
            System.out.printf("Quantity is more than 50 on order id %d so 10%% discount applies\n",third.orderId);
        }
        System.out.printf("%45s","===OUTPUT====\n");
        first.displayOrderDetails();
        second.displayOrderDetails();
        third.displayOrderDetails();
        Order.getTotalOrders();
        System.out.println("Total Revenue : "+Order.totalRevenue);



    }
    }