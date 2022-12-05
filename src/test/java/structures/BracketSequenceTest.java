package structures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static structures.BracketSequence.check;
import static structures.BracketSequence.isBalanced;

/**
 * Checks if bracket sequence is balanced.
 * https://stepik.org/lesson/41233/step/5?unit=19817
 */
class BracketSequenceTest {

    @ParameterizedTest
    @ValueSource(strings = {"()[]{}", "({[]})", "()[({[]})]{}((()))"})
    public void shouldReturnTrueForCorrectStrings(String input) {
        assertTrue(isBalanced(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"))[]{}", "}", "()[({[]})]{}()))))"})
    public void shouldReturnFalseForInCorrectStrings(String input) {
        assertFalse(isBalanced(input));
    }

    @ParameterizedTest
    @EmptySource
    public void shouldReturnFalseForEmptyStrings(String input) {
        assertFalse(isBalanced(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0"})
    public void shouldReturnFalseForNonBracketStrings(String input) {
        assertFalse(isBalanced(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"([](){([])})", ""})
    public void checkShouldReturnSuccessForCorrectStrings(String input) {
        assertEquals("Success", check(input));
    }

    @ParameterizedTest
    @MethodSource("provideInputForCheck")
    public void checkShouldReturnPositionForInCorrectStrings(String input, String expected) {
        assertEquals(expected, check(input));
    }

    private static Stream<Arguments> provideInputForCheck() {
        return Stream.of(
                Arguments.of("()[]}", "5"),
                Arguments.of("{{[()]]", "7"),
                Arguments.of("foo(bar[i);", "10"),
                Arguments.of("[[*", "2"),
                Arguments.of("}*", "1"),
                Arguments.of("*}", "2")
        );
    }
}
