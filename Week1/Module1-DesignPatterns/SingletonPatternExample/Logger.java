public class Logger {
    
    // Step 1: Private static instance of itself
    private static Logger instance;
    
    // Step 2: Private constructor so nobody can do "new Logger()"
    private Logger() {
        System.out.println("Logger instance created!");
    }
    
    // Step 3: Public static method to get the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    // Step 4: Log method to print messages
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}