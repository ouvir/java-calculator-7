package calculator.domain.delimiter;

import java.util.List;

public interface Delimiter {
    List<String> split(final String input);
    void addDelimiter(final String s);
}
