package ArraysAndStrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneAwayTest {
    @Test
    void testLinearApproach() {
        assertTrue(OneAway.linearApproach("", "a"));
        assertTrue(OneAway.linearApproach("a", ""));
        assertTrue(OneAway.linearApproach("pale", "ple"));
        assertTrue(OneAway.linearApproach("pales", "pale"));
        assertTrue(OneAway.linearApproach("pale", "bale"));
        assertTrue(OneAway.linearApproach("12345", "12345"));

        assertFalse(OneAway.linearApproach(null, "a"));
        assertFalse(OneAway.linearApproach("a", null));
        assertFalse(OneAway.linearApproach(null, null));
        assertFalse(OneAway.linearApproach("a", "abc"));
        assertFalse(OneAway.linearApproach("pale", "bake"));
    }
}