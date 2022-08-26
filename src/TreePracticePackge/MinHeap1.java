package TreePracticePackge;

import java.util.Arrays;

public class MinHeap1 {
    private int capacity =10;
    private int size= 0;
    int[] items = new int[capacity];

    public int getLeftChildIndex(int index){
        return 2*index+1;
    }
    public int getRightChildIndex(int index){
        return 2*index+2;
    }

    public int getParentIndex(int index){

        return (index-1)/2;
    }


    public boolean hasLeftChild(int index){
        return getLeftChildIndex(index)<size;
    }
    public boolean hasRightChild(int index){
        return getRightChildIndex(index)<size;
    }
    public boolean hasParent(int index){
        return getParentIndex(index)>=0;
    }

    public int getLeftChild(int index){
        return items[getLeftChildIndex(index)];
    }
    public int getRightChild(int index){
        return items[getRightChildIndex(index)];
    }

    public int getParent(int index){
        return items[getParentIndex(index)];
    }

    public void ensureExtraCapacity(){
        if(size>=capacity){
            capacity=2*capacity;
            items= Arrays.copyOf(items,capacity);
        }
    }

    public void insert(int value){
        ensureExtraCapacity();
        items[size]=value;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {

        int index=size-1;
        while (hasParent(index) && getParent(index)>items[index]){
                swap(getParentIndex(index),index);
                index=getParentIndex(index);
        }
    }

    public int poll(){
        if(size==0){
            throw new IllegalStateException("Empty List");
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
            int min = getLeftChildIndex(index);

            if(getRightChild(index)<items[min]){
                min=getRightChildIndex(index);
            }
            if(items[index]<items[min]){
                break;
            }
            swap(index,min);
            index=min;
        }
    }

    private void swap(int index1,int index2){
        int temp=items[index1];
        items[index1]=items[index2];
        items[index2]=temp;
    }


}

class MinHeapRunner1{
    public static void main(String[] args) {
        MinHeap1 heap1=new MinHeap1();
        heap1.insert(9);
        heap1.insert(4);
        heap1.insert(7);
        heap1.insert(3);
        heap1.insert(2);
        heap1.insert(1);
        heap1.poll();
        heap1.insert(8);

        System.out.println(Arrays.toString(heap1.items));
    }
}
