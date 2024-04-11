package n1.ex2.common;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Crea i emplena un List<Integer>.
 *
 * Crea un segon List<Integer> i insereix a la segona llista els elements de la primera en ordre invers.
 *
 * Empra els objectes ListIterator per a llegir els elements de la primera llista i inserir-los en la segona.
 *
 */

public class App {
    public static void run(){

        var ints = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
            add(8);
            add(9);
            add(10);
        }};

        var moreInts = new ArrayList<Integer>(){{
            add(11);
            add(12);
            add(13);
            add(14);
            add(15);
            add(16);
            add(17);
            add(18);
            add(19);
            add(20);
        }};

        for (var i = ints.reversed().iterator(); i.hasNext();){
            moreInts.add(i.next());
        }

        System.out.println(moreInts.toString());

    }
}
