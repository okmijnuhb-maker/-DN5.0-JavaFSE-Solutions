public class Product {
    
    int productId;
    String productName;
    String category;
    
    // Constructor
    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
    
    // Display product details
    public void display() {
        System.out.println("Product ID: " + productId + 
                           " | Name: " + productName + 
                           " | Category: " + category);
    }
}