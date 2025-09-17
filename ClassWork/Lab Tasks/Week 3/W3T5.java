class Order{
    int orderId;
    String productName;
    float quantity;
    double off;
    float pricePerUnit;
    float TotalPrice;
    public  static int   totalOrders=0;
    public static double totalRevenue;
    Order(int orderId,String productName,float quantity,float pricePerUnit){
        this.orderId=orderId;
        this.productName=productName;
        this.pricePerUnit=pricePerUnit;
        this.quantity=quantity;
        TotalPrice=pricePerUnit*quantity;
        if (quantity>50){
            off=TotalPrice-(TotalPrice*0.1);
        }
        else{
            off=TotalPrice;
        }
        totalOrders++;
        totalRevenue+=off;
    }
    //double TotalPrice=pricePerUnit*quantity;
    public static void getTotalOrders(){
        System.out.println("Total Orders are "+totalOrders);
    }

    void displayOrderDetails() {
        System.out.print("Your Order Id is : " + orderId);
        System.out.print("......Your Product Name is: " + productName);
        System.out.print("......Price per unit is : " + pricePerUnit);
        System.out.print("......Total quantity is : " + quantity);
        //System.out.println("Total Price is " +TotalPrice);
    }

}
public class W3T5{
    public static void main(String [] args){
        Order first=new Order(111,"Coke",50,200);
        Order second=new Order(222,"Pepsi",64,100);
        Order third=new Order(333,"Sting",24,120);
        if (first.quantity  > 50.0){
            System.out.println("Quantity is more than 50 on order id 111 so 10% discount applies");
        }
        if (second.quantity  > 50.0){
            System.out.println("Quantity is more than 50 on order id 222 so 10% discount applies");
        }
        if (third.quantity  > 50.0){
            System.out.println("Quantity is more than 50 on order id 333 so 10% discount applies");
        }
        first.displayOrderDetails();
        System.out.println(".......Total Price of this order is : "+first.off);
        second.displayOrderDetails();
        System.out.println("......Total Price of this order is : "+second.off);
        third.displayOrderDetails();
        System.out.println(".......Total Price of this order is : "+third.off);
        Order.getTotalOrders();
        System.out.println(" Total Revenue is = "+Order.totalRevenue);



    }
    }