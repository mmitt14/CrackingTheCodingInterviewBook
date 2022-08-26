package SortingQuestions;

import java.util.Arrays;

public class BubbleSortImplementation {

    public static void main(String[] args) {

        int[] arr={7,4,4,9,6,3,1,5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void bubbleSort(int[] arr){
        boolean isSorted=false;
        int l=arr.length-1;
        while (!isSorted){
            isSorted=true;
            for (int i=0;i<l;i++){
                if(arr[i]>arr[i+1]){
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    isSorted=false;
                }
            }
            l--;
        }
    }
}
