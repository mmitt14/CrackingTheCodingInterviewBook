package TreePracticePackge;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinHeap {

    private int capacity =10;
    private int size= 0;
    int[] items = new int[capacity];

    private int getLeftIndex(int index){
        return index*2+1;
    }
    private int getRightIndex(int index){
        return index*2+2;
    }

    private int getParentIndex(int index){
        return (index-1)/2;
    }

    private boolean hasLeft(int index){
        return getLeftIndex(index)<size;
    }

    private boolean hasRight(int index){
        return getRightIndex(index)<size;
    }
    private boolean hasParent(int index){
        return getLeftIndex(index)>=0;
    }

    private int leftChild(int index){
        return items[getLeftIndex(index)];
    }
    private int rightChild(int index){
        return items[getRightIndex(index)];
    }
    private int parent(int index){
        return items[getParentIndex(index)];
    }

    private void ensureExtraCapacity(){
        if(size==capacity){
            items= Arrays.copyOf(items,capacity*2);
            capacity *= 2;
        }
    }

    private void swap(int index1,int index2){
        int temp=items[index1];
        items[index1]=items[index2];
        items[index2]=temp;
    }

    public int peek(){
        if(size==0){
            throw new IllegalStateException();
        }
        return items[0];
    }

    public int poll(){
        if(size==0){
            throw new IllegalStateException();
        }
        int item= items[0];
        swap(0,size-1);
        size--;
        heapifyDown();
        return item;

    }

    private void heapifyDown() {
        int index=0;

        while(hasLeft(index)){
            int minChildIndex=getLeftIndex(index);
            if(hasRight(index) && rightChild(index)<leftChild(index)){
                minChildIndex=getRightIndex(index);
            }
            if(items[index]<items[minChildIndex]){
                break;
            }
            else {
                swap(index, minChildIndex);
            }
            index=minChildIndex;
        }
    }

    public void add(int value){
        ensureExtraCapacity();
        items[size]=value;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index=size-1;

        while (hasParent(index) && items[index]<parent(index)){
            swap(index,getParentIndex(index));
            index=getParentIndex(index);
        }
    }

}

    class MinHeapRunning{
        public static void main(String[] args) {
            MinHeap minHeap = new MinHeap();
            minHeap.add(10);
            minHeap.add(15);
            minHeap.add(7);
            minHeap.add(2);
            minHeap.add(4);
            minHeap.add(20);
//            System.out.println(minHeap.peek());
            System.out.println(Arrays.toString(minHeap.items));
            System.out.println(minHeap.poll());
            System.out.println(Arrays.toString(minHeap.items));
            System.out.println(minHeap.poll());
            System.out.println(Arrays.toString(minHeap.items));
            minHeap.add(1);
            minHeap.add(12);
            System.out.println(Arrays.toString(minHeap.items));
        }
    }
