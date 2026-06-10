public class SearchTest {

    // Linear Search - searches unsorted array
    public static int linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productId == targetId) {
                return i; // found at index i
            }
        }
        return -1; // not found
    }

    // Binary Search - searches sorted array
    public static int binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (products[mid].productId == targetId) {
                return mid; // found at index mid
            } else if (products[mid].productId < targetId) {
                left = mid + 1; // search right half
            } else {
                right = mid - 1; // search left half
            }
        }
        return -1; // not found
    }

    public static void main(String[] args) {

        // Products for linear search (unsorted)
        Product[] unsortedProducts = {
            new Product(103, "Laptop", "Electronics"),
            new Product(101, "Phone", "Electronics"),
            new Product(105, "Tablet", "Electronics"),
            new Product(102, "Headphones", "Accessories"),
            new Product(104, "Charger", "Accessories")
        };

        // Products for binary search (sorted by productId)
        Product[] sortedProducts = {
            new Product(101, "Phone", "Electronics"),
            new Product(102, "Headphones", "Accessories"),
            new Product(103, "Laptop", "Electronics"),
            new Product(104, "Charger", "Accessories"),
            new Product(105, "Tablet", "Electronics")
        };

        // Test Linear Search
        System.out.println("=== Linear Search ===");
        int linearResult = linearSearch(unsortedProducts, 104);
        if (linearResult != -1) {
            System.out.print("Product found at index " + linearResult + ": ");
            unsortedProducts[linearResult].display();
        } else {
            System.out.println("Product not found!");
        }

        // Test Binary Search
        System.out.println("=== Binary Search ===");
        int binaryResult = binarySearch(sortedProducts, 104);
        if (binaryResult != -1) {
            System.out.print("Product found at index " + binaryResult + ": ");
            sortedProducts[binaryResult].display();
        } else {
            System.out.println("Product not found!");
        }

        // Time Complexity Analysis
        System.out.println("\n=== Time Complexity Analysis ===");
        System.out.println("Linear Search: O(n) - checks every element");
        System.out.println("Binary Search: O(log n) - divides array in half");
        System.out.println("Binary Search is faster for large datasets!");
    }
}