package hu.unideb.inf.prog2.exam.input.reader;

import java.util.List;

import hu.unideb.inf.prog2.exam.domain.MatchStatistics;
import hu.unideb.inf.prog2.exam.input.parser.MatchStatisticsCSVParser;

/**
 * Class for reading football match statistics.
 */
public class MatchStatisticsReader {

    private final MatchStatisticsCSVParser matchStatisticsCSVParser;

    public MatchStatisticsReader(MatchStatisticsCSVParser matchStatisticsCSVParser) {
        this.matchStatisticsCSVParser = matchStatisticsCSVParser;
    }

    /**
     * Reads a text file on the specified path
     * into a list of {@link MatchStatistics}.
     *
     * @param path file path where the input file is expected to be
     * @return the list of read {@link MatchStatistics}
     */
    public List<MatchStatistics> read(String path) {
        // TODO: implement this method
        throw new UnsupportedOperationException("MatchStatisticsReader#read is not implemented");
    }
}
