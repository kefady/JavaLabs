package lab8;

import lab7.singlylinkedset.SinglyLinkedSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class SinglyLinkedSetTest {
    private static Set<Integer> singlyLinkedSet;

    @BeforeEach
    void setUp() {
        singlyLinkedSet = new SinglyLinkedSet<>(List.of(1, 2, 3, 4, 5));
    }

    @Test
    void add() {
        int sizeBefore = singlyLinkedSet.size();
        singlyLinkedSet.add(10);
        int sizeAfter = singlyLinkedSet.size();
        Assertions.assertEquals(sizeBefore + 1, sizeAfter);
    }

    @Test
    void addAll() {
    }

    @Test
    void clear() {
        int expectedSize = 0;
        singlyLinkedSet.clear();
        int actualSize = singlyLinkedSet.size();
        Assertions.assertEquals(expectedSize, actualSize);

    }

    @Test
    void contains() {
        boolean result = singlyLinkedSet.contains(3);
        Assertions.assertTrue(result);
    }

    @Test
    void containsAll() {
        boolean result = singlyLinkedSet.containsAll(List.of(1, 3, 5));
        Assertions.assertTrue(result);
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(singlyLinkedSet.isEmpty());
    }

    @Test
    void remove() {
        int sizeBefore = singlyLinkedSet.size();
        singlyLinkedSet.remove(3);
        int sizeAfter = singlyLinkedSet.size();
        Assertions.assertEquals(sizeBefore - 1, sizeAfter);
    }

    @Test
    void removeAll() {
        int sizeBefore = singlyLinkedSet.size();
        List.of(1, 2, 4).forEach(singlyLinkedSet::remove);
        int sizeAfter = singlyLinkedSet.size();
        Assertions.assertEquals(sizeBefore - 3, sizeAfter);
    }

    @Test
    void retainAll() {
        int sizeBefore = singlyLinkedSet.size();
        singlyLinkedSet.retainAll(List.of(2, 5));
        int sizeAfter = singlyLinkedSet.size();
        Assertions.assertEquals(sizeBefore - 3, sizeAfter);
    }

    @Test
    void size() {
        int expected = 5;
        int actual = singlyLinkedSet.size();
        Assertions.assertEquals(expected, actual);
    }
}