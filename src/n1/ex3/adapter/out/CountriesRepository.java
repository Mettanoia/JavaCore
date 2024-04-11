package n1.ex3.adapter.out;

import n1.ex3.application.domain.port.out.CountriesReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CountriesRepository implements CountriesReader {

    @Override
    public HashMap<String, String> getCountries() {

        var countryCapitalMap = new HashMap<String, String>(); // Structure to return
        try {

            var reader = new BufferedReader(new FileReader("C:\\Users\\formacio\\Desktop\\Tasca-S5.01-Spring-boot-API-rest-Aplicaci-web-main\\JavaCore\\countries.txt"));

            var nextLine = reader.readLine();
            while (nextLine != null && !nextLine.isBlank()){ // This doesn't take into account a possible blank string in the middle of the file. Only the last one

                var countryCapital = nextLine.split("\\s+");
                countryCapitalMap.put(countryCapital[0], countryCapital[1]);

                nextLine = reader.readLine();

            }

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage()); // Impossible to recover from this error.
        }

        return countryCapitalMap;

    }

}
