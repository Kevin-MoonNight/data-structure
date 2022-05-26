package com.company;

public class LinkedList {
    private LinkedList head = null;
    private LinkedList next = null;

    private int value = 0;

    public LinkedList(int value){
        this.value = value;
    }

    public void setHead(LinkedList head){
        this.head = head;
    }

    public LinkedList getHead(){
        return head;
    }

    public void setNext(LinkedList next){
        this.next = next;
        next.setHead(this);
    }

    public LinkedList getNext(){
        return next;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public void insertPointer(int position,LinkedList pointer){
        int counter =0;
        LinkedList temp = this;

        while (temp != null){
            counter ++;
            if(counter == position){
                pointer.setHead(temp.getHead());
                temp.getHead().setNext(pointer);
                pointer.setNext(temp);
                temp.setHead(pointer);
                break;
            }

            temp = temp.next;
        }
    }

    public void deletePointer(int position){
        int counter =0;
        LinkedList temp = this;

        while (temp != null){
            counter ++;
            if(counter == position){
                temp.getHead().setNext(temp.getNext());
                break;
            }

            temp = temp.next;
        }
    }

    public int getLength(){
        int counter =0;
        LinkedList temp = this;

        while (temp != null){
            counter ++;
            temp = temp.next;
        }

        return counter;
    }

    public String printAllPointValue(){
        String result = "";
        LinkedList temp = this;

        while (temp != null){
            result += temp.value + " ";
            temp = temp.next;
        }

        return result;
    }
}
