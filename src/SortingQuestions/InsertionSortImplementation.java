package SortingQuestions;

import java.util.Arrays;

public class InsertionSortImplementation {

    public static void main(String[] args) {
        int[] arr={9,4,7,6,3,1,5};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int [] arr){
        for (int i=0;i<arr.length;i++){
            int temp=arr[i];//Take the first element
            int j= i-1;
            while (j>=0 && temp<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
    }

    public static void selectionSort(int [] arr){
        for (int i=0;i<arr.length-1;i++){
            int minIndex=i;
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                int temp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=temp;
            }

        }
    }
}
