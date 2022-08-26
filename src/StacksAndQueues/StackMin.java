package StacksAndQueues;

public class StackMin {
    private int[] arr;
    private int size;
    private int top;
    public int min;
    StackArray minStack;

    StackMin(int size){
        this.size=size;
        arr=new int[size];
        top=-1;
        min= Integer.MAX_VALUE;
        minStack=new StackArray(size);
    }

    public void push(int element){
        if(top<size-1){
            top++;
            arr[top]=element;
            System.out.println(element+" added to the stack");
            if(element<min){
                min=element;
                minStack.push(min);
            }
        }
        else {
            System.out.println("Stack is full, so cannot add "+element);
        }
    }

    public int pop(){
        if(top>=0){
            int element=arr[top];
            top--;
            System.out.println(element+" is removed from the Stack");

            if(element==min){
                minStack.pop();
                min=minStack.peek();
            }
            return element;
        }
        else {
            System.out.println("Stack Underflow");
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
        else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

}

    class MinStackRunner{

        public static void main(String[] args) {
            StackMin stk= new StackMin(6);

            stk.push(7);
            stk.push(4);
            stk.push(3);
            stk.push(8);
            stk.push(5);
            stk.push(2);
            System.out.println("Min is "+stk.min);
            stk.pop();

            System.out.println("Min is "+stk.min);
            stk.pop();
            stk.pop();
            stk.pop();
            stk.pop();
            System.out.println("Min is "+stk.min);
        }

}
