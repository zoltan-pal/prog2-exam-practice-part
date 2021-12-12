package hu.unideb.inf.prog2.exam.domain;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Enum for match result selection.
 */
public enum MatchResult {
    HOME_WIN("H"),
    DRAW("D"),
    AWAY_WIN("A");

    private static final Map<String, MatchResult> LOOKUP_MAP = Stream.of(MatchResult.values())
            .collect(Collectors.toMap(MatchResult::getResultCode, Function.identity()));

    private final String resultCode;

    public String getResultCode() {
        return resultCode;
    }

    MatchResult(String resultCode) {
        this.resultCode = resultCode;
    }

    public static MatchResult fromString(String resultCode) {
        return LOOKUP_MAP.get(resultCode);
    }
}
