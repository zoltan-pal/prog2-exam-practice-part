package hu.unideb.inf.prog2.exam;

import java.util.List;

import hu.unideb.inf.prog2.exam.domain.MatchStatistics;
import hu.unideb.inf.prog2.exam.input.parser.MatchStatisticsCSVParser;
import hu.unideb.inf.prog2.exam.input.reader.MatchStatisticsReader;
import hu.unideb.inf.prog2.exam.input.supplier.InputDataSupplier;

public class Main {

    private static final String INPUT_FILE_PATH = "premier_2019-2020.csv";

    private static final MatchStatisticsCSVParser MATCH_STATISTICS_CSV_PARSER = new MatchStatisticsCSVParser();
    private static final MatchStatisticsReader MATCH_STATISTICS_READER = new MatchStatisticsReader(MATCH_STATISTICS_CSV_PARSER);
    private static final InputDataSupplier INPUT_DATA_SUPPLIER = new InputDataSupplier(MATCH_STATISTICS_CSV_PARSER);

    public static void main(String[] args) {
        List<MatchStatistics> matchStatistics = MATCH_STATISTICS_READER.read(INPUT_FILE_PATH);
        // Use match statistics below as a fallback (please see the README for details)
        // List<MatchStatistics> matchStatistics = INPUT_DATA_SUPPLIER.get();
    }
}
