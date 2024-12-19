package LinkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDupsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void bufferApproach() {
        // one element
        List<Integer> oneElmt = new List<>(new Integer[]{1});
        List<Integer> oneElmtExpected = new List<>(new Integer[]{1});
        RemoveDups.bufferApproach(oneElmt);
        assertTrue(oneElmt.isEqual(oneElmtExpected));

        // 2 identical element
        List<Integer> twoIdenticalElmt = new List<>(new Integer[]{1, 1});
        List<Integer> twoIdenticalElmtExpected = new List<>(new Integer[]{1});
        RemoveDups.bufferApproach(twoIdenticalElmt);
        assertTrue(twoIdenticalElmt.isEqual(twoIdenticalElmtExpected));

        // 2 different element
        List<Integer> twoDifferentElmt = new List<>(new Integer[]{1, 2});
        List<Integer> twoDifferentExpected = new List<>(new Integer[]{1, 2});
        RemoveDups.bufferApproach(twoDifferentElmt);
        assertTrue(twoDifferentElmt.isEqual(twoDifferentExpected));

        //long list with some duplicates
        List<Integer> longListWithDups = new List<>(new Integer[]{4, 45, 4, 45, 3, 324, 1, 5, 4, 99});
        List<Integer> longListWithDupsExpected = new List<>(new Integer[]{4, 45, 3, 324, 1, 5, 99});
        RemoveDups.bufferApproach(longListWithDups);
        assertTrue(longListWithDups.isEqual(longListWithDupsExpected));

        //long list without duplicates
        List<Integer> longListWithoutDups = new List<>(new Integer[]{4, 45, 3, 324, 1, 5, 99});
        List<Integer> longListWithoutDupsExpected = new List<>(new Integer[]{4, 45, 3, 324, 1, 5, 99});
        RemoveDups.bufferApproach(longListWithoutDups);
        assertTrue(longListWithoutDups.isEqual(longListWithoutDupsExpected));
    }

    @Test
    void inplaceApproach() {
        // one element
        List<Integer> oneElmt = new List<>(new Integer[]{1});
        List<Integer> oneElmtExpected = new List<>(new Integer[]{1});
        RemoveDups.inPlaceApproach(oneElmt);
        assertTrue(oneElmt.isEqual(oneElmtExpected));

        // 2 identical element
        List<Integer> twoIdenticalElmt = new List<>(new Integer[]{1, 1});
        List<Integer> twoIdenticalElmtExpected = new List<>(new Integer[]{1});
        RemoveDups.inPlaceApproach(twoIdenticalElmt);
        assertTrue(twoIdenticalElmt.isEqual(twoIdenticalElmtExpected));

        // 2 different element
        List<Integer> twoDifferentElmt = new List<>(new Integer[]{1, 2});
        List<Integer> twoDifferentExpected = new List<>(new Integer[]{1, 2});
        RemoveDups.inPlaceApproach(twoDifferentElmt);
        assertTrue(twoDifferentElmt.isEqual(twoDifferentExpected));

        //long list with some duplicates
        List<Integer> longListWithDups = new List<>(new Integer[]{4, 45, 4, 45, 3, 324, 1, 5, 4, 99});
        List<Integer> longListWithDupsExpected = new List<>(new Integer[]{4, 45, 3, 324, 1, 5, 99});
        RemoveDups.inPlaceApproach(longListWithDups);
        assertTrue(longListWithDups.isEqual(longListWithDupsExpected));

        //long list without duplicates
        List<Integer> longListWithoutDups = new List<>(new Integer[]{4, 45, 3, 324, 1, 5, 99});
        List<Integer> longListWithoutDupsExpected = new List<>(new Integer[]{4, 45, 3, 324, 1, 5, 99});
        RemoveDups.inPlaceApproach(longListWithoutDups);
        assertTrue(longListWithoutDups.isEqual(longListWithoutDupsExpected));
    }
}