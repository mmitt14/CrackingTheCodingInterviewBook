package StacksAndQueues;

public class StackArray {
    private int[] arr;
    private int size;
    private int top;

    StackArray(int size){
        this.size=size;
        arr=new int[size];
        top=-1;
    }

    public void push(int element){
        if(top<size-1){
            top++;
            arr[top]=element;
//            System.out.println(element+" added to the stack");

        }
        else {
//            System.out.println("Stack is full, so cannot add "+element);
        }
    }

    public int pop(){
        if(top>=0){
            int element=arr[top];
            top--;
//            System.out.println(element+" is removed from the Stack");

            return element;
        }
        else {
//            System.out.println("Stack Underflow");
            return 0;
        }
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public int peek(){
        if(!isEmpty()){
            return arr[top];
        }
        else return -1;
    }

}



