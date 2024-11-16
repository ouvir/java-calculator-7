package calculator.service;

import java.util.Optional;

public class CustomDelimiterExtractor implements DelimiterExtractor {
    private static final String PREFIX_FORMAT = "//";
    private static final String POSTFIX_FORMAT = "\\n";

    @Override
    public Optional<String> extract(final String data) {
        if (isValidCustomDelimiterInputFormat(data)) {
            int startIndex = data.indexOf(PREFIX_FORMAT) + PREFIX_FORMAT.length();
            int endIndex = data.indexOf(POSTFIX_FORMAT);
            return Optional.of(data.substring(startIndex, endIndex));
        }
        return Optional.empty();
    }

    @Override
    public String deleteDelimiterExtractFormat(final String inputData) {
        int endIndex = inputData.indexOf(POSTFIX_FORMAT) + POSTFIX_FORMAT.length();
        return inputData.substring(endIndex);
    }

    // 커스텀 포맷이 존재하는지, 포맷이 유효한지 검사
    private boolean isValidCustomDelimiterInputFormat(final String data) {
        int prefixIndex = data.indexOf(PREFIX_FORMAT);
        int postfixIndex = data.indexOf(POSTFIX_FORMAT);
        return prefixIndex != -1 && postfixIndex != -1 && prefixIndex < postfixIndex;
    }
}
