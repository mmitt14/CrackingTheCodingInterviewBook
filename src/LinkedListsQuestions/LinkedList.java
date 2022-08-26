package LinkedListsQuestions;

class Node{
    int value;
    Node next;

    Node(int value){
        this.value=value;
    }
    Node(int value, Node next){
        this.value=value;
        this.next=next;
    }
}

public class LinkedList {
    Node head;



    public Node add(int value){
        Node node=new Node(value);
        if(head==null){
            head=node;
            return node;
        }
        Node current = head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=node;
        return node;
    }

    public void append(int value){
        Node node=new Node(value);
        if(head==null){
            head=node;
            return;
        }
        node.next=head;
        head=node;

    }

    public void delete(int value){
        if(head==null){
            return;
        }
        if(head.value==value){
            head=head.next;
            return;
        }
        Node current = head;
        while (current.next!=null){
            if(current.next.value==value){
                current.next=current.next.next;
                return;
            }
            current=current.next;
        }
    }

    public void print(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while(current!=null){
            System.out.print(current.value+" -> ");
            current=current.next;
        }
        System.out.println("NULL");

    }
}
