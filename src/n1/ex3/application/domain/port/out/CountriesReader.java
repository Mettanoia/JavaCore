package n1.ex3.application.domain.port.out;

import java.util.Map;
import java.util.Optional;

public interface CountriesReader {
    Optional<Map<String, String>> getCountries();
}
