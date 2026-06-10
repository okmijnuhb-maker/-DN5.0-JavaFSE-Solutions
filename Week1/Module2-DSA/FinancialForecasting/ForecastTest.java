public class ForecastTest {
    public static void main(String[] args) {

        // Test values
        double presentValue = 1000.0;
        double growthRate = 0.05; // 5% growth rate
        int years = 5;

        // Calculate future value
        double futureValue = FinancialForecast.calculateFutureValue(
                             presentValue, growthRate, years);

        // Display results
        System.out.println("=== Financial Forecasting ===");
        System.out.println("Present Value  : $" + presentValue);
        System.out.println("Growth Rate    : " + (growthRate * 100) + "%");
        System.out.println("Years          : " + years);
        System.out.println("Future Value   : $" + String.format("%.2f", futureValue));

        // Test with different values
        System.out.println("\n=== Different Scenarios ===");
        System.out.println("$1000 for 3 years at 10% : $" + 
                           String.format("%.2f", 
                           FinancialForecast.calculateFutureValue(1000, 0.10, 3)));
        System.out.println("$5000 for 7 years at 8%  : $" + 
                           String.format("%.2f", 
                           FinancialForecast.calculateFutureValue(5000, 0.08, 7)));

        // Time Complexity Analysis
        System.out.println("\n=== Time Complexity Analysis ===");
        System.out.println("Time Complexity  : O(n) - n is number of years");
        System.out.println("Space Complexity : O(n) - recursive call stack");
        System.out.println("Optimization     : Can use loop instead of recursion");
    }
}