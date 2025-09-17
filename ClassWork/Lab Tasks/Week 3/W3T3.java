class Product
{
    //Attributes

    String productName;
    double price;
    static double discount;

    //Constructor
    Product(String productName,double price)
    {
        this.productName=productName;
        this.price=price;
    }
    //Discount setter

    static double setDiscount(double dis) 
    {
        discount=dis; //Sets the discount
        return discount;
    }
    //returns the discounted price of a product
    double calculateDiscountedPrice()
    {
        double discountedPrice;
        discountedPrice =this.price-(this.price * discount);
        return discountedPrice;
    }
    //Taking two products as an argument instead of only the one 
    static void compareDiscounts(Product other,Product secondProduct)
    {
        if (other.calculateDiscountedPrice()>secondProduct.calculateDiscountedPrice()) 
        {
            System.out.printf("Product \"%s\" has a higher discounted price !",other.productName);
        }
        else
        {
            System.out.printf("Product \"%s\" has a higher discounted price !",secondProduct.productName);
        }

        System.out.println("");
    }
    //fun for the output 
    void showOutput()
    {
        System.out.print("Product : "+this.productName);
        System.out.printf(", Original Price: %.2f PKR",this.price);
        System.out.printf(", Discounted Price: %.2f PKR\n",calculateDiscountedPrice());
    }
}
public class W3T3 
{
    public static void main(String[] args) 
    {
        //setting the discount 
        Product.setDiscount(0.2); // == Product.discount=0.2; (Since both(attribute & method) are static )

        //Creation of Objects :

        Product productOne=new Product("Aerial", 1200);
        Product productTwo=new Product("Surf Excel", 600);

        //Showing output
        productOne.showOutput();
        productTwo.showOutput();
        
        //Price Comparison
        Product.compareDiscounts(productOne, productTwo);

    }
    
}
