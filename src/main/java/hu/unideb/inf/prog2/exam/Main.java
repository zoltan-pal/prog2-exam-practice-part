package hu.unideb.inf.prog2.exam;

import java.util.List;

import hu.unideb.inf.prog2.exam.domain.MatchResult;
import hu.unideb.inf.prog2.exam.domain.MatchStatistics;
import hu.unideb.inf.prog2.exam.domain.Team;
import hu.unideb.inf.prog2.exam.handler.MatchStatisticsHandler;
import hu.unideb.inf.prog2.exam.input.parser.InputParameterParser;
import hu.unideb.inf.prog2.exam.input.parser.MatchStatisticsCSVParser;
import hu.unideb.inf.prog2.exam.input.reader.MatchStatisticsReader;
import hu.unideb.inf.prog2.exam.input.supplier.InputDataSupplier;
import hu.unideb.inf.prog2.exam.processor.MatchStatisticsProcessor;

public class Main {

    private static final String INPUT_FILE_PATH = "premier_2019-2020.csv";

    private static final MatchStatisticsCSVParser MATCH_STATISTICS_CSV_PARSER = new MatchStatisticsCSVParser();
    private static final MatchStatisticsReader MATCH_STATISTICS_READER = new MatchStatisticsReader(MATCH_STATISTICS_CSV_PARSER);
    private static final InputDataSupplier INPUT_DATA_SUPPLIER = new InputDataSupplier(MATCH_STATISTICS_CSV_PARSER);
    private static final InputParameterParser INPUT_PARAMETER_PARSER = new InputParameterParser();
    private static final MatchStatisticsProcessor MATCH_STATISTICS_PROCESSOR = new MatchStatisticsProcessor();
    private static final MatchStatisticsHandler MATCH_STATISTICS_HANDLER = new MatchStatisticsHandler(MATCH_STATISTICS_PROCESSOR);

    public static void main(String[] args) {
        Team team = null;
        MatchResult matchResult = null;
        String referee = null;

        try {
            INPUT_PARAMETER_PARSER.verifyParameterCount(args);
            team = INPUT_PARAMETER_PARSER.parseTeam(args);
            matchResult = INPUT_PARAMETER_PARSER.parseMatchResult(args);
            referee = INPUT_PARAMETER_PARSER.parseReferee(args);
        } catch (RuntimeException e) {
            System.out.println("Invalid parameters received, stopping application: " + e.getMessage());
            System.exit(1);
        }

        List<MatchStatistics> matchStatistics = MATCH_STATISTICS_READER.read(INPUT_FILE_PATH);
        // Use match statistics below as a fallback (please see the README for details)
        // List<MatchStatistics> matchStatistics = INPUT_DATA_SUPPLIER.get();
        MATCH_STATISTICS_HANDLER.printSummary(matchStatistics, team, matchResult, referee);
    }
}
