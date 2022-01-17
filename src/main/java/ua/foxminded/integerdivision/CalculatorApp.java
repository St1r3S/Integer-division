package ua.foxminded.integerdivision;

public class CalculatorApp {
    public static void main(String[] args) {

        final String EURASIA_FORMATTER = "Eurasia Formatter";
        final String NETHERLANDS_FORMATTER = "Netherlands Formatter";


        Calculator calculator = new Calculator();  // main computing class
        Result result = calculator.divide(51654123, 6514);
        Formatter formatter = FormatterFactory.getInstance().get(EURASIA_FORMATTER); // Formatter is an interface // or use Netherlands Formatter
        String output = formatter.format(result); // formatted result
        
    }
}
