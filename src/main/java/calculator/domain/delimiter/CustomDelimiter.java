package calculator.domain.delimiter;

import java.util.Arrays;
import java.util.List;

public class CustomDelimiter implements Delimiter {
    private static final String DEFAULT_DELIMITER_COMMA = ",";
    private static final String DEFAULT_DELIMITER_COLON = ":";
    private static final String REGEX = "|";

    private String delimiter;

    public CustomDelimiter() {
        delimiter = DEFAULT_DELIMITER_COMMA + REGEX + DEFAULT_DELIMITER_COLON;
    }

    @Override
    public List<String> split(final String input) {
        return Arrays.stream(input.split(delimiter)).toList();
    }

    @Override
    public void addDelimiter(final String newDelimiter) {
        delimiter = delimiter + REGEX + newDelimiter;
    }

    @Override
    public String toString(){
        return delimiter;
    }
}
