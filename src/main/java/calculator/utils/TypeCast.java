package calculator.utils;

import java.util.ArrayList;
import java.util.List;

public class TypeCast {
    public static List<Integer> cast(final List<String> strings) {
        try {
            return strings.stream().map(String::trim).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("strings can't be converted to double");
        }
    }
}
