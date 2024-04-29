package n1.ex3.application.domain.port.out;

import java.util.HashMap;
import java.util.Optional;

public interface CountriesReader {
    Optional<HashMap<String, String>> getCountries();
}
