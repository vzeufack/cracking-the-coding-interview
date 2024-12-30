package StacksAndQueues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class TreeInOneTest {
    TreeInOne stacks;

    @BeforeEach
    void setUp() {
        stacks = new TreeInOne(2);
    }

    @Test
    void pop() {
        //pop from empty stack
        Exception exception0 = assertThrows(NoSuchElementException.class, () -> {
            stacks.pop(0);
        });
        assertTrue(exception0.getMessage().equalsIgnoreCase(emptyStackErrorMsg(0)));

        Exception exception1 = assertThrows(NoSuchElementException.class, () -> {
            stacks.pop(1);
        });
        assertTrue(exception1.getMessage().equalsIgnoreCase(emptyStackErrorMsg(1)));

        Exception exception2 = assertThrows(NoSuchElementException.class, () -> {
            stacks.pop(2);
        });
        assertTrue(exception2.getMessage().equalsIgnoreCase(emptyStackErrorMsg(2)));

        //pop from stack with one value
        for(int i = 0; i < 2; i++)
            stacks.push(i, i);
        for(int i = 0; i < 2; i++)
            stacks.pop(i);
        assertTrue(stacks.isEmpty(0));
        assertTrue(stacks.isEmpty(1));
        assertTrue(stacks.isEmpty(2));

        //pop from stack with more than one value
        stacks.setStacks(new Integer[]{0, 0, 1, 0, 2, 0}, new int[]{1, 3, 5});

        for(int i = 0; i < 3; i++)
            stacks.pop(i);
        assertTrue(stacks.size(0) == 1);
        assertTrue(stacks.size(1) == 1);
        assertTrue(stacks.size(2) == 1);
    }

    @Test
    void push() {
        //push into empty stack
        Integer[] values = {0, 1, 2};
        for(Integer i: values)
            stacks.push(i, values[i]);
        for(Integer i: values)
            assertTrue(stacks.peek(i) == values[i]);

        //push into non-empty non-full stack
        Integer[] values2 = {3, 4, 5};
        for(Integer i: values2)
            stacks.push(i-3, values2[i-3]);
        for(Integer i: values2)
            assertTrue(stacks.peek(i-3) == values2[i-3]);

        //push into full stack
        Error error = assertThrows(StackOverflowError.class, () -> {
            stacks.push(0, values[0]);
        });
        assertTrue(error.getMessage().equalsIgnoreCase(fullStackErrorMsg(0)));

        Error error1 = assertThrows(StackOverflowError.class, () -> {
            stacks.push(1, values[1]);
        });
        assertTrue(error1.getMessage().equalsIgnoreCase(fullStackErrorMsg(1)));

        Error error2 = assertThrows(StackOverflowError.class, () -> {
            stacks.push(2, values[2]);
        });
        assertTrue(error2.getMessage().equalsIgnoreCase(fullStackErrorMsg(2)));

    }

    @Test
    void peek() {
        //peek into empty stack
        Exception exception0 = assertThrows(NoSuchElementException.class, () -> {
            stacks.peek(0);
        });
        assertTrue(exception0.getMessage().equalsIgnoreCase(emptyStackErrorMsg(0)));

        Exception exception1 = assertThrows(NoSuchElementException.class, () -> {
            stacks.peek(1);
        });
        assertTrue(exception1.getMessage().equalsIgnoreCase(emptyStackErrorMsg(1)));

        Exception exception2 = assertThrows(NoSuchElementException.class, () -> {
            stacks.peek(2);
        });
        assertTrue(exception2.getMessage().equalsIgnoreCase(emptyStackErrorMsg(2)));

        //peek into filled stack
        stacks.setStacks(new Integer[]{0, 0, 1, 0, 2, 0}, new int[]{0, 2, 4});

        for(int i = 0; i < 3; i++) {
            assertTrue(stacks.peek(i) == Integer.valueOf(i));
        }
    }

    private String emptyStackErrorMsg(int stackId){
        return String.format("Stack %d is empty!", stackId);
    }

    private String fullStackErrorMsg(int stackId){
        return String.format("Stack %d is full!", stackId);
    }

    @Test
    void isEmpty() {
        //check empty stacks
        assertTrue(stacks.isEmpty(0));
        assertTrue(stacks.isEmpty(1));
        assertTrue(stacks.isEmpty(2));

        //check non-empty stacks
        stacks.setStacks(new Integer[]{0, 0, 1, 0, 2, 0}, new int[]{0, 2, 4});

        assertFalse(stacks.isEmpty(0));
        assertFalse(stacks.isEmpty(1));
        assertFalse(stacks.isEmpty(2));
    }
}