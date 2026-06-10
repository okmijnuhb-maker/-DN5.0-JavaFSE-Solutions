public class SingletonTest {
    public static void main(String[] args) {
        
        // Step 1: Get first instance
        Logger logger1 = Logger.getInstance();
        
        // Step 2: Get second instance
        Logger logger2 = Logger.getInstance();
        
        // Step 3: Use both to log messages
        logger1.log("First message");
        logger2.log("Second message");
        
        // Step 4: Verify both are same instance
        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both are same instance!");
        } else {
            System.out.println("FAILED: Different instances!");
        }
    }
}