package n1.ex1.common;

import application.domain.model.Month;

import java.util.*;

/**
 *
 * Crea una classe anomenada Month amb un atribut "name" (que emmagatzemarà el nom del mes de l'any).
 * Afegeix 11 objectes Month (cadascun amb el seu atribut diferent) en un ArrayList, a excepció de l'objecte amb atribut "Agost".
 * Després, efectua la inserció en el lloc que correspon a aquest mes i demostra que l’ArrayList manté l'ordre correcte.
 *
 * Converteix l’ArrayList de l’exercici anterior en un HashSet i assegura’t que no permet duplicats.
 *
 * Recorre la llista amb un for i amb un iterador.
 *
 */

class App{
    public static void run(){

        var monthsArrayList = new ArrayList<Month>(){{

            add(new Month(Month.MonthName.JANUARY));
            add(new Month(Month.MonthName.FEBRUARY));
            add(new Month(Month.MonthName.MARCH));
            add(new Month(Month.MonthName.APRIL));
            add(new Month(Month.MonthName.MAY));
            add(new Month(Month.MonthName.JUNE));
            add(new Month(Month.MonthName.JULY));
            add(new Month(Month.MonthName.SEPTEMBER));
            add(new Month(Month.MonthName.OCTOBER));
            add(new Month(Month.MonthName.NOVEMBER));
            add(new Month(Month.MonthName.DECEMBER));

        }};

        // Insert August at position 7

        monthsArrayList.add(7, new Month(Month.MonthName.AUGUST));
        System.out.println(monthsArrayList.toString());

        // Check that HashSet doesn't allow duplicates

        var monthsArrayListWithDuplicates = (ArrayList<Month>) monthsArrayList.clone(); // Copy the original ArrayList

        monthsArrayListWithDuplicates.add(new Month(Month.MonthName.AUGUST));
        monthsArrayListWithDuplicates.add(new Month(Month.MonthName.JULY));
        monthsArrayListWithDuplicates.add(new Month(Month.MonthName.SEPTEMBER));

        var monthsHashSet = new HashSet<Month>(monthsArrayListWithDuplicates);

        System.out.println(monthsHashSet.size() != monthsArrayListWithDuplicates.size()); // It should be true

        // Iterate over the array list using a for loop

        for (Month e: monthsArrayList){
            System.out.println(e.toString());
        }

        System.out.println(""); // Adding some space to the shell's output to format

        // Iterate over the array list using its iterator and the common idiom

        for (var i = monthsArrayList.iterator(); i.hasNext();){
            System.out.println(i.next().toString());
        }

    }

}
