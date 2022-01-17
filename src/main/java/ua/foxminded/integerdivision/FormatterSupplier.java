package ua.foxminded.integerdivision;

import java.util.function.Supplier;

public interface FormatterSupplier extends Supplier<Formatter> {
    String name();
}
