package n1.ex3.adapter.out;

import n1.ex3.application.domain.port.out.CountriesReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

public class CountriesRepository implements CountriesReader {

    @Override
    public Optional<HashMap<String, String>> getCountries() {

        Optional<HashMap<String, String>> result;
        var countryCapitalMap = new HashMap<String, String>(); // Structure to return
        try {

            var reader = new BufferedReader(new FileReader("/home/miguel/IdeaProjects/JavaCore/countries.txt"));

            var nextLine = reader.readLine();
            while (nextLine != null && !nextLine.isBlank()){ // This doesn't take into account a possible blank string in the middle of the file. Only the last one

                var countryCapital = nextLine.split("\\s+");
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
