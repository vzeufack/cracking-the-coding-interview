import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArraysAndStringsTest {

    @Test
    void isUniqueSort() {
        assertFalse(ArraysAndStrings.isUniqueSort(null));
        assertTrue(ArraysAndStrings.isUniqueSort(""));
        assertTrue(ArraysAndStrings.isUniqueSort("a"));
        assertFalse(ArraysAndStrings.isUniqueSort("aa"));
        assertTrue(ArraysAndStrings.isUniqueSort("Aa"));
        assertTrue(ArraysAndStrings.isUniqueSort("abcdefghiklmnopqrstuv142958%^"));
        assertFalse(ArraysAndStrings.isUniqueSort("abcdefghigklmnopqrstuv14452995858%^"));
    }

    @Test
    void isUniqueHashSet() {
        assertFalse(ArraysAndStrings.isUniqueHashSet(null));
        assertTrue(ArraysAndStrings.isUniqueHashSet(""));
        assertTrue(ArraysAndStrings.isUniqueHashSet("a"));
        assertFalse(ArraysAndStrings.isUniqueHashSet("aa"));
        assertTrue(ArraysAndStrings.isUniqueHashSet("Aa"));
        assertTrue(ArraysAndStrings.isUniqueHashSet("abcdefghiklmnopqrstuv142958%^"));
        assertFalse(ArraysAndStrings.isUniqueHashSet("abcdefghigklmnopqrstuv14452995858%^"));
    }
}