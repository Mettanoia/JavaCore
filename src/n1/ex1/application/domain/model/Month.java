package n1.ex1.application.domain.model;

import java.util.Objects;

public record Month(MonthName name) {

    public enum MonthName {
        JANUARY,
        FEBRUARY,
        MARCH,
        APRIL,
        MAY,
        JUNE,
        JULY,
        AUGUST,
        SEPTEMBER,
        OCTOBER,
        NOVEMBER,
        DECEMBER
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return name == month.name;
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(name);
    }
}
