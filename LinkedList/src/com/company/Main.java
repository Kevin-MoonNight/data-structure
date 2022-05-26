package com.company;

public class Main {

    public static void main(String[] args) {
        int[] value = new int[5];
        LinkedList pointer1 = new LinkedList(1);
        LinkedList temp = pointer1;

        for(int i = 1 ; i < value.length;i++){
            value[i] = i+1;
            temp.setNext(new LinkedList(value[i]));
            temp = temp.getNext();
        }

        System.out.println("head=" + pointer1.getHead());
        System.out.println("value=" + pointer1.getValue());
        System.out.println("length=" + pointer1.getLength());
        System.out.println("all value=" + pointer1.printAllPointValue());
        pointer1.insertPointer(2,new LinkedList(7));
        System.out.println("all value=" + pointer1.printAllPointValue());
        pointer1.deletePointer(2);
        System.out.println("all value=" + pointer1.printAllPointValue());
        LinkedList pointer2 = pointer1.getNext();
        pointer1.setHead(new LinkedList(7));
        pointer1.getHead().setNext(pointer1);
        System.out.println("all value=" + pointer1.getHead().printAllPointValue());
    }
}
