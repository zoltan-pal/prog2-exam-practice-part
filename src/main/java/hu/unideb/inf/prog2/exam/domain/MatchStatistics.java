package hu.unideb.inf.prog2.exam.domain;

import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Domain class to hold statistics of football matches.
 */
public class MatchStatistics {
    private final ZonedDateTime matchDateTime;
    private final TeamStatistics homeTeamStatistics;
    private final TeamStatistics awayTeamStatistics;
    private final String referee;
    private final MatchResult fullTimeResult;

    public ZonedDateTime getMatchDateTime() {
        return matchDateTime;
    }

    public TeamStatistics getHomeTeamStatistics() {
        return homeTeamStatistics;
    }

    public TeamStatistics getAwayTeamStatistics() {
        return awayTeamStatistics;
    }

    public String getReferee() {
        return referee;
    }

    public MatchResult getFullTimeResult() {
        return fullTimeResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        MatchStatistics that = (MatchStatistics) o;

        if (!Objects.equals(matchDateTime, that.matchDateTime))
            return false;
        if (!Objects.equals(homeTeamStatistics, that.homeTeamStatistics))
            return false;
        if (!Objects.equals(awayTeamStatistics, that.awayTeamStatistics))
            return false;
        if (!Objects.equals(referee, that.referee))
            return false;
        return fullTimeResult == that.fullTimeResult;
    }

    @Override
    public int hashCode() {
        int result = matchDateTime != null ? matchDateTime.hashCode() : 0;
        result = 31 * result + (homeTeamStatistics != null ? homeTeamStatistics.hashCode() : 0);
        result = 31 * result + (awayTeamStatistics != null ? awayTeamStatistics.hashCode() : 0);
        result = 31 * result + (referee != null ? referee.hashCode() : 0);
        result = 31 * result + (fullTimeResult != null ? fullTimeResult.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MatchStatistics{" +
                "matchDateTime=" + matchDateTime +
                ", homeTeamStatistics=" + homeTeamStatistics +
                ", awayTeamStatistics=" + awayTeamStatistics +
                ", referee='" + referee + '\'' +
                ", fullTimeResult=" + fullTimeResult +
                '}';
    }

    private MatchStatistics(Builder builder) {
        this.matchDateTime = builder.matchDateTime;
        this.homeTeamStatistics = builder.homeTeamStatistics;
        this.awayTeamStatistics = builder.awayTeamStatistics;
        this.referee = builder.referee;
        this.fullTimeResult = builder.fullTimeResult;
    }

    /**
     * Creates builder to build {@link MatchStatistics}.
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder to build {@link MatchStatistics}.
     */
    public static final class Builder {
        private ZonedDateTime matchDateTime;
        private TeamStatistics homeTeamStatistics;
        private TeamStatistics awayTeamStatistics;
        private String referee;
        private MatchResult fullTimeResult;

        public Builder matchDateTime(ZonedDateTime matchDateTime) {
            this.matchDateTime = matchDateTime;
            return this;
        }

        public Builder homeTeamStatistics(TeamStatistics homeTeamStatistics) {
            this.homeTeamStatistics = homeTeamStatistics;
            return this;
        }

        public Builder awayTeamStatistics(TeamStatistics awayTeamStatistics) {
            this.awayTeamStatistics = awayTeamStatistics;
            return this;
        }

        public Builder referee(String referee) {
            this.referee = referee;
            return this;
        }

        public Builder fullTimeResult(MatchResult fullTimeResult) {
            this.fullTimeResult = fullTimeResult;
            return this;
        }

        public MatchStatistics build() {
            return new MatchStatistics(this);
        }
    }
}
