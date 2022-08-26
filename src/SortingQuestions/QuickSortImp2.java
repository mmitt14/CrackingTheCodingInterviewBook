package SortingQuestions;

import java.util.Arrays;

public class QuickSortImp2 {

    public static void main(String[] args) {
        int[] arr={9,4,7,6,3,1,5};
        int[] temp=new int[arr.length];
        System.out.println(Arrays.toString(arr));
        quickSort2(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort2(int[] arr, int start, int end) {

        if(start>=end){
            return;
        }
        int pivot= (start+end)/2;
        int index = partition(arr,start,end,pivot);
        quickSort2(arr,start,index-1);
        quickSort2(arr,index,end);
    }

    private static int partition(int[] arr, int start, int end, int pivot) {

        while (start<=end){

            while (arr[start]<arr[pivot]){
                start++;
            }
            while (arr[end]>arr[pivot]){
                end--;
            }
            if(start<=end) {
                int temp = arr[start];
                arr[start]=arr[end];
                arr[end] = temp;
            }
            start++;
            end--;
        }

        return start;
    }
}
