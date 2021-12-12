package hu.unideb.inf.prog2.exam.input.supplier;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import hu.unideb.inf.prog2.exam.domain.MatchStatistics;
import hu.unideb.inf.prog2.exam.input.parser.MatchStatisticsCSVParser;

/**
 * Helper class to provide a reduced set of match statistics.
 *
 * Use this class only if you do not want to spend time on reading
 * input data from file. Please note that you will lose points in this case.
 */
public class InputDataSupplier implements Supplier<List<MatchStatistics>> {

    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String RAW_CSV_DATA =
            "09/08/2019;20:00;Liverpool;Norwich;4;1;H;M Oliver;0;2;0;0\n"
            + "10/08/2019;12:30;West Ham;Man City;0;5;A;M Dean;2;2;0;0\n"
            + "10/08/2019;15:00;Bournemouth;Sheffield United;1;1;D;K Friend;2;1;0;0\n"
            + "10/08/2019;15:00;Burnley;Southampton;3;0;H;G Scott;0;0;0;0\n"
            + "10/08/2019;15:00;Crystal Palace;Everton;0;0;D;J Moss;2;1;0;1\n"
            + "10/08/2019;15:00;Watford;Brighton;0;3;A;C Pawson;0;1;0;0\n"
            + "10/08/2019;17:30;Tottenham;Aston Villa;3;1;H;C Kavanagh;1;0;0;0\n"
            + "11/08/2019;14:00;Leicester;Wolves;0;0;D;A Marriner;0;2;0;0\n"
            + "11/08/2019;14:00;Newcastle;Arsenal;0;1;A;M Atkinson;1;3;0;0\n"
            + "11/08/2019;16:30;Man United;Chelsea;4;0;H;A Taylor;3;4;0;0\n"
            + "17/08/2019;12:30;Arsenal;Burnley;2;1;H;M Dean;2;1;0;0\n"
            + "17/08/2019;15:00;Aston Villa;Bournemouth;1;2;A;M Atkinson;0;2;0;0\n"
            + "17/08/2019;15:00;Brighton;West Ham;1;1;D;A Taylor;0;2;0;0\n"
            + "17/08/2019;15:00;Everton;Watford;1;0;H;L Mason;2;3;0;0\n"
            + "17/08/2019;15:00;Norwich;Newcastle;3;1;H;S Attwell;1;3;0;0\n"
            + "17/08/2019;15:00;Southampton;Liverpool;1;2;A;A Marriner;2;1;0;0\n"
            + "17/08/2019;17:30;Man City;Tottenham;2;2;D;M Oliver;1;0;0;0\n"
            + "18/08/2019;14:00;Sheffield United;Crystal Palace;1;0;H;D Coote;3;1;0;0\n"
            + "18/08/2019;16:30;Chelsea;Leicester;1;1;D;O Langford;1;0;0;0\n"
            + "19/08/2019;20:00;Wolves;Man United;1;1;D;J Moss;2;2;0;0";

    private final MatchStatisticsCSVParser matchStatisticsCSVParser;

    public InputDataSupplier(MatchStatisticsCSVParser matchStatisticsCSVParser) {
        this.matchStatisticsCSVParser = matchStatisticsCSVParser;
    }

    /**
     * Provides a limited set of input data to be processed.
     *
     * @return the predefined input data as a list of {@link MatchStatistics}
     */
    @Override
    public List<MatchStatistics> get() {
        return Arrays.stream(RAW_CSV_DATA.split(NEW_LINE_SEPARATOR))
                .map(matchStatisticsCSVParser::parse)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
