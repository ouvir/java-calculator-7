package calculator.domain.operator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlusOperatorTest {
    PlusOperator operator = new PlusOperator();

    @Test
    void operateTest() {
        int actual = operator.operate(List.of(1,2,3,4,5));
        assertEquals(15, actual);
    }

}