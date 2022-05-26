package com.company;

public class Main {

    public static void main(String[] args) {
        //LinkedList實作的Queue
        System.out.println("LinkedList實作的Queue");
        IQueue linkedListQueue = new LinkedListQueue();
        for (int i = 1; i <= 5; i++) {
            linkedListQueue.Enqueue(i);
        }

        PrintAnswer(linkedListQueue);


        //Array實作的Queue
        System.out.println("Array實作的Queue");
        IQueue arrayQueue = new ArrayQueue();
        for (int i = 1; i <= 5; i++) {
            arrayQueue.Enqueue(i);
        }

        PrintAnswer(arrayQueue);
    }

    public static void PrintAnswer(IQueue queue) {

        System.out.println("queue 增加前大小:" + queue.Size());
        queue.Enqueue(6);
        System.out.println("queue 增加後大小:" + queue.Size());


        System.out.println("queue 減少前大小:" + queue.Size());
        System.out.println("queue 減少前第一個值:" + queue.First());
        int popValue = queue.Dequeue();
        System.out.println("queue 減少後大小:" + queue.Size());
        System.out.println("queue 減少後第一個值:" + queue.First());
        System.out.println("queue dequeue出來的值:" + popValue);
        for (int i = 1; i <= 11; i++) {
            queue.Enqueue(i);
        }

        System.out.println("queue 清空前:" + queue.IsEmpty());
        while (queue.Size() != 0) {
            queue.Dequeue();
        }
        popValue = queue.Dequeue();
        System.out.println("queue dequeue出來的值:" + popValue);
        System.out.println("queue 清空後:" + queue.IsEmpty());
    }
}
