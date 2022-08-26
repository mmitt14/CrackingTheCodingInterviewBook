package StacksAndQueues;

public class ThreeInOne {
    private int[] arr;
    private int size;
    private int top1;
    private int top2;
    private int top3;


    ThreeInOne(int size){
        this.size=size;
        arr=new int[size];
        top1=-1;
        top2=(size/3)-1;
        top3=(2*size/3)-1;
    }

    public void push1(int element){
        if(top1<(size/3)-1){
            top1++;
            arr[top1]=element;
            System.out.println(element+" Pushed is to stack1 ");
        }
        else {
            System.out.println("Stack1 Overflow for element "+element);
        }
    }

    public void push2(int element){
        if(top2<(2*size/3)-1){
            top2++;
            arr[top2]=element;
            System.out.println(element+" Pushed is to stack2 ");
        }
        else {
            System.out.println("Stack2 Overflow for element "+element);
        }
    }

    public void push3(int element){
        if(top3<size-1){
            top3++;
            arr[top3]=element;
            System.out.println(element+" Pushed is to stack3 ");
        }
        else {
            System.out.println("Stack3 Overflow for element "+element);
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
        if(top2>=size/3){
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

    public int pop3(){
        int element=-1;
        if(top3>=(2*size/3)){
            element=arr[top3];
            top3--;
            System.out.println(element+" is poped from stack3");
            return element;
        }
        else {
            System.out.println("Stack2 Underflow");
        }
        return element;
    }
    
}
