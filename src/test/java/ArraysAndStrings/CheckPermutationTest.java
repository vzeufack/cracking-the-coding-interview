package ArraysAndStrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckPermutationTest {

    @Test
    void hashMapApproach() {
        assertTrue(CheckPermutation.hashMapApproach("", ""));
        assertFalse(CheckPermutation.hashMapApproach("", "a"));
        assertFalse(CheckPermutation.hashMapApproach("a", ""));
        assertTrue(CheckPermutation.hashMapApproach("absdfa80*", "*df8bsaa0"));
    }

    @Test
    void arrayApproach() {
        assertTrue(CheckPermutation.arrayApproach("", ""));
        assertFalse(CheckPermutation.arrayApproach("", "a"));
        assertFalse(CheckPermutation.arrayApproach("a", ""));
        assertTrue(CheckPermutation.arrayApproach("absdfa80*", "*df8bsaa0"));
    }
}