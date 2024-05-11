package n2;

import n2.dimain.entities.Restaurant;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Restaurant restaurant1 = new Restaurant("Higadillos brutales", 9.0);
        Restaurant restaurant2 = new Restaurant("Higadillos no tan buenos", 5.0);


        // El tipo referencial es el más genérico posible, en este casi Set.
        // La colección genérica está parametizada para evitar los Raw types, que existen por razones de
        // compatibilidad con código escrito antes de Java 5
        Set<Restaurant> restaurantSetRepeated = new HashSet<>(List.of(restaurant1, restaurant1));
        Set<Restaurant> restaurantSet = new HashSet<>(List.of(restaurant1, restaurant2));

        System.out.println("Repetidos:");
        System.out.println(restaurantSetRepeated);

        System.out.println();

        System.out.println("Sin repetir:");
        System.out.println(restaurantSet);


        List<Restaurant> restaurants = List.of(
                restaurant1,
                restaurant2,
                new Restaurant("A ver este adónde va", 8.4),
                new Restaurant("A ver este adónde va", 8.3),
                new Restaurant("A ver este adónde va", 8.2)
        );

        System.out.println();
        for (Restaurant r: restaurants)
            System.out.println(r);

    }
}
