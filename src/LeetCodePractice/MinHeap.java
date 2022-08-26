package LeetCodePractice;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinHeap {
    int size=0;
    int capacity=10;
    int[] items=new int[capacity];

    private int getLeftChildIndex(int index){ return 2*index+1;}
    private int getRightChildIndex(int index){ return 2*index+2;}
    private int getParentIndex(int index){
        return Math.floorDiv(index-1,2);
    }

    private boolean hasLeftChild(int index){return getLeftChildIndex(index)<size;};
    private boolean hasRightChild (int index) {return getRightChildIndex(index)<size;}
    private boolean hasParent(int index){
        return getParentIndex(index)>=0;};

    private int getLeftChild(int index){return items[getLeftChildIndex(index)];}
    private int getRightChild(int index){return items[getRightChildIndex(index)];}
    private int getParent(int index){
        return items[getParentIndex(index)];}

    private void swap(int index1, int index2){
        int temp=items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    private void ensureExtraCapacity(){
        if(size==capacity){
            capacity=2*capacity;
            items= Arrays.copyOf(items,capacity);
        }
    }

    public int peek(){
        if(size==0){
            throw new IllegalStateException("Heap is empty");
        }
        return items[0];
    }

    public int poll(){
        if(size==0){
            throw new IllegalStateException("Heap is empty");
        }
        int item=items[0];
        items[0]=items[size-1];
        size--;
        heapifyDown();
        return item;
    }

    private void heapifyDown() {
        int index=0;
        while (hasLeftChild(index)){
            int smallIndex=getLeftChildIndex(index);
            if(hasRightChild(index) && items[smallIndex]>getRightChild(index)){
                smallIndex=getRightChildIndex(index);
            }
            if(items[smallIndex]>=items[index]){
                return;
            }
            swap(index,smallIndex);
            index=smallIndex;
        }

    }

    public void add(int item){
        ensureExtraCapacity();
        items[size]=item;
        size++;
        heapifyUP();
    }

    private void heapifyUP() {
        int index=size-1;
        boolean test1= hasParent(index);
        while (hasParent(index)&& getParent(index)>items[index]){
            swap(index,getParentIndex(index));
            index=getParentIndex(index);
        }
    }


}

    class MinHeapRunner{
        public static void main(String[] args) {
            MinHeap heap= new MinHeap();
            heap.add(15);
            heap.add(10);
            heap.add(17);
            heap.add(20);
            heap.add(5);
            heap.add(1);
            heap.add(2);
            System.out.println(heap.peek());
            System.out.println(heap.poll());
            System.out.println(heap.peek());


        }
    }
