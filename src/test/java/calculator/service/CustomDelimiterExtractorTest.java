package calculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomDelimiterExtractorTest {
    DelimiterExtractor extractor = new CustomDelimiterExtractor();

    @Test
    @DisplayName("구분자 추출하기")
    void extractDelimiterTest() {
        Optional<String> extract = extractor.extract("//;\\n1");
        assertTrue(extract.isPresent());
        assertEquals(";", extract.get());
    }

    @Test
    @DisplayName("구분자 추출하기 예외")
    void extractDelimiterExceptionTest() {
        Optional<String> extract = extractor.extract("\\n;//1");
        assertFalse(extract.isPresent());
    }

    @Test
    @DisplayName("구분자 포맷 제거")
    void deleteDelimiterExtractFormatTest() {
        String actual = extractor.deleteDelimiterExtractFormat("//;\\n1");
        assertThat(actual).isEqualTo("1");
    }

}