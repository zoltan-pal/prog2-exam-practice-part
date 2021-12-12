package hu.unideb.inf.prog2.exam.domain;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Enum for team selection.
 */
public enum Team {
    ARSENAL("Arsenal"),
    ASTON_VILLA("Aston Villa"),
    BOURNEMOUTH("Bournemouth"),
    BRIGHTON("Brighton"),
    BURNLEY("Burnley"),
    CHELSEA("Chelsea"),
    CRYSTAL_PALACE("Crystal Palace"),
    EVERTON("Everton"),
    LEICESTER("Leicester"),
    LIVERPOOL("Liverpool"),
    MAN_CITY("Man City"),
    MAN_UNITED("Man United"),
    NEWCASTLE("Newcastle"),
    NORWICH("Norwich"),
    SHEFFIELD_UNITED("Sheffield United"),
    SOUTHAMPTON("Southampton"),
    TOTTENHAM("Tottenham"),
    WATFORD("Watford"),
    WEST_HAM("West Ham"),
    WOLVES("Wolves");

    private static final Map<String, Team> LOOKUP_MAP = Stream.of(Team.values())
            .collect(Collectors.toMap(Team::getName, Function.identity()));

    private String name;

    public String getName() {
        return name;
    }

    Team(String name) {
        this.name = name;
    }

    public static Team fromString(String name) {
        return LOOKUP_MAP.get(name);
    }
}
