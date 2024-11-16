package calculator.utils;

import calculator.exception.InputDataException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    @DisplayName("입력 문자 검증 예외")
    void validateStringFormatTest() {
        Exception e = assertThrows(InputDataException.class, () -> {
            Validator.validateStringFormat("");
        });

        assertThat(e.getMessage()).isEqualTo("[ERROR] 빈 문자열 입력은 받지 않습니다.");
    }

    @Test
    @DisplayName("split 된 입력 문자 검증 - NaN")
    void validateSplitedDataFormatNaNTest() {
        List<String> test = new ArrayList<>();
        test.add("a");
        Exception e = assertThrows(InputDataException.class, () -> {
            Validator.validateSplitedDataFormat(test);
        });

        assertThat(e.getMessage()).isEqualTo("[ERROR] 구분자를 제외한 나머지 문자는 양의 정수여야 합니다.");
    }

    @Test
    @DisplayName("split 된 입력 문자 검증 - Negative")
    void validateSplitedDataFormatNegativeTest() {
        List<String> test = new ArrayList<>();
        test.add("-3");
        Exception e = assertThrows(InputDataException.class, () -> {
            Validator.validateSplitedDataFormat(test);
        });

        assertThat(e.getMessage()).isEqualTo("[ERROR] 0과 음수는 받지 않습니다.");
    }

}