package hu.unideb.inf.prog2.exam.input.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        List<MatchStatistics> matchStatistics = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            matchStatistics = reader
                    .lines()
                    .skip(1)
                    .map(matchStatisticsCSVParser::parse)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.out.println("Unable to load file from path: " + path);
        } catch (IOException e) {
            System.out.println("Unable to process file on path: " + path);
        }
        return matchStatistics;
    }
}
