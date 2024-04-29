package n1.ex3.adapter.out;

import n1.ex3.application.domain.port.out.CountriesReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CountriesRepository implements CountriesReader {

    @Override
    public Optional<Map<String, String>> getCountries() {

        Optional<Map<String, String>> result;
        Map<String, String> countryCapitalMap = new HashMap<>(); // Structure to return
        try {

            BufferedReader reader = new BufferedReader(new FileReader("countries.txt"));

            String nextLine = reader.readLine();
            while (nextLine != null && !nextLine.isBlank()){ // This doesn't take into account a possible blank string in the middle of the file. Only the last one

                String[] countryCapital = nextLine.split("\\s+");
                countryCapitalMap.put(countryCapital[0], countryCapital[1]);

                nextLine = reader.readLine();

            }

            result = Optional.of(countryCapitalMap);

        } catch (IOException e) {
            result = Optional.empty();
        }

        return result;

    }

}
