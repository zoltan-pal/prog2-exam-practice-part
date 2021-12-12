package hu.unideb.inf.prog2.exam.handler;

import java.util.List;

import hu.unideb.inf.prog2.exam.domain.MatchResult;
import hu.unideb.inf.prog2.exam.domain.MatchStatistics;
import hu.unideb.inf.prog2.exam.domain.Team;
import hu.unideb.inf.prog2.exam.processor.MatchStatisticsProcessor;

public class MatchStatisticsHandler {

    private final MatchStatisticsProcessor matchStatisticsProcessor;

    public MatchStatisticsHandler(MatchStatisticsProcessor matchStatisticsProcessor) {
        this.matchStatisticsProcessor = matchStatisticsProcessor;
    }

    public void printSummary(List<MatchStatistics> matchStatistics, Team team, MatchResult matchResult, String referee) {
        System.out.println("Match count by team and result: " + matchStatisticsProcessor.countMatchesByTeamAndResult(matchStatistics, team, matchResult));

        System.out.println("Top 3 goals count:");
        matchStatisticsProcessor.getTop3GoalCounts(matchStatistics).forEach(System.out::println);

        System.out.println("Given cards by referee:");
        matchStatisticsProcessor.aggregateMisconductStatsByReferee(matchStatistics, referee).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("No stats were found for the specified referee"));
    }
}
