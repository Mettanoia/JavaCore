package n1.ex3.application.domain.port.out;

import java.util.HashMap;

public interface CountriesReader {
    HashMap<String, String> getCountries();
}
