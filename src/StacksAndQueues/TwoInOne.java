package StacksAndQueues;

public class TwoInOne {
    private int[] arr;
    private int size;
    private int top1;
    private int top2;

    TwoInOne(int size){
        this.size=size;
        arr=new int[size];
        top1=-1;
        top2=(size/2)-1;
    }

    public void push1(int element){
        if(top1<(size/2)-1){
            top1++;
            arr[top1]=element;
            System.out.println(element+" Pushed is to stack1 ");
        }
        else {
            System.out.println("Stack1 Overflow for element "+element);
        }
    }

    public void push2(int element){
        if(top2<size-1){
            top2++;
            arr[top2]=element;
            System.out.println(element+" Pushed is to stack2 ");
        }
        else {
            System.out.println("Stack2 Overflow for element "+element);
        }
    }

    public int pop1(){
        int element=-1;
        if(top1>=0){
            element=arr[top1];
            top1--;
            System.out.println(element+" is poped from stack1");
            return element;
        }
        else {
            System.out.println("Stack1 Underflow");
        }
        return element;
    }

    public int pop2(){
        int element=-1;
        if(top2>=size/2){
            element=arr[top2];
            top2--;
            System.out.println(element+" is poped from stack2");
            return element;
        }
        else {
            System.out.println("Stack2 Underflow");
        }
        return element;
    }


}
