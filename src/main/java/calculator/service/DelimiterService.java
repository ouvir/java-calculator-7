package calculator.service;

import calculator.domain.delimiter.Delimiter;

import java.util.List;

public class DelimiterService {

    private final Delimiter delimiter;

    public DelimiterService(Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    public void addDelimiter(final String newDelimiter) {
        delimiter.addDelimiter(newDelimiter);
    }

    public List<String> split(final String inputData) {
        return delimiter.split(inputData);
    }
}
