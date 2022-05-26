package com.company;

public class ArrayQueue implements IQueue {
    private int[] values;
    private int head;
    private int end;
    private int length;
    private int count;

    public ArrayQueue() {
        init();
    }

    private void init() {
        length = 10;
        values = new int[length];
        head = 0;
        end = -1;
        count = 0;
    }

    public void Enqueue(int value) {
        if ((end + 1) == length) {
            length *= 2;
            CopyArray();
        }
        end++;
        count++;
        values[end] = value;
    }

    private void CopyArray() {
        int[] newValues = new int[length];
        count = 0;
        for (int i = head; i <= end; i++) {
            newValues[count] = values[i];
            count++;
        }

        head = 0;
        end = count;

        values = newValues;
    }

    public int Dequeue() {
        if (IsEmpty()) {
            return 0;
        }

        int result = values[head];

        head++;
        count--;

        IsEmpty();
        return result;
    }

    public int First() {
        if (IsEmpty()) {
            return 0;
        }

        return values[head];
    }

    public int Size() {
        return count;
    }

    public boolean IsEmpty() {
        boolean result = false;
        if (count == 0) {
            //歸還記憶體
            init();
            result = true;
        }

        return result;
    }
}
