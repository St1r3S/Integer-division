package ua.foxminded.integerdivision;

public class EurasiaFormatterSupplier implements FormatterSupplier {
    @Override
    public String name() {
        return "Eurasia Formatter";
    }

    @Override
    public Formatter get() {
        return new EurasiaFormatter();
    }
}
