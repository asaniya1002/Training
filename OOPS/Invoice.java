public class Invoice {
    private String partNum;
    private String partDescription;
    private int quantity;
    private double price;

    public Invoice(String partNum, String partDescription, int quantity, double price) {
        this.partNum = partNum;
        this.partDescription = partDescription;
        this.setQuantity(quantity);
        this.setPrice(price);
    }

    public String getPartNum() {
        return partNum;
    }

    public void setPartNum(String partNum) {
        this.partNum = partNum;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity < 0)
            this.quantity = 0;
        else
            this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0)
            this.price = 0;
        else
            this.price = quantity;
    }

    public double getInvoiceAmount()
    {
        return price * quantity;
    }
}

class InvoiceTest
{
    public static void main(String[] args)
    {
        Invoice myInvoice = new Invoice("277", "cable", 2, 30.0);
        System.out.println("myInvoice's invoice amount is: " + myInvoice.getInvoiceAmount());

        System.out.println("Setting Quantity to 5:");
        System.out.println("Setting Price to 15");

        System.out.println("Printing out Invoice Amount: " + myInvoice.getInvoiceAmount());
    }
}
