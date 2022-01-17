package ua.foxminded.integerdivision;

public class NetherlandsFormatterSupplier implements FormatterSupplier {
    @Override
    public String name() {
        return "Netherlands Formatter";
    }

    @Override
    public Formatter get() {
        return new NetherlandsFormatter();
    }
}
