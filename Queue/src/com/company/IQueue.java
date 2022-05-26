package com.company;

public interface IQueue {
    void Enqueue(int value);
    int Dequeue();
    int First();
    int Size();
    boolean IsEmpty();
}
