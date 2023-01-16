package sample;
import java.util.function.Supplier;

public interface StatSupplier extends Supplier<Profile> {
    Profile get(String company);
}
