package hu.unideb.inf.prog2.exam.domain;

import java.util.Objects;

/**
 * Domain class to hold statistics of disciplinary
 * actions warranted by referees.
 */
public class DisciplinaryActionStatistics {
    private final Integer yellowCards;
    private final Integer redCards;

    public DisciplinaryActionStatistics(Integer yellowCards, Integer redCards) {
        this.yellowCards = yellowCards;
        this.redCards = redCards;
    }

    public Integer getYellowCards() {
        return yellowCards;
    }

    public Integer getRedCards() {
        return redCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        DisciplinaryActionStatistics that = (DisciplinaryActionStatistics) o;

        if (!Objects.equals(yellowCards, that.yellowCards))
            return false;
        return Objects.equals(redCards, that.redCards);
    }

    @Override
    public int hashCode() {
        int result = yellowCards != null ? yellowCards.hashCode() : 0;
        result = 31 * result + (redCards != null ? redCards.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DisciplinaryActionStatistics{" +
                "yellowCards=" + yellowCards +
                ", redCards=" + redCards +
                '}';
    }
}
