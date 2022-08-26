package LinkedListsQuestions;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList ls= new LinkedList();
        ls.add(5);
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(3);
        ls.add(4);
        ls.add(5);
        ls.add(5);
        removeDuplicates(ls.head);
        ls.print();




//        print(reverseLinkedList1Recur(ls.head));

//        System.out.println(kthToLastIterative2(ls.head,2).value);
//        ls.print();

//        LinkedList ls1= new LinkedList();
//        ls1.add(4);
//        Node n1 =ls1.add(6);
//        n1.next=n2;
//        ls.print();
//        ls1.print();
//        System.out.println(intersection(ls.head,ls1.head).value);



//        LinkedList ls1= new LinkedList();
//        ls1.add(5);
//        ls1.add(9);
//        ls1.add(2);
//        ls1.print();
//
//
//        Node temp1 = sumLinkedList(ls.head,ls1.head);
//        print(temp1);



    }

//    class Index{
//        public int count;
//    }

//    public static int kthNode(Node head,int k){
//        if(head==null){
//            return 0;
//
//        }
//        int n=1+kthNode(head.next,k);
//        if(n==k){
//            System.out.println("Kth element from last is "+head.value);
//        }
//
//        return n;
//
//    }


    static class Index {
        public int value=0;
    }

    private static Node kthToLast(Node head, int k) {
        Index idx = new Index();
        return kthToLast(head, k, idx);
    }

    public static Node kthToLast(Node head, int k, Index idx) {
        if (head == null) {
            return null ;
        }
        Node node = kthToLast(head.next, k, idx);
        idx.value = idx.value + 1;
        if (idx.value == k) {
            return head;
        }
        return node;
    }

    public static void print(Node head){
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

    public static Node kthToLastIterative(Node head,int k){
        int count=0;
        Node cur= head;
        while (cur!=null){
            count++;
            cur=cur.next;
        }
        int element=count-k;
        for (int i=1;i<element;i++){
            head=head.next;
        }

        return head;
    }

    public static Node kthToLastIterative2(Node head,int k){
        Node p=head;
        Node q=head;
        for (int i=0;i<k;i++){
            q=q.next;
        }
        while (q.next!=null){
            p=p.next;
            q=q.next;
        }

        return p;
    }


    public static void removeDuplicatesTwoPointer(Node head){
        if(head==null || head.next==null){
            return;
        }
        Node current = head;
        while(current!=null){
            Node runner=current;
            while (runner.next!=null){
                if(current.value==runner.next.value){
                    runner.next=runner.next.next;
                }
                else {
                    runner=runner.next;
                }
            }
            current=current.next;
        }
    }
    public static void removeDuplicates(Node head){
        if(head==null || head.next==null){
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(head.value);
        Node current =head;
        while(current.next!=null){
            if(arrayList.contains(current.next.value)){
                current.next=current.next.next;
            }
            else {
                arrayList.add(current.next.value);
                current=current.next;
            }

        }
//        System.out.println(arrayList);
    }
//    Delete Middle Node: Implement an algorithm to delete a node in the middle (Le., any node but
//    the first and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.




    public static void deleteMiddleNode(Node node){

        if(node==null || node.next==null){
            return;
        }
        Node next= node.next;
        node.value=next.value;
        node.next=next.next;
    }

    public static Node partition1(Node head, int x){
        Node list1 =null;
        Node list1Head =null;
        Node list2 = null;
        Node list2Head=null;
        Node current = head;
        while (current != null){
            if(current.value<x){
                if(list1Head==null){
                    list1Head=current;
                    list1=list1Head;
                }
                else {
                    list1.next=current;
                    list1=list1.next;
                }
            }
            else {
                if(list2Head==null){
                    list2Head=current;
                    list2=list2Head;
                }
                else {
                    list2.next=current;
                    list2=list2.next;
                }
            }
            current=current.next;
        }
        list2.next=null;

        if(list1Head==null){
            return list2Head;
        }

        list1.next=list2Head;

        return list1Head;

    }

    public static Node partition2(Node node, int x){
        Node head=node;
        Node tail=node;
        Node current=node;
        while (current!=null){
            Node next=current.next;
            if(current.value<x){
                current.next=head;
                head=current;
            }
            else {
                tail.next=current;
                tail=current;
            }
            current=next;
        }
        tail.next=null;
        return head;
    }

    public static Node sumLinkedList(Node h1, Node h2){

        Node l3 = null;
        Node l3Head=null;
        int carry=0;
        while (h1!=null || h2!=null){
            int x= (h1!=null) ? h1.value:0;
            int y= (h2!=null) ? h2.value:0;
            int sum=x+y+carry;
            carry=sum/10;
            if(l3==null){
                l3=new Node(sum%10);
                l3Head=l3;
            }
            else {
                l3.next=new Node(sum%10);
                l3=l3.next;
            }

            if(h1!=null) h1=h1.next;
            if(h2!=null) h2=h2.next;
        }

        return l3Head;
    }

    public static Node sumLinkedList2(Node h1, Node h2){
        h1=reverseLinkedList(h1);
        h2= reverseLinkedList(h2);
        Node l3 = null;
        Node l3Head=null;
        int carry=0;
        while (h1!=null || h2!=null){
            int x= (h1!=null) ? h1.value:0;
            int y= (h2!=null) ? h2.value:0;
            int sum=x+y+carry;
            carry=sum/10;
            if(l3==null){
                l3=new Node(sum%10);
                l3Head=l3;
            }
            else {
                l3.next=new Node(sum%10);
                l3=l3.next;
            }

            if(h1!=null) h1=h1.next;
            if(h2!=null) h2=h2.next;
        }


        return reverseLinkedList(l3Head);
    }

    public static Node reverseLinkedList(Node n){

        Node head = null;
        while(n!=null){
            Node node= new Node(n.value);
            node.next=head;
            head=node;
            n=n.next;
        }
     return head;
    }

    public static boolean isPlalindrom(Node node){

        Node reverse = reverseLinkedList(node);

        while (node.next!=null){
            if(node.value!=reverse.value){
                return false;
            }
            reverse=reverse.next;
            node=node.next;
        }

        return true;

    }

    public static Node intersection(Node l1, Node l2){
        Node head1=l1;
        Node head2 =l2;

        int s1=0;
        int s2=0;
        while (l1 !=null){
            s1++;
            if(l1.next==null){
                break;
            }
            l1=l1.next;
        }
        while (l2 !=null){
            s2++;
            if(l2.next==null){
                break;
            }
            l2=l2.next;
        }
        if(l1!=l2) return null;

        int diff= Math.abs(s1-s2);
        Node c1=head1;
        Node c2=head2;

        if(s1<s2){
            for (int i = 0; i <diff ; i++) {
                c2=c2.next;
            }
        }
        else{
            for (int i = 0; i <diff ; i++) {
                c1=c1.next;
            }

        }

        while(c1!=null && c2!=null){
            if(c1==c2){
                return c1;
            }
            c1=c1.next;
            c2=c2.next;
        }

        return null;
    }

    public static Node loopDetection(Node head){
        ArrayList<Node> al=new ArrayList<>();
        while(head.next!=null){
            if(al.contains(head)){
                return head;
            }
            al.add(head);
            head=head.next;
        }

        return null;

    }

    public static Node reverseLinkedList1Recur(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node newHead= reverseLinkedList1Recur(head.next);
        Node headNext=head.next;
        headNext.next=head;
        head.next=null;
        return newHead;

    }

    public static Node reverseLinkedList1Iterative(Node node){
        if(node==null || node.next==null){
            return node;
        }
        Node head= null;

        while(node!=null){
            Node temp= new Node(node.value);
            temp.next=head;
            head=temp;
            node=node.next;
        }

        return head;
    }

    public static Node reverseLinkedList2Iterative(Node head){

        Node prev= null;
        Node cur=head;

        while(cur!=null){
            Node next= cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }

        return prev;
    }


}
