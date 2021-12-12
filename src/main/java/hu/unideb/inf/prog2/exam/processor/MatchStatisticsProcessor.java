package hu.unideb.inf.prog2.exam.processor;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import hu.unideb.inf.prog2.exam.domain.MatchResult;
import hu.unideb.inf.prog2.exam.domain.MatchStatistics;
import hu.unideb.inf.prog2.exam.domain.DisciplinaryActionStatistics;
import hu.unideb.inf.prog2.exam.domain.Team;

public class MatchStatisticsProcessor {

    public long countMatchesByTeamAndResult(
            List<MatchStatistics> matchStatistics,
            Team team,
            MatchResult matchResult) {
        return matchStatistics.stream()
                .filter(singleMatchStat -> isMatchingByTeamAndResult(singleMatchStat, team, matchResult))
                .count();
    }

    public List<Integer> getTop3GoalCounts(List<MatchStatistics> matchStatistics) {
        return matchStatistics.stream()
                .map(this::sumScoredGoals)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
    }

    public Optional<DisciplinaryActionStatistics> aggregateMisconductStatsByReferee(List<MatchStatistics> matchStatistics, String referee) {
        return matchStatistics.stream()
                .filter(singleMatchStat -> singleMatchStat.getReferee().equals(referee))
                .map(this::extractMisconductStats)
                .reduce(this::aggregateDisciplinaryActionStatistics);
    }

    private boolean isMatchingByTeamAndResult(MatchStatistics matchStatistics, Team team, MatchResult matchResult) {
        boolean isMatching = false;
        if (matchResult == matchStatistics.getFullTimeResult()) {
            switch (matchResult) {
            case AWAY_WIN:
                isMatching = team == matchStatistics.getAwayTeamStatistics().getTeam();
                break;
            case HOME_WIN:
                isMatching = team == matchStatistics.getHomeTeamStatistics().getTeam();
                break;
            case DRAW:
            default:
                isMatching = team == matchStatistics.getHomeTeamStatistics().getTeam()
                        || team == matchStatistics.getAwayTeamStatistics().getTeam();
            }
        }
        return isMatching;
    }

    private Integer sumScoredGoals(MatchStatistics matchStatistics) {
        return matchStatistics.getHomeTeamStatistics().getFullTimeGoals()
                + matchStatistics.getAwayTeamStatistics().getFullTimeGoals();
    }

    private DisciplinaryActionStatistics extractMisconductStats(MatchStatistics matchStatistics) {
        Integer yellowCards =
                matchStatistics.getHomeTeamStatistics().getDisciplinaryActionStatistics().getYellowCards()
                + matchStatistics.getAwayTeamStatistics().getDisciplinaryActionStatistics().getYellowCards();
        Integer redCards =
                matchStatistics.getHomeTeamStatistics().getDisciplinaryActionStatistics().getRedCards()
                        + matchStatistics.getAwayTeamStatistics().getDisciplinaryActionStatistics().getRedCards();
        return new DisciplinaryActionStatistics(yellowCards, redCards);
    }

    private DisciplinaryActionStatistics aggregateDisciplinaryActionStatistics(DisciplinaryActionStatistics first, DisciplinaryActionStatistics second) {
        Integer yellowCards = first.getYellowCards() + second.getYellowCards();
        Integer redCards = first.getRedCards() + second.getRedCards();
        return new DisciplinaryActionStatistics(yellowCards, redCards);
    }
}
