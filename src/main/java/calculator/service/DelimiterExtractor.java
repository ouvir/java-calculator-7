package calculator.service;

import java.util.Optional;

public interface DelimiterExtractor {
    Optional<String> extract(String data);
    String deleteDelimiterExtractFormat(String inputData);
}
