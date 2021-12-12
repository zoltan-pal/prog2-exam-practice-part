package hu.unideb.inf.prog2.exam.input.parser;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import hu.unideb.inf.prog2.exam.domain.MatchStatistics;
import hu.unideb.inf.prog2.exam.domain.DisciplinaryActionStatistics;
import hu.unideb.inf.prog2.exam.domain.Team;
import hu.unideb.inf.prog2.exam.domain.TeamStatistics;
import hu.unideb.inf.prog2.exam.domain.MatchResult;

/**
 * Class for parsing statistics of football matches
 * to {@link MatchStatistics} from {@link String} in CSV format.
 *
 * Field values are expected to be in the following order:
 * Date;Time;HomeTeam;AwayTeam;FTHG;FTAG;FTR;Referee;HY;AY;HR;AR
 *
 * Abbreviations:
 * FTHG - full time home team goals
 * FTAG - full time away team goals
 * FTR - full time result
 * HY - home team yellow cards
 * AY - away team red cards
 * HR - home team red cards
 * AR - away team yellow cards
 */
public class MatchStatisticsCSVParser {

    private static final String MATCH_DATE_TIME_PATTERN = "dd/MM/yyyy HH:mm z";
    private static final String MATCH_DATE_TIME_STRING_TEMPLATE = "%s %s GMT";
    private static final DateTimeFormatter MATCH_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(MATCH_DATE_TIME_PATTERN);

    /**
     * Parses the input CSV string into {@link MatchStatistics}.
     *
     * @param sourceString input CSV string
     * @return the parsed {@link MatchStatistics}
     */
    public MatchStatistics parse(String sourceString) {
        String[] splitFields = sourceString.split(";");

        TeamStatistics homeTeamStatistics = TeamStatistics.builder()
                .team(Team.fromString(splitFields[2]))
                .fullTimeGoals(parseFullTimeGoals(splitFields[4]))
                .disciplinaryActionStatistics(parseDisciplinaryActionStatistics(splitFields[8], splitFields[10]))
                .build();
        TeamStatistics awayTeamStatistics = TeamStatistics.builder()
                .team(Team.fromString(splitFields[3]))
                .fullTimeGoals(parseFullTimeGoals(splitFields[5]))
                .disciplinaryActionStatistics(parseDisciplinaryActionStatistics(splitFields[9], splitFields[11]))
                .build();

        return MatchStatistics.builder()
                .matchDateTime(parseMatchDateTime(splitFields[0], splitFields[1]))
                .homeTeamStatistics(homeTeamStatistics)
                .awayTeamStatistics(awayTeamStatistics)
                .fullTimeResult(MatchResult.fromString(splitFields[6]))
                .referee(splitFields[7])
                .build();
    }

    private ZonedDateTime parseMatchDateTime(String date, String time) {
        ZonedDateTime matchDateTime = null;
        try {
            String matchDateTimeString = String.format(MATCH_DATE_TIME_STRING_TEMPLATE, date, time);
            matchDateTime = ZonedDateTime.parse(matchDateTimeString, MATCH_DATE_TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            String errorMessage = String.format("Unable to parse matchDateTime: date=%s, time=%s, message=%s", date, time, e.getMessage());
            System.out.println(errorMessage);
        }
        return matchDateTime;
    }

    private Integer parseFullTimeGoals(String sourceString) {
        return parseInteger(sourceString, "fullTimeGoals");
    }

    private DisciplinaryActionStatistics parseDisciplinaryActionStatistics(String yellowCardsString, String redCardsString) {
        Integer yellowCards = parseInteger(yellowCardsString, "yellowCards");
        Integer redCards = parseInteger(redCardsString, "redCards");
        return new DisciplinaryActionStatistics(yellowCards, redCards);
    }

    private Integer parseInteger(String sourceString, String fieldName) {
        Integer parsedInteger = null;
        try {
            parsedInteger = Integer.parseInt(sourceString);
        } catch (NumberFormatException e) {
            String errorMessage = String.format("Unable to parse %s: sourceString=%s, message=%s", fieldName, sourceString, e.getMessage());
            System.out.println(errorMessage);
        }
        return parsedInteger;
    }
}
