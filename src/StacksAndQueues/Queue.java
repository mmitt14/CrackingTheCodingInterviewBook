package StacksAndQueues;

public class Queue {

    private class Node{
        private int data;
        private Node next;
        private Node(int data){
            this.data=data;
        }
    }

    private Node head;
    private Node tail;

    public boolean isEmpty(){
      return head==null;
    }
    public int peek(){
        return head.data;
    }

    public void add(int data){
        Node node= new Node(data);
        if(tail!=null){
            tail.next=node;
        }
        tail=node;
        if (head==null){
            head=node;
        }
    }
    public int remove(){
        int data = head.data;
        head=head.next;
        return data;
    }

    public void printQueue(){
        Node current =head;
        while (current!=null){
            System.out.print(current.data+" -> ");
            current=current.next;
        }
        System.out.println("Null");
    }

}
