package utils;

import java.util.function.Consumer;
import java.util.function.Function;

public class NullUtils {
    private NullUtils() {
    }

    /**
     * This method will be used to trim the String without causing the nullPointer Exception. When the value is null,
     * It will return null.
     * "  test   " -> "test"
     * "    "      -> ""
     * ""          -> ""
     * null        -> null
     *
     * @param value -String value
     * @return - trimmed value
     */
    public static String trimValue(String value) {
        return NullUtils.executeViaNullSafer(value, String::trim);
    }

    /**
     * This method is used to mutate the input object without causing the null pointer exception.
     * when the value is null, It will not execute the mutator
     *
     * @param value   - The value which need to send in mutatorFunction
     * @param mutator - The function which mutates on the value
     * @param <I>     - Type of the value
     */
    public static <I> void executeMutator(I value, Consumer<I> mutator) {
        if (value != null) {
            mutator.accept(value);
        }
    }

    /**
     * This method will execute on Non-Null Values when the value is null It will return Null instead of executing the function
     *
     * @param value            - The value which need to send in executorFunction
     * @param executorFunction - The function which applies on the value
     * @param <I>              - Input value type
     * @param <O>              - Executor Function Output Value
     * @return - executedValue or Null
     */
    public static <I, O> O executeViaNullSafer(I value, Function<I, O> executorFunction) {
        return value != null ? executorFunction.apply(value) : null;
    }

    /**
     * This method will execute the executorFunction on Non-Null Values. If the value is null, It will return the default value
     *
     * @param value            - The value which need to send in executorFunction
     * @param executorFunction - The function which applies on the value
     * @param defaultValue     - If the value is null, this value will be return instead of executing the function
     * @param <I>              - Input value type
     * @param <O>              - Output value type
     * @return - executed value or defaultValue
     */
    public static <I, O> O executeExecutorOrDefault(I value, Function<I, O> executorFunction, O defaultValue) {
        return value != null ? executorFunction.apply(value) : defaultValue;
    }

    /**
     * This method will replace the null value by provided defaultValue. when the value is not null, It will return the value
     *
     * @param value        - The value which needs to be replaced if it is null
     * @param defaultValue - This defaultValue will be used to replace the value when the value is null
     * @param <I>          - Type of the value
     * @return actualValue or defaultValue
     */
    public static <I> I replaceNull(I value, I defaultValue) {
        return value == null ? defaultValue : value;
    }

    /**
     * This method is used to check the String value has any kind of text
     * ""    - false
     * "   " - false
     * null  - false
     * "a"   - true
     * "  a" - true
     *
     * @param value - string value which needs to be checked
     * @return - true / false
     */
    public static boolean hasText(String value) {
        return value != null && !value.trim().isEmpty();
    }

}
