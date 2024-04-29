package n1.ex3.common;

import application.adapter.out.ResultsRepository;
import n1.ex3.adapter.out.CountriesRepository;
import n1.ex3.application.domain.port.out.CountriesReader;

import java.util.*;

/**
 * Donat el fitxer countrties.txt (revisa l'apartat recursos) que conté països i capitals.
 * El programa ha de llegir el fitxer i guardar les dades en un HashMap<String, String>.
 * El programa demana el nom de l’usuari/ària, i després ha de mostrar un país de forma aleatòria, guardat en el HashMap.
 * Es tracta de què l’usuari/ària ha d’escriure el nom de la capital del país en qüestió. Si l’encerta se li suma un punt.
 * Aquesta acció es repeteix 10 vegades.
 * Un cop demanades les capitals de 10 països de forma aleatòria, llavors s’ha de guardar en un fitxer anomenat classificacio.txt, el nom de l’usuari/ària i la seva puntuació.
 */

public class App {

    static private final CountriesReader reader;

    static {
        reader = new CountriesRepository(); // Poor imitation of dependency injection
    }

    public static void run() {

        Optional<HashMap<String, String>> countriesToCapitals = reader.getCountries();

        if (countriesToCapitals.isEmpty())
            throw new RuntimeException("Couldn't load the file. Fail fast."); // I know this can be done better specially exploiting the Optional functional pattern but I don't think it worths it here

        List<String> keys = new ArrayList<>(countriesToCapitals.get().keySet());

        var randomKeys = new HashSet<String>();

        while (randomKeys.size() < 10) {
            var randomIndex = new java.util.Random().nextInt(keys.size());
            randomKeys.add(keys.get(randomIndex));
        }

        List<Boolean> results = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (var country : randomKeys) {

            System.out.println(country);
            results.add(scanner.nextLine().equalsIgnoreCase(countriesToCapitals.get().get(country)));

        }

        System.out.println("We finished! Please introduce your name to write your results:");
        var name = scanner.nextLine();
        var total = results.stream().mapToInt(x -> x ? 1 : 0).sum();

        new ResultsRepository().writeResults(name, total);

    }

}
