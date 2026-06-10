public class FinancialForecast {

    // Recursive method to calculate future value
    public static double calculateFutureValue(
                         double presentValue, 
                         double growthRate, 
                         int years) {

        // Base case: no more years left
        if (years == 0) {
            return presentValue;
        }

        // Recursive case: calculate next year value
        return calculateFutureValue(
               presentValue * (1 + growthRate), 
               growthRate, 
               years - 1);
    }
}