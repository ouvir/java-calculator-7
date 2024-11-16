package calculator.domain.delimiter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomDelimiterTest {
    Delimiter delimiter;

    @BeforeEach
    void setUp() {
        delimiter = new CustomDelimiter();
    }

    @Test
    @DisplayName("기본 구분자로 구분하기")
    void splitTest() {
        List<String> actual = delimiter.split("1,2:3,4:5");
        List<String> expected = List.of("1", "2", "3", "4", "5");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("구분자 추가하기")
    void addDelimiterTest() {
        delimiter.addDelimiter("LL");
        String actual = delimiter.toString();
        String expected = ",|:|LL";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("구분자 추가로 구분")
    void addDelimiterAndSplitTest() {
        delimiter.addDelimiter("LL");
        List<String> actual = delimiter.split("1,2:3LL4:5");
        List<String> expected = List.of("1", "2", "3", "4", "5");
        assertEquals(expected, actual);
    }

}