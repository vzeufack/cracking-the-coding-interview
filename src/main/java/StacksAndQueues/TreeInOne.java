package StacksAndQueues;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class TreeInOne {
    private Integer[] stacks;
    private int[] topIndices;
    private int[] sizes;
    private int stackCapacity;
    private final int NUMBER_OF_STACKS = 3;
    public TreeInOne(int stackCapacity){
        topIndices = new int[NUMBER_OF_STACKS];
        for(int i = 0; i < NUMBER_OF_STACKS; i++){
            topIndices[i] = stackCapacity * i - 1;
        }
        this.stackCapacity = stackCapacity;
        stacks =  new Integer[stackCapacity * NUMBER_OF_STACKS];
        sizes = new int[NUMBER_OF_STACKS];
    }

    public Integer pop(int stackId) throws EmptyStackException {
        if(isEmpty(stackId))
            throw new NoSuchElementException("Stack " + stackId + " is empty!");
        sizes[stackId]--;
        int topId = topIndices[stackId];
        topIndices[stackId] = topId - 1;
        return stacks[topId];
    }

    public void push(int stackId, Integer data) throws StackOverflowError{
        if(size(stackId) == stackCapacity)
            throw new StackOverflowError("Stack " + stackId + " is full!");

        topIndices[stackId] = topIndices[stackId] + 1;
        stacks[topIndices[stackId]] = data;
        sizes[stackId]++;
    }

    public Integer peek(int stackId){
        if(isEmpty(stackId))
            throw new NoSuchElementException("Stack " + stackId + " is empty!");
        return stacks[topIndices[stackId]];
    }

    public boolean isEmpty(int stackId){
        return topIndices[stackId] == stackCapacity * (stackId) - 1;
    }

    public int size(int stackId){
        return sizes[stackId];
    }

    public void setStacks(Integer[] stacks, int[] topIndices){
        if(stacks.length != this.stacks.length){
            throw new IllegalArgumentException("Stacks array must be of size " + stackCapacity * NUMBER_OF_STACKS);
        }
        this.stacks = stacks;
        this.topIndices = topIndices;

        for(int i = 0; i < NUMBER_OF_STACKS; i++){
            sizes[i] = topIndices[i] - (stackCapacity * (i) - 1);
        }
    }

    public void print(){
        for (int i = 0; i < NUMBER_OF_STACKS; i++){
            System.out.printf("Stack %d:", i);
            for(int j = i; j < this.stackCapacity + i; j++){
                System.out.printf(" %d", stacks[i+j]);
            }
            System.out.println();
        }
    }
}
