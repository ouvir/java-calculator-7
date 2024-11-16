package calculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TypeCastTest {

    @Test
    @DisplayName("타입 변환 기능 테스트")
    void castTest() {
        List<String> data = List.of("1","2","3");
        List<Integer> actual = TypeCast.cast(data);
        List<Integer> expected = List.of(1,2,3);
        assertEquals(expected,actual);
    }

}