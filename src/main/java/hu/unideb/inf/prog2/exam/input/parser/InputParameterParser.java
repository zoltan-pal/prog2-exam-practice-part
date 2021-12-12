package hu.unideb.inf.prog2.exam.input.parser;

import hu.unideb.inf.prog2.exam.domain.MatchResult;
import hu.unideb.inf.prog2.exam.domain.Team;
import hu.unideb.inf.prog2.exam.input.parser.exception.ParameterParsingException;

public class InputParameterParser {

    public void verifyParameterCount(String[] args) {
        if (args.length != 3) {
            throw new ParameterParsingException("Invalid number of parameters");
        }
    }

    public Team parseTeam(String[] args) {
        Team team = Team.fromString(args[0]);
        if (team == null) {
            throw new ParameterParsingException("Invalid team: " + args[0]);
        }

        return team;
    }

    public MatchResult parseMatchResult(String[] args) {
        MatchResult matchResult = MatchResult.fromString(args[1]);
        if (matchResult == null) {
            throw new ParameterParsingException("Invalid matchResult: " + args[1]);
        }

        return matchResult;
    }

    public String parseReferee(String[] args) {
        return args[2];
    }
}
