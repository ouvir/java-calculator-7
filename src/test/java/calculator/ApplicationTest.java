package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            run("-1,2,3", "1:2");
            assertThat(output()).contains("[ERROR] 0과 음수는 받지 않습니다.");
        });
    }

    @Test
    void 커스텀_구분자_사용_숫자() {
        assertSimpleTest(() -> {
            run("//6\\n161");
            assertThat(output()).contains("결과 : 2");
        });
    }

    @Test
    void 커스텀_구분자_사용_문자열() {
        assertSimpleTest(() -> {
            run("//format\\n1format5");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("int 값 넘어감")
    void rangeErrorTest() {
        assertSimpleTest(() -> {
            run("1000000000,2000000000", "1");
            assertThat(output()).contains("[ERROR] 계산 값은 Integer 범위를 넘을 수 없습니다.");
        });
    }

    @ParameterizedTest
    @DisplayName("숫자 공백 존재")
    @ValueSource(strings = {"1, 2", "1 ,2", "1,2 "})
    void trimTest(String data) {
        assertSimpleTest(() -> {
            run(data);
            assertThat(output()).contains("결과 : 3");
        });
    }

    @ParameterizedTest
    @DisplayName("공백 커스텀 구분자")
    @ValueSource(strings = {"// \\n1 2", "// \\n2 1"})
    void spaceDelimiterTest(String data) {
        assertSimpleTest(() -> {
            run(data);
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
