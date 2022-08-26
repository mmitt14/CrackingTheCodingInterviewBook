package LinkedListsQuestions;

public class InterviewPractice {
    public static void main(String[] args) {
        LinkedList ls= new LinkedList();

        ls.add(7);
        ls.add(1);
        Node node=ls.add(2);
        ls.add(4);
        ls.add(8);
        ls.print();

        deleteMiddle(node);
        ls.print();
    }

    private static void deleteMiddle(Node node) {
        node.value=node.next.value;
        node.next=node.next.next;

    }

    // No Extra Buffer
    public static void removeDuplicates1(Node head){
        if(head==null){
            return;
        }
        if(head.next==null){
            return;
        }

        Node current= head;
        while (current!=null){
            Node runner=current;
            while (runner.next!=null){
                if(current.value==runner.next.value){
                    runner.next=runner.next.next;
                }else {
                runner=runner.next;
                }

            }
            current=current.next;
        }
    }
}
