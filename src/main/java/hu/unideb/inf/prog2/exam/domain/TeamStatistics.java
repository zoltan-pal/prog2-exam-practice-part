package hu.unideb.inf.prog2.exam.domain;

import java.util.Objects;

/**
 * Domain class to hold statistics of football teams.
 */
public class TeamStatistics {
    private final Team team;
    private final Integer fullTimeGoals;
    private final DisciplinaryActionStatistics disciplinaryActionStatistics;

    public Team getTeam() {
        return team;
    }

    public Integer getFullTimeGoals() {
        return fullTimeGoals;
    }

    public DisciplinaryActionStatistics getDisciplinaryActionStatistics() {
        return disciplinaryActionStatistics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        TeamStatistics that = (TeamStatistics) o;

        if (team != that.team)
            return false;
        if (!Objects.equals(fullTimeGoals, that.fullTimeGoals))
            return false;
        return Objects.equals(disciplinaryActionStatistics, that.disciplinaryActionStatistics);
    }

    @Override
    public int hashCode() {
        int result = team != null ? team.hashCode() : 0;
        result = 31 * result + (fullTimeGoals != null ? fullTimeGoals.hashCode() : 0);
        result = 31 * result + (disciplinaryActionStatistics != null ? disciplinaryActionStatistics.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TeamStatistics{" +
                "team=" + team +
                ", fullTimeGoals=" + fullTimeGoals +
                ", disciplinaryActionStatistics=" + disciplinaryActionStatistics +
                '}';
    }

    private TeamStatistics(Builder builder) {
        this.team = builder.team;
        this.fullTimeGoals = builder.fullTimeGoals;
        this.disciplinaryActionStatistics = builder.disciplinaryActionStatistics;
    }

    /**
     * Creates builder to build {@link TeamStatistics}.
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder to build {@link TeamStatistics}.
     */
    public static final class Builder {
        private Team team;
        private Integer fullTimeGoals;
        private DisciplinaryActionStatistics disciplinaryActionStatistics;

        public Builder team(Team team) {
            this.team = team;
            return this;
        }

        public Builder fullTimeGoals(Integer fullTimeGoals) {
            this.fullTimeGoals = fullTimeGoals;
            return this;
        }

        public Builder disciplinaryActionStatistics(DisciplinaryActionStatistics disciplinaryActionStatistics) {
            this.disciplinaryActionStatistics = disciplinaryActionStatistics;
            return this;
        }

        public TeamStatistics build() {
            return new TeamStatistics(this);
        }
    }
}
