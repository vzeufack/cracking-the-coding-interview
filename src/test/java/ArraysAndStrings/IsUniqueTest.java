package ArraysAndStrings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsUniqueTest {
    String caseNull = null;
    String caseEmpty = "";
    String caseSingleChar = "a";
    String caseTwoRepeated = "aa";
    String caseChangingCase = "Aa";
    String caseMoreThan2AndUnique = "abcdefghiklmnopqrstuv142958%^";
    String caseMoreThan2AndNotUnique = "abcdefghigklmnopqrstuv14452995858%^";

    @BeforeEach
    void setUp() {
    }

    @Test
    void sortApproach() {
        assertFalse(ArraysAndStrings.IsUnique.sortApproach(caseNull));
        assertTrue(ArraysAndStrings.IsUnique.sortApproach(caseEmpty));
        assertTrue(ArraysAndStrings.IsUnique.sortApproach(caseSingleChar));
        assertFalse(ArraysAndStrings.IsUnique.sortApproach(caseTwoRepeated));
        assertTrue(ArraysAndStrings.IsUnique.sortApproach(caseChangingCase));
        assertTrue(ArraysAndStrings.IsUnique.sortApproach(caseMoreThan2AndUnique));
        assertFalse(ArraysAndStrings.IsUnique.sortApproach(caseMoreThan2AndNotUnique));
    }

    @Test
    void hashSetApproach() {
        assertFalse(ArraysAndStrings.IsUnique.hashSetApproach(caseNull));
        assertTrue(ArraysAndStrings.IsUnique.hashSetApproach(caseEmpty));
        assertTrue(ArraysAndStrings.IsUnique.hashSetApproach(caseSingleChar));
        assertFalse(ArraysAndStrings.IsUnique.hashSetApproach(caseTwoRepeated));
        assertTrue(ArraysAndStrings.IsUnique.hashSetApproach(caseChangingCase));
        assertTrue(ArraysAndStrings.IsUnique.hashSetApproach(caseMoreThan2AndUnique));
        assertFalse(ArraysAndStrings.IsUnique.hashSetApproach(caseMoreThan2AndNotUnique));
    }

    @Test
    void asciiArrayApproach() {
        assertFalse(ArraysAndStrings.IsUnique.asciiArrayApproach(caseNull));
        assertTrue(ArraysAndStrings.IsUnique.asciiArrayApproach(caseEmpty));
        assertTrue(ArraysAndStrings.IsUnique.asciiArrayApproach(caseSingleChar));
        assertFalse(ArraysAndStrings.IsUnique.asciiArrayApproach(caseTwoRepeated));
        assertTrue(ArraysAndStrings.IsUnique.asciiArrayApproach(caseChangingCase));
        assertTrue(ArraysAndStrings.IsUnique.asciiArrayApproach(caseMoreThan2AndUnique));
        assertFalse(ArraysAndStrings.IsUnique.asciiArrayApproach(caseMoreThan2AndNotUnique));
    }
}