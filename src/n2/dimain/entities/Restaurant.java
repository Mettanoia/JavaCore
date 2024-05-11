package n2.dimain.entities;

import java.util.Objects;

// Se declara final porque de esta manera no se puede romper la encapsulación por medio de una herencia
// no controlada. Es recomendable solo permitir crear subtipos de clases explícitamente diseñadas para ello.
public final class Restaurant implements Comparable<Restaurant> {

    // Para fomentar la inmutabilidad declaramos todas las propiedades como final. Así evitamos que mute el
    // estado de las instancias de manera incontrolada y sea más fácil razonar sobre su estado.
    private final String nom;
    private final double score;

    public Restaurant(String nom, double score) {
        this.nom = nom;
        this.score = score;
    }

    // Al forzar el acceso a las variables con los getter podemis monitorear cualquier acceso y no hacemos
    // las variables parte de la API de esta clase. Lo que nos permite cambiar la implementación en cualquier momento.
    // Por ahora son package-private porque en ningún momento ha hecho falta todavía acceder a ellos durante el desarrollo.
    String getNom() {
        return nom;
    }

    double getScore() {
        return score;
    }

    // Sobreescribimos los métodos para conseeguir una igualdad referencial, de esta manera dos instancias de esta clase
    // serán iguales si y solo si tienen exactamente los mismos atributos con los mismos valores.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant that)) return false;
        return Double.compare(score, that.score) == 0 && Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, score);

    }

    @Override
    public int compareTo(Restaurant o) {
        // Es totalmente válido acceder a los atributos privados de o, porque técnicamente, ambos pertenecen a la misma clase.
        // Los modificadores de visibilidad se aplican en términos de clases, no de instancias.
        int nomDiff = nom.compareTo(o.nom);
        double scoreDiff = score - o.score;

        // Primero comparamos los nombres, se usa la implementación de String de compareTo.
        //
        return (int) ((nomDiff != 0) ? Math.signum(nomDiff) : (scoreDiff != 0) ? Math.signum(nomDiff) : 0);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "nom='" + nom + '\'' +
                ", score=" + score +
                '}';
    }
}
